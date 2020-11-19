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

}