package chapter2;

interface MediaPlayer { void play(String path); }
class LegacyPlayer { void playFile(java.io.File f){ System.out.println("Legacy playing " + f.getName()); } }
class PlayerAdapter implements MediaPlayer {
    private final LegacyPlayer legacy = new LegacyPlayer();
    public void play(String path){ legacy.playFile(new java.io.File(path)); }
}
public class C1_Adapter_Media {
    public static void main(String[] args){
        MediaPlayer p = new PlayerAdapter();
        p.play("song.mp3");
    }
}
