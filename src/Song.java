import com.mpatric.mp3agic.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Song extends Thread {

    private Thread t;
    private String title;
    private String artist;
    private String album;
    private String year;
    private String path;
    private Player playMp3;


    Song(String filePath) throws UnsupportedTagException, InvalidDataException, IOException, JavaLayerException {
        setup(filePath);
    }

    private void setup(String filePath) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        FileInputStream fis = new FileInputStream(filePath);
        playMp3 = new Player(fis);
        Mp3File mp3File = new Mp3File(filePath);
        path = filePath;
        if (mp3File.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3File.getId3v1Tag();
            title = id3v1Tag.getTitle();
            artist = id3v1Tag.getArtist();
            album = id3v1Tag.getAlbum();
            year = id3v1Tag.getYear();
        }

        if (mp3File.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            title = id3v2Tag.getTitle();
            artist = id3v2Tag.getArtist();
            album = id3v2Tag.getAlbum();
            year = id3v2Tag.getYear();
        }
    }

    String getTitle() {
        return title;
    }

    String getArtist() {
        return artist;
    }

    String getAlbum() {
        return album;
    }

    String getYear() {
        return year;
    }

    String getPath() {
        return path;
    }

    public void run() {
        try {
            playMp3.play();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void start() {
        System.out.println("Starting " + path);
        if (t == null) {
            t = new Thread(this, path);
            t.start();
        }
    }

    void stopPlaying() {
        playMp3.close();
        t.interrupt();
    }

}
