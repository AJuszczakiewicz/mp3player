
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    private static int playingIndex = -1;

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
            checkSelectedOption(userInput, songsList);
        }
        System.exit(0);
    }


    private static void displayMainContent(List<Song> songsList) {
        displayWelcomeMessage();
        displayList(songsList);
        displayControls();
    }

    private static void checkSelectedOption(String input, List<Song> songsList) {
        switch (input) {
            case "s":
                stopPlaying(songsList);
                break;
            case "n":
                playNext(songsList);
                break;
            case "d":
                showDetailedList();
                break;
            default:
                if (playingIndex >=0){
                    songsList.get(playingIndex).stopPlaying();
                }
                playingIndex = abs(parseNumberFrom(input, songsList.size())) - 1;
                System.out.println("playing " + playingIndex);
                playSong(songsList);
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
        System.out.println("s    - stop song");
        System.out.println("n    - play next song");
        System.out.println("q    - quit program");
    }

    private static void checkIfNowPlaying(List<Song> songsList) {
        if (playingIndex != -1) {
            System.out.println("NOW PLAYING: "
                    + (playingIndex + 1) + ". "
                    + songsList.get(playingIndex).getArtist() + " "
                    + songsList.get(playingIndex).getTitle());
        }
    }

    private static void displayList(List<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(i + 1 + ". " + songs.get(i).getArtist() + " " + songs.get(i).getTitle());
        }
    }

    private static void stopPlaying(List<Song> songsList) {
        if (playingIndex >= 0) {
            songsList.get(playingIndex).stopPlaying();
            playingIndex = -1;
        }
    }

    private static void playSong(List<Song> songsList) {
        songsList.get(playingIndex).start();
    }

    private static void playNext(List<Song> songsList) {
        if (playingIndex >= 0) {
            songsList.get(playingIndex).stopPlaying();
        }
        if (playingIndex < songsList.size() - 1) {
            songsList.get(++playingIndex).start();
        } else if (playingIndex == songsList.size()) {
            playingIndex = 0;
            songsList.get(playingIndex).start();
        }
    }

    private static void showDetailedList() {
    }

}
