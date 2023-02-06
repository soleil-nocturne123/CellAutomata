package Simulation;

import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import static Util.Calculator.indexFromCoord;

/* GENERIC CELL */
public class Cell {
    protected int id; // Indicate different cell types (0: off cell, 1: firing cell, 2: refractory cell)
    protected int x; // x-coordinate of the cell
    protected int y; // y-coordinate of the cell

    /* CONSTRUCTORS */
    // Default constructor
    public Cell() {
        this(0,0,0);
    }
    public Cell(Pair coord) {
        setId(0);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public Cell(int id, int x, int y) {
        setId(id);
        setX(x);
        setY(y);
    }

    /* SETTER AND GETTERS */
    // Setter
    public void setId(int id) {
        if(id < 0 || id > 5) {
            this.id = 0;
        }
        else {
            this.id = id;
        }
    }
    public void setX(int x) {
        if(x < 0) { // Borderline
            this.x = 0;
        }
        else if( x > 1000) { // Borderline
            this.x = 1000;
        }
        else {
            this.x = x;
        }
    }
    public void setY(int y) {
        if(y < 0) { // Borderline
            this.y = 0;
        }
        else if(y > 1000) { // Borderline
            this.y = 1000;
        }
        else {
            this.y = y;
        }
    }
    // Getter
    public int getId() {
        return this.id;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    /* METHODS */
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        // Get all adjacent cells information
        HashMap<Integer, Cell> adj_cells = new HashMap<Integer, Cell>();
        adj_cells.put(1, neighbors.get(indexFromCoord(this.x - 1, this.y - 1)));
        adj_cells.put(2, neighbors.get(indexFromCoord(this.x, this.y - 1)));
        adj_cells.put(3, neighbors.get(indexFromCoord(this.x + 1, this.y - 1)));
        adj_cells.put(4, neighbors.get(indexFromCoord(this.x - 1, this.y)));
        adj_cells.put(5, neighbors.get(indexFromCoord(this.x + 1, this.y)));
        adj_cells.put(6, neighbors.get(indexFromCoord(this.x - 1, this.y + 1)));
        adj_cells.put(7, neighbors.get(indexFromCoord(this.x, this.y + 1)));
        adj_cells.put(8, neighbors.get(indexFromCoord(this.x + 1, this.y + 1)));
    }
}
