package com.itakademy.tpdavidsayagdfs24a.controllers;

import com.itakademy.tpdavidsayagdfs24a.models.Donnee;
import com.itakademy.tpdavidsayagdfs24a.repositories.DonneeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/donnees")
public class DonneeController {
    public DonneeRepository donneeRepository;
    public DonneeController(DonneeRepository donneeRepository) {
        this.donneeRepository = donneeRepository;
    }

    // Récupérer toutes les donnees
    @GetMapping(value = "/")
    List<Donnee> all() {
        return donneeRepository.findAll();
    }

    // Récupérer une donnees selon son id
    @GetMapping(value="/{donnee}")
    Donnee getOne(@PathVariable(name = "donnee", required = false)
                     Donnee donnee) {
        if(donnee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Donnee introuvable");
        } else {
            return donnee;
        }
    }

    // Créer une donnée
    @PostMapping(value = "/") // http://localhost:8090/api/donnees
    public ResponseEntity<Donnee> saveResidence(@Valid @RequestBody Donnee donnee, BindingResult bindingResult){

        donneeRepository.save(donnee);
        return new ResponseEntity<>(donnee, HttpStatus.CREATED);
    }

    // Modifier une donnee
    @PutMapping(value = "/{donnee}")
    public ResponseEntity<Donnee> update(@PathVariable(name = "donnee", required = false) Donnee donnee,
                                            @Valid @RequestBody Donnee donneeUpdate, BindingResult bindingResult) {
        if (donnee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Donnee introuvable"
            );
        } else {
            if(bindingResult.hasErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                donneeUpdate.setId(donnee.getId());
                donneeRepository.save(donneeUpdate);
                return new ResponseEntity<>(donneeUpdate, HttpStatus.OK);
            }
        }
    }

    // Supprimer une donnee
    @DeleteMapping(value = "/{donnee}")
    public void deleteOne(@PathVariable(name = "donnee", required = false) Donnee donnee) {
        if (donnee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Donnee introuvable"
            );
        } else {
            donneeRepository.delete(donnee);
        }
    }
}
