package com.itakademy.tpdavidsayagdfs24a.controllers;

import com.itakademy.tpdavidsayagdfs24a.models.Cuve;
import com.itakademy.tpdavidsayagdfs24a.repositories.CuveRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cuves")

public class CuveController {

    public CuveRepository cuveRepository;
    public CuveController(CuveRepository cuveRepository){
        this.cuveRepository = cuveRepository;
    }

    // Récupérer toutes les cuves
    @GetMapping(value = "/")
    List<Cuve> all() {
        return cuveRepository.findAll();
    }

    // Récupérer une cuve
    @GetMapping(value="/{cuve}")
    Cuve getOne(@PathVariable(name = "cuve", required = false)
                     Cuve cuve) {
        if(cuve == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuve introuvable");
        } else {
            return cuve;
        }
    }

    // Créer une cuve
    @PostMapping(value = "/") // http://localhost:8090/api/cuves
    public ResponseEntity<Cuve> saveCuve(@Valid @RequestBody Cuve cuve, BindingResult bindingResult){
        cuveRepository.save(cuve);
        return new ResponseEntity<>(cuve, HttpStatus.CREATED);
    }

    // Modifier une cuve
    @PutMapping(value = "/{cuve}")
    public ResponseEntity<Cuve> update(@PathVariable(name = "cuve", required = false) Cuve cuve,
                                            @Valid @RequestBody Cuve cuveUpdate, BindingResult bindingResult) {
        if (cuve == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cuve introuvable"
            );
        } else {
            if(bindingResult.hasErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                cuveUpdate.setId(cuve.getId());
                cuveRepository.save(cuveUpdate);
                return new ResponseEntity<>(cuveUpdate, HttpStatus.OK);
            }
        }
    }

    // Supprimer une cuve
    @DeleteMapping(value = "/{cuve}")
    public void deleteOne(@PathVariable(name = "cuve", required = false) Cuve cuve) {
        if (cuve == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cuve introuvable"
            );
        } else {
            cuveRepository.delete(cuve);
        }
    }





}
