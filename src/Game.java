import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static void hangMan() {

        boolean victory = false;
        int playerLife = 10;
        String placeholder = "Newton".toLowerCase();
        ArrayList<Character> allLetters = new ArrayList<>(placeholder.length());
        Scanner in = new Scanner(System.in);
        Player userName = new Player();
        System.out.println("Welcome " +userName.userToGame() + " guess the word that is  " + placeholder.length() + " letters long!");


        for (int i = 0; i < placeholder.length(); i++) {
            System.out.print("_");
            allLetters.add(i, '_');
        }

        while (victory == false && playerLife > 0) {
            boolean guessCorrect = false;
            boolean guessIncorrect = false;

            String letter = in.next().toLowerCase();

            for (int i = 0; i < placeholder.length(); i++) {
                if (letter.charAt(0) == placeholder.charAt(i)) {
                    guessCorrect = true;
                } else if (letter.charAt(0) != placeholder.charAt(i)) {
                    guessIncorrect = true;
                } else {
                    System.out.println("BLÖ");
                }
            }

            if (guessCorrect) {
                correctLetter(letter, placeholder, allLetters);
            } else if (guessIncorrect) {
                playerLife = playerLife - 1;
                System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
            }
            if (playerLife == 0){
                System.out.println("\nYou have been defeated! (Scrub)");
            }
        }
    }

    public static void correctLetter(String letter, String placeholder, ArrayList<Character> allLetters) {
        char guess = letter.charAt(0);

        for (int i = 0; i < placeholder.length(); i++) {
            if (guess == placeholder.charAt(i)) {
                allLetters.set(i, guess);
                //System.out.print(allLetters.get(i));
            }
        }
        for (int j = 0; j < allLetters.size(); j++) {
            System.out.print(allLetters.get(j));
        }
        if(allLetters.contains('_')){

        }
        else{
            System.out.println("\n\nVictory! :)");
            System.exit(0);
        }
    }
}

