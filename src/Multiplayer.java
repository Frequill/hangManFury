import java.io.IOException;
import java.util.*;

class Multiplayer{

        public static Scanner in = new Scanner(System.in);

        /**
         This method launches and plays the entire game, this is the most important class. It picks out a word and makes player guess the various letters
         in said word until the player either wins or loses!
         */

        public static void hangMan(String user1, String user2, String user3, String user4) throws Exception {
            //  //This array holds all currently selected and playing users
            String[] users = {user1, user2, user3, user4};


            //  **********************  This ArrayList keeps track of users SCORE during the game **********************
            ArrayList<Integer> usersPoints = new ArrayList<>();
            if (user3 == null){
                usersPoints.add(0, 0);
                usersPoints.add(1, 0);
            }else if (user4 == null){
                usersPoints.add(0, 0);
                usersPoints.add(1, 0);
                usersPoints.add(2, 0);
            }else{
                usersPoints.add(0, 0);
                usersPoints.add(1, 0);
                usersPoints.add(2, 0);
                usersPoints.add(3, 0);
            }
            // *********************************************************************************************************


            boolean victory = false;
            int playersLife = 0;
            // Here is our full wordlist!
            String[] wordHolder = {"Björn", /* "Bill", "Java", "Edwin", "Julius", "Martin", "Johanna", "String", "Int", "Scanner", "ArrayList", "boolean", "Character", "Placeholder", "null",
                    "monster", "redbull", "Newton", "Switchbitch", "HANGMAN", "FUCKYOU", "Fury", "Class", "Static", "Void", "GeOssHögtBetygBill", "System", "Exception", "Mupphuvud"
                    , "JamesGosling", "Kaffe", "ForLoop", "While", "Index", "Double", "Minecraft", "Starcraft", "Warcraft", "Cantcrashthisgame", "Xbox", "Discord", "Git", "Github", "CleanDrink", "Corona",
                    "False", "True", "Stockholm", "CtrlAltDelete", "Syntax"*/};

            String guessWord = wordHolder[randomizer(wordHolder)].toLowerCase();
            ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
            ArrayList<Character> dumbGuesses = new ArrayList();
            Player userName = new Player();



            //This if/else-if case keeps track of if the game has 2, 3 or 4 players!
            ArrayList<Integer> randomNumber = new ArrayList<>();

            int amountOfPlayers;

            if (user3 == null) {
                String[] splitUserName1 = user1.split(" ", 6);
                String[] splitUserName2 = user2.split(" ", 6);
                playersLife = 20;
                System.out.println(Color.PURPLE + "Welcome " + /*userName.getInstanceVarUsername(splitUserName1[0])*/ splitUserName1[0] + " and " + splitUserName2[0] + ", get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
                System.out.println("Press 0 to save and exit");

                randomNumber.add(0, 1);
                randomNumber.add(1, 2);
                amountOfPlayers = randomizerList(randomNumber);
                //turn(amountOfPlayers, user1, user2, user3, user4);

            } else if (user4 == null) {
                String[] splitUserName1 = user1.split(" ", 6);
                String[] splitUserName2 = user2.split(" ", 6);
                String[] splitUserName3 = user3.split(" ", 6);
                playersLife = 5;
                System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + " and " + splitUserName3[0] + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
                System.out.println("Press 0 to save and exit");

                randomNumber.add(0, 1);
                randomNumber.add(1, 2);
                randomNumber.add(2, 3);
                amountOfPlayers = randomizerList(randomNumber);
                //turn(amountOfPlayers, user1, user2, user3, user4);
            } else {
                String[] splitUserName1 = user1.split(" ", 6);
                String[] splitUserName2 = user2.split(" ", 6);
                String[] splitUserName3 = user3.split(" ", 6);
                String[] splitUserName4 = user4.split(" ", 6);

                playersLife = 6;
                System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + ", " + splitUserName3[0] + " and " + splitUserName4[0] + "! Get ready for battle!\nThe first word is " + guessWord.length() + " letters long!" + Color.RESET);
                System.out.println("Press 0 to save and exit");

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
                            trueLetter = characterDestroyer(letter, allLetters, guessWord, dumbGuesses, playersLife, usersPoints);

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
                            String[] userSpliter = users[currentPlayer].split(" ",6);
                            System.out.println(Color.GREEN + "\n\nCongratulations " + userSpliter[0] + ". You get a point!\n(It's still " + userSpliter[0] + "'s turn)" + Color.RESET);
                            usersPoints.set(currentPlayer,usersPoints.get(currentPlayer) + 1) ;
                            System.out.println(usersPoints.get(currentPlayer));
                            guessWord = wordHolder[randomizer(wordHolder)].toLowerCase();
                            System.out.println("The next word to be guessed is " + guessWord.length() + " letters long!");
                            System.out.println("Press 0 to save and exit");
                            //Här ska den spelare som skrev ut ordet få ett poäng
                            dumbGuesses.removeAll(dumbGuesses);
                            allLetters.clear();
                            for (int i = 0; i < guessWord.length(); i++) {
                                System.out.print("_");
                                allLetters.add(i, '_');
                            }
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
                        System.out.print(Color.RED + "\nThe game is over! The last word was: " + guessWord +
                                Color.RESET);
                        winnerSelect(usersPoints, users);
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData1()));
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData2()));
                            if (Player.modifyX.getPickUserData3() != -1){
                                highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData3()));
                            }
                            if (Player.modifyX.getPickUserData4() != -1){
                                highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData4()));
                            }



                        //Player.matchAdderCaller();
                        //Player.lossAdderCaller();
                        in.nextLine();

                        victory = true;
                        runMultiplayer = false;
                    }
                }
            }
        }



            public static void winnerSelect(ArrayList<Integer> usersPoints, String[] users) throws Exception {
                Integer maxVal = Collections.max(usersPoints);
                int index = usersPoints.indexOf(maxVal);  // "index" means the index with the highest points aka the Winner
                String[] splitUser = users[index].split(" ", 6);

                // If game ends as a draw

                drawChecker(users,index,maxVal,usersPoints,splitUser);


                // If there is a single clear winner


                    // Adds a win to the winner (Duh)
                //Player.winAdder(index);

                    int x = 0;
                    int y = 0;

                    for (int i = 0; i < usersPoints.size(); i++) {
                        x++;
                        Player.multiplayerPointAdderCaller(usersPoints.get(i), x);
                        Player.multiMatchAdderCaller(x);
                        //System.out.println("Snurr");
                    }
                    for (int j = 0; j < usersPoints.size(); j++) {
                        y++;
                        Player.multiLossAdderCaller(y, index ,users);
                    }
                }

            public static void drawChecker (String[] users, int index, Integer maxVal, ArrayList<Integer> usersPoints, String[] splitUser ) throws Exception {
                boolean run = true;
                while(run == true) {
                    if(usersPoints.size() == 4) {
                        for (int l = 0; l < usersPoints.size(); l++) {
                            for (int h = 1; h < usersPoints.size(); h++) {
                                if (h == 4) {
                                    h = 0;
                                }
                                for (int r = 2; r < usersPoints.size(); r++) {
                                    if (r == 4) {
                                        r = 0;
                                    }
                                    if (users[l] != users[index] && users[h] != users[index] && users[r] != users[index] && users[l] != users[h] && users[r] != users[h] && users[l] != users[r] && run == true) {
                                        String[] splitL = users[l].split(" ", 6);
                                        String[] splitH = users[h].split(" ", 6);
                                        String[] splitR = users[r].split(" ", 6);
                                        if (maxVal == usersPoints.get(l) && maxVal == usersPoints.get(h) && maxVal == usersPoints.get(h) && run == true) {
                                            System.out.println("\n\nPlayers " + splitUser[0] + ", " + splitL[0] + ", " + splitH[0]  + " and " + splitR[0]  + " all have " + maxVal + " points!\nThe Game ends as a draw!");
                                            run = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(usersPoints.size() == 3 || usersPoints.size() == 4) {
                        for (int i = 1; i < usersPoints.size(); i++) {
                            if (i == 4) {
                                i = 0;
                            }
                            for (int j = 0; j < usersPoints.size(); j++) {
                                if (users[i] != users[index] && users[j] != users[index] && users[i] != users[j] && run == true) {
                                    String[] splitI = users[i].split(" ", 6);
                                    String[] splitJ = users[j].split(" ", 6);
                                    if (maxVal == usersPoints.get(j) && maxVal == usersPoints.get(i) && run == true) {
                                        System.out.println("\n\nPlayers " + splitUser[0]+ ", " + splitJ[0] + " and " + splitI[0] + " all have " + maxVal + " points!\nThe Game ends as a draw!");
                                        run = false;
                                    }
                                }
                            }
                        }
                    }
                    if(usersPoints.size() == 3 || usersPoints.size() == 4 || usersPoints.size() == 2) {
                        for (int k = 0; k < usersPoints.size(); k++) {
                            if (users[index] != users[k] && run == true) {
                                String[] splitK = users[k].split(" ", 6);
                                if (maxVal == usersPoints.get(k) && run == true) {
                                    System.out.println("\n\nPlayers " + splitUser[0] + " and " + splitK[0] + " both have " + maxVal + " points!\nThe Game ends as a draw!");
                                    run = false;
                                }
                            }
                        }
                    }
                    if (run == true) {
                        System.out.println("\nThe winner is " + splitUser[0] + " with " + maxVal + " points!");
                        int x = 0;
                        for (int i = 0; i < usersPoints.size();i++){
                            x++;
                            Player.multiWinAdderCaller(x,index,users);

                        }
                        run = false;

                    }
                }
            }


            public static int turn (int amountOfPlayers, String user1, String user2, String user3, String user4) {

            if (amountOfPlayers == 1){
                String[] splitUserName1 = user1.split(" ", 6);
                System.out.println("\nIt is " + splitUserName1[0] +"'s turn!");
                amountOfPlayers = 2;
                }

            else if (amountOfPlayers == 2){
                String[] splitUserName2 = user2.split(" ", 6);
                System.out.println("\nIt is " + splitUserName2[0] +"'s turn!");
                if (user3 == null){
                    amountOfPlayers = 1;
                }
                else {
                    amountOfPlayers = 3;
                }
            }

            else if (amountOfPlayers == 3){
                String[] splitUserName3 = user3.split(" ", 6);
                System.out.println("\nIt is " + splitUserName3[0] +"'s turn!");
                if (user4 == null){
                    amountOfPlayers = 1;
                }
                else {
                    amountOfPlayers = 4;
                }
            }

            else if (amountOfPlayers == 4){
                String[] splitUserName4 = user4.split(" ", 6);
                System.out.println("\nIt is " + splitUserName4[0] +"'s turn!");
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

        public static String characterDestroyer(String letter, ArrayList<Character>allLetters, String guessWord, ArrayList<Character> dumbGuesses,
                                                int playersLife, ArrayList<Integer> usersPoints) throws IOException {
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
                } else if
                (letter.contains("0"))  // ***************************** SAVE FEATURE *********************************
                {
                    System.out.println(Color.RED +"Saving and exiting!" + Color.RESET);
                    SaveGame.saveToFile(allLetters, guessWord, dumbGuesses, playersLife, usersPoints);
                    System.exit(0);
                }

                // ****************************************************************************************************
                else if (letter.contains("!")) {
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
