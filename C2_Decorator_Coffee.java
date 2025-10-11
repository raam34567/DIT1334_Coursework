package chapter2;

interface Coffee { double cost(); String desc(); }
class BasicCoffee implements Coffee { public double cost(){ return 5.0; } public String desc(){ return "Coffee"; } }
abstract class CoffeeExtra implements Coffee { protected final Coffee base; CoffeeExtra(Coffee b){ base=b; } }
class Milk extends CoffeeExtra { Milk(Coffee b){ super(b); } public double cost(){ return base.cost()+1.0; } public String desc(){ return base.desc()+", Milk"; } }
class Sugar extends CoffeeExtra { Sugar(Coffee b){ super(b); } public double cost(){ return base.cost()+0.5; } public String desc(){ return base.desc()+", Sugar"; } }
public class C2_Decorator_Coffee {
    public static void main(String[] args){
        Coffee c = new Sugar(new Milk(new BasicCoffee()));
        System.out.println(c.desc() + " = RM" + c.cost());
    }
}
