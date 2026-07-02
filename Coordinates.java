public class Coordinates {
    private int x;
    private int y;

    // Constructor: creates a Coordinates object with the given x and y values
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Returns the x value of this coordinate
    public int getX() {
        return x;
    }

    // Returns the y value of this coordinate
    public int getY() {
        return y;
    }

    // Calculates and returns the distance between this point and another point p
    public double distance(Coordinates p) {
        double diffX = p.getX() - this.x;
        double diffY = p.getY() - this.y;
        return Math.sqrt((diffX * diffX) + (diffY * diffY));
    }

    // Moves this coordinate by adding dx to x and dy to y
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Scales this coordinate by multiplying (sign=true) or dividing (sign=false) by factor
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            if (factor != 0) {
                this.x /= factor;
                this.y /= factor;
            }
        }
    }

    // Returns a string showing the x and y values
    public String display() {
        return "X = " + x + ", Y = " + y;
    }
}
