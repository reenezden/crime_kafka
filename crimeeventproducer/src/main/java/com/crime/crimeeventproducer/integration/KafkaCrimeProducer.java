package com.crime.crimeeventproducer.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaCrimeProducer {

    Logger logger = LoggerFactory.getLogger( KafkaCrimeProducer.class );

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public KafkaCrimeProducer( KafkaTemplate<String, String> kafkaTemplate ) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @Value( "${kafka.topic}" )
    private String topic;

    public void saveCrime( CrimeDTO crimeDTO ) {

        try {
            String crimeString = objectMapper.writeValueAsString( crimeDTO );
            kafkaTemplate.send( topic, crimeString );
        }
        catch ( JsonProcessingException e ) {
            logger.error( "Failed to convert object to string" );
        }
    }
}
