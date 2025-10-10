package chapter2;

import java.util.*;
interface Observer { void update(String msg); }
interface Subject { void attach(Observer o); void detach(Observer o); void notifyAllObs(String msg); }
class News implements Subject {
    private final List<Observer> obs = new ArrayList<>();
    public void attach(Observer o){ obs.add(o); }
    public void detach(Observer o){ obs.remove(o); }
    public void notifyAllObs(String msg){ for(Observer o: obs) o.update(msg); }
    void publish(String msg){ notifyAllObs(msg); }
}
class Subscriber implements Observer { private final String name; Subscriber(String n){ name=n; } public void update(String msg){ System.out.println(name + " received: " + msg); } }
public class D1_Observer_News {
    public static void main(String[] args){
        News n = new News();
        n.attach(new Subscriber("Ali"));
        n.attach(new Subscriber("Siti"));
        n.publish("Chapter 2 released");
        n.publish("Quiz next week");
    }
}
