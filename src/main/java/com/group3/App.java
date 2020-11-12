package com.group3;

import jdk.internal.org.jline.utils.Display;

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
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...htaaa");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
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
                // Close connection
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
    public ArrayList<Country> getcountrypopuinworld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital "
                            + "FROM country "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("country.Name");
                coun.Population = rset.getInt("population");
                coun.Continent = rset.getString("continent");
                coun.Region = rset.getString("Region");
                coun.Capital = rset.getString("Capital");
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displaycounpopuinworld(ArrayList<Country> countries) {
        //Title of table
        System.out.println("All Countries in the world by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s", coun.Code, coun.Name, coun.Population, coun.Continent, coun.Region, coun.Capital);
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the country name by population in descenting order in asia.
     */
    public ArrayList<Country> getcountrypopuinasia() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital "
                            + "FROM country "
                            + "WHERE Continent = 'Asia'"
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in asia if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("country.Name");
                coun.Population = rset.getInt("population");
                coun.Continent = rset.getString("continent");
                coun.Region = rset.getString("Region");
                coun.Capital = rset.getString("Capital");
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in asia");
            return null;
        }
    }

    public void displaycounpopuinasia(ArrayList<Country> countries) {
        //Title of table
        System.out.println("All Countries in the Asia by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s", coun.Code, coun.Name, coun.Population, coun.Continent, coun.Region, coun.Capital);
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the country name by population in descenting order in caribbean.
     */
    public ArrayList<Country> getcountrypopuincaribbean() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital "
                            + "FROM country "
                            + "WHERE Region = 'Caribbean'"
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in asia if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("country.Name");
                coun.Population = rset.getInt("population");
                coun.Continent = rset.getString("continent");
                coun.Region = rset.getString("Region");
                coun.Capital = rset.getString("Capital");
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in caribbean");
            return null;
        }
    }

    public void displaycounpopuincaribbean(ArrayList<Country> countries) {
        //Title of table
        System.out.println("All Countries in the Caribbean by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s", coun.Code, coun.Name, coun.Population, coun.Continent, coun.Region, coun.Capital);
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top country name by population in descenting order in the world provided by user.
     */
    public ArrayList<Country> gettopcountrypopuinworld(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital "
                            + "FROM country "
                            + "ORDER BY country.Population DESC lIMIT " + n ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("country.Name");
                coun.Population = rset.getInt("population");
                coun.Continent = rset.getString("continent");
                coun.Region = rset.getString("Region");
                coun.Capital = rset.getString("Capital");
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displaytopcounpopuinworld(ArrayList<Country> countries) {
        //Title of table
        System.out.println("Top Countries in the world by population by user input.");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s", coun.Code, coun.Name, coun.Population, coun.Continent, coun.Region, coun.Capital);
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the top country name by population in descenting order in the asia provided by user.
     */
    public ArrayList<Country> gettopcountriespopuinasia(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Population, Continent, Region, Capital "
                            + "FROM country "
                            + "WHERE country.Continent = 'Asia'"
                            + "ORDER BY country.Population DESC lIMIT " + n ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return all countries if valid.

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("country.Name");
                coun.Population = rset.getInt("population");
                coun.Continent = rset.getString("continent");
                coun.Region = rset.getString("Region");
                coun.Capital = rset.getString("Capital");
                countries.add(coun);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displaytopcounpopuinasia(ArrayList<Country> countries) {
        //Title of table
        System.out.println("Top Countries in Asia by population by user input.");
        System.out.println(String.format("%-10s %-45s %-20s %-25s %-25s", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list
        for (Country coun : countries) {
            String coun_string = String.format("%-10s %-45s %-20s %-25s %-25s", coun.Code, coun.Name, coun.Population, coun.Continent, coun.Region, coun.Capital);
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the cities name by population in descenting order in world.
     */
    public ArrayList<City> getcitypopuinworld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM city "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in world if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.Population = rset.getInt("Population");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in world");
            return null;
        }
    }

    public void displaycitypopuinworld(ArrayList<City> cities) {
        //Title of table
        System.out.println("Cities in the world by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "CountryCode", "District"));
        //Loop all the City get from cities list
        for (City city : cities) {
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.ID, city.Name, city.Population, city.CountryCode, city.District);
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the cities name by population in descenting order in a Asia.
     */
    public ArrayList<City> getcitypopuinasia(int conti) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM city "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = 'Asia'"
                            + "ORDER BY city.Population DESC LIMIT " + conti;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in world if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.Population = rset.getInt("Population");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in Asia");
            return null;
        }
    }

    public void displaycitypopuinasia(ArrayList<City> cities) {
        //Title of table
        System.out.println("Cities in Asia by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "CountryCode", "District"));
        //Loop all the City get from cities list
        for (City city : cities) {
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.ID, city.Name, city.Population, city.CountryCode, city.District);
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }


    /**
     * * Get the top cities name by population in descenting order in asia.
     */
    public ArrayList<City> gettopcitypopuinasia() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM city, country "
                            + "WHERE city.Countrycode = country.Code AND country.Continent = 'Asia' "
                    + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in asia if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.Population = rset.getInt("Population");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in asia");
            return null;
        }
    }

    public void displaytopcitypopuinasia(ArrayList<City> cities) {
        //Title of table
        System.out.println("Cities in the asia by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "CountryCode", "District"));
        //Loop all the City get from cities list
        for (City city : cities) {
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.ID, city.Name, city.Population, city.CountryCode, city.District);
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }

    /**
     * * Get the cities name by population in descenting order in middle east.
     */
    public ArrayList<City> getcitypopuinmiddleeast() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM city, country "
                            + "WHERE city.Countrycode = country.Code AND country.Region = 'Middle East' "
                    + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries in middle east if valid.
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.Population = rset.getInt("Population");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details in middle east");
            return null;
        }
    }

    public void displaycitypopuinmiddleeast(ArrayList<City> cities) {
        //Title of table
        System.out.println("Cities in the middle east by population.");
        System.out.println(String.format("%-10s %-45s %-20s %-20s %-20s", "ID", "City Name", "Population", "CountryCode", "District"));
        //Loop all the City get from cities list
        for (City city : cities) {
            String city_string = String.format("%-10s %-45s %-20s %-20s %-20s", city.ID, city.Name, city.Population, city.CountryCode, city.District);
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get Country list in the world
        ArrayList<Country> countries = a.getcountrypopuinworld();
        // Display countries
        a.displaycounpopuinworld(countries);

        // Get Country list in asia
        ArrayList<Country> asiacountries = a.getcountrypopuinasia();
        // Display countries
        a.displaycounpopuinasia(asiacountries);

        // Get Country list in caribbeanm
        ArrayList<Country> caribbeancountries = a.getcountrypopuincaribbean();
        // Display countries
        a.displaycounpopuincaribbean(caribbeancountries);

        // Get Top Country list in world by user input
        //ArrayList<Country> topcountriesinworld = a.gettopcountrypopuinworld(10);
        // Display countries
        //a.displaytopcounpopuinworld(topcountriesinworld);

        //Get Country List in Aisa by user input
        ArrayList<Country> topcountriesinasia = a.gettopcountriespopuinasia(20);
        //Display countries
        a.displaytopcounpopuinasia(topcountriesinasia);


        // Get Country list in the world
        //ArrayList<City> citypopuinworld = a.getcitypopuinworld();
        //Display cities
        //a.displaycitypopuinworld(citypopuinworld);

        // Get Country list in the asia
        //ArrayList<City> citypopuinasia = a.getcitypopuinasia();
        //Display cities
        //a.displaycitypopuinasia(citypopuinasia);

        // Get Country list in the middle east
       //ArrayList<City> citypopuinmiddleeast = a.getcitypopuinmiddleeast();
        //Display cities
        //a.displaycitypopuinmiddleeast(citypopuinmiddleeast);

        //Get Top City list in Asia
        ArrayList<City> topcitypopuinasia = a.gettopcitypopuinasia();
        //Display Cities
        a.displaytopcitypopuinasia(topcitypopuinasia);

        // Disconnect from database

        a.disconnect();
    }

}