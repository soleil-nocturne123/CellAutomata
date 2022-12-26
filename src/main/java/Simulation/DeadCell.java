package Simulation;


import Util.Pair;

/**
 * This cell is dead and does nothing
 */
public class DeadCell extends Cell{
    /* CONSTRUCTORS */
    // Default constructor
    public DeadCell() {
        this(3,0,0,0);
    }
    public DeadCell(Pair coord) {
        setId(3);
        setStrength(0);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public DeadCell(int id, int strength, int x, int y) {
        setId(id);
        setStrength(strength);
        setX(x);
        setY(y);
    }
}
