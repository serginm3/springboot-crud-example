package com.example.demo.controller;

import com.example.demo.dto.CatRequest;
import com.example.demo.entities.Cat;
import com.example.demo.repositories.iCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatController {

    @Autowired
    private iCatRepository iCatRepository;

    @GetMapping("/cats")
    public Iterable<Cat> getCats() {
        return iCatRepository.findAll();
    }

    @PostMapping("/cats")
    public CatRequest createCat(@RequestBody CatRequest request) {

        Cat cat = new Cat();
        cat.setId(request.getId()); // mejor quitar si es autogenerado
        cat.setName(request.getName());
        cat.setPicUrl(request.getPicUrl());

        Cat savedCat = iCatRepository.save(cat);

        // devolver el MISMO DTO actualizado
        request.setId(savedCat.getId());

        return request;
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable Long id) {

        return iCatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {

        if (!iCatRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        iCatRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/cats/{id}")
    public ResponseEntity<Cat> updateCat(
            @PathVariable Long id,
            @RequestBody CatRequest request) {

        return iCatRepository.findById(id)
                .map(cat -> {

                    cat.setName(request.getName());
                    cat.setPicUrl(request.getPicUrl());

                    Cat updated = iCatRepository.save(cat);

                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
