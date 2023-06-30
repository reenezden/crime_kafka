package com.crime.crimeeventproducer.integration;

public class CrimeDTO {

    private String imagePath;
    private String description;
    private String location;

    public CrimeDTO( String imagePath, String description, String location ) {

        this.imagePath = imagePath;
        this.description = description;
        this.location = location;
    }


    public String getImagePath() {

        return imagePath;
    }


    public String getDescription() {

        return description;
    }


    public String getLocation() {

        return location;
    }


    public void setImagePath( String imagePath ) {

        this.imagePath = imagePath;
    }


    public void setDescription( String description ) {

        this.description = description;
    }


    public void setLocation( String location ) {

        this.location = location;
    }


    @Override
    public String toString() {

        return "Crime [imagePath=" + imagePath + ", description=" + description + ", location="
                + location + "]";
    }

}
