package com.crime.crimeeventproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CrimeeventproducerApplication {

    public static void main( String[] args ) {

        SpringApplication.run( CrimeeventproducerApplication.class, args );
    }

}
