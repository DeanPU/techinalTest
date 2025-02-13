package com.example.techinalTest.controller;

import com.example.techinalTest.dto.RequestUser;
import com.example.techinalTest.entity.Users;
import com.example.techinalTest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody RequestUser requestUser){
        return userService.register(requestUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody RequestUser requestUser){
        return userService.verify(requestUser);
    }
}
