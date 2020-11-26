package com.group3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testgetCountryPopuinWorld()
    {
        Country coun =app.getCountryPopuinWorld().get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgetTopCountryPopuinWorldsize()
    {
        int coun =app.getTopCountryPopuinWorld(10).size();
        assertEquals(coun, 10);
    }

    @Test
    void testgetCountryPopuinAsia()
    {
        Country coun =app.getCountryPopuinAsia().get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgetCountryPopuinCaribbean()
    {
        Country coun =app.getCountryPopuinCaribbean().get(0);
        assertEquals(coun.getCode(), "CUB");
        assertEquals(coun.getName(), "Cuba");
        assertEquals(coun.getPopulation(),  11201000);
        assertEquals(coun.getContinent(), "North America");
        assertEquals(coun.getRegion(), "Caribbean");
        assertEquals(coun.getCapital(), 2413);
    }

    @Test
    void testgetTopCountryPopuinWorld()
    {
        Country coun =app.getTopCountryPopuinWorld(10).get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgetTopCountriesPopuinAsia()
    {
        Country coun =app.getTopCountriesPopuinAsia(10).get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgetTopCountriesPopuinAsiasize()
    {
        int city =app.getTopCountriesPopuinAsia(10).size();
        assertEquals(city, 10);
    }
    @Test
    void testgetTopCountriesPopuinSoutherneurope()
    {
        Country coun =app.getTopCountriesPopuinSoutherneurope(10).get(0);
        assertEquals(coun.getCode(), "ITA");
        assertEquals(coun.getName(), "Italy");
        assertEquals(coun.getPopulation(), 57680000);
        assertEquals(coun.getContinent(), "Europe");
        assertEquals(coun.getRegion(), "Southern Europe");
        assertEquals(coun.getCapital(), 1464);
    }
    @Test
    void testgetTopCountriesPopuinSoutherneuropesize()
    {
        int city =app.getTopCountriesPopuinSoutherneurope(10).size();
        assertEquals(city, 10);
    }


    @Test
    void testgetCityPopuinWorld()
    {
        City city =app.getCityPopuinWorld().get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }

    @Test
    void testgetCityPopuinAsia()
    {
        City city =app.getCityPopuinAsia().get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }

    @Test
    void testgetCityPopuinMiddleEast()
    {
        City city =app.getCityPopuinMiddleEast().get(0);
        assertEquals(city.getID(), 3357);
        assertEquals(city.getName(), "Istanbul");
        assertEquals(city.getPopulation(), 8787958);
        assertEquals(city.getDistrict(), "Istanbul");
        assertEquals(city.getCountryDetail().getName(), "Turkey");
    }

    @Test
    void testgetCityPopuinMyanmar()
    {
        City city =app.getCityPopuinMyanmar().get(0);
        assertEquals(city.getID(), 2710);
        assertEquals(city.getName(), "Rangoon (Yangon)");
        assertEquals(city.getPopulation(), 3361700);
        assertEquals(city.getDistrict(), "Rangoon [Yangon]");
        assertEquals(city.getCountryDetail().getName(), "Myanmar");
    }

    @Test
    void testgetCityPopuinVirginia()
    {
        City city =app.getCityPopuinVirginia().get(0);
        assertEquals(city.getID(), 3830);
        assertEquals(city.getName(), "Virginia Beach");
        assertEquals(city.getPopulation(), 425257);
        assertEquals(city.getDistrict(), "Virginia");
        assertEquals(city.getCountryDetail().getName(), "United States");
    }


    @Test
    void testgetTopCityPopuinWorld()
    {
        City city =app.getTopCityPopuinWorld(10).get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }
    @Test
    void testgetTopCityPopuinWorldsize()
    {
        int city =app.getTopCityPopuinWorld(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgetTopCityPopuinAsiasize()
    {
        City city =app.getTopCityPopuinAsia(10).get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }
    @Test
    void testgetTopCityPopuinAsia()
    {
        int city =app.getTopCityPopuinAsia(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgetTopCityPopuinCaribbean()
    {
        City city =app.getTopCityPopuinCaribbean(10).get(0);
        assertEquals(city.getID(), 2413);
        assertEquals(city.getName(), "La Habana");
        assertEquals(city.getPopulation(), 2256000);
        assertEquals(city.getDistrict(), "La Habana");
        assertEquals(city.getCountryDetail().getName(), "Cuba");
    }
    @Test
    void testgetTopCityPopuinCaribbeansize()
    {
        int city =app.getTopCityPopuinCaribbean(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgetTopCityPopuinMyanmar()
    {
        City city =app.getTopCityPopuinMyanmar(10).get(0);
        assertEquals(city.getID(), 2710);
        assertEquals(city.getName(), "Rangoon (Yangon)");
        assertEquals(city.getPopulation(), 3361700);
        assertEquals(city.getDistrict(), "Rangoon [Yangon]");
        assertEquals(city.getCountryDetail().getName(), "Myanmar");
    }
    @Test
    void testgetTopCityPopuinMyanmarsize()
    {
        int city =app.getTopCityPopuinMyanmar(10).size();
        assertEquals(city, 10);
    }


    @Test
    void testgetTopCityPopuinVirginia()
    {
        City city =app.getTopCityPopuinVirginia(10).get(0);
        assertEquals(city.getID(), 3830);
        assertEquals(city.getName(), "Virginia Beach");
        assertEquals(city.getPopulation(), 425257);
        assertEquals(city.getDistrict(), "Virginia");
        assertEquals(city.getCountryDetail().getName(), "United States");
    }
    @Test
    void testgetTopCityPopuinVirginiasize()
    {
        int city =app.getTopCityPopuinVirginia(10).size();
        assertEquals(city, 10);
    }

    @Test
    void testgetCapitalCityPopuinWorld()
    {
        City city =app.getCapitalCityPopuinWorld().get(0);
        assertEquals(city.getID(), 2331);
        assertEquals(city.getName(), "Seoul");
        assertEquals(city.getPopulation(), 9981619);
        assertEquals(city.getDistrict(), "South Korea");
        assertEquals(city.getCountryDetail().getName(), "South Korea");
    }

    @Test
    void testgetCapitalCityPopuinAsia()
    {
        City city =app.getCapitalCityPopuinAsia().get(0);
        assertEquals(city.getID(), 2331);
        assertEquals(city.getName(), "Seoul");
        assertEquals(city.getPopulation(), 9981619);
        assertEquals(city.getDistrict(), "South Korea");
        assertEquals(city.getCountryDetail().getName(), "South Korea");
    }
    @Test
    void testgetCapitalCityPopuinMiddleEast()
    {
        City city =app.getCapitalCityPopuinMiddleEast().get(0);
        assertEquals(city.getID(), 1365);
        assertEquals(city.getName(), "Baghdad");
        assertEquals(city.getPopulation(), 4336000);
        assertEquals(city.getDistrict(), "Iraq");
        assertEquals(city.getCountryDetail().getName(), "Baghdad");
    }

    @Test
    void testgetTopCapitalCityPopuinWorld()
    {
        City city =app.getTopCapitalCityPopuinWorld(10).get(0);
        assertEquals(city.getID(), 2331);
        assertEquals(city.getName(), "Seoul");
        assertEquals(city.getPopulation(), 9981619);
        assertEquals(city.getDistrict(), "South Korea");
        assertEquals(city.getCountryDetail().getName(), "South Korea");

    }
    @Test
    void testgetTopCapitalCityPopuinWorldsize()
    {
        int city =app.getTopCapitalCityPopuinWorld(10).size();
        assertEquals(city, 10);
    }


    @Test
    void testgetTopCapitalCityPopuinAsia()
    {
        City city =app.getTopCapitalCityPopuinAsia(10).get(0);
        assertEquals(city.getID(), 2331);
        assertEquals(city.getName(), "Seoul");
        assertEquals(city.getPopulation(), 9981619);
        assertEquals(city.getDistrict(), "South Korea");
        assertEquals(city.getCountryDetail().getName(), "South Korea");
    }
    @Test
    void testgetTopCapitalCityPopuinAsiasize()
    {
        int city =app.getTopCityPopuinAsia(10).size();
        assertEquals(city, 10);
    }

    @Test
    void testgetTopCapitalCityPopuinMiddleEast()
    {
        City city =app.getTopCapitalCityPopuinMiddleEast(10).get(0);
        assertEquals(city.getID(), 1365);
        assertEquals(city.getName(), "Baghdad");
        assertEquals(city.getPopulation(), 4336000);
        assertEquals(city.getDistrict(), "Iraq");
        assertEquals(city.getCountryDetail().getName(), "Baghdad");
    }
    @Test
    void testgetTopCapitalCityPopuinMiddleEastsize()
    {
        int city =app.getTopCapitalCityPopuinMiddleEast(10).size();
        assertEquals(city, 10);
    }


}