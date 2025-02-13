package com.example.techinalTest.repository;

import com.example.techinalTest.entity.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarBrandRepository extends JpaRepository<CarBrand, UUID> {
}
