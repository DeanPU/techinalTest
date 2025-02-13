package com.example.techinalTest.service;

import com.example.techinalTest.dto.RequestCarBrand;
import com.example.techinalTest.entity.CarBrand;
import com.example.techinalTest.repository.CarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.techinalTest.handler.ResponseHandler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;

    public ResponseEntity<Object> createCarBrand(RequestCarBrand requestCarBrand){
//        if(errors.hasErrors()){
//            return ResponseHandler.generateResponse(null, errors.getAllErrors().getFirst().getDefaultMessage(), HttpStatus.BAD_REQUEST);
//        }

        CarBrand carBrand = new CarBrand();
        carBrand.setName(requestCarBrand.getName());
        carBrand.setCountry(requestCarBrand.getCountry());
        carBrand.setFoundedYear(requestCarBrand.getFoundedYear());
        carBrand.setDescription(requestCarBrand.getDescription());
        return ResponseHandler.generateResponse(carBrandRepository.save(carBrand), "Car brand added successfully", HttpStatus.ACCEPTED);
    }

    public List<CarBrand> getCarBrands(){
        return carBrandRepository.findAll();
    }

    public ResponseEntity<Object> updateCarBrandById(RequestCarBrand requestCarBrand, UUID id){
//        System.out.println(errors.getAllErrors());
//        if(errors.hasErrors()){
//            return ResponseHandler.generateResponse(null, errors.getAllErrors().getFirst().getDefaultMessage(), HttpStatus.BAD_REQUEST);
//        }

        Optional<CarBrand> optionalCarBrand = carBrandRepository.findById(id);
        if (optionalCarBrand.isPresent()) {
            CarBrand carBrand = optionalCarBrand.get();
            carBrand.setName(requestCarBrand.getName());
            carBrand.setCountry(requestCarBrand.getCountry());
            carBrand.setFoundedYear(requestCarBrand.getFoundedYear());
            carBrand.setDescription(requestCarBrand.getDescription());
            return ResponseHandler.generateResponse(carBrandRepository.save(carBrand), "Car brand updated successfully", HttpStatus.OK);
        } else {
            return ResponseHandler.generateResponse(null, "Car brand not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteCarBrandById(UUID id){
        Optional<CarBrand> optionalCarBrand = carBrandRepository.findById(id);
        if (optionalCarBrand.isPresent()){
            CarBrand carBrand = optionalCarBrand.get();
            carBrandRepository.deleteById(id);
            return ResponseHandler.generateResponse(carBrand, "Car brand has been deleted", HttpStatus.OK);
        } else {
            return ResponseHandler.generateResponse(null, "Car brand not found", HttpStatus.NOT_FOUND);
        }
    }
}
