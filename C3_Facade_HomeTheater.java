package chapter2;

class Amplifier{ void on(){ System.out.println("Amp on"); } }
class Tuner{ void setStation(double s){ System.out.println("Tuned " + s); } }
class DVD{ void play(String m){ System.out.println("Play " + m); } }
class HomeTheaterFacade {
    private final Amplifier amp=new Amplifier();
    private final Tuner tuner=new Tuner();
    private final DVD dvd=new DVD();
    void watchMovie(String movie){ amp.on(); tuner.setStation(101.1); dvd.play(movie); }
}
public class C3_Facade_HomeTheater {
    public static void main(String[] args){
        new HomeTheaterFacade().watchMovie("Inception");
    }
}
