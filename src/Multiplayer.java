import java.util.ArrayList;
import java.util.Scanner;

        class Multiplayer {

        public static Scanner in = new Scanner(System.in);

        /**
         This method launches and plays the entire game, this is the most important class. It picks out a word and makes player guess the various letters
         in said word until the player either wins or loses!
         */

        public static void hangMan(String user1, String user2, String user3, String user4) throws Exception {
            boolean victory = false;
            int playerLife = 10;
            // Here is our full wordlist!
            String [] wordHolder = {"Björn","Bill","Java","Edwin","Julius","Martin","Johanna","String","Int","Scanner","ArrayList","boolean","Character","Placeholder","null",
                    "monster","redbull","Newton","Switchbitch","HANGMAN","FUCKYOU","Fury","Class","Static","Void","GeOssHögtBetygBill","System","Exception","Mupphuvud"
                    ,"JamesGosling","Kaffe","ForLoop","While","Index","Double","Minecraft","Starcraft","Warcraft","Cantcrashthisgame","Xbox","Discord","Git","Github","CleanDrink","Corona",
                    "False","True","Stockholm","CtrlAltDelete","Syntax"};

            String guessWord = wordHolder[randomizer(wordHolder)].toLowerCase();
            ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
            ArrayList<Character> dumbGuesses = new ArrayList();
            Player userName = new Player();
            String [] splitUserName = user1.split(" ", 5);


            //This if/else-if case keeps track of if the game has 2, 3 or 4 players!

            if (user3 == null) {
                System.out.println(Color.PURPLE + "Welcome " + /*userName.getInstanceVarUsername(splitUserName[0])*/ user1 + " and " + user2 + ", get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
            }
            else if (user4 == null){
                System.out.println(Color.PURPLE + "Welcome " + user1 + ", " + user2 + " and " + user3 + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
            }
            else{
                System.out.println(Color.PURPLE + "Welcome " + user1 + ", " + user2 + ", " + user3 + " and " + user4 + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
            }


            for (int i = 0; i < guessWord.length(); i++) {
                System.out.print("_");

                allLetters.add(i,  '_');
            }

            // "Victory" and "playerLife" checks weather the player wins or looses throughout the game.
            while (victory == false && playerLife > 0) {
                boolean guessCorrect = false;
                boolean guessIncorrect = false;
                boolean doubleGuess = true;
                System.out.println();
                String letter = null;
                String trueLetter = null;

                // doubleGuess ensures player does not guess same letter twice! You're welcome <3
                while(doubleGuess) {
                    boolean destroyDumbCharacters = true;
                    while (destroyDumbCharacters) {
                        letter = in.nextLine().toLowerCase(); // to lower case kills you capitalized letters *evil laugh*
                        trueLetter = characterDestroyer(letter, allLetters);

                        if (trueLetter != null) {
                            destroyDumbCharacters = false;
                        }
                    }
                    if (dumbGuesses.contains(trueLetter.charAt(0)) || allLetters.contains(trueLetter.charAt(0))) {
                        System.out.println(Color.RED + "Letter has already been guessed!"+ Color.RESET);
                        for (int j = 0; j < allLetters.size(); j++) {
                            System.out.print(allLetters.get(j));
                        }

                    } else {
                        doubleGuess = false;
                    }
                }
                for (int i = 0; i < guessWord.length(); i++) {
                    if (trueLetter.charAt(0) == guessWord.charAt(i)) {
                        guessCorrect = true;
                    } else if (trueLetter.charAt(0) != guessWord.charAt(i)) {
                        guessIncorrect = true;
                    }
                }

                /* "guessCorrect" and "guessIncorrect" makes the game react to your choices as a player.
                    incorrect guesses result in a loss of life, correct guesses reveals letter in arrayList!*/

                if (guessCorrect) {
                    correctLetter(trueLetter, guessWord, allLetters, userName, user1);
                    if (allLetters.contains('_')) {
                    } else {
                        System.out.println(Color.GREEN + "\n\nCongratulations " + userName.getInstanceVarUsername(splitUserName[0]) + ". You are victorious! :)" + Color.RESET + "\n (Press Enter to return to main menu)");
                        Player.matchAdderCaller();
                        Player.winAdderCaller();
                        if (playerLife == 10){
                            Player.flawlessAdderCaller();
                            System.out.println(Color.YELLOW + "\nNO LIVES LOST! FLAWLESS VICTORY ARCHIVED!!!!!!\n" + userName.getInstanceVarUsername(splitUserName[0]) + " is a legend!" + Color.RESET);
                        }
                        in.nextLine();
                        victory = true;
                    }
                } else if (guessIncorrect) {
                    playerLife = playerLife - 1;
                    hangManWriter(playerLife);
                    System.out.println(Color.RED + "Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)" + Color.RESET);
                    incorrectLetterCollector(trueLetter, dumbGuesses);
                    System.out.println();
                    for (int j = 0; j < allLetters.size(); j++) {
                        System.out.print(allLetters.get(j));
                    }

                }
                // You already know what "playerLife" does...
                if (playerLife == 0) {
                    System.out.println();
                    hangManWriter(playerLife);
                    System.out.print(Color.RED + "\nYou have been defeated! The word in question was: " + guessWord + "\n\nPress the Enter key to return to the main menu in shame" + Color.RESET);
                    Player.matchAdderCaller();
                    Player.lossAdderCaller();
                    in.nextLine();
                    victory = true;
                }
            }
        }

        /**
         Randomizer uses a Math-random function to pick out a word from our "wordlist" at the top of "hangMan" method.
         It's also used to randomize colors for our "hangMan-graph"!
         */
        public static int randomizer(String [] randomArray){
            int rand = (int) (Math.random()*randomArray.length);
            return rand;
        }

        /**
         Checks if inputted letter is correct.
         */
        public static void correctLetter(String trueLetter, String placeholder, ArrayList<Character> allLetters, Player userName, String user) throws Exception {
            char guess = trueLetter.charAt(0);

            if (Character.isDigit(guess)) {
                System.out.println(Color.RED + "Wrongful input!"+ Color.RESET +  "\nPlease enter a CHARACTER!");
            }

            for (int i = 0; i < placeholder.length(); i++) {
                if (guess == placeholder.charAt(i)) {
                    allLetters.set(i, guess);
                }
            }
            for (int j = 0; j < allLetters.size(); j++) {
                System.out.print(allLetters.get(j));
            }

        }

        /**
         Method collects all user inputted letters that were incorrect guesses! These letters are later printed out
         to remind user what he or she previously guessed as to not make same mistake twice.
         */
        public static ArrayList<Character> incorrectLetterCollector(String trueLetter, ArrayList<Character> dumbGuesses) {
            dumbGuesses.add(trueLetter.charAt(0));
            System.out.println(Color.CYAN + "\nPreviously guessed letters: " + Color.RESET);
            for (int i = 0; i < dumbGuesses.size(); i++) {
                System.out.print(Color.RED + dumbGuesses.get(i) + " " + Color.RESET);
            }
            return dumbGuesses;
        }

        /**
         Method randomly changes color of "hangMan-graphic" as to make it stand out from text... and because this way it is less boring!p
         */
        public static void hangManWriter (int playerLife) {

            String [] wordHolder = {Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE,Color.PURPLE,Color.CYAN};

            String[] hangManIllus = {"   +--+\n   |  |\n   \uD83D\uDC80 |\n  /|\\ |\n  / \\ |\n      |\n ======\n",
                    "   +--+\n   |  |\n   0  |\n  /|\\ |\n  /   |\n      |\n ======\n",
                    "   +--+\n   |  |\n   0  |\n  /|\\ |\n      |\n      |\n ======\n",
                    "   +--+\n   |  |\n   0  |\n  /|  |\n      |\n      |\n ======\n",
                    "   +--+\n   |  |\n   0  |\n   |  |\n      |\n      |\n ======\n",
                    "   +--+\n   |  |\n   0  |\n      |\n      |\n      |\n ======\n",
                    "   +--+\n   |  |\n      |\n      |\n      |\n      |\n ======\n",
                    "   +--+\n      |\n      |\n      |\n      |\n      |\n ======\n",
                    "      +\n      |\n      |\n      |\n      |\n      |\n ======\n",
                    "       \n       \n       \n       \n       \n       \n ======\n",""};

            for (int i = playerLife; i == playerLife; i++) {
                System.out.println(wordHolder[randomizer(wordHolder)] + hangManIllus[i] + Color.RESET);
            }


        }

        /**
         This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
         */

        public static String characterDestroyer(String letter,ArrayList<Character>allLetters) {
            if (!letter.isEmpty()) {
                if (letter.contains("1")) {
                    System.out.println(Color.RED + "You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("2")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("3")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("4")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("5")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("6")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("7")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("8")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("9")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("0")) {
                    System.out.println(Color.RED +"You may not guess numbers!" + Color.RESET);
                } else if (letter.contains("!")) {
                    System.out.println(Color.RED +"You may not guess an exclamation point!" + Color.RESET);
                } else if (letter.contains("?")) {
                    System.out.println(Color.RED +"You may not guess a question mark!" + Color.RESET);
                } else if (letter.contains("#")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("¤")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("%")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("&")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("/")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("(")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains(")")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("=")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("*")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("-")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("+")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains(",")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains(".")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("<")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains(">")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("|")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("@")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("£")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("$")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("€")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("{")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("[")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("]")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("}")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("´´")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("\"")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains("\\")) {
                    System.out.println(Color.RED +"You may not guess a non-alphabetical character!" + Color.RESET);
                } else if (letter.contains(" ")) {
                    System.out.println(Color.RED +"No whitespace!" + Color.RESET);
                } else if (letter.isEmpty()) {
                    System.out.println(Color.RED +"No input was given!" + Color.RESET);
                } else if (letter.contains("æ")) {
                    System.out.println(Color.RED +"Inga danskjävlar i spelet!" + Color.RESET);
                    System.exit(0);
                } else if (letter.contains("ø")) {
                    System.out.println(Color.RED +"Inga danskjävlar i spelet!" + Color.RESET);
                    System.exit(0);
                } else {
                    return letter;
                }
                for (int j = 0; j < allLetters.size(); j++) {
                    System.out.print(allLetters.get(j));
                }

            }
            return null;
        }
    }
