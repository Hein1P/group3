package com.group3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

    public class AppTest
    {
        static App app;

        @BeforeAll
        static void init()
        {
            app = new App();
        }

        @Test
        void displaycounpopuinworldTestNull()
        {
            app.displaycounpopuinworld(null);
        }
        @Test
        void displaycounpopuinworldTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaycounpopuinworld(countries);
        }
        @Test
        void displaycounpopuinworldTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaycounpopuinworld(countries);
        }
        @Test
        void displaycounpopuinworldTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaycounpopuinworld(countries);
        }
        @Test
        void displaycitypopuinworldTestNull()
        {
            app.displaycitypopuinworld(null);
        }
        @Test
        void displaycitypopuinworldTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaycitypopuinworld(cities);
        }
        @Test
        void displaycitypopuinworldTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaycitypopuinworld(cities);
        }
        @Test
        void displaycitypopuinworldTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaycitypopuinworld(cities);
        }

    }

