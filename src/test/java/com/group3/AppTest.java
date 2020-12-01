
package com.group3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
        Country coun = new Country(null,countryname,null);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(2710, "Rangoon (Yangon)", 3361700, "Rangoon [Yangon]", coun);
        cities.add(city);
        app.displayCity(cities);

    }

    @Test
    void displayCityPopuOfPeopleinEachContinentTestNull() {
        app.displayCityPopuOfPeopleinEachContinent(null);
    }

    @Test
    void displayCityPopuOfPeopleinEachContinentTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopuOfPeopleinEachContinent(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachContinentTestEmptyCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopuOfPeopleinEachContinent(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachContinentTestNormal() {
        String continent = "Asia";
        Country coun = new Country(null,continent);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City( "0.08%", "99.92%",Long.valueOf(900937599400L),coun);
        cities.add(city);
        app.displayCityPopuOfPeopleinEachContinent(cities);

    }
    @Test
    void displayCityPopuOfPeopleinEachRegionTestNull() {
        app.displayPopuOfPeopleinEachRegion(null);
    }

    @Test
    void displayCityPopuOfPeopleinEachRegionTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayPopuOfPeopleinEachRegion(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachRegionTestEmptyCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayPopuOfPeopleinEachRegion(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachRegionTestNormal() {
        String Region = "Southeast Asia";
        Country coun = new Country(null,Region);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(  "0.08%", "99.92%",Long.valueOf(10000000L),coun);
        cities.add(city);
        app.displayPopuOfPeopleinEachRegion(cities);

    }

    @Test
    void displayCityPopuOfPeopleinEachCountryTestNull() {
        app.displayPopuOfPeopleinEachCountry(null);
    }

    @Test
    void displayCityPopuOfPeopleinEachCountryTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayPopuOfPeopleinEachCountry(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachCountryTestEmptyCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayPopuOfPeopleinEachCountry(cities);
    }

    @Test
    void displayCityPopuOfPeopleinEachCountryTestNormal() {
        String Country = "Myanmar";
        Country coun = new Country(null,Country);
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City(  "0.08%", "99.92%",Long.valueOf(10000000L),coun);
        cities.add(city);
        app.displayPopuOfPeopleinEachCountry(cities);

    }

    @Test
    void displayworldpopulationTestNull() {
        app.displayWorldPopulation(null);
    }

    @Test
    void displayworldpopulationTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayWorldPopulation(countries);
    }

    @Test
    void displayworldpopulationTestEmptyCountry() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayWorldPopulation(countries);
    }

    @Test
    void displayworldpopulationTestNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country(Long.valueOf(6078749450L),null);
        countries.add(country);
        app.displayWorldPopulation(countries);

    }
    @Test
    void displaycountrypopulationTestNull() {
        app.displayCountryPopulation(null);
    }

    @Test
    void displaycountrypopulationTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountryPopulation(countries);
    }

    @Test
    void displaycountrypopulationTestEmptyCountry() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountryPopulation(countries);
    }

    @Test
    void displaycountrypopulationTestNormal() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country(Long.valueOf(3705025700L), "Asia");
        countries.add(country);
        app.displayCountryPopulation(countries);

    }

    @Test
    void displayCityPopulationTestNull() {
        app.displayCityPopulation(null);
    }

    @Test
    void displayCityPopulationTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCityPopulation(cities);
    }

    @Test
    void displayCityPopulationTestEmptyCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCityPopulation(cities);
    }

    @Test
    void displayCityPopulationTestNormal() {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City("Rangoon [Yangon]", 3361700);
        cities.add(city);
        app.displayCityPopulation(cities);

    }


    @Test
    void displayLanguageTestNull() {
        app.displayLanguage(null);
    }

    @Test
    void displayLanguageTestEmpty() {
        ArrayList<CountryLanguage> Languages = new ArrayList<CountryLanguage>();
        app.displayLanguage(Languages);
    }

    @Test
    void displayLanguageTestEmptyCountryLanguage() {
        ArrayList<CountryLanguage> Languages = new ArrayList<CountryLanguage>();
        Languages.add(null);
        app.displayLanguage(Languages);
    }

    @Test
    void displayLanguageTestNormal() {
        ArrayList<CountryLanguage> languages = new ArrayList<CountryLanguage>();
        CountryLanguage language = new CountryLanguage("Chinese", "19.61%", 1191843539);
        languages.add(language);
        app.displayLanguage(languages);

    }
}

