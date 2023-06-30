package com.crime.crimeeventproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.crimeeventproducer.integration.CrimeDTO;
import com.crime.crimeeventproducer.service.CrimeEventProducerService;

@RestController
@RequestMapping( "/crime" )
public class CrimeEventProducerController {

    @Autowired
    private CrimeEventProducerService crimeEventProducerService;

    @PostMapping( "/report" )
    public void saveCrime( @RequestBody CrimeDTO crimeDTO ) {

        crimeEventProducerService.saveCrime( crimeDTO );
    }
}
