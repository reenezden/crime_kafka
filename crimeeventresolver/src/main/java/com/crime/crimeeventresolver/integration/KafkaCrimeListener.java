package com.crime.crimeeventresolver.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.crime.crimeeventresolver.service.CrimeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaCrimeListener {

    Logger logger = LoggerFactory.getLogger( KafkaCrimeListener.class );

    @Value( value = "${kafka.resolve.location}" )
    private String resolveTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaCrimeListener() {

    }


    @KafkaListener( topics = "${kafka.listner.location}" )
    public void receiveCrime( String crimeJson ) {

        CrimeDTO crimeDTO;
        try {
            crimeDTO = objectMapper.readValue( crimeJson, CrimeDTO.class );
            String crimeDToString = objectMapper.writeValueAsString( crimeDTO );
            kafkaTemplate.send( resolveTopic, crimeDToString );
        }
        catch ( JsonMappingException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( JsonProcessingException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
