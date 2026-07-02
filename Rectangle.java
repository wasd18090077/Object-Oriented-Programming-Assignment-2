public class Rectangle extends Shape {
    private double width;
    private double length;

    // Constructor: creates a Rectangle with the given width, length and position
    public Rectangle(double width, double length, Coordinates coord) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    // Scales the rectangle's width, length and position by multiplying (sign=true) or dividing (sign=false) by factor
    // Uses integer division when dividing to truncate the result (e.g. 7 / 2 = 3)
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            if (factor != 0) {
                this.width = (int) (this.width / factor);
                this.length = (int) (this.length / factor);
            }
        }
    }

    // Returns the area of the rectangle using the formula width * length
    @Override
    public double getArea() {
        return width * length;
    }

    // Returns the perimeter of the rectangle using the formula 2 * width + 2 * length
    @Override
    public double getPerimeter() {
        return 2 * width + 2 * length;
    }

    // Returns a string with all information about this rectangle
    @Override
    public String display() {
        return "Shape: Rectangle, Sides: " + getSides() + ", Position: (" + getCoordinates().display() +
                "), Width: " + width + ", Length: " + length + ", Area: " + getArea() + ", Perimeter: "
                + getPerimeter();
    }
}
