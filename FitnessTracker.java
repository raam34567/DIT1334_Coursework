// File: FitnessTracker.java
// Demonstrates OOP concepts: Inheritance and Method Overriding

package Chapter1; // Declares that this file belongs to the package named Chapter1

// Abstract class representing a generic activity
abstract class Activity {
    double duration, distance; // Variables to store duration (hours) and distance (km)
    
    // Abstract method to calculate calories — must be implemented by subclasses
    abstract double calculateCalories();
}

// Running class inherits from Activity
class Running extends Activity {
    // Constructor to initialize duration and distance
    Running(double d, double dist) { 
        duration = d; 
        distance = dist; 
    }

    // Overriding calculateCalories method for running
    double calculateCalories() { 
        return distance * 60; // Example formula: 60 calories per km
    }
}

// Cycling class inherits from Activity
class Cycling extends Activity {
    // Constructor to initialize duration and distance
    Cycling(double d, double dist) { 
        duration = d; 
        distance = dist; 
    }

    // Overriding calculateCalories method for cycling
    double calculateCalories() { 
        return distance * 40; // Example formula: 40 calories per km
    }
}

// Main class where program execution starts
public class FitnessTracker {
    public static void main(String[] args) { // Main method — entry point of the program
        Activity run = new Running(1.0, 5.0);   // Create a Running object: 1 hour, 5 km
        Activity cycle = new Cycling(1.5, 10.0); // Create a Cycling object: 1.5 hours, 10 km

        // Display calories burned for running and cycling
        System.out.println("Running calories: " + run.calculateCalories());
        System.out.println("Cycling calories: " + cycle.calculateCalories());
    }
}
