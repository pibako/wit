/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author piotrkowalski
 */
public class Square implements Shape {

    private double side;

    public Square(double a) {
        this.side = a;
    }

    public double area() {
        return side * side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square with side " + side;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.side) ^ (Double.doubleToLongBits(this.side) >>> 32));
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
        Square otherMyClass = (Square) other;
        if (otherMyClass.getSide() == this.getSide()) {
            return false;
        }
        return true;
    }
}
