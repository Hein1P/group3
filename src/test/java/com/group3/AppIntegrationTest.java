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
    void testgetcountrypopuinworld()
    {
    Country coun =app.getcountrypopuinworld().get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgettopcountrypopuinworldsize()
    {
        int coun =app.gettopcountrypopuinworld(10).size();
        assertEquals(coun, 10);
    }

    @Test
    void testgetcountrypopuinasia()
    {
        Country coun =app.getcountrypopuinasia().get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgetcountrypopuincaribbean()
    {
        Country coun =app.getcountrypopuincaribbean().get(0);
        assertEquals(coun.getCode(), "CUB");
        assertEquals(coun.getName(), "Cuba");
        assertEquals(coun.getPopulation(),  11201000);
        assertEquals(coun.getContinent(), "North America");
        assertEquals(coun.getRegion(), "Caribbean");
        assertEquals(coun.getCapital(), 2413);
    }

    @Test
    void testgettopcountrypopuinworld()
    {
        Country coun =app.gettopcountrypopuinworld(10).get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgettopcountriespopuinasia()
    {
        Country coun =app.gettopcountriespopuinasia(10).get(0);
        assertEquals(coun.getCode(), "CHN");
        assertEquals(coun.getName(), "China");
        assertEquals(coun.getPopulation(), 1277558000);
        assertEquals(coun.getContinent(), "Asia");
        assertEquals(coun.getRegion(), "Eastern Asia");
        assertEquals(coun.getCapital(), 1891);
    }
    @Test
    void testgettopcountriespopuinasiasize()
    {
        int city =app.gettopcountriespopuinasia(10).size();
        assertEquals(city, 10);
    }
    @Test
    void testgettopcountriespopuinsoutherneurope()
    {
        Country coun =app.gettopcountriespopuinsoutherneurope(10).get(0);
        assertEquals(coun.getCode(), "ITA");
        assertEquals(coun.getName(), "Italy");
        assertEquals(coun.getPopulation(), 57680000);
        assertEquals(coun.getContinent(), "Europe");
        assertEquals(coun.getRegion(), "Southern Europe");
        assertEquals(coun.getCapital(), 1464);
    }
    @Test
    void testgettopcountriespopuinsoutherneuropesize()
    {
        int city =app.gettopcountriespopuinsoutherneurope(10).size();
        assertEquals(city, 10);
    }


    @Test
    void testgetcitypopuinworld()
    {
        City city =app.getcitypopuinworld().get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }

    @Test
    void testgetcitypopuinasia()
    {
        City city =app.getcitypopuinasia().get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }

    @Test
    void testgetcitypopuinmiddleeast()
    {
        City city =app.getcitypopuinmiddleeast().get(0);
        assertEquals(city.getID(), 3357);
        assertEquals(city.getName(), "Istanbul");
        assertEquals(city.getPopulation(), 8787958);
        assertEquals(city.getDistrict(), "Istanbul");
        assertEquals(city.getCountryDetail().getName(), "Turkey");
    }

    @Test
    void testgetcitypopuinMyanmar()
    {
        City city =app.getcitypopuinMyanmar().get(0);
        assertEquals(city.getID(), 2710);
        assertEquals(city.getName(), "Rangoon (Yangon)");
        assertEquals(city.getPopulation(), 3361700);
        assertEquals(city.getDistrict(), "Rangoon [Yangon]");
        assertEquals(city.getCountryDetail().getName(), "Myanmar");
    }

    @Test
    void testgetcitypopuinvirginia()
    {
        City city =app.getcitypopuinvirginia().get(0);
        assertEquals(city.getID(), 3830);
        assertEquals(city.getName(), "Virginia Beach");
        assertEquals(city.getPopulation(), 425257);
        assertEquals(city.getDistrict(), "Virginia");
        assertEquals(city.getCountryDetail().getName(), "United States");
    }


    @Test
    void testgettopcitypopuinworld()
    {
        City city =app.gettopcitypopuinworld(10).get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }
    @Test
    void testgettopcitypopuinworldsize()
    {
        int city =app.gettopcitypopuinworld(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgettopcitypopuinasiasize()
    {
        City city =app.gettopcitypopuinasia(10).get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }
    @Test
    void testgettopcitypopuinasia()
    {
        int city =app.gettopcitypopuinasia(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgettopcitypopuincaribbean()
    {
        City city =app.gettopcitypopuincaribbean(10).get(0);
        assertEquals(city.getID(), 2413);
        assertEquals(city.getName(), "La Habana");
        assertEquals(city.getPopulation(), 2256000);
        assertEquals(city.getDistrict(), "La Habana");
        assertEquals(city.getCountryDetail().getName(), "Cuba");
    }
    @Test
    void testgettopcitypopuincaribbeansize()
    {
        int city =app.gettopcitypopuincaribbean(10).size();
        assertEquals(city, 10);
    }



    @Test
    void testgettopcitypopuinmyanmar()
    {
        City city =app.gettopcitypopuinmyanmar(10).get(0);
        assertEquals(city.getID(), 2710);
        assertEquals(city.getName(), "Rangoon (Yangon)");
        assertEquals(city.getPopulation(), 3361700);
        assertEquals(city.getDistrict(), "Rangoon [Yangon]");
        assertEquals(city.getCountryDetail().getName(), "Myanmar");
    }
    @Test
    void testgettopcitypopuinmyanmarsize()
    {
        int city =app.gettopcitypopuinmyanmar(10).size();
        assertEquals(city, 10);
    }


    @Test
    void testgettopcitypopuinvirginia()
    {
        City city =app.gettopcitypopuinvirginia(10).get(0);
        assertEquals(city.getID(), 3830);
        assertEquals(city.getName(), "Virginia Beach");
        assertEquals(city.getPopulation(), 425257);
        assertEquals(city.getDistrict(), "Virginia");
        assertEquals(city.getCountryDetail().getName(), "United States");
    }
    @Test
    void testgettopcitypopuinvirginiasize()
    {
        int city =app.gettopcitypopuinvirginia(10).size();
        assertEquals(city, 10);
    }


}