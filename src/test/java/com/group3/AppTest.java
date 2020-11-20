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
    void displayCounPopuinWorldTestNull()
    {
        app.displayCounPopuinWorld(null);
    }
    @Test
    void displayCounPopuinWorldTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCounPopuinWorld(countries);
    }
    @Test
    void displayCounPopuinWorldTestEmptyCoun()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCounPopuinWorld(countries);
    }
    @Test
    void displayCounPopuinWorldTestNormal()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
        countries.add(coun);
        app.displayCounPopuinWorld(countries);
    }
    @Test
    void displayCityPopuinWorldTestNull()
    {
        app.displayCityPopuinWorld(null);
    }
    @Test
    void displayCityPopuinWorldTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuinWorld(cities);
    }
    @Test
    void displayCityPopuinWorldTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuinWorld(cities);
    }
    @Test
    void displayCityPopuinWorldTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayCityPopuinWorld(cities);
    }
    @Test
    void displayCounPopuinAsiaTestNull()
    {
        app.displayCounPopuinAsia(null);
    }
    @Test
    void displayCounPopuinAsiaTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCounPopuinAsia(countries);
    }
    @Test
    void displayCounPopuinAsiaTestEmptyCoun()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCounPopuinAsia(countries);
    }
    @Test
    void displayCounPopuinAsiaTestNormal()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
        countries.add(coun);
        app.displayCounPopuinAsia(countries);
    }
    @Test
    void displayCounPopuinCaribbeanTestNull()
    {
        app.displayCounPopuinCaribbean(null);
    }
    @Test
    void displayCounPopuinCaribbeanTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCounPopuinCaribbean(countries);
    }
    @Test
    void displayCounPopuinCaribbeanTestEmptyCoun()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCounPopuinCaribbean(countries);
    }
    @Test
    void displayCounPopuinCaribbeanTestNormal()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
        countries.add(coun);
        app.displayCounPopuinCaribbean(countries);
    }
    @Test
    void displayTopCounpopuinWorldTestNull()
    {
        app.displayTopCounPopuinWorld(null);
    }
    @Test
    void displayTopCounPopuinWorldTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayTopCounPopuinWorld(countries);
    }
    @Test
    void displayTopCounPopuinWorldTestEmptyCoun()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayTopCounPopuinWorld(countries);
    }
    @Test
    void displayTopCounPopuinWorldTestNormal()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
        countries.add(coun);
        app.displayTopCounPopuinWorld(countries);
    }
    @Test
    void displayTopCounPopuinAsiaTestNull()
    {
        app.displayTopCounPopuinAsia(null);
    }
    @Test
    void displayTopCounPopuinAsiaTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayTopCounPopuinAsia(countries);
    }
    @Test
    void displayTopCounPopuinAsiaTestEmptyCoun()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayTopCounPopuinAsia(countries);
    }
    @Test
    void displayTopCounPopuinAsiaTestNormal()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("MMR","Myanmar","Asia","Southeast Asia",45611000,2710);
        countries.add(coun);
        app.displayTopCounPopuinAsia(countries);
    }
    @Test
    void displayCityPopuinAsiaTestNull()
    {
        app.displayCityPopuinAsia(null);
    }
    @Test
    void displayCityPopuinAsiaTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuinAsia(cities);
    }
    @Test
    void displayCityPopuinAsiaTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuinAsia(cities);
    }
    @Test
    void displayCityPopuinAsiaTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayCityPopuinAsia(cities);
    }

    @Test
    void displayCityPopuinMiddleEastTestNull()
    {
        app.displayCityPopuinMiddleEast(null);
    }
    @Test
    void displayCityPopuinMiddleEastTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuinMiddleEast(cities);
    }
    @Test
    void displayCityPopuinMiddleEastTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuinMiddleEast(cities);
    }
    @Test
    void displayCityPopuinMiddleEastTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayCityPopuinMiddleEast(cities);
    }

    @Test
    void displayCityPopuinMyanmarTestNull()
    {
        app.displayCityPopuinMyanmar(null);
    }
    @Test
    void displayCityPopuinMyanmarTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuinMyanmar(cities);
    }
    @Test
    void displayCityPopuinMyanmarTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuinMyanmar(cities);
    }
    @Test
    void displayCityPopuinMyanmarTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayCityPopuinMyanmar(cities);
    }

    @Test
    void displayCityPopuinVirginiaTestNull()
    {
        app.displayCityPopuinVirginia(null);
    }
    @Test
    void displayCityPopuinGelderlandTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuinVirginia(cities);
    }
    @Test
    void displayCityPopuinGelderlandTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuinVirginia(cities);
    }
    @Test
    void displayCityPopuinGelderlandTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayCityPopuinVirginia(cities);
    }

    @Test
    void displayTopCityPopuinWorldTestNull()
    {
        app.displayTopCityPopuinWorld(null);
    }
    @Test
    void displayTopCityPopuinWorldTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayTopCityPopuinWorld(cities);
    }
    @Test
    void displayTopCityPopuinWorldTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayTopCityPopuinWorld(cities);
    }
    @Test
    void displayTopCityPopuinWorldTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayTopCityPopuinWorld(cities);
    }
    @Test
    void displayTopCityPopuinCaribbeanTestNull()
    {
        app.displayTopCityPopuinCaribbean(null);
    }
    @Test
    void displayTopCityPopuinCaribbeanTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayTopCityPopuinCaribbean(cities);
    }
    @Test
    void displayTopCityPopuinCaribbeanTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayTopCityPopuinCaribbean(cities);
    }
    @Test
    void displayTopCityPopuinCaribbeanTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayTopCityPopuinCaribbean(cities);
    }
    @Test
    void displayTopCityPopuinAsiaTestNull()
    {
        app.displayTopCityPopuinAsia(null);
    }
    @Test
    void displayTopCityPopuinAsiaTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayTopCityPopuinAsia(cities);
    }
    @Test
    void displayTopCityPopuinAsiaTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayTopCityPopuinAsia(cities);
    }
    @Test
    void displayTopCityPopuinAsiaTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayTopCityPopuinAsia(cities);
    }
    @Test
    void displayTopCityPopuinMyanmarTestNull()
    {
        app.displayTopCityPopuinMyanmar(null);
    }
    @Test
    void displayTopCityPopuinMyanmarTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayTopCityPopuinMyanmar(cities);
    }
    @Test
    void displayTopCityPopuinMyanmarTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayTopCityPopuinMyanmar(cities);
    }
    @Test
    void displayTopCityPopuinMyanmarTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayTopCityPopuinMyanmar(cities);
    }
    @Test
    void displayTopCityPopuinVirginiaTestNull()
    {
        app.displayTopCityPopuinVirginia(null);
    }
    @Test
    void displayTopCityPopuinVirginiaTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayTopCityPopuinVirginia(cities);
    }
    @Test
    void displayTopCityPopuinVirginiaTestEmptyCoun()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayTopCityPopuinVirginia(cities);
    }
    @Test
    void displayTopCityPopuinVirginiaTestNormal()
    {
        String countryname = "Myanmar";
        Country coun = new Country(countryname);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710,"Rangoon (Yangon)",3361700,"Rangoon [Yangon]",coun);
        cities.add(city);
        app.displayTopCityPopuinVirginia(cities);
    }




}



