import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

        class Multiplayer {

        public static Scanner in = new Scanner(System.in);

        /**
         This method launches and plays the entire game, this is the most important class. It picks out a word and makes player guess the various letters
         in said word until the player either wins or loses!
         */

        public static void hangMan(String user1, String user2, String user3, String user4) throws Exception {
            //  //This array holds all currently selected and playing users
            String[] users = {user1, user2, user3, user4};

            boolean victory = false;
            int playersLife = 0;
            // Here is our full wordlist!
            String[] wordHolder = {"Björn", "Bill", "Java", "Edwin", "Julius", "Martin", "Johanna", "String", "Int", "Scanner", "ArrayList", "boolean", "Character", "Placeholder", "null",
                    "monster", "redbull", "Newton", "Switchbitch", "HANGMAN", "FUCKYOU", "Fury", "Class", "Static", "Void", "GeOssHögtBetygBill", "System", "Exception", "Mupphuvud"
                    , "JamesGosling", "Kaffe", "ForLoop", "While", "Index", "Double", "Minecraft", "Starcraft", "Warcraft", "Cantcrashthisgame", "Xbox", "Discord", "Git", "Github", "CleanDrink", "Corona",
                    "False", "True", "Stockholm", "CtrlAltDelete", "Syntax"};

            String guessWord = wordHolder[randomizer(wordHolder)].toLowerCase();
            ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
            ArrayList<Character> dumbGuesses = new ArrayList();
            Player userName = new Player();
            String[] splitUserName = user1.split(" ", 5);

            //This if/else-if case keeps track of if the game has 2, 3 or 4 players!
            ArrayList<Integer> randomNumber = new ArrayList<>();

            int amountOfPlayers;

            if (user3 == null) {
                playersLife = 20;
                System.out.println(Color.PURPLE + "Welcome " + /*userName.getInstanceVarUsername(splitUserName[0])*/ user1 + " and " + user2 + ", get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);

                randomNumber.add(0, 1);
                randomNumber.add(1, 2);
                amountOfPlayers = randomizerList(randomNumber);
                //turn(amountOfPlayers, user1, user2, user3, user4);

            } else if (user4 == null) {
                playersLife = 30;
                System.out.println(Color.PURPLE + "Welcome " + user1 + ", " + user2 + " and " + user3 + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);

                randomNumber.add(0, 1);
                randomNumber.add(1, 2);
                randomNumber.add(2, 3);
                amountOfPlayers = randomizerList(randomNumber);
                //turn(amountOfPlayers, user1, user2, user3, user4);
            } else {
                playersLife = 40;
                System.out.println(Color.PURPLE + "Welcome " + user1 + ", " + user2 + ", " + user3 + " and " + user4 + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);

                randomNumber.add(0, 1);
                randomNumber.add(1, 2);
                randomNumber.add(2, 3);
                randomNumber.add(3, 4);
                amountOfPlayers = randomizerList(randomNumber);

            }

            amountOfPlayers = turn(amountOfPlayers, user1, user2, user3, user4);

            boolean runMultiplayer = true;
            while (runMultiplayer) {
                for (int i = 0; i < guessWord.length(); i++) {
                    System.out.print("_");
                    allLetters.add(i, '_');
                }


                // ******************************************** Game Start! ************************************************


                // "Victory" and "playersLife" checks weather the player wins or looses throughout the game.
                while (victory == false && playersLife > 0) {
                    boolean guessCorrect = false;
                    boolean guessIncorrect = false;
                    boolean doubleGuess = true;
                    System.out.println();
                    String letter;
                    String trueLetter = null;

                    // doubleGuess ensures player does not guess same letter twice! You're welcome <3
                    while (doubleGuess) {
                        boolean destroyDumbCharacters = true;
                        while (destroyDumbCharacters) {
                            letter = in.nextLine().toLowerCase(); // to lower case kills you capitalized letters *evil laugh*
                            trueLetter = characterDestroyer(letter, allLetters);

                            if (trueLetter != null) {
                                destroyDumbCharacters = false;
                            }
                        }
                        if (dumbGuesses.contains(trueLetter.charAt(0)) || allLetters.contains(trueLetter.charAt(0))) {
                            System.out.println(Color.RED + "Letter has already been guessed!" + Color.RESET);
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

                    // this matches current turn with an index in the "users" array to keep track of which player should get a point

                    int currentPlayer = 0;

                    if (amountOfPlayers == 2 || amountOfPlayers == 3 || amountOfPlayers == 4) {
                        currentPlayer = amountOfPlayers - 2;
                    } else if (amountOfPlayers == 1) {
                        if (user3 == null) {
                            currentPlayer = 1;
                        } else if (user4 == null) {
                            currentPlayer = 2;
                        } else {
                            currentPlayer = 3;
                        }
                    }

                /* "guessCorrect" and "guessIncorrect" makes the game react to your choices as a player.
                incorrect guesses result in a loss of life, correct guesses reveals letter in arrayList!*/


                    if (guessCorrect) {
                        correctLetter(trueLetter, guessWord, allLetters, userName, user1);
                        if (allLetters.contains('_')) {
                        } else {

                            System.out.println(Color.GREEN + "\n\nCongratulations " + users[currentPlayer] + ". You get a point! :)" + Color.RESET);
                            guessWord = wordHolder[randomizer(wordHolder)].toLowerCase();
                            System.out.println(guessWord);
                            //Här ska den spelare som skrev ut ordet få ett poäng
                            // Här avslutade vi igår 4 november. Detta är morgondagens grupp furys problem, Fuckyou och jag ska leva lite. Inte mitt problem iallafall.
                            dumbGuesses.clear();

                        }
                    } else if (guessIncorrect) {
                        playersLife = playersLife - 1;
                        //hangManWriter(playersLife);
                        System.out.println(Color.RED + "Incorrect guess! Your collective life has gone down by 1!" + "\n(" + playersLife + " lives remaining)" + Color.RESET);
                        incorrectLetterCollector(trueLetter, dumbGuesses);
                        System.out.println();
                        for (int j = 0; j < allLetters.size(); j++) {
                            System.out.print(allLetters.get(j));
                        }
                        amountOfPlayers = turn(amountOfPlayers, user1, user2, user3, user4);

                    }

                    // You already know what "playersLife" does...
                    if (playersLife == 0) {
                        System.out.println();
                        //hangManWriter(playersLife);
                        System.out.print(Color.RED + "\nThe game is over! The last word was: " + guessWord + "\n\nThe winning player was PLACEHOLDER!\n\nPress enter to return to main menu" +  Color.RESET);
                        Player.matchAdderCaller();
                        Player.lossAdderCaller();
                        in.nextLine();
                        victory = true;
                        runMultiplayer = false;
                    }
                }
            }
        }


            public static int turn (int amountOfPlayers, String user1, String user2, String user3, String user4) {
            if (amountOfPlayers == 1){
                System.out.println("\nIt is " + user1 +"'s turn!");
                amountOfPlayers = 2;
                }

            else if (amountOfPlayers == 2){
                System.out.println("\nIt is " + user2 +"'s turn!");
                if (user3 == null){
                    amountOfPlayers = 1;
                }
                else {
                    amountOfPlayers = 3;
                }
            }

            else if (amountOfPlayers == 3){
                System.out.println("\nIt is " + user3 +"'s turn!");
                if (user4 == null){
                    amountOfPlayers = 1;
                }
                else {
                    amountOfPlayers = 4;
                }
            }

            else if (amountOfPlayers == 4){
                System.out.println("\nIt is " + user4 +"'s turn!");
                amountOfPlayers = 1;
            }
            return amountOfPlayers;
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
         This method randomizes which player starts first in a multiplayer game!
         */

        public static int randomizerList(ArrayList<Integer> randomNumber){
            Random rng = new Random();
            int rand = randomNumber.get(rng.nextInt(randomNumber.size()));
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
