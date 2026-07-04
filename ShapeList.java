import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listOfShapes;

    // Constructor: creates an empty list to store shapes
    public ShapeList() {
        this.listOfShapes = new ArrayList<>();
    }

    // Adds a shape to the end of the list
    public void addShape(Shape s) {
        listOfShapes.add(s);
    }

    // Moves all shapes in the list by dx and dy
    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) {
            s.translate(dx, dy);
        }
    }

    // Returns the shape at the given position, or null if the position does not exist
    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.get(pos);
        }
        System.out.println("Error: No shape at position " + pos);
        return null;
    }

    // Removes and returns the shape at the given position, or null if the position does not exist
    public Shape removeShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.remove(pos);
        }
        System.out.println("Error: Cannot remove, no shape at position " + pos);
        return null;
    }

    // Returns the area of the shape at the given position, or -1 if not found
    public double area(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return -1;
    }

    // Scales all shapes in the list by multiplying (sign=true) or dividing (sign=false) by factor
    public void scale(int factor, boolean sign) {
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
    }

    // Returns the perimeter of the shape at the given position, or -1 if not found
    public double perimeter(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return -1;
    }

    // Returns the total number of shapes currently in the list
    public int getNumberOfShapes() {
        return listOfShapes.size();
    }

    // Returns a string showing all shapes in the list with their details
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeList contains ").append(getNumberOfShapes()).append(" shapes:\n");
        for (int i = 0; i < listOfShapes.size(); i++) {
            sb.append("[").append(i + 1).append("] ").append(listOfShapes.get(i).display()).append("\n");
        }
        return sb.toString();
    }
}
