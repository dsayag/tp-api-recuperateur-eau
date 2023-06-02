package com.itakademy.tpdavidsayagdfs24a.repositories;

import com.itakademy.tpdavidsayagdfs24a.models.Residence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenceRepository extends CrudRepository<Residence, Integer> {
    @Override
    List<Residence> findAll();
    List<Residence> findByUser_Id(Integer id);

}