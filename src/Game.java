import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

 class Game {
     public static void hangMan(String user) {


         boolean victory = false;
         int playerLife = 10;
         String placeholder = "Newton".toLowerCase();
         ArrayList<Character> allLetters = new ArrayList<>(placeholder.length());
         Scanner in = new Scanner(System.in);
         ArrayList<String> dumbGuesses = new ArrayList();
         Player userName = new Player();

         System.out.println("Welcome " + userName.getInstanceVarUsername(user) + " guess the word that is  " + placeholder.length() + " letters long!");


         for (int i = 0; i < placeholder.length(); i++) {
             System.out.print("_");
             allLetters.add(i, '_');
         }

         while (victory == false && playerLife > 0) {
             boolean guessCorrect = false;
             boolean guessIncorrect = false;
             System.out.println();                                                      //JAG TROR ATT MARTIN KAN LÖSA DETTA...
             String letter = null;                                                      //FIXA SÅ ATT DET BLIR EN charAt() fucking grej usch vad jag blir sur att det inte funkaaaar..........
             String trueLetter = null;

             boolean destroyDumbCharacters = true;
             while (destroyDumbCharacters) {
             letter = in.nextLine().toLowerCase(); // to lower case kills you capitalized letters *evil laugh*
                 trueLetter = characterDestroyer(letter);
                 if (trueLetter != null){
                     destroyDumbCharacters = false;
                 }
             }
             for (int i = 0; i < placeholder.length(); i++) {
                 if (trueLetter.charAt(0) == placeholder.charAt(i)) {
                     guessCorrect = true;
                 } else if (trueLetter.charAt(0) != placeholder.charAt(i)) {
                     guessIncorrect = true;
                 } else {
                     System.out.println("BLÖ");
                 }
             }

             if (guessCorrect) {
                 correctLetter(letter, placeholder, allLetters, userName, user);
             } else if (guessIncorrect) {
                 playerLife = playerLife - 1;
                 System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
                 incorrectLetterCollector(letter, dumbGuesses);
             }
             if (playerLife == 0) {
                 System.out.print("\nYou have been defeated! (Scrub)");
             }
         }
     }

     public static void correctLetter(String letter, String placeholder, ArrayList<Character> allLetters, Player userName, String user) {
         char guess = letter.charAt(0);
         if (Character.isDigit(guess)) {
             System.out.println("Wrongful input!\nPlease enter a CHARACTER!");
         }

         for (int i = 0; i < placeholder.length(); i++) {
             if (guess == placeholder.charAt(i)) {
                 allLetters.set(i, guess);
                 //System.out.print(allLetters.get(i));
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

     public static ArrayList<String> incorrectLetterCollector(String letter, ArrayList<String> dumbGuesses) {

         dumbGuesses.add(letter);
         System.out.println("\nPreviously guessed letters: ");
         for (int i = 0; i < dumbGuesses.size(); i++) {
             System.out.print(dumbGuesses.get(i) + " ");
         }
         return dumbGuesses;
     }

     /** This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
      */
§\\
     public static String characterDestroyer(String letter) {
             if (letter.contains("1", "2"-)) {
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
             }

             else {
                 return letter;
             }
         return null;
         }
     }



