
package com.group3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    @Test
    void displayCountryTestNull() {
        app.displayCountry(null);
    }

    @Test
    void displayCountryTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountry(countries);
    }

    @Test
    void displayCountryTestEmptyCoun() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountry(countries);
    }

    @Test
    void displayCountryTestNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR", "Myanmar", "Asia", "Southeast Asia", 45611000, 2710);
        countries.add(coun);
        app.displayCountry(countries);
    }

    @Test
    void displayCityTestNull() {
        app.displayCity(null);
    }

    @Test
    void displayCityTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCity(cities);
    }

    @Test
    void displayCityTestEmptyCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCity(cities);
    }

    @Test
    void displayCityTestNormal() {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710, "Rangoon (Yangon)", 3361700, "Rangoon [Yangon]", coun);
        cities.add(city);
        app.displayCity(cities);

    }
}

