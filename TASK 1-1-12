// Step 1: Define the Shape interface
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Step 2: Create the AbstractShape abstract class
abstract class AbstractShape implements Shape {
    // Common attributes
    String color;
    double length;
    double width;

    // Constructor
    AbstractShape(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
    }

    // Implementations for calculateArea and calculatePerimeter methods
    @Override
    public abstract double calculateArea();

    @Override
    public abstract double calculatePerimeter();
}

// Step 3: Implement concrete classes Circle and Rectangle
class Circle extends AbstractShape {
    double radius;

    // Constructor
    Circle(String color, double radius) {
        super(color, 0, 0); // For simplicity, set length and width to 0
        this.radius = radius;
    }

    // Implementations for calculateArea and calculatePerimeter methods
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends AbstractShape {
    // Constructor
    Rectangle(String color, double length, double width) {
        super(color, length, width);
    }

    // Implementations for calculateArea and calculatePerimeter methods
    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Step 4: Main class
public class Main {
    public static void main(String[] args) {
        // Create instances of Circle and Rectangle
        Circle circle = new Circle("Red", 5.0);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);

        // Display their areas and perimeters
        displayDetails(circle);
        displayDetails(rectangle);
    }

    // Display details method
    private static void displayDetails(AbstractShape shape) {
        System.out.println(shape.color + " " + shape.getClass().getSimpleName());
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println();
    }
}
