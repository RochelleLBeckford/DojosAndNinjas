package com.rochelle.dojos_ninjas_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.dojos_ninjas_demo.models.Ninja;
import com.rochelle.dojos_ninjas_demo.repository.NinjaRepository;

@Service
public class NinjaService {
    // service talks to the repo
    // coonect servive to repo
    @Autowired NinjaRepository ninjaRepository;
    
    public Ninja createNinja( Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }
}
