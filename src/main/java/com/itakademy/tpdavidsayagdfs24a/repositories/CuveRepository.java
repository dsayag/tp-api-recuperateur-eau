package com.itakademy.tpdavidsayagdfs24a.repositories;

import com.itakademy.tpdavidsayagdfs24a.models.Cuve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CuveRepository extends CrudRepository<Cuve, Integer> {
    @Override
    List<Cuve> findAll();
}