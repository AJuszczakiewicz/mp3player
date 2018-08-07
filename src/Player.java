
import java.util.Scanner;

public class Player {

    //will be replaced with songsList getting from List.createList()
    private  static String[] songsList = {"song1", "song2", "song3"};
    private static int playingIndex=0;
    //        List songsList = new List();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while(!userInput.equals("q")){
            displayMainContent(songsList);
            System.out.println("\nEnter your option: ");
            userInput = scanner.nextLine();
            checkSelectedOption(userInput);
        }
    }


    private static void displayMainContent(String [] list) {
        displayWelcomeMessage();
        displayList(list);
        displayControls();
    }


    private static void checkSelectedOption(String input){
        if (input.equals("p")) {
            System.out.println("option p");
            pauseSong(playingIndex);
        } else if (input.equals("s")) {
            System.out.println("option s");
            stopPlaying(playingIndex);
        } else if (input.equals("n")) {
            System.out.println("option n");
            playNext(playingIndex);
        } else if (input.equals("d")) {
            System.out.println("option d");
            showDetailedList();
        } else {
            playingIndex =  parseNumberFrom(input);
            if (playingIndex != 0){
                System.out.println("playing " + playingIndex);
                playSong(playingIndex);
            }
        }
    }


    private static int parseNumberFrom(String input) {
        try {
            return Integer.parseInt(input);
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
//        System.out.println("n    - play next song");
        System.out.println("q    - quit program");
    }


    private static void displayList(String[] songs) {
        for (int i=0; i<songs.length; i++) {
            System.out.println(i+1 + ". " + songs[i]);
        }
    }


    private static void stopPlaying(int song) {
//        if (song>0) {
//          songsList[song-1].stop();
//        }
    }


    private static void pauseSong(int song) {
//        if (song>0) {
//            songsList[song-1].pause();
//        }

    }


    private static void playSong(int song) {
//        if (song>0) {
//            songsList[song-1].play();
//        }
    }


    private static void playNext(int song) {
//        if (song>0) {
//            songsList[song-1].stop();
//        }
//        songsList[song].play();
    }


    private static void showDetailedList() {
    }
}
