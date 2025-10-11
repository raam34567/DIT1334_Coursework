package chapter2;

interface PayStrategy { void pay(double amt); }
class CardPay implements PayStrategy { public void pay(double a){ System.out.println("Card: RM"+a); } }
class PaypalPay implements PayStrategy { public void pay(double a){ System.out.println("PayPal: RM"+a); } }
class Checkout {
    private PayStrategy strategy;
    Checkout(PayStrategy s){ strategy=s; }
    void setStrategy(PayStrategy s){ strategy=s; }
    void process(double amt){ strategy.pay(amt); }
}
public class D2_Strategy_Payment {
    public static void main(String[] args){
        Checkout co = new Checkout(new CardPay());
        co.process(50.0);
        co.setStrategy(new PaypalPay());
        co.process(99.0);
    }
}
