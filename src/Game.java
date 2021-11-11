import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
class Game extends GUI implements ActionListener {
    public static void main(String[] args) {
        new Game();
    }
    public static Scanner in = new Scanner(System.in);

    // Here is our full wordlist!
    private static String [] wordCollection = {"Björn","Bill","Java","Edwin","Julius","Martin","Johanna","String","Int","Scanner","ArrayList","boolean","Character","Placeholder","null",
            "monster","redbull","Newton","Switchbitch","HANGMAN","FUCKYOU","Fury","Class","Static","Void","GeOssHögtBetygBill","System","Exception","Mupphuvud"
            ,"JamesGosling","Kaffe","ForLoop","While","Index","Double","Minecraft","Starcraft","Warcraft","Cantcrashthisgame","Xbox","Discord","Git","Github","CleanDrink","Corona",
            "False","True","Stockholm","CtrlAltDelete","Syntax"};
    private static String guessWord = wordCollection[randomizer(wordCollection)].toLowerCase();


    //Button array
    char[] validLetters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','å','ä','ö'};

    JLabel greetLabel;
    JTextArea guessedWordArea;
    JTextField wordTextField;
    JButton[] buttons = new JButton[validLetters.length];

    Game(){

        //Panels
        headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout());
        bodyPanel = new JPanel();
        FlowLayout buttonLayout = new FlowLayout();
        buttonLayout.setVgap(5);
        buttonLayout.setHgap(5);
        bodyPanel.setLayout(buttonLayout);
        bodyPanel.setBorder(new EmptyBorder(0,80,0,80));

        //TextField
        wordTextField = new JTextField(guessWord);
        wordTextField.setPreferredSize(new Dimension(400,70));
        wordTextField.setHorizontalAlignment(SwingConstants.CENTER);
        wordTextField.setBackground(Color.gray);
        wordTextField.setForeground(Color.WHITE);
        wordTextField.setBorder(BorderFactory.createTitledBorder(null,"Previously guessed letters",0, 0, new Font(null, Font.ITALIC, 10),Color.WHITE));
        wordTextField.setFont(new Font(null, Font.BOLD,30));
        wordTextField.setEditable(false);
        wordTextField.setBorder(BorderFactory.createTitledBorder("Word to guess"));

        //textArea
        guessedWordArea = new JTextArea();
        guessedWordArea.setBackground(Color.gray);
        guessedWordArea.setForeground(Color.WHITE);
        guessedWordArea.setPreferredSize(wordTextField.getPreferredSize());
        guessedWordArea.setBorder(BorderFactory.createTitledBorder(null,"Previously guessed letters",0, 0, new Font(null, Font.PLAIN, 14),Color.WHITE));
        guessedWordArea.setFont(new Font(null, Font.BOLD,20));
        guessedWordArea.setEditable(false);

        //Labels
//        greetLabel = new JLabel("Welcome " + hangMan(userName.getInstanceVarUsername(splitUserName[0]) + " guess the word that is " + guessWord.length() + " letters long!"));

        //Add components
        add(headPanel);
        add(bodyPanel);
        headPanel.add(wordTextField);
        headPanel.add(guessedWordArea);

        letterButtonPrint();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Prints out a grid system of letter buttons
     */
    public void letterButtonPrint(){
        for(int i = 0; i < validLetters.length; i++) {
            buttons[i] = new JButton(String.valueOf(validLetters[i]));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            bodyPanel.add(buttons[i]);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton ) {
            String letter = e.getActionCommand();
            JButton pressedButton = (JButton)e.getSource();
            pressedButton.setText(letter);
            pressedButton.setEnabled(false);


            guessedWordArea.append(letter);
        }
    }
    /**
     This method launches and plays the entire game, this is the most important class. It picks out a word and makes player guess the various letters
     in said word until the player either wins or loses!
     */

     static void hangMan(String user) throws Exception {
        boolean victory = false;
         int playerLife = 10;




        ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
        ArrayList<Character> dumbGuesses = new ArrayList();
        Player userName = new Player();
        String [] splitUserName = user.split(" ", 5);

        System.out.println("Welcome " + userName.getInstanceVarUsername(splitUserName[0]) + " guess the word that is " + guessWord.length() + " letters long!");

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
                    System.out.println("Letter has already been guessed!");
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
                correctLetter(trueLetter, guessWord, allLetters, userName, user);
                 if (allLetters.contains('_')) {
                 } else {
            System.out.println("\n\nCongratulations " + userName.getInstanceVarUsername(splitUserName[0]) + ". You are victorious! :)\n (Press Enter to return to main menu)");
            Player.matchAdderCaller();
            Player.winAdderCaller();
            if (playerLife == 10){
                Player.flawlessAdderCaller();
                System.out.println("\nNO LIVES LOST! FLAWLESS VICTORY ARCHIVED!!!!!!\n" + userName.getInstanceVarUsername(splitUserName[0]) + " is a legend!");
            }
            in.nextLine();
            victory = true;
                 }
            } else if (guessIncorrect) {
                playerLife = playerLife - 1;
                System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
                incorrectLetterCollector(trueLetter, dumbGuesses);
                System.out.println();
                for (int j = 0; j < allLetters.size(); j++) {
                    System.out.print(allLetters.get(j));
                }

            }
            // You already know what "playerLife" does...
            if (playerLife == 0) {
                System.out.println();
                System.out.print("\nYou have been defeated! The word in question was: " + guessWord + "\n\nPress the Enter key to return to the main menu in shame");
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
            System.out.println("Wrongful input!\nPlease enter a CHARACTER!");
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
        System.out.println("\nPreviously guessed letters: ");
        for (int i = 0; i < dumbGuesses.size(); i++) {
            System.out.print(dumbGuesses.get(i) + " ");
        }
        return dumbGuesses;
    }



    /**
     This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
     */

    public static String characterDestroyer(String letter,ArrayList<Character>allLetters) {
    if (!letter.isEmpty()) {
        if (letter.contains("1")) {
            System.out.println("You may not guess numbers!");
        } else if (letter.contains("2")) {
            System.out.println("You may not guess numbers!");
        } else if (letter.contains("3")) {
            System.out.println("You may not guess numbers!");
        } else if (letter.contains("4")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("5")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("6")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("7")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("8")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("9")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("0")) {
            System.out.println(Color.RED +"You may not guess numbers!");
        } else if (letter.contains("!")) {
            System.out.println(Color.RED +"You may not guess an exclamation point!");
        } else if (letter.contains("?")) {
            System.out.println(Color.RED +"You may not guess a question mark!");
        } else if (letter.contains("#")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("¤")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("%")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("&")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("/")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("(")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains(")")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("=")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("*")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("-")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("+")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains(",")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains(".")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("<")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains(">")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("|")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("@")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("£")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("$")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("€")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("{")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("[")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("]")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("}")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("´´")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("\"")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains("\\")) {
            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
        } else if (letter.contains(" ")) {
            System.out.println(Color.RED +"No whitespace!");
        } else if (letter.isEmpty()) {
            System.out.println(Color.RED +"No input was given!");
        } else if (letter.contains("æ")) {
            System.out.println(Color.RED +"Inga danskjävlar i spelet!");
            System.exit(0);
        } else if (letter.contains("ø")) {
            System.out.println(Color.RED +"Inga danskjävlar i spelet!");
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



