package com.crime.crimeeventproducer.service;

import com.crime.crimeeventproducer.integration.CrimeDTO;

public interface CrimeEventProducerService {

    void saveCrime( CrimeDTO crimeDTO );
}
