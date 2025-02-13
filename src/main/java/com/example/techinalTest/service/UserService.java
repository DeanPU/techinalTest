package com.example.techinalTest.service;

import com.example.techinalTest.dto.RequestUser;
import com.example.techinalTest.entity.Users;
import com.example.techinalTest.handler.ResponseHandler;
import com.example.techinalTest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Users register(RequestUser requestUser){
        Users user = new Users();
        requestUser.setPassword(bCryptPasswordEncoder.encode(requestUser.getPassword()));
        user.setPassword(requestUser.getPassword());
        user.setUsername(requestUser.getUsername());
        return userRepository.save(user);
    }

    public ResponseEntity<Object> verify(RequestUser requestUser){
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(requestUser.getUsername(), requestUser.getPassword())
                    );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(requestUser.getUsername());
            }
            return ResponseHandler.generateResponse(null, "Invalid username or password", HttpStatus.UNAUTHORIZED);
        } catch (BadCredentialsException e) {
            return ResponseHandler.generateResponse(null, "Invalid username or password", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(null, "Authentication failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
