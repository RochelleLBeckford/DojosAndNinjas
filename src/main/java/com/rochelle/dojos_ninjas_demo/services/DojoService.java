package com.rochelle.dojos_ninjas_demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.dojos_ninjas_demo.models.Dojo;
import com.rochelle.dojos_ninjas_demo.repository.DojoRepository;

// have to annotate this as a service
@Service
public class DojoService {
    // service talks to the repo
    // coonect servive to repo
    @Autowired DojoRepository dojoRepository;

    // set up method to take in a Dojo 
    // -> saying expect a param or arguement of type dojo
    public void createDojo(Dojo dojo) {
        // call on repo -> pass down dojo
        dojoRepository.save(dojo);
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo getOneDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
}
