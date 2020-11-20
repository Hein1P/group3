package com.group3;

import java.sql.*;
import java.util.ArrayList;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Disconnect connection
                System.out.println("Database connection closed.");
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
    /**
     * * Get the country name by population in descenting order in the world.
     */
    public ArrayList<Country> getCountryPopuinWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCounPopuinWorld(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the countries in the world organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the country name by population in descenting order in asia.
     */
    public ArrayList<Country> getCountryPopuinAsia() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE Continent = 'Asia' ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in asia if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in asia");
            return null;
        }
    }

    public void displayCounPopuinAsia(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the countries in a continent organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the country name by population in descenting order in caribbean.
     */
    public ArrayList<Country> getCountryPopuinCaribbean() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE Region = 'Caribbean' ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in asia if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in caribbean");
            return null;
        }
    }

    public void displayCounPopuinCaribbean(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the countries in a region organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top country name by population in descenting order in the world provided by user.
     */
    public ArrayList<Country> getTopCountryPopuinWorld(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country ORDER BY country.Population DESC LIMIT " + n ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayTopCounPopuinWorld(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("The top N populated countries in the world where N is provided by the user.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top country name by population in descenting order in the asia provided by user.
     */
    public ArrayList<Country> getTopCountriesPopuinAsia(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE country.Continent = 'Asia' ORDER BY country.Population DESC LIMIT " + n ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayTopCounPopuinAsia(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("The top N populated countries in a continent where N is provided by the user.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the top country name by population in descenting order in the region provided by user.
     */
    public ArrayList<Country> getTopCountriesPopuinSoutherneurope(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE country.Region = 'Southern Europe' ORDER BY country.Population DESC LIMIT " + n ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital"));
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayTopCounPopuinSoutherneurope(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("The top N populated countries in a region where N is provided by the user.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            if (coun == null)
                continue;
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s %-25s", coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the cities name by population in descenting order in world.
     */
    public ArrayList<City> getCityPopuinWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in world if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in world");
            return null;
        }
    }

    public void displayCityPopuinWorld(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the world organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the cities name by population in descenting order in a Asia.
     */
    public ArrayList<City> getCityPopuinAsia() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in world if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in Asia");
            return null;
        }
    }

    public void displayCityPopuinAsia(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in a continent organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }



    /**
     * * Get the cities name by population in descenting order in middle east.
     */
    public ArrayList<City> getCityPopuinMiddleEast() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Region = 'Middle East' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in middle east if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in middle east");
            return null;
        }
    }

    public void displayCityPopuinMiddleEast(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in a region organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the cities name by population in descenting order in Myanmar.
     */
    public ArrayList<City> getCityPopuinMyanmar() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Code = 'MMR' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in middle east if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in Myanmar");
            return null;
        }
    }

    public void displayCityPopuinMyanmar(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in a country organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the cities name by population in descenting order in virginia.
     */
    public ArrayList<City> getCityPopuinVirginia() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND city.District = 'virginia' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in middle east if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in virginia");
            return null;
        }
    }

    public void displayCityPopuinVirginia(ArrayList<City> cities) {
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in a District organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the top City name by population in descenting order in the world provided by user.
     */
    public ArrayList<City> getTopCityPopuinWorld(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code ORDER BY city.Population DESC LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return cities in world if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in world");
            return null;
        }
    }

    public void displayTopCityPopuinWorld(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the world organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top City name by population in descenting order in the asia provided by user.
     */
    public ArrayList<City> getTopCityPopuinAsia(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' ORDER BY city.Population DESC LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return cities in asia if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in asia");
            return null;
        }
    }

    public void displayTopCityPopuinAsia(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the asia organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the top City name by population in descenting order in the caribbean provided by user.
     */
    public ArrayList<City> getTopCityPopuinCaribbean(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Region = 'Caribbean' ORDER BY city.Population DESC LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return cities in caribbean if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in caribbean");
            return null;
        }
    }

    public void displayTopCityPopuinCaribbean(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the caribbean organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top City name by population in descenting order in the myanmar provided by user.
     */
    public ArrayList<City> getTopCityPopuinMyanmar(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Name = 'Myanmar' ORDER BY city.Population DESC LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return cities in myanmar if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in myanmar");
            return null;
        }
    }

    public void displayTopCityPopuinMyanmar(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the myanmar organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the top City name by population in descenting order in the virginia provided by user.
     */
    public ArrayList<City> getTopCityPopuinVirginia(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND city.District = 'Virginia' ORDER BY city.Population DESC LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return cities in virginia if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                String countryname = rset.getString("country.Name");
                Country coun = new Country(countryname);
                City city = new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), coun);
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in virginia");
            return null;
        }
    }

    public void displayTopCityPopuinVirginia(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("There is no data in ArrayList of Cities");
            return;
        }
        //Title of table
        System.out.println("=======================================================================================================================================");
        System.out.println("All the cities in the virginia organised by largest population to smallest.");
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get Country list in the world
        ArrayList<Country> countries = a.getCountryPopuinWorld();
        // Display countries
        a.displayCounPopuinWorld(countries);

        // Get Country list in asia
        ArrayList<Country> asiacountries = a.getCountryPopuinAsia();
        // Display countries
        a.displayCounPopuinAsia(asiacountries);

        // Get Country list in caribbeanm
        ArrayList<Country> caribbeancountries = a.getCountryPopuinCaribbean();
        // Display countries
        a.displayCounPopuinCaribbean(caribbeancountries);

        // Get Top Country list in world by user input
        ArrayList<Country> topcountriesinworld = a.getTopCountryPopuinWorld(10);
        // Display countries
        a.displayTopCounPopuinWorld(topcountriesinworld);

        //Get Top Country List in Asia by user input
        ArrayList<Country> topcountriesinasia = a.getTopCountriesPopuinAsia(10);
        //Display countries
        a.displayTopCounPopuinAsia(topcountriesinasia);

        //Get Top Country List in Region by user input
        ArrayList<Country> topcountriesinsoutherneurope = a.getTopCountriesPopuinSoutherneurope(10);
        //Display countries
        a.displayTopCounPopuinSoutherneurope(topcountriesinsoutherneurope);

        // Get City list in the world
        ArrayList<City> citypopuinworld = a.getCityPopuinWorld();
        //Display cities
        a.displayCityPopuinWorld(citypopuinworld);

        // Get Country list in the asia
        ArrayList<City> citypopuinasia = a.getCityPopuinAsia();
        //Display cities
        a.displayCityPopuinAsia(citypopuinasia);

        // Get Country list in the middle east
        ArrayList<City> citypopuinmiddleeast = a.getCityPopuinMiddleEast();
        //Display cities
        a.displayCityPopuinMiddleEast(citypopuinmiddleeast);

        // Get Country list in Myanmar
        ArrayList<City> citypopuinMyanmar = a.getCityPopuinMyanmar();
        //Display cities
        a.displayCityPopuinMyanmar(citypopuinMyanmar);

        // Get Country list in Rangoon
        ArrayList<City> citypopuinvirginia = a.getCityPopuinVirginia();
        //Display cities
        a.displayCityPopuinVirginia(citypopuinvirginia);

        // Get Top City list in world by user input
        ArrayList<City> topcitiesinworld = a.getTopCityPopuinWorld(10);
        // Display Cities
        a.displayTopCityPopuinWorld(topcitiesinworld);

        //Get Top City list in asia by user input
        ArrayList<City> topcitiesinasia = a.getTopCityPopuinAsia(10);
        // Display Cities
        a.displayTopCityPopuinAsia(topcitiesinasia);


        //Get Top City list in caribbean by user input
        ArrayList<City> topcitiesincaribbean = a.getTopCityPopuinCaribbean(10);
        // Display Cities
        a.displayTopCityPopuinCaribbean(topcitiesincaribbean);

        // Get Top City list in myanmar by user input
        ArrayList<City> topcitiesinmyanmar = a.getTopCityPopuinMyanmar(10);
        // Display Cities
        a.displayTopCityPopuinMyanmar(topcitiesinmyanmar);

        // Get Top City list in virginia by user input
        ArrayList<City> topcitiesinvirginia = a.getTopCityPopuinVirginia(10);
        // Display Cities
        a.displayTopCityPopuinVirginia(topcitiesinvirginia);


        // Disconnect from database
        a.disconnect();
    }

}