package com.rochelle.dojos_ninjas_demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rochelle.dojos_ninjas_demo.models.Dojo;

@Repository
// dojo is the model we are keeping track of and the type of it's id is Long
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    // always want to override the findAll -> override iteration
    List<Dojo> findAll();
}
