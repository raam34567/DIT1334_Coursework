// File: FoodOrder.java
// Demonstrates OOP concepts: class, constructor, object interaction.

package Chapter1; // Declares that this file belongs to the package named Chapter1
import java.util.ArrayList; // Imports ArrayList class to store multiple Food objects

// Define the Food class to represent food items
class Food {
    String name;     // Variable to store the name of the food
    double price;    // Variable to store the price of the food
    int prepTime;    // Variable to store preparation time in minutes

    // Constructor to initialize food details
    Food(String name, double price, int prepTime) {
        this.name = name;       // Assigns the food name to the object's name
        this.price = price;     // Assigns the food price to the object's price
        this.prepTime = prepTime; // Assigns preparation time to the object's prepTime
    }
}

// Define the Cart class to store and manage multiple food items
class Cart {
    ArrayList<Food> items = new ArrayList<>(); // Creates a list to hold Food objects

    // Method to add a food item to the cart
    void addFood(Food f) {
        items.add(f); // Adds the food object to the ArrayList
        System.out.println(f.name + " added to cart."); // Prints confirmation message
    }

    // Method to calculate and display the total price of all food items
    void showTotal() {
        double total = 0; // Initialize total variable to 0
        for (Food f : items) total += f.price; // Loop through all items and add their prices
        System.out.println("Total Price: RM" + total); // Display total price
    }
}

// Define the main class where the program starts
public class FoodOrder {
    public static void main(String[] args) { // Main method — entry point of the program
        Cart c = new Cart(); // Create a new Cart object

        // Add food items to the cart
        c.addFood(new Food("Burger", 8.5, 10)); // Adds a Burger object to the cart
        c.addFood(new Food("Fries", 4.0, 5));   // Adds a Fries object to the cart

        // Show total price of items in the cart
        c.showTotal();
    }
}
