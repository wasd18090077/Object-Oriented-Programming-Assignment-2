import java.util.Scanner;

public class ShapeManagement {
    private ShapeList shapeList;
    private Scanner scanner;

    // Constructor: creates a new ShapeList and Scanner for user input
    public ShapeManagement() {
        this.shapeList = new ShapeList();
        this.scanner = new Scanner(System.in);
    }

    // Reads and returns a valid integer from the user, keeps asking if input is invalid
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    // Reads and returns a valid decimal number from the user, keeps asking if input is invalid
    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Reads and returns a valid boolean (true/false) from the user, keeps asking if input is invalid
    private boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }

    // Runs the main menu loop until the user chooses to quit
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Shape Management Menu ---");
            System.out.println("1: Add a shape");
            System.out.println("2: Remove a shape by position");
            System.out.println("3: Get information about a shape by position");
            System.out.println("4: Area and perimeter of a shape by position");
            System.out.println("5: Display information of all the shapes");
            System.out.println("6: Translate all the shapes");
            System.out.println("7: Scale all the shapes");
            System.out.println("0: Quit program");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    manageAddShape();
                    break;
                case 2:
                    manageRemoveShape();
                    break;
                case 3:
                    manageShapeInfo();
                    break;
                case 4:
                    manageAreaAndPerimeter();
                    break;
                case 5:
                    manageDisplay();
                    break;
                case 6:
                    manageTranslateShapes();
                    break;
                case 7:
                    manageScaleShapes();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
                    break;
            }
        }
    }

    // Asks the user to select a shape type, then reads its details and adds it to the list
    private void manageAddShape() {
        System.out.println("Select shape to add: ");
        System.out.println("1: Rectangle");
        System.out.println("2: Square");
        System.out.println("3: Circle");
        System.out.println("4: Triangle");
        int type = readInt("> ");
        int x = readInt("Enter X coordinate: ");
        int y = readInt("Enter Y coordinate: ");
        Coordinates coord = new Coordinates(x, y);

        switch (type) {
            case 1:
                double w = readDouble("Enter width: ");
                double l = readDouble("Enter length: ");
                shapeList.addShape(new Rectangle(w, l, coord));
                System.out.println("Rectangle added.");
                break;
            case 2:
                double s = readDouble("Enter side: ");
                shapeList.addShape(new Square(s, coord));
                System.out.println("Square added.");
                break;
            case 3:
                double r = readDouble("Enter radius: ");
                shapeList.addShape(new Circle(r, coord));
                System.out.println("Circle added.");
                break;
            case 4:
                int x2 = readInt("Enter V2 X coordinate: ");
                int y2 = readInt("Enter V2 Y coordinate: ");
                int x3 = readInt("Enter V3 X coordinate: ");
                int y3 = readInt("Enter V3 Y coordinate: ");
                shapeList.addShape(new Triangle(coord, new Coordinates(x2, y2), new Coordinates(x3, y3)));
                System.out.println("Triangle added.");
                break;
            default:
                System.out.println("Invalid shape type.");
                break;
        }
    }

    // Asks the user for a position and removes the shape at that position
    private void manageRemoveShape() {
        int pos = readInt("Enter position to remove (1, 2, 3...): ");
        Shape removed = shapeList.removeShape(pos - 1);
        if (removed != null) {
            System.out.println("Shape removed successfully.");
        }
    }

    // Asks the user for a position and displays the information of the shape at that position
    private void manageShapeInfo() {
        int pos = readInt("Enter position to view info (1, 2, 3...): ");
        Shape shape = shapeList.getShape(pos - 1);
        if (shape != null) {
            System.out.println(shape.display());
        }
    }

    // Asks the user for a position and displays the area and perimeter of the shape at that position
    private void manageAreaAndPerimeter() {
        int pos = readInt("Enter position (1, 2, 3...): ");
        Shape shape = shapeList.getShape(pos - 1);
        if (shape != null) {
            System.out.println("Area: " + shapeList.area(pos - 1));
            System.out.println("Perimeter: " + shapeList.perimeter(pos - 1));
        }
    }

    // Displays all shapes currently in the list
    private void manageDisplay() {
        System.out.println(shapeList.display());
    }

    // Asks the user for dx and dy values, then translates all shapes
    private void manageTranslateShapes() {
        int dx = readInt("Enter X distance (dx): ");
        int dy = readInt("Enter Y distance (dy): ");
        shapeList.translateShapes(dx, dy);
        System.out.println("All shapes translated by dx=" + dx + ", dy=" + dy);
    }

    // Asks the user for a scale factor and direction, then scales all shapes
    private void manageScaleShapes() {
        int factor = readInt("Enter factor: ");
        boolean sign = readBoolean("Multiply (true) or Divide (false)? ");
        shapeList.scale(factor, sign);
        System.out.println("All shapes scaled by factor=" + factor + ", sign=" + sign);
    }

    // Entry point of the program
    public static void main(String[] args) {
        ShapeManagement app = new ShapeManagement();
        app.run();
    }
}
