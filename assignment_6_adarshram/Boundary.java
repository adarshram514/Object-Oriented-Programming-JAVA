package geography;

import java.util.ArrayList;

public class boundary {

    private coordinates beginning;
    private coordinates end;
    private static int count = 0;
    private int id;

    ArrayList<geographical> Places;

    boundary(coordinates beginning, coordinates end)
    {
        this.beginning = beginning;
        this.end = end;
        count++;
        this.id = count;
    }

    public double boundaryLength()
    {
        double dist;


        int X1 = beginning.getCoordinateX();
        int X2 = end.getCoordinateX();
        int Y1 = beginning.getCoordinateY();
        int Y2 = end.getCoordinateY();


        dist = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));

        return dist;
    }

    public ArrayList<geographical> borderOf()
    {
        return Places;
    }

    void addPlace(geographical Place)
    {
     Places.add(Place);
    }

    int getId()
    {
        return id;
    }

}