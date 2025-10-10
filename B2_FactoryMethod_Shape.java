package chapter2;

interface Shape { String draw(); }
class Circle implements Shape { public String draw(){ return "Circle"; } }
class Square implements Shape { public String draw(){ return "Square"; } }
abstract class ShapeDialog {
    abstract Shape createShape();
    void show(){ System.out.println("Draw: " + createShape().draw()); }
}
class CircleDialog extends ShapeDialog { Shape createShape(){ return new Circle(); } }
class SquareDialog extends ShapeDialog { Shape createShape(){ return new Square(); } }
// TODO: Add Triangle + TriangleDialog and call in main
public class B2_FactoryMethod_Shape {
    static void client(ShapeDialog dialog){ dialog.show(); }
    public static void main(String[] args){
        client(new CircleDialog());
        client(new SquareDialog());
        // client(new TriangleDialog());
    }
}
