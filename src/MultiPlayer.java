import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


    class MultiPlayer {

        // Global Scanner
        public static Scanner in = new Scanner(System.in);

        //******************************************* Global Variables ******************************************
        // Global variables that can be initialized during game or loaded in
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

        private int playersTurn;
        public int getPlayersTurn() {
            return playersTurn;
        }
        public void setPlayersTurn(int playersTurn) {
            this.playersTurn = playersTurn;
        }

        private String userInQuestion;
        public String getUserInQuestion() {
            return userInQuestion;
        }
        public void setUserInQuestion(String userInQuestion) {
            this.userInQuestion = userInQuestion;
        }

        public static MultiPlayer modify = new MultiPlayer();
        // *****************************************************************************************************


        /**
         This method launches and plays the entire game in multiplayer mode (two, three or four users)
         */

        public static void hangMan(String user1, String user2, String user3, String user4) throws Exception {

            //Adds user1, 2, 3 and 4 to its own Arraylist (Users)
            modify.getUsers().add(0,user1);
            modify.getUsers().add(1,user2);
            modify.getUsers().add(2,user3);
            modify.getUsers().add(3,user4);


            //Keeps track of weather the game has been loaded or started as a new game
            if (modify.getHasSeenLoadMenu() == 0) {


                /* If-case decides how many users will need their points saved (usersPoints Arraylist)
                based on amount of current players */
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
             }


            // Self-explanatory
            boolean victory = false;

            // Here is our full wordlist!
            String[] wordHolder = {"Björn", "Bill", "Java", "Edwin", "Julius", "Martin", "Johanna", "String", "Int", "Scanner", "ArrayList", "boolean", "Character", "Placeholder", "null",
                    "monster", "redbull", "Newton", "Switchbitch", "HANGMAN", "FUCKYOU", "Fury", "Class", "Static", "Void", "GeOssHögtBetygBill", "System", "Exception", "Mupphuvud"
                    , "JamesGosling", "Kaffe", "ForLoop", "While", "Index", "Double", "Minecraft", "Starcraft", "Warcraft", "Cantcrashthisgame", "Xbox", "Discord", "Git", "Github", "CleanDrink", "Corona",
                    "False", "True", "Stockholm", "CtrlAltDelete", "Syntax"};

                // If this is a new game, randomize a new word to be guessed by players
                if (modify.getHasSeenLoadMenu() == 0){
                    modify.setGuessWord(wordHolder[randomizer(wordHolder)].toLowerCase());
                }

            /* This if-case greets players and initializes the relevant data based on how many users are playing,
               such as three players have less overall health than four, and who gets to guess first */

            ArrayList<Integer> amountOfPlayers = new ArrayList<>();
            if (modify.getHasSeenLoadMenu() == 0){
                if (user3 == null) {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    modify.setPlayerLife(20);

                    System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + " and " + splitUserName2[0] + ", get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                    /* "amountOfPlayers" Arraylist is modified based on how many users are playing,
                    it then randomizes who gets to go first using the "randomizerList" method */
                    amountOfPlayers.add(0, 1);
                    amountOfPlayers.add(1, 2);
                    modify.setPlayersTurn(randomizerList(amountOfPlayers));

                } else if (user4 == null) {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    modify.setPlayerLife(30);
                    System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + " and " + splitUserName3[0] + "! Get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                    amountOfPlayers.add(0, 1);
                    amountOfPlayers.add(1, 2);
                    amountOfPlayers.add(2, 3);
                    modify.setPlayersTurn(randomizerList(amountOfPlayers));

                } else {
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    String[] splitUserName4 = user4.split(" ", 6);

                    modify.setPlayerLife(40);
                    System.out.println(Color.PURPLE + "Welcome " + splitUserName1[0] + ", " + splitUserName2[0] + ", " + splitUserName3[0] + " and " + splitUserName4[0] + "! Get ready for battle!\nThe first word is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                    amountOfPlayers.add(0, 1);
                    amountOfPlayers.add(1, 2);
                    amountOfPlayers.add(2, 3);
                    amountOfPlayers.add(3, 4);
                    modify.setPlayersTurn(randomizerList(amountOfPlayers));
                }
            }





            // Greets players also, but doesn't create new data if the game is LOADED
            else if (modify.hasSeenLoadMenu == 1) {
                if (user3 == null) {
                        String[] splitUserName1 = user1.split(" ", 6);
                        String[] splitUserName2 = user2.split(" ", 6);

                        System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + " and " + splitUserName2[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                        System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                }else if (user4 == null){
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + ", " + splitUserName2[0] + " and " + splitUserName3[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                }else{
                    String[] splitUserName1 = user1.split(" ", 6);
                    String[] splitUserName2 = user2.split(" ", 6);
                    String[] splitUserName3 = user3.split(" ", 6);
                    String[] splitUserName4 = user4.split(" ", 6);


                    System.out.println(Color.PURPLE + "Welcome back " + splitUserName1[0] + ", " + splitUserName2[0] + ", " + splitUserName3[0] + " and " + splitUserName4[0] + "! Prepare for the battle to resume!\nThe word is still " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                    System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);
                }
            }


            // ****************************************** Game Start! ********************************************


            //If this is a new game, the game will alternate turns based on the current four players
            if (modify.hasSeenLoadMenu == 0) {
                turn(user1, user2, user3, user4);
            }
            /* If this is a loaded game, the game will start letter players take turns, but also shows them their
            previous guesses from the start */
            else if (modify.hasSeenLoadMenu == 1){
                turn(user1, user2, user3, user4);
                System.out.println(Color.CYAN + "Previously guessed letters: " + Color.RESET);
                for (int i = 0; i < modify.dumbGuesses.size(); i++){
                    System.out.print(Color.RED + modify.dumbGuesses.get(i) + Color.RESET + " ");
                }
                System.out.println();
            }


            boolean runMultiplayer = true;
            while (runMultiplayer) {
                /* On new game, make sure the "allLetters" list is empty and fill it with as many underscores (_)
                 as the word in question has letters */
                if (modify.getHasSeenLoadMenu() == 0) {
                    modify.getAllLetters().clear();
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        System.out.print("_");
                        modify.getAllLetters().add(i, '_');
                    }
                }
                // On a loaded game, gets the loaded information already set in "guessWord and allLetters lists
                else if(modify.getHasSeenLoadMenu() == 1){
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        System.out.print(modify.getAllLetters().get(i));
                    }
                }


                /* When "playerLife" reaches zero (0) the game is over and the player with the highest score wins
                which toggles the "victory" boolean and leaves the game-loop */
                while (victory == false && modify.getPlayerLife() > 0) {
                    boolean guessCorrect = false;
                    boolean guessIncorrect = false;
                    boolean doubleGuess = true;
                    System.out.println();
                    String letter;
                    String trueLetter = null;

                    //doubleGuess ensures player does not guess same letter twice! You're welcome <3
                    while (doubleGuess) {
                        boolean destroyDumbCharacters = true;
                        while (destroyDumbCharacters) {
                            //to lower case kills you capitalized letters *evil laugh*
                            letter = in.nextLine().toLowerCase();

                            //If "letter" contains a forbidden character it will be returned as NULL
                            trueLetter = characterDestroyer(letter, modify.getAllLetters(), modify.getGuessWord(),
                            modify.getDumbGuesses(), modify.getPlayerLife(), modify.getUsersPoints(),
                            modify.getPlayersTurn(), modify.getUsers());

                            /* IF "trueLetter" does NOT come back as NULL this means that the player inputted
                            an appropriate character, loop is exited */
                            if (trueLetter != null) {
                                destroyDumbCharacters = false;
                            }
                        }
                        /* If the player has already guessed their current input, they are informed that they cannot
                        make the same guess twice and are asked to input a new character */
                        if (modify.getDumbGuesses().contains(trueLetter.charAt(0)) || modify.getAllLetters().contains(trueLetter.charAt(0))) {
                            System.out.println(Color.RED + "Letter has already been guessed!" + Color.RESET);
                            for (int j = 0; j < modify.getAllLetters().size(); j++) {
                                System.out.print(modify.getAllLetters().get(j));
                            }

                        //The game has figured out that your guess hadn't already been made
                        } else {
                            doubleGuess = false;
                        }
                    }

                    //Checks weather players input corresponds with a letter in the current word
                    for (int i = 0; i < modify.getGuessWord().length(); i++) {
                        if (trueLetter.charAt(0) == modify.getGuessWord().charAt(i)) {
                            guessCorrect = true;
                        } else if (trueLetter.charAt(0) != modify.getGuessWord().charAt(i)) {
                            guessIncorrect = true;
                        }
                    }

                    /* This matches current turn with an index in the "users" array
                    that keeps track of which player should receive a point */
                    int currentPlayer = 0;



                    /* Based on how many users are currently playing "currentPlayer" is given a number that represents
                    the previous players position in the "users" Array list, if the first selected player is selected
                    we, in other words want the user before that user! Logically, the number is subtracted by two
                    as in player 2 has the index "1" in the AList, but we want player 1, so we find index "0"

                    Confused? This makes more sense later on in the code... */
                    if (modify.getPlayersTurn() == 2 ||  modify.getPlayersTurn() == 3 ||  modify.getPlayersTurn() == 4) {
                        currentPlayer = modify.getPlayersTurn()-2;

                    } else if (modify.getPlayersTurn() == 1) {
                        if (user3 == null) {
                            currentPlayer = 1;
                        } else if (user4 == null) {
                            currentPlayer = 2;
                        } else {
                            currentPlayer = 3;
                        }
                    }



                /* "guessCorrect" and "guessIncorrect" makes the game react to your choices as a player.
                incorrect guesses result in a loss of life,
                correct guesses reveals letter in the "allLetters" Array list! */

                    if (guessCorrect) {
                        correctLetter(trueLetter, modify.getGuessWord(), modify.getAllLetters());
                        if (modify.getAllLetters().contains('_')) {
                        } else {
                            //We split the full username, so we can show only the name and not the stats
                            String[] userSpliter = modify.getUsers().get(currentPlayer).split(" ",6);

                            //Moral-boosting congratulatory message!
                            System.out.println(Color.GREEN + "\n\nCongratulations " + userSpliter[0] + ". You get a point!\n(It's still " + userSpliter[0] + "'s turn)" + Color.RESET);

                            //Increase the users index in the Array list "usersPoints" by 1 (+1)
                            modify.getUsersPoints().set(currentPlayer,modify.getUsersPoints().get(currentPlayer) + 1) ;

                            //Randomize a new word since the last word is fully guessed
                            modify.setGuessWord(wordHolder[randomizer(wordHolder)].toLowerCase());
                            System.out.println(Color.BLUE + "The next word to be guessed is " + modify.getGuessWord().length() + " letters long!" + Color.RESET);
                            System.out.println(Color.GREEN_BACKGROUND + Color.BLACK + "Press 0 to save and exit game" + Color.RESET);

                            /* Remove all your previously guessed letters so that you can guess them again and refills
                            "allLetters" with underscores(_) again so that a new word can be guessed out */
                            modify.getDumbGuesses().removeAll(modify.getDumbGuesses());
                            modify.getAllLetters().clear();
                            for (int i = 0; i < modify.getGuessWord().length(); i++) {
                                System.out.print("_");
                                modify.getAllLetters().add(i, '_');
                            }
                        }

                    } else if (guessIncorrect) {
                        /* Remove lives if the guess was incorrect and also strikes fear into your heart by informing
                        the player of their coming doom */
                        modify.setPlayerLife(modify.getPlayerLife()-1);
                        if(user4 != null){
                            if(modify.getPlayerLife() < 4){
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is dead .." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                            else{
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is getting closer to death..." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                        }
                        else if(user3 != null){
                            if(modify.getPlayerLife() < 3){
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is dead .." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                            else{
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is getting closer to death..." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                        }
                        else {
                            if(modify.getPlayerLife() < 2){
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is dead .." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                            else{
                                System.out.println("\n" + Color.RED + "Incorrect guess! " + Color.RESET + "\n" + Color.CYAN + modify.getUserInQuestion() + "`s character is getting closer to death..." + Color.RESET + "\n(" + modify.getPlayerLife() + " lives remaining)");
                            }
                        }
                        //Get lives for messages
                        hangManWriter(modify.getPlayerLife(), user3, user4);
                        //Collect players incorrect guesses
                        incorrectLetterCollector(trueLetter);
                        System.out.println();

                        // Doesn't print out "allLetters" or give a new player a turn if the game has ended
                        if (modify.getPlayerLife() != 0) {
                            for (int j = 0; j < modify.getAllLetters().size(); j++) {
                                System.out.print(modify.getAllLetters().get(j));
                            }
                            turn(user1, user2, user3, user4);
                        }
                    }

                    // When "playerLife" is over the game is done!
                    if (modify.getPlayerLife() == 0) {
                        System.out.println();
                        System.out.print(Color.RED + "\nThe game is over! The last word was: " + modify.getGuessWord() + Color.RESET);
                        System.out.println(Color.BLUE + "\nPress Enter to return to the main menu..." + Color.RESET);
                        modify.hasSeenLoadMenu = 0;
                        winnerSelect(modify.getUsersPoints(), modify.getUsers());

                        //Saves the players score from the game so that it can be added to a high score list!
                        highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData1()));
                        highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData2()));

                        //Checks how many users are currently playing
                        if (Player.modifyX.getPickUserData3() != -1){
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData3()));
                        }
                        if (Player.modifyX.getPickUserData4() != -1){
                            highScoreFunction.fileReader(Player.allUsernames.get(Player.modifyX.getPickUserData4()));
                        }

                        /* After the game is over "hasSeenLoadMenu" is set to 0 so that a game can't be reloaded.
                        This prevents cheating by reloading a game that is almost done over and over to add more
                        "wins" to your users stats!

                         "Cheaters are beaters" -Sun Tzu    (probably)                                        */
                        modify.setHasSeenLoadMenu(0);


                        in.nextLine();

                        victory = true;
                        runMultiplayer = false;

                        Menu.firstMenu();
                    }
                }
            }
        }


        /**
         winnerSelect method selects which user should be given the "win-stat" after the game is over
         */
        //Brings all relevant information
        public static void winnerSelect(ArrayList<Integer> usersPoints, ArrayList <String> users) throws Exception {
            Integer maxVal = Collections.max(usersPoints);
            int index = usersPoints.indexOf(maxVal);  // "index" means the index with the highest points aka the Winner
            String[] splitUser = users.get(index).split(" ", 6);

            // "drawChecker" is called to see weather multiple users tied or not
            drawChecker(users,index,maxVal,usersPoints,splitUser);

            int x = 0;
            int y = 0;

            //Gives all players "matches played" and "losses" stats when they deserve them!
            for (int i = 0; i < usersPoints.size(); i++) {
                x++;
                Player.multiplayerPointAdderCaller(usersPoints.get(i), x);
                Player.multiMatchAdderCaller(x);
            }
            for (int j = 0; j < usersPoints.size(); j++) {
                y++;
                Player.multiLossAdderCaller(y, index ,users);
            }
        }

        /**
         drawChecker method checks if the game had one or multiple winners. If more than one person had the highest score of the game,
         the game makes sure to clarify that to the players.
         */
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
                                        System.out.println(Color.YELLOW + "\n\nPlayers " + splitUser[0] + ", " + splitL[0] + ", " + splitH[0]  + " and " + splitR[0]  + " all have " + maxVal + " points!\nThe Game ends as a draw!" + Color.RESET);
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
                                    System.out.println(Color.YELLOW + "\n\nPlayers " + splitUser[0]+ ", " + splitJ[0] + " and " + splitI[0] + " all have " + maxVal + " points!\nThe Game ends as a draw!" + Color.RESET);
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
                                System.out.println(Color.YELLOW + "\n\nPlayers " + splitUser[0] + " and " + splitK[0] + " both have " + maxVal + " points!\nThe Game ends as a draw!" + Color.RESET);
                                run = false;
                            }
                        }
                    }
                }
                if (run == true) {
                    System.out.println(Color.GREEN + "\nThe winner is " + splitUser[0] + " with " + maxVal + " points!" + Color.RESET);
                    int x = 0;
                    for (int i = 0; i < usersPoints.size();i++){
                        x++;
                        Player.multiWinAdderCaller(x,index,users);

                    }
                    run = false;

                }
            }
        }

        /**
         turn method changes which player gets to guess the next letter and who gets a pont upon word-completion
         */
        public static void turn( String user1, String user2, String user3, String user4){
            if (modify.getPlayerLife() != 0) {

                if (modify.getPlayersTurn() == 1) {
                    String[] splitUserName1 = user1.split(" ", 6);


                    System.out.println("\nIt is " + splitUserName1[0] + "'s turn!");
                    modify.setPlayersTurn(2);
                    modify.setUserInQuestion(splitUserName1[0]);


                } else if (modify.getPlayersTurn() == 2) {
                    String[] splitUserName2 = user2.split(" ", 6);

                    System.out.println("\nIt is " + splitUserName2[0] + "'s turn!");
                    if (user3 == null || user3.equals("null")) {
                        modify.setPlayersTurn(1);
                    } else {
                        modify.setPlayersTurn(3);
                    }
                    modify.setUserInQuestion(splitUserName2[0]);

                } else if (modify.getPlayersTurn() == 3) {
                    String[] splitUserName3 = user3.split(" ", 6);
                    System.out.println("\nIt is " + splitUserName3[0] + "'s turn!");

                    if (user4 == null || user3.equals("null")) {
                        modify.setPlayersTurn(1);
                    } else {
                        modify.setPlayersTurn(4);
                    }
                    modify.setUserInQuestion(splitUserName3[0]);

                } else if (modify.getPlayersTurn() == 4) {
                    String[] splitUserName4 = user4.split(" ", 6);
                    System.out.println("\nIt is " + splitUserName4[0] + "'s turn!");
                    modify.setPlayersTurn(1);
                    modify.setUserInQuestion(splitUserName4[0]);
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
        public static void correctLetter(String trueLetter, String placeholder, ArrayList<Character> allLetters) throws Exception {
            char guess = trueLetter.charAt(0);

            if (Character.isDigit(guess)) {
                System.out.println(Color.RED + "Wrongful input!"+ Color.RESET +  "\nPlease enter a CHARACTER!");
            }

            for (int i = 0; i < placeholder.length(); i++) {
                if (guess == placeholder.charAt(i)) {
                    allLetters.set(i, guess);
                }
            }
            if(modify.getPlayerLife() != 0) {
                for (int j = 0; j < allLetters.size(); j++) {
                    System.out.print(allLetters.get(j));
                }
            }
        }

        /**
         This method collects all user inputted letters that were incorrect guesses! These letters are later printed out
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
         This method shows each player their own "graphic" when they lose lives!
         It also randomly changes the color as to make it stand out from text... and because this way it is less boring!
         */
        public static void hangManWriter (int playerLife, String user3, String user4) {

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

            if(user3 == null){
                for (int i = playerLife; i == playerLife; i++) {
                    System.out.println(wordHolder[randomizer(wordHolder)] + hangManIllus[i/2] + Color.RESET);
                }
            }
            else if(user4 == null){
                for (int i = playerLife; i == playerLife; i++) {
                    System.out.println(wordHolder[randomizer(wordHolder)] + hangManIllus[i/3] + Color.RESET);
                }
            }
            else if(user4 != null){
                for (int i = playerLife; i == playerLife; i++) {
                    System.out.println(wordHolder[randomizer(wordHolder)] + hangManIllus[i/4] + Color.RESET);
                }
            }



        }

        /**
         This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
         (It kills characters that we don't like)
         We also added the ability to call the "Save game" feature by pressing the "0" key during gameplay
         */

        public static String characterDestroyer(String letter, ArrayList<Character>allLetters, String guessWord, ArrayList<Character> dumbGuesses,
                                                int playersLife, ArrayList<Integer> usersPoints, int amountOfPlayers, ArrayList<String> users) throws Exception {
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
                    System.out.println(Color.RED +"Saving and exiting game!" + Color.RESET);
                    SaveGame.saveToFile(allLetters, guessWord, dumbGuesses, playersLife, usersPoints, amountOfPlayers, users);
                    dumbGuesses.clear(); // This fixes the stupid bug
                    allLetters.clear();
                    usersPoints.clear();
                    Menu.firstMenu();
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

