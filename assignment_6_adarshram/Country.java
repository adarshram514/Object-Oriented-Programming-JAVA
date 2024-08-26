package geography;

import java.util.ArrayList;

public class country extends geographical {

    ArrayList<state> states;

    country(String name) {
        super(name);
    }

    country(String name, double area) {
        super(name, area);
    }

    public void addState(state State) {
        State.setCountry(this);
        states.add(State);
    }

    public ArrayList<state> getStates() {
        return states;
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