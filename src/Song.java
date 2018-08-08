import com.mpatric.mp3agic.*;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

class Song {

    private String title;
    private String artist;
    private String album;
    private String year;
    private String path;

    Song(String filePath) throws UnsupportedTagException, InvalidDataException, IOException {
            Mp3File mp3File = new Mp3File(filePath);
            if (mp3File.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3File.getId3v1Tag();
                this.title = id3v1Tag.getTitle();
                this.artist = id3v1Tag.getArtist();
                this.album = id3v1Tag.getAlbum();
                this.year = id3v1Tag.getYear();
                this.path = filePath;
            }

            if (mp3File.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                this.title = id3v2Tag.getTitle();
                this.artist = id3v2Tag.getArtist();
                this.album = id3v2Tag.getAlbum();
                this.year = id3v2Tag.getYear();
                this.path = filePath;
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

    public void play(){
        try {

            FileInputStream fis = new FileInputStream(this.path);
            Player playMp3 = new Player(fis);

            playMp3.play();

        } catch(Exception e) {
            System.out.println(e);
        }

    }

}
