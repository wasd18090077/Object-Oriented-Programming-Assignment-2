public class Circle extends Shape {
    private double radius;

    // Constructor: creates a Circle with the given radius and position
    public Circle(double radius, Coordinates coord) {
        super(0, coord);
        this.radius = radius;
    }

    // Scales the circle's radius and position by multiplying (sign=true) or dividing (sign=false) by factor
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.radius *= factor;
        } else {
            if (factor != 0) {
                this.radius = (int) (this.radius / factor);
            }
        }
    }

    // Returns the area of the circle using the formula PI * r * r
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Returns the perimeter (circumference) of the circle using the formula 2 * PI * r
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Returns a string with all information about this circle
    @Override
    public String display() {
        return "Shape: Circle, Sides: " + getSides() + ", Position: (" + getCoordinates().display() +
                "), Radius: " + radius + ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}
