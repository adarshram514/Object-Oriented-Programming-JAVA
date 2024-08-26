package geography;


import java.util.ArrayList;

abstract class geographical {


    private geography.coordinates coordinates;
    private String name;
    private ArrayList<boundary> Boundaries;
    private double area;

    geographical() {
        coordinates = new coordinates();
        name = null;
    }

    geographical(String name, coordinates location, double area)
    {
        this.coordinates = location;
        this.name = name;
        this.area = area;
    }

    geographical(String name, double area)
    {
        this.coordinates = null;
        this.name = name;
        this.area = area;
    }

    geographical(coordinates location) {
        this.coordinates = location;
        this.name = null;
        this.area = -1;
    }

    geographical(String name) {
        this.coordinates = null;
        this.name = name;
        this.area = -1;
    }

    geographical(String name, coordinates location) {
        this.coordinates = location;
        this.name = name;
        this.area = -1;
    }

    public coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public void setCoordinates(coordinates Coordinates)
    {
        coordinates = Coordinates;
    }


    int setCoordinateX(int x) {
        int oldCoordinateX = coordinates.getCoordinateX();
        coordinates.setCoordinateX(x);
        return oldCoordinateX;
    }

    int setCoordinatesY(int y) {
        int oldCoordinateY = coordinates.getCoordinateX();
        coordinates.setCoordinateY(y);
        return oldCoordinateY;
    }


    String getName() {
        return name;
    }

    String setName(String name) {
        String oldName = this.name;
        this.name = name;
        return oldName;
    }

    public void addBoundary(boundary Boundary) {
        Boundary.addPlace(this);
        Boundaries.add(Boundary);
    }

    public ArrayList<geographical> neighbors(ArrayList<geographical> Places)
    {
        ArrayList<geographical> Neighbors = new ArrayList<>();
        return Neighbors;
    }

    double area()
    {
        return area;
    }

    void area(double area)
    {
        this.area = area;
    }


}