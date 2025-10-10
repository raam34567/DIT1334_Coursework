package chapter2;

class Order {
    final String item;
    final int qty;
    final boolean giftWrap;
    Order(String item, int qty, boolean giftWrap){
        this.item=item; this.qty=qty; this.giftWrap=giftWrap;
    }
    public String toString(){ return "Order[item="+item+", qty="+qty+", giftWrap="+giftWrap+"]"; }
}
class OrderBuilder {
    private String item="Coffee";
    private int qty=1;
    private boolean giftWrap=false;
    public OrderBuilder item(String i){ this.item=i; return this; }
    public OrderBuilder qty(int q){ this.qty=q; return this; }
    public OrderBuilder giftWrap(boolean g){ this.giftWrap=g; return this; }
    public Order build(){ return new Order(item, qty, giftWrap); }
}
public class B3_Builder_Order {
    public static void main(String[] args){
        Order o = new OrderBuilder().item("Latte").qty(2).giftWrap(true).build();
        System.out.println(o);
    }
}
