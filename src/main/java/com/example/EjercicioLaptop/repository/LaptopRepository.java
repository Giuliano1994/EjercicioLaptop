package com.example.EjercicioLaptop.repository;


import com.example.EjercicioLaptop.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {

}
