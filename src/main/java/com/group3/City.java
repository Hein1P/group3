package com.group3;

public class City {

    /**
     * City's ID
     */
    private int ID;
    /**
     * City's Name
     */
    private String Name;
    /**
     * City's Country COde
     */
    private String CountryCode;
    /**
     * City's District
     */
    private String District;
    /**
     * City's Population
     */
    private int Population;
    /**
     * City's Sum Population
     */
    private long CitySumPopulation;

    /**
     * No City's Sum Population
     */
    private long NoCitySumPopulation;

    /**
     * City's Country
     */
    private Country CountryDetail;

    public City(long citySumPopulation, long noCitySumPopulation, Country countryDetail) {
        CitySumPopulation = citySumPopulation;
        NoCitySumPopulation = noCitySumPopulation;
        CountryDetail = countryDetail;
    }

    public City(int ID, String name, int population, String district, Country countryDetail) {
        this.ID = ID;
        Name = name;
        //CountryCode = countryCode;
        District = district;
        Population = population;
        CountryDetail = countryDetail;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public Country getCountryDetail() {
        return CountryDetail;
    }


    public void setCountryDetail(Country countryDetail) {
        CountryDetail = countryDetail;
    }

    public long getCitySumPopulation() {
        return CitySumPopulation;
    }

    public void setCitySumPopulation(long citySumPopulation) {
        CitySumPopulation = citySumPopulation;
    }

    public long getNoCitySumPopulation() {
        return NoCitySumPopulation;
    }

    public void setNoCitySumPopulation(long noCitySumPopulation) {
        NoCitySumPopulation = noCitySumPopulation;
    }
}
