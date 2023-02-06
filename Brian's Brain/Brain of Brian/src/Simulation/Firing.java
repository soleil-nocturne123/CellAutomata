package Simulation;

import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import static Util.Calculator.indexFromCoord;
public class Firing extends Cell{
    /* CONSTRUCTORS */
    // Default constructor
    public Firing() {
        this(1,0,0);
    }
    public Firing(Pair coord) {
        setId(1);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public Firing(int id, int x, int y) {
        setId(id);
        setX(x);
        setY(y);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        // Always turn into Refractory Cell
        neighbors.set(indexFromCoord(this.x, this.y), new Refractory(2, this.x, this.y));
    }
}
