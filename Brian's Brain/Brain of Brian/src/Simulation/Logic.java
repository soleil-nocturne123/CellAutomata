/* CREATE AND IMPLEMENT CELL LOGIC */
package Simulation;

import java.util.ArrayList;

import Util.Calculator;
import Util.Pair;

public class Logic {
    private int width; //number of cells in x dir
    private int height; //number of cells in y dir
    private ArrayList<Cell> cellList; //arraylist holding cells
    private Calculator calc; //helpful calculator

    /* CONSTRUCTOR */
    public Logic(int width, int height){
        if (width < 0) {
            width = 0;
        };
        if(height < 0) {
            height = 0;
        }
        this.width = width;
        this.height = height;
        this.calc = new Calculator(width, height);
        cellList = new ArrayList<>();
        initialize();
    }

    /* INITIALIZE CELLS -- PUT CELLS ON THE BOARD */
    private void initialize(){
        double rngNum =0;
        // Fill in every cell in the board
        for(int i =0; i < width*height; i++){
            rngNum = Math.random()*100;
            if (rngNum < 80.0){
                cellList.add(new Off(calc.coordFromIndex(i)));
            }
            else if (rngNum >= 80.0 && rngNum < 90.0){
                cellList.add(new Firing(calc.coordFromIndex(i)));
            } else {
                cellList.add(new Refractory(calc.coordFromIndex(i)));
            }
        }
        cellList.add(new Cell());
    }

    /* CELL INTERACTIONS -- ITERATE THROUGH EVERY CELL*/
    public void timeStep(){
        for(Cell c : cellList){
            c.interactNeighbors(cellList);
        }
    }

    public int setColour(Pair coords){
        int toRet = cellList.get(calc.indexFromCoord(coords)).id;
        return toRet;
    }
}
