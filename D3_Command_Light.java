package chapter2;

import java.util.*;
interface Command { void execute(); void undo(); }
class Light { private boolean on=false; void on(){ on=true; System.out.println("Light on"); } void off(){ on=false; System.out.println("Light off"); } boolean isOn(){ return on; } }
class LightOn implements Command { private final Light l; LightOn(Light l){ this.l=l; } public void execute(){ l.on(); } public void undo(){ l.off(); } }
class LightOff implements Command { private final Light l; LightOff(Light l){ this.l=l; } public void execute(){ l.off(); } public void undo(){ l.on(); } }
class Invoker {
    java.util.Deque<Command> history = new java.util.ArrayDeque<>();
    void run(Command c){ c.execute(); history.push(c); }
    void undo(){ if(!history.isEmpty()) history.pop().undo(); }
}
public class D3_Command_Light {
    public static void main(String[] args){
        Light light = new Light();
        Invoker inv = new Invoker();
        inv.run(new LightOn(light));
        inv.run(new LightOff(light));
        inv.undo(); // should turn light on
    }
}
