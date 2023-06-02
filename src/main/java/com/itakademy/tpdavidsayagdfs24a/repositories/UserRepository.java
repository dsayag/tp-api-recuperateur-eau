package com.itakademy.tpdavidsayagdfs24a.repositories;

import com.itakademy.tpdavidsayagdfs24a.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();
    User findByEmailAndMdp(String email, String mdp);
}