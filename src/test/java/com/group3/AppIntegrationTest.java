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
    void testgetcitypopuinworld()
    {
        City city =app.getcitypopuinworld().get(0);
        assertEquals(city.getID(), 1024);
        assertEquals(city.getName(), "Mumbai (Bombay)");
        assertEquals(city.getPopulation(), 10500000);
        assertEquals(city.getDistrict(), "Maharashtra");
        assertEquals(city.getCountryDetail().getName(), "India");
    }
}