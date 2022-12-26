package Simulation;


import Util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static Util.Calculator.indexFromCoord;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell{
    /* CONSTRUCTORS */
    // Default constructor
    public CancerCell() {
        this(2,0,0,0);
    }
    public CancerCell(Pair coord) {
        setId(2);
        setStrength(100);
        setX(coord.getX());
        setY(coord.getY());
    }
    // Specified constructor
    public CancerCell(int id, int strength, int x, int y) {
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

        // Count the number of each cell type
        int count_immune = 0;
        int count_dead = 0;
        int count_tissue = 0;
        int count_cancer = 0;

        for (int i = 1; i < 9; i++) {
            Cell check_cell = adj_cells.get(i);
            if(check_cell.id == 1) {
                count_immune++;
            }
            if(check_cell.id == 3) {
                count_dead++;
            }
            if(check_cell.id == 4) {
                count_tissue++;
            }
        }

        // Cancer Cell action
        if(count_tissue > count_immune) {
            int num_kill = this.strength/2;
            if(num_kill < 1) {
                num_kill = 1;
            }
            for(int i = 1; i < 9; i++) {
                Cell check_cell = adj_cells.get(i);
                if(check_cell.id == 4 && num_kill > 0) {
                    neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new DeadCell(3, 0, check_cell.x, check_cell.y));
                    num_kill--;
                }
            }
        } else if(count_tissue <= count_immune){
            int num_attack = this.strength/2;
            if(num_attack < 1) {
                num_attack = 1;
            }
            for(int i = 1; i < 9; i++) {
                Cell check_cell = adj_cells.get(i);
                if(check_cell.id == 1 && num_attack > 0) {
                    double probability = Math.random();
                    if(check_cell.strength < this.strength - 3) {
                        if(probability > 0.5) {
                            neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new DeadCell(3, 0, check_cell.x, check_cell.y));
                        }
                    }
                    else if(check_cell.strength < this.strength) {
                        if(probability < 0.5 && probability > 0.4) {
                            neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new DeadCell(3, 0, check_cell.x, check_cell.y));
                        }
                    }
                    num_attack--;
                }
            }
        }
        if(count_dead > 0) {
            int num_transform = this.strength/2;
            if (num_transform < 1) {
                num_transform = 1;
            }
            for(int i = 1; i < 9; i++) {
                Cell check_cell = adj_cells.get(i);
                if(check_cell.id == 3 && num_transform > 0) {
                    neighbors.set(indexFromCoord(check_cell.x, check_cell.y), new CancerCell(2, this.strength/2, check_cell.x, check_cell.y));
                    num_transform--;
                }
            }
        }
    }
}
