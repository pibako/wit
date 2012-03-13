/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author piotrkowalski
 */
public class Circle implements Shape {

    private int radius;

    public Circle(double radius) {
        this.radius = (int) radius;
    }

    public double area() {
        return Math.PI * (radius ^ 2);
    }

    public double getRadius() {
        return radius;
    }
    
    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.radius;
        return hash;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Circle otherMyClass = (Circle) other;
        if (otherMyClass.getRadius() != this.getRadius()) {
            return false;
        }
        return true;
    }
    
}
