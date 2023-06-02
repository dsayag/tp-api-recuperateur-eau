package com.itakademy.tpdavidsayagdfs24a.controllers;

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

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private UserRepository userRepository;
    private ResidenceRepository residenceRepository;

    public UserController(UserRepository userRepository, ResidenceRepository residenceRepository) {
        this.userRepository = userRepository;
        this.residenceRepository = residenceRepository;
    }

    // Récupérer un user par son id
    @GetMapping(value = "/{user}")
    User getOne(@PathVariable(name = "user", required = false) User user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User introuvable");
        } else {
            return user;
        }
    }

    // Récupérer un user par son email et mdp
    @GetMapping("/{email}/{mdp}")
    User getOneByEmailAndMdp(@PathVariable(name = "email", required = false) String email, @PathVariable(name = "mdp", required = false) String mdp) {
        User user = userRepository.findByEmailAndMdp(email, mdp);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User introuvable");
        } else {
            return user;
        }
    }

    // Récupérer tous les users
    @GetMapping(value = "/")
    List<User> all() {
        return userRepository.findAll();
    }

    // Créer un user
    @PostMapping(value = "/") // http://localhost:8090/api/user
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user, BindingResult bindingResult){

        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Modifier un user
    @PutMapping(value = "/{user}")
    public ResponseEntity<User> update(@PathVariable(name = "user", required = false) User user,
                                       @Valid @RequestBody User userUpdate, BindingResult bindingResult) {
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User introuvable"
            );
        } else {
            if(bindingResult.hasErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                userUpdate.setId(user.getId());
                userRepository.save(userUpdate);
                return new ResponseEntity<>(userUpdate, HttpStatus.OK);
            }
        }
    }

    // Supprimer un user
    @DeleteMapping(value = "/{user}")
    public void deleteOne(@PathVariable(name = "user", required = false) User user) {
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User introuvable"
            );
        } else {
            userRepository.delete(user);
        }
    }
}