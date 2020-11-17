package com.group3;

public class Country {
    /**
     * Country's Code
     */
    private String Code;
    /**
     * Country's Name
     */
    private String Name;
    /**
     * Country's Continent
     */
    private String Continent;
    /**
     * Country's Region
     */
    private String Region;

    /**
     * Country's Population
     */
    private int Population;
    /**
     * Country's Capital
     */
    private String Capital;

    public Country(String name) {
        Name = name;
    }

    public Country(String code, String name, String continent, String region, int population, String capital) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Population = population;
        Capital = capital;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }
}
