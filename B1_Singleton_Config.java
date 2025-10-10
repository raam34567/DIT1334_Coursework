package chapter2;

final class Config {
    private static volatile Config instance;
    private boolean darkMode = false;
    private Config(){}
    public static Config getInstance(){
        if(instance == null){
            synchronized(Config.class){
                if(instance == null){
                    instance = new Config();
                }
            }
        }
        return instance;
    }
    public boolean isDarkMode(){ return darkMode; }
    public void setDarkMode(boolean enabled){ this.darkMode = enabled; }
}
public class B1_Singleton_Config {
    public static void main(String[] args){
        Config a = Config.getInstance();
        a.setDarkMode(true);
        Config b = Config.getInstance();
        System.out.println("Same instance? " + (a==b));
        System.out.println("Dark mode from b: " + b.isDarkMode());
    }
}
