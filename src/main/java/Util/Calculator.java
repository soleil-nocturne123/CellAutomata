package Util;

public class Calculator {
    private static int width; //number of cells in x dir
    private static int height; //number of cells in y dir

    /* CONSTRUCTOR */
    public Calculator(int width, int height){
        this.width = width;
        this.height = height;
    }

    /* Cells are stored in a 1D array and the corresponding coordinates in a 2D pixel space are translated back to the index */
    public static int indexFromCoord(int x, int y){
        if(x >= width || y >= height || x <= 0 || y <= 0){
            return 10000;
        }
        return width*y + x;
    }

    /* Cells are stored in a 1D array and the corresponding coordinates in a 2D pixel space are translated back to the index */
    public static int indexFromCoord(Pair coord){
        return indexFromCoord(coord.getX(), coord.getY());
    }

    /* Cells are stored in a 1D array and translated to the corresponding coordinates in a 2D pixel space */
    public static Pair coordFromIndex(int i){
        return new Pair(i%width, (i - (i%width))/width);
    }
}
