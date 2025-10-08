// File: SmartLight.java
// Demonstrates OOP concepts: class, object, encapsulation, and methods.

package Chapter1; // Declares that this file belongs to the package named Chapter1

// Define a class named Light
class Light {
    private String roomName;   // Variable to store the name of the room
    private int brightness;    // Variable to store brightness level (in percentage)
    private boolean isOn;      // Variable to store whether the light is ON or OFF

    // Constructor to initialize the light with room name and brightness
    public Light(String roomName, int brightness) {
        this.roomName = roomName;   // Assign the given room name to this object's roomName
        this.brightness = brightness; // Assign the given brightness to this object's brightness
        this.isOn = false;            // By default, the light is OFF when created
    }

    // Method to turn on the light
    public void turnOn() {
        isOn = true;  // Set the light state to ON
        System.out.println(roomName + " light is ON."); // Display message that the light is ON
    }

    // Method to turn off the light
    public void turnOff() {
        isOn = false; // Set the light state to OFF
        System.out.println(roomName + " light is OFF."); // Display message that the light is OFF
    }

    // Method to change the brightness level
    public void adjustBrightness(int level) {
        brightness = level; // Update brightness to the new level
        System.out.println(roomName + " brightness set to " + brightness + "%"); // Show updated brightness
    }

    // Method to display current light status
    public void displayStatus() {
        String status = isOn ? "ON" : "OFF"; // Use ternary operator to check ON/OFF state
        System.out.println(roomName + " → " + status + " | Brightness: " + brightness + "%"); // Display status
    }
}

// Define the main class SmartLight that will run the program
public class SmartLight {
    public static void main(String[] args) { // Main method — entry point of the program
        Light livingRoom = new Light("Living Room", 70); // Create a Light object for the Living Room with brightness 70%

        livingRoom.turnOn();           // Turn ON the light
        livingRoom.adjustBrightness(85); // Adjust brightness to 85%
        livingRoom.displayStatus();      // Display current status (ON, Brightness)
        livingRoom.turnOff();            // Turn OFF the light
    }
}
