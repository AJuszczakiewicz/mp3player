import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Playlist {

    private final File folder;

    Playlist(String folder) {
        this.folder = new File(folder);
    }

    List<Song> createList() {
        List<String> songsPaths = listFilesForFolder(folder);
        List<Song> songs = new ArrayList<>();
        for (String file : songsPaths) {
            try {
                songs.add(new Song(file));
            } catch (Exception e) {
                System.out.println("Could not read file path: " + file);
            }
        }
        return songs;
    }

    private List<String> listFilesForFolder(File directory) {
        List<String> files = new ArrayList<>();
        for (final File fileEntry : directory.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getAbsolutePath());
            }
        }
        return files;
    }

}

