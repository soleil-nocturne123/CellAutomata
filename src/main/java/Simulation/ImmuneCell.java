package Simulation;

import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import static Util.Calculator.indexFromCoord;

public class ImmuneCell extends Cell{
    /* CONSTRUCTORS */
    // Default constructor
    public ImmuneCell() {
        this(1,0,0,0);
    }
    public ImmuneCell(Pair coord) {
        setId(1);
        setStrength(100);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public ImmuneCell(int id, int strength, int x, int y) {
        setId(id);
        setStrength(strength);
        setX(x);
        setY(y);
    }

    @Override
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

        // Immune Cell action
        for(int i = 1; i < 9; i++) {
            Cell check_cell = adj_cells.get(i);
            if(check_cell != null) {
                if(check_cell.id == 2) {
                    if(this.strength > check_cell.strength) {
                        neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new DeadCell(3, 0, check_cell.x, check_cell.y));
                    }
                    else if(this.strength > check_cell.strength - 2) {
                        double probability = Math.random();
                        if(probability > 0.5) {
                            neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new DeadCell(3, 0, check_cell.x, check_cell.y));
                        }
                    }
                }
            }
        }
    }
}