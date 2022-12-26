/* PIXEL SETUP */

package Rendering;

import Util.Pair;

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pixel extends Component{
    private final int x;
    private final int y;
    int colourID;
    Color[] colors = new Color[10];
    private final int w;
    private final int h;

    /**
     * Constructor for fun stuff Shows ya what colors should be
     * @param x x position, with 0 being left most
     * @param y y position, with 0 being top most
     * @param w width of pixel
     * @param h height of pixel
     * @param colourID index of color array (see the method below what what colour is what index)
     */
    Pixel(int x, int y, int w, int h, int colourID){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colourID = colourID;
        colors[0] = Color.WHITE; // Generic Cell
        colors[1] = Color.ORANGE; // ImmuneCell
        colors[2] = Color.BLUE; // CancerCell
        colors[3] = Color.BLACK; // DeadCell
        colors[4] = Color.LIGHT_GRAY; // TissueCell
        colors[5] = Color.CYAN;
        colors[6] = Color.MAGENTA;
        colors[7] = Color.RED;
        colors[8] = Color.YELLOW;
        colors[9] = Color.GREEN;
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
    }

    /**
     * Sets the colour of the pixel
     * @param colourID The id that represents the color
     */
    public void setColour(int colourID){
        if(colourID <= 4 && colourID >= 0){
            this.colourID = colourID;
        }
    }

    /**
     * Paints a pixel on the screen
     * @param g the graphic to paint on.
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(colors[colourID]);
        g.fillRect(x,y,w,h);

    }
}
