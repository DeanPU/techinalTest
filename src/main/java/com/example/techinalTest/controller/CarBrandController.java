package com.example.techinalTest.controller;

import com.example.techinalTest.dto.RequestCarBrand;
import com.example.techinalTest.entity.CarBrand;
import com.example.techinalTest.service.CarBrandService;
import com.example.techinalTest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-brand")
public class CarBrandController {
    private final UserService userService;
    private final CarBrandService carBrandService;

    @PostMapping
    public ResponseEntity<Object> createCarBrand(@RequestBody @Valid RequestCarBrand requestCarBrand){
        return carBrandService.createCarBrand(requestCarBrand);
    }

    @GetMapping
    public List<CarBrand> getCarBrands(){
        return carBrandService.getCarBrands();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCarBrandById(@RequestBody @Valid RequestCarBrand requestCarBrand, @PathVariable UUID id){
        return carBrandService.updateCarBrandById(requestCarBrand, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCarBrandById(@PathVariable UUID id){
        return carBrandService.deleteCarBrandById(id);
    }
}
