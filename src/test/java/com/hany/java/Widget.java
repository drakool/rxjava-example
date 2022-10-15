/**
 * 
 */
package com.hany.java;


/**
 * @author hany
 *
 */
public class Widget {


    private int weight;
    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }
    /**
     * @param weight
     * @param color
     */
    public Widget(int weight, Color color) {
        super();
        this.weight = weight;
        this.color = color;
    }
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    private Color color;
    public enum Color {
       RED, GREEN, BLUE;
    }
    
    
    
    
    
}