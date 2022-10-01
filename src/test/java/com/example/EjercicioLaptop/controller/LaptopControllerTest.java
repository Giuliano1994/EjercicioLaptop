package com.example.EjercicioLaptop.controller;

import com.example.EjercicioLaptop.entity.LaptopEntity;
import com.example.EjercicioLaptop.repository.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.discovery.predicates.IsTestClassWithTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate template;
    @Autowired
    private RestTemplateBuilder builder;
    @LocalServerPort 
    private int port;

    @BeforeEach
    void setUp() {
        builder = builder.rootUri("http://localhost:" + port);
        template = new TestRestTemplate(builder);

    }

    @Test
    void findAll() {
        ResponseEntity<LaptopEntity[]> resultado = template.getForEntity("/api/laptops", LaptopEntity[].class);

        assertEquals(resultado.getStatusCode(), HttpStatus.OK);

        assertEquals(resultado.getStatusCodeValue(), 200);

        List<LaptopEntity> laptops = Arrays.asList(resultado.getBody());

        assertEquals(laptops.size(),0);

    }

    @DisplayName("bucar laptop por id, nohay laptop en la bbdd")
    @Test
    void findById() {

        ResponseEntity<LaptopEntity> resultado = template.getForEntity("/api/laptop/1", LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());

        assertEquals(404, resultado.getStatusCodeValue());

    }

    @DisplayName("crear")
    @Test
    void create() {
  /*      HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {    
                        "id":"1",
                        "marca":"Lenovo",
                        "modelo":"Len150",
                        "precio":150000
                        "stock":true
                    }
                """;

        HttpEntity<String>request = new HttpEntity<>(json, headers);

        ResponseEntity<LaptopEntity> response = template.exchange("/api/create", HttpMethod.POST, request, LaptopEntity.class);

        LaptopEntity laptop = response.getBody();

        assertEquals("Lenovo", laptop.getMarca());
        assertEquals("Len150", laptop.getModelo());
        assertEquals(150000D, laptop.getPrecio());
        assertEquals(true, laptop.isStock());

   */
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {


    }
}