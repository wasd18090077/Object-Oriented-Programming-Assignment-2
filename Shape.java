public abstract class Shape {
    private Coordinates position;
    private int sides;

    // Constructor: sets the number of sides and the starting position of the shape
    public Shape(int noOfSides, Coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }

    // Returns the position (coordinates) of this shape
    public Coordinates getCoordinates() {
        return position;
    }

    // Returns the number of sides of this shape
    public int getSides() {
        return sides;
    }

    // Updates the position of this shape to a new coordinate
    public void setCoordinates(Coordinates newcoord) {
        this.position = newcoord;
    }

    // Moves the shape's position by dx and dy
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    // Scales the shape's position by multiplying or dividing by factor
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
    }

    // Returns the area of this shape (to be implemented by subclasses)
    public abstract double getArea();

    // Returns the perimeter of this shape (to be implemented by subclasses)
    public abstract double getPerimeter();

    // Returns a string with all information about this shape (to be implemented by subclasses)
    public abstract String display();
}
