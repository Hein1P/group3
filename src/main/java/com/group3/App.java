package com.group3;

import javax.print.CancelablePrintJob;
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
    /** Get data from database */
    public ResultSet getDataFromQuery(String query) {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Execute SQL statement and return
            return stmt.executeQuery(query);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /** Setting the Country data to the result */
    void setCountryDataFromQueryResult(ArrayList<Country> countries, ResultSet rset) {
        try{
            while(rset.next()) {
                countries.add(new Country(rset.getString("Code"),rset.getString("country.Name"),rset.getString("continent"), rset.getString("Region"),rset.getInt("population"),rset.getInt("Capital")));
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
    /** Setting the City data to the result */
    void setCityDataFromQueryResult(ArrayList<City> cities, ResultSet rset) {
        try{
            while(rset.next()) {
                cities.add(new City(rset.getInt("city.ID"), rset.getString("city.Name"), rset.getInt("city.Population"), rset.getString("city.District"), new Country(rset.getString("country.name"))));

            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }
    /** Setting the City data to the result */
    void setCitySumDataFromQueryResult(ArrayList<City> cities, ResultSet rset) {
        try{
            while(rset.next()) {
                cities.add(new City(rset.getLong("CitySumPopulation"),rset.getLong("NoCityPopulation"), new Country(rset.getString("Continent"))));
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }
    public void displayCountry(ArrayList<Country> countries) {
        if(countries == null){
            System.out.println("There is no data in Arraylist of countries");
            return;
        }
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-10s %-45s %-20s %-25s %-25s %-25s", "No", "Code No", "Country Name", "Population", "Continent", "Region", "Capital"));
        //Loop all the country get from countries list

        for (Country coun : countries)  {
            if (coun == null)
                continue;
            int i = countries.indexOf(coun) +1;
            String coun_string = String.format("%-10s %-10s %-45s %-20s %-25s %-25s %-25s", i, coun.getCode(), coun.getName(),coun.getPopulation(), coun.getContinent(), coun.getRegion(), coun.getCapital());
            System.out.println(coun_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    public void displayCity(ArrayList<City> cities) {
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        System.out.println("=======================================================================================================================================");
        System.out.println(String.format("%-10s %-10s %-45s %-20s %-20s %-20s","No", "ID", "City Name", "Population", "District", "Country Name"));
        //Loop all the City get from cities list
        for (City city : cities) {
            if (city == null)
                continue;
            int i = cities.indexOf(city) +1;
            String city_string = String.format("%-10s %-10s %-45s %-20s %-20s %-20s", i, city.getID(), city.getName(), city.getPopulation(), city.getDistrict(), city.getCountryDetail().getName());
            System.out.println(city_string);
        }
        System.out.println("=======================================================================================================================================");
    }
    /**
     * * Get the country name by population in descenting order in the world.
     */
    public ArrayList<Country> getCountryPopuinWorld() {

        // Create string for SQL statement
        String strSelect = "SELECT Code, country.Name, Population, Continent, Region, Capital FROM country ORDER BY country.Population DESC";
        ArrayList<Country> countries = new ArrayList<Country>();
        setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
        return countries;
    }

    /**
     * * Get the country name by population in descenting order in asia.
     */
    public ArrayList<Country> getCountryPopuinAsia() {

            // Create string for SQL statement
            String strSelect = "SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE Continent = 'Asia' ORDER BY country.Population DESC";
            ArrayList<Country> countries = new ArrayList<Country>();
            setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
            return countries;
    }


    /**
     * * Get the country name by population in descenting order in caribbean.
     */
    public ArrayList<Country> getCountryPopuinCaribbean() {

            // Create string for SQL statement
        String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE Region = 'Caribbean' ORDER BY country.Population DESC";
        ArrayList<Country> countries = new ArrayList<Country>();
        setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
        return countries;
    }


    /**
     * * Get the top country name by population in descenting order in the world provided by user.
     */
    public ArrayList<Country> getTopCountryPopuinWorld(int n) {
            // Create string for SQL statement
        String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country ORDER BY country.Population DESC LIMIT " + n ;
        ArrayList<Country> countries = new ArrayList<Country>();
        setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
        return countries;
    }


    /**
     * * Get the top country name by population in descenting order in the asia provided by user.
     */
    public ArrayList<Country> getTopCountriesPopuinAsia(int n) {
            // Create string for SQL statement
        String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE country.Continent = 'Asia' ORDER BY country.Population DESC LIMIT " + n ;
        ArrayList<Country> countries = new ArrayList<Country>();
        setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
        return countries;
    }



    /**
     * * Get the top country name by population in descenting order in the region provided by user.
     */
    public ArrayList<Country> getTopCountriesPopuinSoutherneurope(int n) {
        // Create string for SQL statement
        String strSelect ="SELECT Code, country.Name, Population, Continent, Region, Capital FROM country WHERE country.Region = 'Southern Europe' ORDER BY country.Population DESC LIMIT " + n ;
        ArrayList<Country> countries = new ArrayList<Country>();
        setCountryDataFromQueryResult(countries, getDataFromQuery(strSelect));
        return countries;
    }


    /**
     * * Get the cities name by population in descenting order in world.
     */
    public ArrayList<City> getCityPopuinWorld() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get the cities name by population in descenting order in a Asia.
     */
    public ArrayList<City> getCityPopuinAsia() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get the cities name by population in descenting order in middle east.
     */
    public ArrayList<City> getCityPopuinMiddleEast() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Region = 'Middle East' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    /**
     * * Get the cities name by population in descenting order in Myanmar.
     */
    public ArrayList<City> getCityPopuinMyanmar() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Code = 'MMR' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    /**
     * * Get the cities name by population in descenting order in virginia.
     */
    public ArrayList<City> getCityPopuinVirginia() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND city.District = 'virginia' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    /**
     * * Get the top City name by population in descenting order in the world provided by user.
     */
    public ArrayList<City> getTopCityPopuinWorld(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get the top City name by population in descenting order in the asia provided by user.
     */
    public ArrayList<City> getTopCityPopuinAsia(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }



    /**
     * * Get the top City name by population in descenting order in the caribbean provided by user.
     */
    public ArrayList<City> getTopCityPopuinCaribbean(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Region = 'Caribbean' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get the top City name by population in descenting order in the myanmar provided by user.
     */
    public ArrayList<City> getTopCityPopuinMyanmar(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND country.Name = 'Myanmar' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    /**
     * * Get the top City name by population in descenting order in the virginia provided by user.
     */
    public ArrayList<City> getTopCityPopuinVirginia(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.CountryCode = country.Code AND city.District = 'Virginia' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    /**
     * * Get the Capital cities name by population in descenting order in world.
     */
    public ArrayList<City> getCapitalCityPopuinWorld() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
    /**
     * * Get the capital cities name by population in descenting order in a Asia.
     */
    public ArrayList<City> getCapitalCityPopuinAsia() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital AND country.Continent = 'Asia' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get the capital cities name by population in descenting order in middle east.
     */
    public ArrayList<City> getCapitalCityPopuinMiddleEast() {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital AND country.Region = 'Middle East' ORDER BY city.Population DESC";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
    /**
     * * Get Top Capital cities name by population in descenting order in world.
     */
    public ArrayList<City> getTopCapitalCityPopuinWorld(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
    /**
     * * Get Top capital cities name by population in descenting order in a Asia.
     */
    public ArrayList<City> getTopCapitalCityPopuinAsia(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital AND country.Continent = 'Asia' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }


    /**
     * * Get Top capital cities name by population in descenting order in middle east.
     */
    public ArrayList<City> getTopCapitalCityPopuinMiddleEast(int n) {
        // Create string for SQL statement
        String strSelect = "SELECT * FROM city, country WHERE city.ID = country.Capital AND country.Region = 'Middle East' ORDER BY city.Population DESC LIMIT " + n;
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }

    public ArrayList<City> getCityPopuOfPeopleinEachContinent(){
        // Create string for SQL statement
        String strSelect = "SELECT SUM(city.Population) as CitySumPopulation, country.Continent, SUM(country.Population) - SUM(city.Population) as NoCityPopulation FROM city, country WHERE city.CountryCode = country.Code group by country.Continent";
        ArrayList<City> cities = new ArrayList<City>();
        setCitySumDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
    /**
    public ArrayList<City> getCityPopuOfPeopleinEachRegion(){
        // Create string for SQL statement
        String strSelect = "SELECT SUM(city.Population) as SumPopulation, country.Continent FROM city, country WHERE city.CountryCode = country.Code group by country.Continent";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
    public ArrayList<City> getCityPopuOfPeopleinEachCountry(){
        // Create string for SQL statement
        String strSelect = "SELECT SUM(city.Population) as SumPopulation, country.Continent FROM city, country WHERE city.CountryCode = country.Code group by country.Continent";
        ArrayList<City> cities = new ArrayList<City>();
        setCityDataFromQueryResult(cities, getDataFromQuery(strSelect));
        return cities;
    }
     */
    public void displayCityPopuOfPeopleinEachContinent(ArrayList<City> cities){
        if(cities == null){
            System.out.println("There is no data in Arraylist of cities");
            return;
        }
        System.out.println("=======================================================================================================================================");
        for (City city : cities) {
            if (city == null)
                continue;
            System.out.println("This is the population of people that lives in cities in " + city.getCountryDetail().getContinent() + " => " + city.getCitySumPopulation());
            System.out.println("This is the population of people that does not live in cities in " + city.getCountryDetail().getContinent() +  " => " + city.getNoCitySumPopulation());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    /**
    public void displayPopuOfPeopleinMiddleEast(){
        int cityPeop = getCityPopuOfPeopleinMiddleEast();
        long noCityPeop = (long)getNoCityPopuOfPeopleinMiddleEast() - (long)cityPeop;
        System.out.println("=======================================================================================================================================");
        System.out.println("This is the population of people that lives in cities in Middle East => " + cityPeop);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("This is the population of people that does not live in cities in Middle East => " + noCityPeop);
        System.out.println("=======================================================================================================================================");
    }
    public void displayPopuOfPeopleinMyanmar(){
        int cityPeop = getCityPopuOfPeopleinMyanmar();
        //long noCityPeop = (long)getNoCityPopuOfPeopleinMyanmar() - (long)cityPeop;
        System.out.println("=======================================================================================================================================");
        System.out.println("This is the population of people that lives in cities in Myanmar => " + cityPeop);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        //System.out.println("This is the population of people that does not live in cities in Myanmar => " + noCityPeop);
        System.out.println("=======================================================================================================================================");
    }
*/
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
/**
        // Get Country list in the world
        ArrayList<Country> countries = a.getCountryPopuinWorld();
        // Display countries
        System.out.println("=======================================================================================================================================");
        System.out.println("All the countries in the world organised by largest population to smallest.");
        a.displayCountry(countries);

        // Get Country list in asia
        ArrayList<Country> asiacountries = a.getCountryPopuinAsia();
        // Display countries
        System.out.println("All the countries in a continent organised by largest population to smallest.");
        a.displayCountry(asiacountries);

        // Get Country list in caribbeanm
        ArrayList<Country> caribbeancountries = a.getCountryPopuinCaribbean();
        // Display countries
        System.out.println("All the countries in a region organised by largest population to smallest.");
        a.displayCountry(caribbeancountries);

        // Get Top Country list in world by user input
        ArrayList<Country> topcountriesinworld = a.getTopCountryPopuinWorld(10);
        // Display countries
        System.out.println("The top N populated countries in the world where N is provided by the user.");
        a.displayCountry(topcountriesinworld);

        //Get Top Country List in Asia by user input
        ArrayList<Country> topcountriesinasia = a.getTopCountriesPopuinAsia(10);
        //Display countries
        System.out.println("The top N populated countries in a continent where N is provided by the user.");
        a.displayCountry(topcountriesinasia);

        //Get Top Country List in Region by user input
        ArrayList<Country> topcountriesinsoutherneurope = a.getTopCountriesPopuinSoutherneurope(10);
        //Display countries
        System.out.println("The top N populated countries in a region where N is provided by the user.");
        a.displayCountry(topcountriesinsoutherneurope);

        // Get City list in the world
        ArrayList<City> citypopuinworld = a.getCityPopuinWorld();
        //Display cities
        System.out.println("All the cities in the world organised by largest population to smallest.");
        a.displayCity(citypopuinworld);

        // Get Country list in the asia
        ArrayList<City> citypopuinasia = a.getCityPopuinAsia();
        //Display cities
        System.out.println("All the cities in a continent organised by largest population to smallest.");
        a.displayCity(citypopuinasia);

        // Get Country list in the middle east
        ArrayList<City> citypopuinmiddleeast = a.getCityPopuinMiddleEast();
        //Display cities
        System.out.println("All the cities in a region organised by largest population to smallest.");
        a.displayCity(citypopuinmiddleeast);

        // Get Country list in Myanmar
        ArrayList<City> citypopuinMyanmar = a.getCityPopuinMyanmar();
        //Display cities
        System.out.println("All the cities in a country organised by largest population to smallest.");
        a.displayCity(citypopuinMyanmar);

        // Get Country list in Rangoon
        ArrayList<City> citypopuinvirginia = a.getCityPopuinVirginia();
        //Display cities
        System.out.println("All the cities in a District organised by largest population to smallest.");
        a.displayCity(citypopuinvirginia);

        // Get Top City list in world by user input
        ArrayList<City> topcitiesinworld = a.getTopCityPopuinWorld(10);
        // Display Cities
        System.out.println("The top N populated cities in the world where N is provided by the user.");
        a.displayCity(topcitiesinworld);

        //Get Top City list in asia by user input
        ArrayList<City> topcitiesinasia = a.getTopCityPopuinAsia(10);
        // Display Cities
        System.out.println("The top N populated cities in a continent where N is provided by the user.");
        a.displayCity(topcitiesinasia);


        //Get Top City list in caribbean by user input
        ArrayList<City> topcitiesincaribbean = a.getTopCityPopuinCaribbean(10);
        // Display Cities
        System.out.println("The top N populated cities in a region where N is provided by the user.");
        a.displayCity(topcitiesincaribbean);

        // Get Top City list in myanmar by user input
        ArrayList<City> topcitiesinmyanmar = a.getTopCityPopuinMyanmar(10);
        // Display Cities
        System.out.println("The top N populated cities in a country where N is provided by the user.");
        a.displayCity(topcitiesinmyanmar);

        // Get Top City list in virginia by user input
        ArrayList<City> topcitiesinvirginia = a.getTopCityPopuinVirginia(10);
        // Display Cities
        System.out.println("The top N populated cities in a district where N is provided by the user.");
        a.displayCity(topcitiesinvirginia);

        // Get City list in the world
        ArrayList<City> capitalcitypopuinworld = a.getCapitalCityPopuinWorld();
        //Display cities
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        a.displayCity(capitalcitypopuinworld);

        // Get City list in asia
        ArrayList<City> capitalcitypopuinasia = a.getCapitalCityPopuinAsia();
        //Display cities
        System.out.println("All the capital cities in a continent organised by largest population to smallest.");
        a.displayCity(capitalcitypopuinasia);

        // Get City list in middle east
        ArrayList<City> capitalcitypopuinMiddleEast = a.getCapitalCityPopuinMiddleEast();
        //Display cities
        System.out.println("All the capital cities in a region organised by largest to smallest.");
        a.displayCity(capitalcitypopuinMiddleEast);
        // Get Top City List in the world
        ArrayList<City> topcapitalcitypopuinworld = a.getTopCapitalCityPopuinWorld(10);
        //Display cities
        System.out.println("The top N populated capital cities in the world where N is provided by the user.");
        a.displayCity(topcapitalcitypopuinworld);

        // Get Top City List in asia
        ArrayList<City> topcapitalcitypopuinasia = a.getTopCapitalCityPopuinAsia(10);
        //Display cities
        System.out.println("The top N populated capital cities in a continent where N is provided by the user.");
        a.displayCity(topcapitalcitypopuinasia);

        // Get Top City List in middle east
        ArrayList<City> topcapitalcitypopuinMiddleEast = a.getTopCapitalCityPopuinMiddleEast(10);
        //Display cities
        System.out.println("The top N populated capital cities in a region where N is provided by the user.");
        a.displayCity(topcapitalcitypopuinMiddleEast);
 */

        ArrayList<City> sumpopuineachcontinent = a.getCityPopuOfPeopleinEachContinent();
        System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
        a.displayCityPopuOfPeopleinEachContinent(sumpopuineachcontinent);

        System.out.println("The population of people, people living in cities, and people not living in cities in each region.");
        //a.displayPopuOfPeopleinMiddleEast();

        System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
        //a.displayPopuOfPeopleinMyanmar();

        System.out.println("HeinThu");
        // Disconnect from database
        a.disconnect();
    }

}