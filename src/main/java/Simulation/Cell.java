package Simulation;

import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import static Util.Calculator.indexFromCoord;

/* GENERIC CELL */
public class Cell {
    protected int id; // Indicate different cell types (0: generic cell, 1: immune cell, 2: cancer cell, 3: dead cell, 4:tissue cell)
    protected int strength; // The strength of the cell used for combat simulation
    protected int x; // x-coordinate of the cell
    protected int y; // y-coordinate of the cell

    /* CONSTRUCTORS */
    // Default constructor
    public Cell() {
        this(0,0,0,0);
    }
    public Cell(Pair coord) {
        setId(0);
        setStrength(0);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public Cell(int id, int strength, int x, int y) {
        setId(id);
        setStrength(strength);
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
    public void setStrength(int strength) {
        if(strength < 0) {
            this.strength = 0;
        }
        if(strength > 10) {
            double probability = Math.random();
            if(probability < 0.1) {
                this.strength = 1;
            }
            else if(probability < 0.2) {
                this.strength = 2;
            }
            else if(probability < 0.3) {
                this.strength = 3;
            }
            else if(probability < 0.4) {
                this.strength = 4;
            }
            else if(probability < 0.5) {
                this.strength = 5;
            }
            else if(probability < 0.6) {
                this.strength = 6;
            }
            else if(probability < 0.7) {
                this.strength = 7;
            }
            else if(probability < 0.8) {
                this.strength = 8;
            }
            else if(probability < 0.9) {
                this.strength = 9;
            }
            else {
                this.strength = 10;
            }
        }
        else {
            this.strength = strength;
        }
    }
    public void setX(int x) {
        if(x < 0) { // Borderline
            this.x = 0;
        }
        else if( x > 100) { // Borderline
            this.x = 100;
        }
        else {
            this.x = x;
        }
    }
    public void setY(int y) {
        if(y < 0) { // Borderline
            this.y = 0;
        }
        else if(y > 100) { // Borderline
            this.y = 100;
        }
        else {
            this.y = y;
        }
    }
    // Getter
    public int getId() {
        return this.id;
    }
    public int getStrength() {
        return this.strength;
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
