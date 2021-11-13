import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


    class MultiPlayer {

        public static Scanner in = new Scanner(System.in);


        private int hasSeenLoadMenu = 0;

        public int getHasSeenLoadMenu() {
            return hasSeenLoadMenu;
        }

        public void setHasSeenLoadMenu(int hasSeenLoadMenu) {
            this.hasSeenLoadMenu = hasSeenLoadMenu;
        }


        private ArrayList<Integer> usersPoints = new ArrayList<>();

        public ArrayList<Integer> getUsersPoints() {
            return usersPoints;
        }


        private ArrayList<String> users = new ArrayList<>();

        public ArrayList<String> getUsers() {
            return users;
        }


        private int playerLife = 0;

        public int getPlayerLife() {
            return playerLife;
        }

        public void setPlayerLife(int playerLife) {
            this.playerLife = playerLife;
        }

        private String guessWord;

        public String getGuessWord() {
            return guessWord;
        }

        public void setGuessWord(String guessWord) {
            this.guessWord = guessWord;
        }

        private ArrayList<Character> allLetters = new ArrayList();

        public ArrayList<Character> getAllLetters() {
            return allLetters;
        }

        private ArrayList<Character> dumbGuesses = new ArrayList();

        public ArrayList<Character> getDumbGuesses() {
            return dumbGuesses;
        }

        private int amountOfPlayers;

        public int getAmountOfPlayers() {
            return amountOfPlayers;
        }

        public void setAmountOfPlayers(int amountOfPlayers) {
            this.amountOfPlayers = amountOfPlayers;
        }

        public static MultiPlayer modify = new MultiPlayer();



        /**
         This method launches and plays the entire game, this is the most important class. It picks out a word and makes player guess the various letters
         in said word until the player either wins or loses!
         */

        public static void hangMan(String user1, String user2, String user3, String user4) throws Exception {
            //  //This array holds all currently selected and playing users

            modify.getUsers().add(0,user1);
            modify.getUsers().add(1,user2);
            modify.getUsers().add(2,user3);
            modify.getUsers().add(3,user4);





            if (modify.getHasSeenLoadMenu() == 0) {
                //  **********************  This ArrayList keeps track of users SCORE during the game **********************

                if (user3 == null) {
                    modify.getUsersPoints().add(0,0);
                    modify.getUsersPoints().add(1,0);
                } else if (user4 == null) {
                    modify.getUsersPoints().add(0,0);
                    modify.getUsersPoints().add(1,0);
                    modify.getUsersPoints().add(2,0);
                } else {
                    modify.getUsersPoints().add(0,0);
                    modify.getUsersPoints().add(1,0);
                    modify.getUsersPoints().add(2,0);
                    modify.getUsersPoints().add(3,0);

                }
                // *********************************************************************************************************
             }


            boolean victory = false;

            // Here is our full wordlist!
            String[] wordHolder = {"Björn", "Bill", "Java", "Edwin", "Julius", "Martin", "Johanna", "String", "Int", "Scanner", "ArrayList", "boolean", "Character", "Placeholder", "null",
                    "monster", "redbull", "Newton", "Switchbitch", "HANGMAN", "FUCKYOU", "Fury", "Class", "Static", "Void", "GeOssHögtBetygBill", "System", "Exception", "Mupphuvud"
                    , "JamesGosling", "Kaffe", "ForLoop", "While", "Index", "Double", "Minecraft", "Starcraft", "Warcraft", "Cantcrashthisgame", "Xbox", "Discord", "Git", "Github", "CleanDrink", "Corona",
                    "False", "True", "Stockholm", "CtrlAltDelete", "Syntax"};

                if (modify.getHasSeenLoadMenu() == 0){
                    modify.setGuessWord(wordHolder[randomizer(wordHolder)].toLowerCase());
                }


                Player userName = new Player();



            //This if/else-if case greets players and initializes the relevant data based on how many users are playing
            // Like three players having less overall health than four, and who gets to guess first
            ArrayList<Integer> randomNumber = new ArrayList<>();
            if (modify.getHasSeenLoadMenu() == 0){
                if (user3 == null) {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    modify.setPlayerLife(20);

                    System.out.println(Color.PURPLE + "Welcome " + /*userName.getInstanceVarUsername(splitUserName1[0])*/ splitUserName1[0] + " and " + splitUserName2[0] + ", get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println("Press 0 to save and exit");

                    randomNumber.add(0, 1);
                    randomNumber.add(1, 2);
                    modify.setAmountOfPlayers(randomizerList(randomNumber));

                } else if (user4 == null) {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    modify.setPlayerLife(20);
                    System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + " and " + splitUserName3[0] + "! Get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println("Press 0 to save and exit");

                    randomNumber.add(0, 1);
                    randomNumber.add(1, 2);
                    randomNumber.add(2, 3);
                    modify.setAmountOfPlayers(randomizerList(randomNumber));

                } else {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    String[] splitUserName4 = user4.split(" ", 6);

                    modify.setPlayerLife(30);
                    System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + ", " + splitUserName3[0] + " and " + splitUserName4[0] + "! Get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println("Press 0 to save and exit");

                    randomNumber.add(0, 1);
                    randomNumber.add(1, 2);
                    randomNumber.add(2, 3);
                    randomNumber.add(3, 4);
                    modify.setAmountOfPlayers(randomizerList(randomNumber));
                }
            }





            // Greets players also, but doesn't load in new data if the game is LOADED
            else if (modify.hasSeenLoadMenu == 1) {
                if (user3 == null) {
                        String[] splitUserName1 = user1.split(" ", 6);
                        String[] splitUserName2 = user2.split(" ", 6);

                        System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + " and " + splitUserName2[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                        System.out.println("Press 0 to save and exit");

                }else if (user4 == null){
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + ", " + splitUserName2[0] + " and " + splitUserName3[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println("Press 0 to save and exit");

                }else{
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    String[] splitUserName4 = user4.split(" ", 6);


                    System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + ", " + splitUserName2[0] + ", " + splitUserName3[0] + " and " + splitUserName4[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println("Press 0 to save and exit");
                }
            }

            if (modify.hasSeenLoadMenu == 0) {
                turn(user1, user2, user3, user4);
            }
            else if (modify.hasSeenLoadMenu == 1){
                turn(user1, user2, user3, user4);
                System.out.println("Previously guessed letters: ");
                for (int i = 0; i < modify.dumbGuesses.size(); i++){
                    System.out.print(modify.dumbGuesses.get(i) + " ");
                }
                System.out.println();
            }


            boolean runMultiplayer = true;
            while (runMultiplayer) {
                if (modify.getHasSeenLoadMenu() == 0) {
                    modify.getAllLetters().clear();
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        System.out.print("_");
                        modify.getAllLetters().add(i, '_');
                    }
                }
                else if(modify.getHasSeenLoadMenu() == 1){
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        System.out.print(modify.getAllLetters().get(i));
                    }
                }
                //System.out.println(user1 + " " + user2 + " " +  user3 + " " + user4);


                // ******************************************** Game Start! ************************************************


                // "Victory" and "playersLife" checks weather the player wins or looses throughout the game.
                while (victory == false && modify.getPlayerLife() > 0) {
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
                            trueLetter = characterDestroyer(letter, modify.getAllLetters(), modify.getGuessWord(), modify.getDumbGuesses(), modify.getPlayerLife(), modify.getUsersPoints(), modify.getAmountOfPlayers(), modify.getUsers());

                            if (trueLetter != null) {
                                destroyDumbCharacters = false;
                            }
                        }
                        if (modify.getDumbGuesses().contains(trueLetter.charAt(0)) || modify.getAllLetters().contains(trueLetter.charAt(0))) {
                            System.out.println(Color.RED + "Letter has already been guessed!" + Color.RESET);
                            for (int j = 0; j < modify.getAllLetters().size(); j++) {
                                System.out.print(modify.getAllLetters().get(j));
                            }

                        } else {
                            doubleGuess = false;
                        }
                    }
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        if (trueLetter.charAt(0) == modify.getGuessWord().charAt(i)) {
                            guessCorrect = true;
                        } else if (trueLetter.charAt(0) != modify.getGuessWord().charAt(i)) {
                            guessIncorrect = true;
                        }
                    }

                    // this matches current turn with an index in the "users" array to keep track of which player should get a point

                    int currentPlayer = 0;

                    if ( modify.getAmountOfPlayers() == 2 ||  modify.getAmountOfPlayers() == 3 ||  modify.getAmountOfPlayers() == 4) {
                        currentPlayer =  modify.getAmountOfPlayers() - 2;
                    } else if ( modify.getAmountOfPlayers() == 1) {
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
                        correctLetter(trueLetter, modify.getGuessWord(), modify.getAllLetters(), userName, user1);
                        if (modify.getAllLetters().contains('_')) {
                        } else {
                            String[] userSpliter = modify.getUsers().get(currentPlayer).split(" ",6);
                            System.out.println(Color.GREEN + "\n\nCongratulations " + userSpliter[0] + ". You get a point!\n(It's still " + userSpliter[0] + "'s turn)" + Color.RESET);
                            modify.getUsersPoints().set(currentPlayer,modify.getUsersPoints().get(currentPlayer) + 1) ;
                            System.out.println(modify.getUsersPoints().get(currentPlayer));
                            modify.setGuessWord(wordHolder[randomizer(wordHolder)].toLowerCase());
                            System.out.println("The next word to be guessed is " + modify.getGuessWord().length() + " letters long!");
                            System.out.println("Press 0 to save and exit");
                            //Här ska den spelare som skrev ut ordet få ett poäng
                            modify.getDumbGuesses().removeAll(modify.getDumbGuesses());
                            modify.getAllLetters().clear();
                            for (int i = 0; i < modify.getGuessWord().length(); i++) {
                                System.out.print("_");
                                modify.getAllLetters().add(i, '_');
                            }
                        }

                    } else if (guessIncorrect) {
                        modify.setPlayerLife(modify.getPlayerLife()-1);
                        //hangManWriter(playersLife);
                        System.out.println(Color.RED + "Incorrect guess! Your collective life has gone down by 1!" + "\n(" + modify.getPlayerLife() + " lives remaining)" + Color.RESET);
                        incorrectLetterCollector(trueLetter);
                        System.out.println();
                        for (int j = 0; j < modify.getAllLetters().size(); j++) {
                            System.out.print(modify.getAllLetters().get(j));
                        }
                        turn(user1,user2,user3,user4);
                    }

                    // You already know what "playersLife" does...
                    if (modify.getPlayerLife() == 0) {
                        System.out.println();
                        System.out.print(Color.RED + "\nThe game is over! The last word was: " + modify.getGuessWord() + Color.RESET);
                        System.out.println(Color.BLUE + "\nPress Enter to return to the main menu..." + Color.RESET);
                        winnerSelect(modify.getUsersPoints(), modify.getUsers());

                        highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData1()));
                        highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData2()));

                        if (Player.modifyX.getPickUserData3() != -1){
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData3()));
                        }
                        if (Player.modifyX.getPickUserData4() != -1){
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData4()));
                        }

                        modify.setHasSeenLoadMenu(0);

                        in.nextLine();

                        victory = true;
                        runMultiplayer = false;

                        Menu.firstMenu();
                    }
                }
            }
        }



        public static void winnerSelect(ArrayList<Integer> usersPoints, ArrayList <String> users) throws Exception {
            Integer maxVal = Collections.max(usersPoints);
            int index = usersPoints.indexOf(maxVal);  // "index" means the index with the highest points aka the Winner
            String[] splitUser = users.get(index).split(" ", 6);

            // If game ends as a draw

            drawChecker(users,index,maxVal,usersPoints,splitUser);


            // If there is a single clear winner


            // Adds a win to the winner (Duh)

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

        public static void drawChecker (ArrayList<String> users, int index, Integer maxVal, ArrayList<Integer> usersPoints, String[] splitUser ) throws Exception {
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
                                if (users.get(l) != users.get(index) && users.get(h) != users.get(index) && users.get(r) != users.get(index) && users.get(l) != users.get(h) && users.get(r) != users.get(h) && users.get(l) != users.get(r) && run == true) {
                                    String[] splitL = users.get(l).split(" ", 6);
                                    String[] splitH = users.get(h).split(" ", 6);
                                    String[] splitR = users.get(r).split(" ", 6);
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
                            if (users.get(i) != users.get(index) && users.get(j) != users.get(index) && users.get(i) != users.get(j) && run == true) {
                                String[] splitI = users.get(i).split(" ", 6);
                                String[] splitJ = users.get(j).split(" ", 6);
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
                        if (users.get(index) != users.get(k) && run == true) {
                            String[] splitK = users.get(k).split(" ", 6);
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


        public static void turn (String user1, String user2, String user3, String user4) {
            if (modify.getAmountOfPlayers() == 1){
                String[] splitUserName1 = user1.split(" ", 6);
                System.out.println("\nIt is " + splitUserName1[0] +"'s turn!");
                modify.setAmountOfPlayers(2);
            }

            else if (modify.getAmountOfPlayers() == 2){
                String[] splitUserName2 = user2.split(" ", 6);
                System.out.println("\nIt is " + splitUserName2[0] +"'s turn!");
                if (user3 == null|| user3.equals("null")){
                    modify.setAmountOfPlayers(1);
                }
                else {
                    modify.setAmountOfPlayers(3);
                }
            }

            else if (modify.getAmountOfPlayers() == 3){
                String[] splitUserName3 = user3.split(" ", 6);
                System.out.println("\nIt is " + splitUserName3[0] +"'s turn!");
                if (user4 == null|| user3.equals("null")){
                    modify.setAmountOfPlayers(1);
                }
                else {
                    modify.setAmountOfPlayers(4);
                }
            }

            else if (modify.getAmountOfPlayers() == 4){
                String[] splitUserName4 = user4.split(" ", 6);
                System.out.println("\nIt is " + splitUserName4[0] +"'s turn!");
                modify.setAmountOfPlayers(1);
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
        public static void incorrectLetterCollector(String trueLetter) {
            modify.getDumbGuesses().add(trueLetter.charAt(0));
            System.out.println(Color.CYAN + "\nPreviously guessed letters: " + Color.RESET);
            for (int i = 0; i < modify.getDumbGuesses().size(); i++) {
                System.out.print(Color.RED + modify.getDumbGuesses().get(i) + " " + Color.RESET);
            }
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
                                                int playersLife, ArrayList<Integer> usersPoints, int amountOfPlayers, ArrayList<String> users) throws IOException {
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
                    SaveGame.saveToFile(allLetters, guessWord, dumbGuesses, playersLife, usersPoints, amountOfPlayers, users);
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

