package com.itakademy.tpdavidsayagdfs24a.controllers;

import com.itakademy.tpdavidsayagdfs24a.models.Residence;
import com.itakademy.tpdavidsayagdfs24a.models.User;
import com.itakademy.tpdavidsayagdfs24a.repositories.ResidenceRepository;
import com.itakademy.tpdavidsayagdfs24a.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/residences")
public class ResidenceController {
    public ResidenceRepository residenceRepository;
    private UserRepository userRepository;

    public ResidenceController(ResidenceRepository residenceRepository, UserRepository userRepository) {
        this.residenceRepository = residenceRepository;
        this.userRepository = userRepository;
    }

    // Récupérer toutes les résidences
    @GetMapping(value = "/")
    public List<Residence> all() {
        return residenceRepository.findAll();
    }

    // Récupérer une résidence
    @GetMapping(value="/{residence}")
    Residence getOne(@PathVariable(name = "residence", required = false)
                     Residence residence) {
        if(residence == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Residence introuvable");
        } else {
            return residence;
        }
    }

    // Récupérer la liste des résidences d'un user
    @GetMapping(value="/user/{userId}")
    public ResponseEntity<List<Residence>> getResidencesByUser(@PathVariable(name = "userId", required = false) Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User introuvable");
        }
        List<Residence> residences = residenceRepository.findByUser_Id(userId);
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    // Créer une residence
    @PostMapping(value = "/") // http://localhost:8090/api/residences
    public ResponseEntity<Residence> saveResidence(@Valid @RequestBody Residence residence, BindingResult bindingResult){
        residenceRepository.save(residence);
        return new ResponseEntity<>(residence, HttpStatus.CREATED);
    }

    // Modifier une residence
    @PutMapping(value = "/{residence}")
    public ResponseEntity<Residence> update(@PathVariable(name = "residence", required = false) Residence residence,
                                            @Valid @RequestBody Residence residenceUpdate, BindingResult bindingResult) {
        if (residence == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Residence introuvable"
            );
        } else {
            if(bindingResult.hasErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                residenceUpdate.setId(residence.getId());
                residenceRepository.save(residenceUpdate);
                return new ResponseEntity<>(residenceUpdate, HttpStatus.OK);
            }
        }
    }

    // Supprimer une residence
    @DeleteMapping(value = "/{residence}")
    public void deleteOne(@PathVariable(name = "residence", required = false) Residence residence) {
        if (residence == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Residence introuvable"
            );
        } else {
            residenceRepository.delete(residence);
        }
    }

}
