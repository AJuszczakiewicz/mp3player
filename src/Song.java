import com.mpatric.mp3agic.*;

import java.io.IOException;

public class Song {

    private String title;
    private String artist;
    private String album;
    private String year;

    Song(String filePath) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
        Mp3File mp3File = new Mp3File(filePath);
        if (mp3File.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3File.getId3v1Tag();
            title = id3v1Tag.getTitle();
            artist = id3v1Tag.getArtist();
            album = id3v1Tag.getAlbum();
            year = id3v1Tag.getYear();
        }

        if (mp3File.hasId3v2Tag()){
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            title = id3v2Tag.getTitle();
            artist = id3v2Tag.getArtist();
            album = id3v2Tag.getAlbum();
            year = id3v2Tag.getYear();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getAlbum(){
        return album;
    }

    public String getYear(){
        return year;
    }




}
