package com.itakademy.tpdavidsayagdfs24a.repositories;

import com.itakademy.tpdavidsayagdfs24a.models.Temps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TempsRepository extends CrudRepository<Temps, Integer> {
    @Override
    List<Temps> findAll();
}
