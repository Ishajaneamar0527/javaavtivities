// Base class
class Vehicle {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor
    Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

// Derived class
class Car extends Vehicle {
    // Additional attribute
    int numberOfDoors;

    // Constructor
    Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Car class
        Car myCar = new Car("Toyota", "Camry", 2022, 4);

        // Display details of the car
        myCar.displayDetails();
    }
}
