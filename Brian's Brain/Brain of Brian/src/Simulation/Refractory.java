package Simulation;

import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

public class Refractory extends Cell{
    /* CONSTRUCTORS */
    // Default constructor
    public Refractory() {
        this(2,0,0);
    }
    public Refractory(Pair coord) {
        setId(2);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public Refractory(int id, int x, int y) {
        setId(id);
        setX(x);
        setY(y);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        // Always turn into Off Cell
        neighbors.set(indexFromCoord(this.x, this.y), new Refractory(0, this.x, this.y));
    }
}
