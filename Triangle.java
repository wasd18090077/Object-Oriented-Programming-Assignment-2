public class Triangle extends Shape {
    private Coordinates vertex2;
    private Coordinates vertex3;

    // Constructor: creates a Triangle with three vertices (position is vertex1)
    public Triangle(Coordinates position, Coordinates vertex2, Coordinates vertex3) {
        super(3, position);
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    // Moves all three vertices of the triangle by dx and dy
    @Override
    public void translate(int dx, int dy) {
        super.translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }

    // Scales all three vertices of the triangle by multiplying (sign=true) or dividing (sign=false) by factor
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        vertex2.scale(factor, sign);
        vertex3.scale(factor, sign);
    }

    // Returns the area of the triangle using Heron's Formula
    @Override
    public double getArea() {
        double a = getCoordinates().distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(getCoordinates());
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Returns the perimeter of the triangle as the sum of the three side lengths
    @Override
    public double getPerimeter() {
        double a = getCoordinates().distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(getCoordinates());
        return a + b + c;
    }

    // Returns a string with all information about this triangle
    @Override
    public String display() {
        return "Shape: Triangle, Sides: " + getSides() + ", Vertices: V1(" + getCoordinates().display() +
                "), V2(" + vertex2.display() + "), V3(" + vertex3.display() + "), Area: " + getArea() +
                ", Perimeter: " + getPerimeter();
    }
}
