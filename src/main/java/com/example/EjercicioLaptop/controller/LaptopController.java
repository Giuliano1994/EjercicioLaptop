package com.example.EjercicioLaptop.controller;

import com.example.EjercicioLaptop.entity.LaptopEntity;
import com.example.EjercicioLaptop.repository.LaptopRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // atributo
    LaptopRepository repository;

    //Controlador

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }


    //Metodos
    @GetMapping ("/api/laptops")
    public ResponseEntity<List<LaptopEntity>> findAll(){

        List<LaptopEntity> resultado = repository.findAll();

        return ResponseEntity.ok(resultado);
    }


    @GetMapping ("/api/laptop/{id}")
    public ResponseEntity<LaptopEntity> findById(@PathVariable Long id){

        Optional<LaptopEntity> resultado = repository.findById(id);

        if (resultado.isPresent()){

            return ResponseEntity.ok(resultado.get());
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping ("/api/create")
    public ResponseEntity<LaptopEntity> create(@RequestBody LaptopEntity laptop){

        if (laptop.getId() != null){

            return ResponseEntity.notFound().build();
        }

        LaptopEntity resultado = repository.save(laptop);

        return ResponseEntity.ok(resultado);
    }


    @PostMapping ("/api/laptop/update")
    public ResponseEntity<LaptopEntity> update(@RequestBody LaptopEntity laptop){

        if (laptop.getId() != null && repository.existsById(laptop.getId())){

            repository.save(laptop);

            return ResponseEntity.ok(laptop);
        }
        else {

           return  ResponseEntity.notFound().build();

        }
    }





    @DeleteMapping ("/api/laptop/{id}")
    public ResponseEntity<LaptopEntity> delete(@PathVariable Long id){

        if (repository.existsById(id)){

            repository.deleteById(id);

            return ResponseEntity.ok().build();
        }else {

            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping ("/api/laptop/delete")
    public ResponseEntity<LaptopEntity> deleteAll(){

        repository.deleteAll();

       return  ResponseEntity.noContent().build();

    }


}
