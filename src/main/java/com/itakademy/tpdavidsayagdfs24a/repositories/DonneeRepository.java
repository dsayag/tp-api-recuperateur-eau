package com.itakademy.tpdavidsayagdfs24a.repositories;

import com.itakademy.tpdavidsayagdfs24a.models.Donnee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonneeRepository extends CrudRepository<Donnee, Integer> {
    @Override
    List<Donnee> findAll();
}