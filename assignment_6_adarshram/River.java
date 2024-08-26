package geography;

import java.util.ArrayList;

public class river extends geographical {

    ArrayList<city> cities;

    public river()
    {
        super();
    }

    public river(String name)
    {
        super(name);
    }

    void addCity(city City)
    {
        cities.add(City);
    }

    public ArrayList<city> getCities()
    {
        return cities;
    }


}