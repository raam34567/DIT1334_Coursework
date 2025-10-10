package chapter1;//my Package name

//Author name: Miss Diana
//Date Created: 17.09.2025
//Purpose of the code: to show how inheritance works

//library that being imported when necessary

//class inheritance 
public class Inheritance { //main class for inheritance
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); // inherited from Vehicle
        myCar.drive(); // defined in Car
    }
}

// Parent class
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Child class inherits Vehicle
class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving...");
    }
}