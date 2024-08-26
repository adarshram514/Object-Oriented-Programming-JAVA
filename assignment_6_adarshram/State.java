package geography;

import java.util.ArrayList;

public class state extends geographical {

    ArrayList<city> cities;
    city CapitalCity;
    country parentCountry;


    state() {
        cities = new ArrayList<>();
    }

    state(String name) {
        super(name);
        cities = new ArrayList<>();
    }

    public void addCity(String name, coordinates location, boolean isCapitalCity) {
        city newCity = new city(this, name, location, isCapitalCity);
        if (isCapitalCity) {
            CapitalCity = newCity;
            this.setCoordinates(newCity.getCoordinates());
        }
        cities.add(newCity);
    }

    public void addCity(city City, boolean isCapitalCity) {
        City.Capital(isCapitalCity);
        City.setState(this);
        if (isCapitalCity) {
            CapitalCity = City;
            this.setCoordinates(City.getCoordinates());
        }
        cities.add(City);

    }

    public void Capital(city CapitalCity)
    {
        this.CapitalCity = CapitalCity;
    }

    public city Capital()
    {
        return CapitalCity;
    }


    public void setCountry(country parentCountry)
    {
        this.parentCountry = parentCountry;
    }

    public ArrayList<city> getCities()
    {
        return cities;
    }

    public country getCountry()
    {
        return parentCountry;
    }

    @Override
    public double area()
    {
        return super.area();
    }

    @Override
    public void area(double area)
    {
        super.area(area);
    }

}