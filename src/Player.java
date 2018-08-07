
import java.util.List;
import java.util.Scanner;

public class Player {

    private static int playingIndex = 0;

    public static void main(String[] args) {

        Playlist playlist = new Playlist("./playlist");
        Scanner scanner = new Scanner(System.in);
        List<Song> songsList = playlist.createList();
        String userInput = "";

        while (!userInput.equals("q")) {
            displayMainContent(songsList);
            checkIfNowPlaying(songsList);
            System.out.println("\nEnter your option: ");
            userInput = scanner.nextLine();
            checkSelectedOption(userInput, songsList.size());
        }
    }


    private static void displayMainContent(List<Song> songsList) {
        displayWelcomeMessage();
        displayList(songsList);
        displayControls();
    }

    private static void checkSelectedOption(String input, int listSize) {
        switch (input) {
            case "p":
                System.out.println("option p");
                pauseSong(playingIndex);
                break;
            case "s":
                System.out.println("option s");
                stopPlaying(playingIndex);
                break;
            case "n":
                System.out.println("option n");
                playNext(playingIndex);
                break;
            case "d":
                System.out.println("option d");
                showDetailedList();
                break;
            default:
                playingIndex = parseNumberFrom(input, listSize);
                if (playingIndex != 0) {
                    System.out.println("playing " + playingIndex);
                    playSong(playingIndex);
                }
                break;
        }
    }

    private static int parseNumberFrom(String input, int listSize) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0 && number <= listSize) {
                return number;
            } else {
                return 0;
            }
        } catch (Exception NumberFormatException) {
            return 0;
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("Hello User! \n\nWelcome to this amazing edge cutting song player!");
        System.out.println("Here is a list of songs you put into playlist catalog:\n");
    }

    private static void displayControls() {
        System.out.println("\nPlease enter one of the options below to enchant your experience:");
        System.out.println("sort - display sorting options");
        System.out.println("<number> - play song");
        System.out.println("d    - change to detailed list");
        System.out.println("p    - pause song");
        System.out.println("s    - stop song");
        System.out.println("n    - play next song");
        System.out.println("q    - quit program");
    }

    private static void checkIfNowPlaying(List<Song> songsList) {
        if (playingIndex != 0) {
            System.out.println("NOW PLAYING: "
                    + playingIndex + ". "
                    + songsList.get(playingIndex-1).getArtist() + " "
                    + songsList.get(playingIndex-1).getTitle());
        }
    }

    private static void displayList(List<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(i + 1 + ". " + songs.get(i).getArtist() + " " + songs.get(i).getTitle());
        }
    }

    private static void stopPlaying(int song) {
//        if (song>0) {
//          songsList.get(song-1).stop();
//        }
    }

    private static void pauseSong(int song) {
//        if (song>0) {
//            songsList.get(song-1).pause();
//        }
    }

    private static void playSong(int song) {
//        if (song>0) {
//            songsList.get(song-1).play();
//        }
    }

    private static void playNext(int song) {
//        if (song>0) {
//            songsList.get(song-1).stop();
//        }
//        songsList.get(song).play();
    }

    private static void showDetailedList() {
    }
}
