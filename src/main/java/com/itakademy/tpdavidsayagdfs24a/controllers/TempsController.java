package com.itakademy.tpdavidsayagdfs24a.controllers;

import com.itakademy.tpdavidsayagdfs24a.models.Temps;
import com.itakademy.tpdavidsayagdfs24a.repositories.TempsRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/temps")
public class TempsController {
    public TempsRepository tempsRepository;
    public TempsController(TempsRepository tempsRepository) {
        this.tempsRepository = tempsRepository;
    }

    // Récupérer la liste des temps des 5 derniers jours d'une résidence
    public static void search( String[] args ) {
        System.out.println("Hello");
    }

//        City city = $("input[name=ville]").val().replace(/\s/g, "");
//        let City city = $("input[name=ville]").val().replace(/\s/g, "");
//        if(city.length == 0){
//            alert("Vous n'avez rien saisi")
//        }
//        else{
//            let params = {
//                    q : city,
//                    appid : "ddc1fb46496269d36a7cb86214f42266",
//                    units : "metrics",
//                    lang : "fr",
//    };
//            $.ajax({
//                    url : `https://api.openweathermap.org/data/2.5/forecast`,
//                    method : 'GET',
//                    dataType : 'JSONP',
//                    data: params,
//                    success: show,
//                    error: (xhr, status, error) => console.log(xhr, status, error)
//         });
//        }
//    }
//    MyURL myURL = "api.openweathermap.org/data/2.5/forecast?lat=61.0619611&lon=28.1033313&appid=fe15b043f8750eff8eca663f0b86a299"


    // Créer un temps
    @PostMapping(value = "/") // http://localhost:8090/api/temps
    public ResponseEntity<Temps> saveTemps(@Valid @RequestBody Temps temps, BindingResult bindingResult){

        tempsRepository.save(temps);
        return new ResponseEntity<>(temps, HttpStatus.CREATED);
    }

    // Modifier un temps
    @PutMapping(value = "/{temps}")
    public ResponseEntity<Temps> update(@PathVariable(name = "temps", required = false) Temps temps,
                                            @Valid @RequestBody Temps tempsUpdate, BindingResult bindingResult) {
        if (temps == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Temps introuvable"
            );
        } else {
            if(bindingResult.hasErrors()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                tempsUpdate.setId(temps.getId());
                tempsRepository.save(tempsUpdate);
                return new ResponseEntity<>(tempsUpdate, HttpStatus.OK);
            }
        }
    }

}
