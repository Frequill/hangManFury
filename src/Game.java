import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Game {
    public static void hangMan(String user) {
        boolean victory = false;
        int playerLife = 10;
        String [] wordHolder = {"Björn","Bill","Java","Edwin","Julius","Martin","Johanna","String","Int","Scanner","ArrayList","boolean","Character","Placeholder","null",
                "monster","redbull","Newton","Katarina"};

        String guessWord = wordHolder[wordGenerator(wordHolder)].toLowerCase();
        ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
        Scanner in = new Scanner(System.in);
        ArrayList<Character> dumbGuesses = new ArrayList();
        Player userName = new Player();

        System.out.println("Welcome " + userName.getInstanceVarUsername(user) + " guess the word that is  " + guessWord.length() + " letters long!");

        for (int i = 0; i < guessWord.length(); i++) {
            System.out.print("_");
            allLetters.add(i, '_');
        }

        while (victory == false && playerLife > 0) {
            boolean guessCorrect = false;
            boolean guessIncorrect = false;
            boolean doubleGuess = true;
            System.out.println();
            String letter = null;
            String trueLetter = null;

            while(doubleGuess) {
                boolean destroyDumbCharacters = true;
                while (destroyDumbCharacters) {
                    letter = in.nextLine().toLowerCase(); // to lower case kills you capitalized letters *evil laugh*
                    trueLetter = characterDestroyer(letter);
                    if (trueLetter != null) {
                        destroyDumbCharacters = false;
                    }
                    if (dumbGuesses.contains(trueLetter.charAt(0)) || allLetters.contains(trueLetter.charAt(0))) {
                        System.out.println("Letter has already been guessed ??? What are you doing????");
                    }  if (trueLetter != null) {
                        destroyDumbCharacters = false;
                    }else {
                        doubleGuess = false;
                    }
                }
            }



                for (int i = 0; i < guessWord.length(); i++) {
                    if (trueLetter.charAt(0) == guessWord.charAt(i)) {
                        guessCorrect = true;
                    } else if (trueLetter.charAt(0) != guessWord.charAt(i)) {
                        guessIncorrect = true;
                    } else {
                        System.out.println("BLÖ");
                    }

            }

            if (guessCorrect) {
                correctLetter(trueLetter, guessWord, allLetters, userName, user);
            } else if (guessIncorrect) {
                playerLife = playerLife - 1;
                System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
                incorrectLetterCollector(trueLetter, dumbGuesses);
            }
            if (playerLife == 0) {
                System.out.print("\nYou have been defeated! (Scrub)");
            }
        }
    }
    public static int wordGenerator(String [] wordHolder){
        int rand = (int) (Math.random()*wordHolder.length);
        return rand;
    }

    public static void correctLetter(String trueLetter, String placeholder, ArrayList<Character> allLetters, Player userName, String user) {
        char guess = trueLetter.charAt(0);
        if (Character.isDigit(guess)) {
            System.out.println("Wrongful input!\nPlease enter a CHARACTER!");
        }

        for (int i = 0; i < placeholder.length(); i++) {
            if (guess == placeholder.charAt(i)) {
                allLetters.set(i, guess);
                //System.out.print(allLetters.get(i));
                //jaG
            }
        }
        for (int j = 0; j < allLetters.size(); j++) {
            System.out.print(allLetters.get(j));
        }
        if (allLetters.contains('_')) {

        } else {
            System.out.println("\n\nCongratulations " + userName.getInstanceVarUsername(user) + ". You are victorious! :)");
           System.exit(0);
        }
    }

    public static ArrayList<Character> incorrectLetterCollector(String trueLetter, ArrayList<Character> dumbGuesses) {

        dumbGuesses.add(trueLetter.charAt(0));
        System.out.println("\nPreviously guessed letters: ");
        for (int i = 0; i < dumbGuesses.size(); i++) {
            System.out.print(dumbGuesses.get(i) + " ");
        }
        return dumbGuesses;
    }

    public static char doubleGuessCollector (String trueLetter, ArrayList<Character> dumbGuesses,ArrayList<Character> allLetters){
        if (dumbGuesses.contains(trueLetter.charAt(0)) || allLetters.contains(trueLetter.charAt(0))){
            System.out.println("Letter has already been guessed ??? What are you doing????");
        }
        return  trueLetter.charAt(0);
    }

    /** This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
     */

    public static String characterDestroyer(String letter) {

            if (letter.contains("1")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("2")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("3")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("4")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("5")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("6")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("7")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("8")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("9")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("0")) {
                System.out.println("You may not guess numbers!");
            } else if (letter.contains("!")) {
                System.out.println("You may not guess an exclamation point!");
            } else if (letter.contains("?")) {
                System.out.println("You may not guess a question mark!");
            } else if (letter.contains("#")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("¤")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("%")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("&")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("/")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("(")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains(")")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("=")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("*")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("-")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("+")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains(",")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains(".")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("<")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains(">")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("|")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("@")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("£")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("$")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("€")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("{")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("[")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("]")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("}")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("´´")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("\"")) {
                System.out.println("You may not guess a non-alphabetical character!");
            } else if (letter.contains("\\")) {
                System.out.println("You may not guess a non-alphabetical character!");
            }else if (letter.contains(" ")) {
                System.out.println("No whitespace!");
            }else if (letter.isEmpty()) {
                System.out.println("No input was given!");
            }else if (letter.contains("æ")) {
                System.out.println("Inga danskjävlar i spelet!");
                System.exit(0);
            } else if (letter.contains("ø")) {
                System.out.println("Inga danskjävlar i spelet!");
                System.exit(0);
            } else {
                return letter;
            }
        return null;
    }
}



