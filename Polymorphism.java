package chapter1;//my Package name

//Author name: Miss Diana
//Date create: 17.09.2025
//Purpose of Code: Create Chapter's 1 Polymorphism Simple Code

//library that being imported when necessary

//class shape
class Shape {
    void draw() {
        System.out.println("Drawing a shape...");
    }
}

class CirclePoly extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle...");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle...");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Triangle...");
    }
}

//my class name
public class Polymorphism {
    public static void main(String[] args) {
    	//Shape shape  = new Shape();
        Shape s1 = new Triangle();
        Shape s2 = new Rectangle();
        Shape s3 = new CirclePoly();
        //shape.draw();
        s1.draw(); // Triangle version
        s2.draw(); // Rectangle's version
        s3.draw(); // Circle's version
    }
}