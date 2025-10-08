// File: MovieBooking.java
// Demonstrates OOP concepts: Classes, Objects, and Conditional Logic

package Chapter1; // Declares that this file belongs to the package named Chapter1

// Define the Movie class
class Movie {
    String title;       // Movie title
    String showTime;    // Show time of the movie
    double basePrice;   // Base ticket price

    // Constructor to initialize movie details
    Movie(String title, String showTime, double basePrice) {
        this.title = title;       // Assign title to the object
        this.showTime = showTime; // Assign show time to the object
        this.basePrice = basePrice; // Assign base price to the object
    }

    // Method to calculate ticket price based on seat type
    double calculatePrice(String seatType) {
        if (seatType.equalsIgnoreCase("Premium")) return basePrice * 1.5; // Premium seat: 50% extra
        else if (seatType.equalsIgnoreCase("VIP")) return basePrice * 2.0; // VIP seat: 100% extra
        else return basePrice; // Standard seat: no extra charge
    }
}

// Main class where program execution starts
public class MovieBooking {
    public static void main(String[] args) { // Main method — entry point
        Movie movie = new Movie("Interstellar", "8:00 PM", 15.0); // Create Movie object
        String seat = "VIP"; // Selected seat type
        double total = movie.calculatePrice(seat); // Calculate total price based on seat type

        // Display movie booking details
        System.out.println("Movie: " + movie.title);
        System.out.println("Seat: " + seat);
        System.out.println("Total: RM" + total);
    }
}
