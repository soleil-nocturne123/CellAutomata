package Simulation;

import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import static Util.Calculator.indexFromCoord;
public class Off extends Cell {
    /* CONSTRUCTORS */
    // Default constructor
    public Off() {
        this(0,0,0);
    }
    public Off(Pair coord) {
        setId(0);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public Off(int id, int x, int y) {
        setId(id);
        setX(x);
        setY(y);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        int num_firing = 0;
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

        // Tissue Cell action
        for(int i = 1; i < 9; i++) {
            Cell check_cell = adj_cells.get(i);
            if(check_cell.id == 1) {
                num_firing++;
            }
        }

        // Turn into firing if there are exactly 2 adjacent firing cells
        if(num_firing == 2) {
            neighbors.set(indexFromCoord(this.x, this.y), new Firing(1, this.x, this.y));
        }
    }
}
