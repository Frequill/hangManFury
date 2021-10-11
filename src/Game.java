import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void hangMan(String user) {


        boolean victory = false;
        int playerLife = 10;
        String placeholder = "Newton".toLowerCase();
        ArrayList<Character> allLetters = new ArrayList<>(placeholder.length());
        Scanner in = new Scanner(System.in);
        ArrayList<Character> dumbGuesses = new ArrayList();
        Player userName = new Player();

        System.out.println("Welcome " + userName.getInstanceVarUsername(user) + " guess the word that is  " + placeholder.length() + " letters long!");


        for (int i = 0; i < placeholder.length(); i++) {
            System.out.print("_");
            allLetters.add(i, '_');
        }

        while (victory == false && playerLife > 0) {
            try {
                boolean guessCorrect = false;
                boolean guessIncorrect = false;
                String letter = getInput(in.next());
                //String letter = in.next().toLowerCase();


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
                    correctLetter(letter, placeholder, allLetters, userName, user);
                    System.out.println("\n\nPreviously guessed incorrect letters: ");
                    for (int i = 0; i < dumbGuesses.size(); i++) {
                        System.out.print(dumbGuesses.get(i) + " ");
                    }
                } else if (guessIncorrect) {
                    playerLife = playerLife - 1;
                    System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
                    incorrectLetterCollector(letter, dumbGuesses);
                }
                if (playerLife == 0) {
                    System.out.print("\nYou have been defeated! (Scrub)");
                }
            }
            catch (Exception E) {
                System.out.println("Please enter a letter! ");
            }
        }
    }

    public static void correctLetter(String letter, String placeholder, ArrayList<Character> allLetters ,Player userName, String user) {
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
            System.out.println("\n\nCongratulations "+userName.getInstanceVarUsername(user) +". You are victorious! :)");
            System.exit(0);
        }
    }
    public static ArrayList<Character> incorrectLetterCollector(String letter, ArrayList<Character> dumbGuesses){
        char charLetter = letter.charAt(0);
        dumbGuesses.add(charLetter);
        System.out.println("\nPreviously guessed incorrect letters: ");
        for(int i = 0; i < dumbGuesses.size(); i++){
            System.out.print(dumbGuesses.get(i) +" ");
        }
        return dumbGuesses;
    }

    public static String getInput(String playerInput) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        while(run){
            if(!scan.hasNextLine()) {
                System.out.println("NOOOO try again!!!!!!");
                scan.next(); }
        else {
            playerInput = scan.nextLine();
            run = false;
        }
        }
    return playerInput;
    }
}

