package com.rochelle.dojos_ninjas_demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rochelle.dojos_ninjas_demo.models.Ninja;

@Repository
// ninja is the model we are keeping track of and the type of it's id is Long
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
    // always want to override the findAll -> override iteration
    List<Ninja> findAll();
}
