/* Initiate and implement coordinate pairs */
package Util;

public class Pair {
    private int x; // x pos
    private int y; //y pos

    /* CONSTRUCTOR */
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Pair(){
        this(0,0);
    }

    /* METHODS TO GET SEPARATE COORDS */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
