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
        @Test
        void displaycounpopuinasiaTestNull()
        {
            app.displaycounpopuinasia(null);
        }
        @Test
        void displaycounpopuinasiaTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaycounpopuinasia(countries);
        }
        @Test
        void displaycounpopuinasiaTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaycounpopuinasia(countries);
        }
        @Test
        void displaycounpopuinasiaTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaycounpopuinasia(countries);
        }

        @Test
        void displaytopcounpopuinsoutherneuropeTestNull()
        {
            app.displaytopcounpopuinsoutherneurope(null);
        }
        @Test
        void displaytopcounpopuinsoutherneuropeTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaytopcounpopuinsoutherneurope(countries);
        }
        @Test
        void displaytopcounpopuinsoutherneuropeTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaytopcounpopuinsoutherneurope(countries);
        }
        @Test
        void displaytopcounpopuinsoutherneuropeTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaytopcounpopuinsoutherneurope(countries);
        }

        @Test
        void displaycounpopuincaribbeanTestNull()
        {
            app.displaycounpopuincaribbean(null);
        }
        @Test
        void displaycounpopuincaribbeanTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaycounpopuincaribbean(countries);
        }
        @Test
        void displaycounpopuincaribbeanTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaycounpopuincaribbean(countries);
        }
        @Test
        void displaycounpopuincaribbeanTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaycounpopuincaribbean(countries);
        }
        @Test
        void displaytopcounpopuinworldTestNull()
        {
            app.displaytopcounpopuinworld(null);
        }
        @Test
        void displaytopcounpopuinworldTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaytopcounpopuinworld(countries);
        }
        @Test
        void displaytopcounpopuinworldTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaytopcounpopuinworld(countries);
        }
        @Test
        void displaytopcounpopuinworldTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaytopcounpopuinworld(countries);
        }
        @Test
        void displaytopcounpopuinasiaTestNull()
        {
            app.displaytopcounpopuinasia(null);
        }
        @Test
        void displaytopcounpopuinasiaTestEmpty()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            app.displaytopcounpopuinasia(countries);
        }
        @Test
        void displaytopcounpopuinasiaTestEmptyCoun()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            countries.add(null);
            app.displaytopcounpopuinasia(countries);
        }
        @Test
        void displaytopcounpopuinasiaTestNormal()
        {
            ArrayList<Country> countries = new ArrayList<Country>();
            Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
            countries.add(coun);
            app.displaytopcounpopuinasia(countries);
        }
        @Test
        void displaycitypopuinasiaTestNull()
        {
            app.displaycitypopuinasia(null);
        }
        @Test
        void displaycitypopuinasiaTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaycitypopuinasia(cities);
        }
        @Test
        void displaycitypopuinasiaTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaycitypopuinasia(cities);
        }
        @Test
        void displaycitypopuinasiaTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaycitypopuinasia(cities);
        }

        @Test
        void displaycitypopuinmiddleeastTestNull()
        {
            app.displaycitypopuinmiddleeast(null);
        }
        @Test
        void displaycitypopuinmiddleeastTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaycitypopuinmiddleeast(cities);
        }
        @Test
        void displaycitypopuinmiddleeastTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaycitypopuinmiddleeast(cities);
        }
        @Test
        void displaycitypopuinmiddleeastTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaycitypopuinmiddleeast(cities);
        }

        @Test
        void displaycitypopuinMyanmarTestNull()
        {
            app.displaycitypopuinMyanmar(null);
        }
        @Test
        void displaycitypopuinMyanmarTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaycitypopuinMyanmar(cities);
        }
        @Test
        void displaycitypopuinMyanmarTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaycitypopuinMyanmar(cities);
        }
        @Test
        void displaycitypopuinMyanmarTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaycitypopuinMyanmar(cities);
        }

        @Test
        void displaycitypopuinvirginiaTestNull()
        {
            app.displaycitypopuinvirginia(null);
        }
        @Test
        void displaycitypopuinGelderlandTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaycitypopuinvirginia(cities);
        }
        @Test
        void displaycitypopuinGelderlandTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaycitypopuinvirginia(cities);
        }
        @Test
        void displaycitypopuinGelderlandTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaycitypopuinvirginia(cities);
        }

        @Test
        void displaytopcitypopuinworldTestNull()
        {
            app.displaytopcitypopuinworld(null);
        }
        @Test
        void displaytopcitypopuinworldTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaytopcitypopuinworld(cities);
        }
        @Test
        void displaytopcitypopuinworldTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaytopcitypopuinworld(cities);
        }
        @Test
        void displaytopcitypopuinworldTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaytopcitypopuinworld(cities);
        }
        @Test
        void displaytopcitypopuincaribbeanTestNull()
        {
            app.displaytopcitypopuincaribbean(null);
        }
        @Test
        void displaytopcitypopuincaribbeanTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaytopcitypopuincaribbean(cities);
        }
        @Test
        void displaytopcitypopuincaribbeanTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaytopcitypopuincaribbean(cities);
        }
        @Test
        void displaytopcitypopuincaribbeanTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaytopcitypopuincaribbean(cities);
        }
        @Test
        void displaytopcitypopuinasiaTestNull()
        {
            app.displaytopcitypopuinasia(null);
        }
        @Test
        void displaytopcitypopuinasiaTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaytopcitypopuinasia(cities);
        }
        @Test
        void displaytopcitypopuinasiaTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaytopcitypopuinasia(cities);
        }
        @Test
        void displaytopcitypopuinasiaTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaytopcitypopuinasia(cities);
        }
        @Test
        void displaytopcitypopuinmyanmarTestNull()
        {
            app.displaytopcitypopuinmyanmar(null);
        }
        @Test
        void displaytopcitypopuinmyanmarTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaytopcitypopuinmyanmar(cities);
        }
        @Test
        void displaytopcitypopuinmyanmarTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaytopcitypopuinmyanmar(cities);
        }
        @Test
        void displaytopcitypopuinmyanmarTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaytopcitypopuinmyanmar(cities);
        }
        @Test
        void displaytopcitypopuinvirginiaTestNull()
        {
            app.displaytopcitypopuinvirginia(null);
        }
        @Test
        void displaytopcitypopuinvirginiaTestEmpty()
        {
            ArrayList<City> cities = new ArrayList<City>();
            app.displaytopcitypopuinvirginia(cities);
        }
        @Test
        void displaytopcitypopuinvirginiaTestEmptyCoun()
        {
            ArrayList<City> cities = new ArrayList<City>();
            cities.add(null);
            app.displaytopcitypopuinvirginia(cities);
        }
        @Test
        void displaytopcitypopuinvirginiaTestNormal()
        {
            String countryname = "Myanmar";
            Country coun = new Country(countryname);
            ArrayList<City> cities = new ArrayList<City>();
            City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
            cities.add(city);
            app.displaytopcitypopuinvirginia(cities);
        }




    }



