package com.group3;

public class CountryLanguage {
    /**
     * Country's Code
     */
    private String CountryCode;
    /**
     * Country's Language
     */
    private String Language;
    /**
     * Country's Language percentage
     */
    private String Percentage;

    /**
     * Country's population
     */
    private long population;

    public CountryLanguage( String language, String percentage, long population) {
        Language = language;
        Percentage = percentage;
        this.population = population;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
