package chapter1;//my Package name

//Author name: Miss Diana
//Date create: 17.09.2025
//Purpose of Code: Create Chapter's 1 Abstraction Simple Code

//library that being imported when necessary

//Abstract class
abstract class Animal 
{
	abstract void sound(); // abstract method
	 void sleep() 
	 {         // concrete method
	     System.out.println("Sleeping...");
	 }
}

class Dog extends Animal {
	 void sound() {
	     System.out.println("Woof Woof!");
	 }
}

class Cat extends Animal {
	void sound() {
		System.out.println("Meow Meow~");
	}
}

//my class name
public class Abstraction {
	 public static void main(String[] args) {
	     Animal a = new Dog(); // reference of abstract class
	     Animal b = new Cat(); // reference of abstract class
	     a.sound();            // implementation from Dog
	     a.sleep();            // concrete method from Animal
	     b.sound();            // implementation from Cat
	     b.sleep();            // concrete method from Animal
	 }
}