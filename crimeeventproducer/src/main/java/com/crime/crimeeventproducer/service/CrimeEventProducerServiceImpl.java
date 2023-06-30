package com.crime.crimeeventproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crime.crimeeventproducer.integration.CrimeDTO;
import com.crime.crimeeventproducer.integration.KafkaCrimeProducer;

@Service
public class CrimeEventProducerServiceImpl implements CrimeEventProducerService {

    @Autowired
    private KafkaCrimeProducer kafkaCrimeProducer;

    @Override
    public void saveCrime( CrimeDTO crimeDTO ) {

        kafkaCrimeProducer.saveCrime( crimeDTO );
    }

}
