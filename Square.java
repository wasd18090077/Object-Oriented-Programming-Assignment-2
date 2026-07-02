public class Square extends Shape {
    private double side;

    // Constructor: creates a Square with the given side length and position
    public Square(double side, Coordinates coord) {
        super(4, coord);
        this.side = side;
    }

    // Scales the square's side and position by multiplying (sign=true) or dividing (sign=false) by factor
    // Uses integer division when dividing to truncate the result (e.g. 7 / 2 = 3)
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.side *= factor;
        } else {
            if (factor != 0) {
                this.side = (int) (this.side / factor);
            }
        }
    }

    // Returns the area of the square using the formula side * side
    @Override
    public double getArea() {
        return side * side;
    }

    // Returns the perimeter of the square using the formula 4 * side
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    // Returns a string with all information about this square
    @Override
    public String display() {
        return "Shape: Square, Sides: " + getSides() + ", Position: (" + getCoordinates().display() +
                "), Side: " + side + ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}
