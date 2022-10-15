/**
 * 
 */
package com.hany.java;


/**
 * @author hany
 *
 */
public class Widget implements Comparable<Widget>{


    private int weight;
    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }
    /**
     * @return
     */
    @Override
    public String toString() {
        return "Widget [weight=" + weight + ", color=" + color + "]";
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
    
    
    
    /**
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + weight;
        return result;
    }
    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Widget other = (Widget) obj;
        if (color != other.color)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
    /**
     * @param o
     * @return
     */
    @Override
    public int compareTo(Widget in) {
        if (in.equals(this))
            return 0;
        else if(in.getWeight() < this.getWeight() )
            return -1;
        else
            return 1;
    }
    
    
    
    
    
}