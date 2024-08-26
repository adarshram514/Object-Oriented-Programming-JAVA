package geography;

import java.util.ArrayList;

public class city extends geographical {


    boolean isCapitalCity;
    state State;
    ArrayList<river> Rivers;


    city() {
        super();
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }

    city(coordinates location) {
        super(location);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }


    city(String name) {
        super(name);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }


    city(String name, coordinates location) {
        super(name, location);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }

    city(String name, coordinates location, boolean isCapitalCity) {
        super(name, location);
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }

    city(state State, String name, coordinates location, boolean isCapitalCity) {
        super(name, location);
        this.State = State;
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }

    city(state State, String name, coordinates location, boolean isCapitalCity, double area) {
        super(name, location, area);
        this.State = State;
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }


    public static double distance(city A, city B) {
        double dist;

        geography.coordinates coordinatesA = A.getCoordinates();
        geography.coordinates coordinatesB = B.getCoordinates();
        int X1 = coordinatesA.getCoordinateX();
        int X2 = coordinatesB.getCoordinateX();
        int Y1 = coordinatesA.getCoordinateY();
        int Y2 = coordinatesB.getCoordinateY();


        dist = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));

        return dist;
    }

    public boolean Capital() {
        return isCapitalCity;
    }

    public void Capital(boolean isCapitalCity) {
        this.isCapitalCity = isCapitalCity;
    }


    public state getState() {
        return this.State;
    }

    public void setState(state parentState) {
        this.State = parentState;
    }

    public void addRiver(river River) {
        River.addCity(this);
        Rivers.add(River);
    }

    public ArrayList<river> getRivers() {
        return Rivers;
    }


    @Override
    public double area() {
        return super.area();
    }

    @Override
    public void area(double area) {
        super.area(area);
    }


}