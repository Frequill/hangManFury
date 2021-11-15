import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


class SinglePlayer extends GUI implements ActionListener {

    public static Scanner in = new Scanner(System.in);

    // Here is our full wordlist!
    private static String[] wordHolder = {"Björn", "Bill", "Java", "Edwin", "Julius", "Martin", "Johanna", "String", "Int", "Scanner", "ArrayList", "boolean", "Character", "Placeholder", "null",
            "monster", "redbull", "Newton", "Switchbitch", "HANGMAN", "Fury", "Class", "Static", "Void", "System", "Exception", "Kaffe", "ForLoop", "While", "Index",
            "Double", "Minecraft", "Starcraft", "Warcraft", "Xbox", "Discord", "Git", "Github", "Corona","StarWars","Lunch","Kanelbulle","ParkeringsPlats","Diabetes",
            "False", "True", "Stockholm", "Syntax", "Multiplayer", "SingelPlayer", "SwitchCase", "Dator", "html", "Color", "IFCase" , "Variable","Stenart","Anus","Dyslexi","Kungen","Spagetti",
            "Player", "Playstation","Nintendo","Wii","Diablo", "Snapchat", "Runescape", "Samsung", "Apple", "Google", "Legend", "TangentBord", "Ryssland", "Sverige","Tyskland","Brasilien",
            "Teams", "AtomBomb", "Uppsala", "Järfälla", "Gärdet", "Östermalm", "Medborgarplatsen", "Tunnelbana", "Motorväg","Hemläxa","Julafton", "Midsommar", "Screen", "Skandinavien",
            "Full", "Bakis", "Bakfull", "Riksdagsval", "Nyårsafton", "Ordlista", "Lägenhet", "School","DanskJävel", "IntelliJ", "JetBrains", "Add","Remove","Clear", "Sushi", "Helvetet",
            "Lounge", "Grupprum", "Spotify", "Huawei", "GTA", "Kalkylator", "Kalender", "GräsMatta", "HashPlanta", "Vodka", "Arlanda","Öl","Torsdag","Tisdag","Distans", "Fifa","Organ",
            "Instagram", "Metod","Jultomten", "Username", "Password", "HighScore", "Main", "Laptop","SkyRim", "Irrelevant", "Allmänt","Video", "Mamma", "Pappa", "Windows", "Macbook","Program",
            "Programmering"};

    private String guessWord = wordHolder[randomizer(wordHolder)].toUpperCase();
    private ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
    private int playerLife = 10;
    private boolean guessCorrect = false;
    private ArrayList<Character> dumbGuesses = new ArrayList();
    private String letter = null;
    private boolean victory = false;


    public static void userFetcher(String user) throws Exception {

        userName.setUser(user);

    }


//    String [] splitUserName = user.split(" ", 5);
    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;


    //Button array
    char[] buttonLettersArray ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Å','Ä','Ö'};

    //Swing components
    JFrame frame = new JFrame();
    JPanel headPanel, bodyPanel;
    JLabel menuTitle, menuImage;
    JButton button;
    JLabel greetLabel;
    JTextArea guessedLetterArea;
    JTextField wordToGuessField, playerStatsField;
    JButton[] buttons;

    SinglePlayer() throws Exception {
//frame settings

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setTitle("HangMan by Group Fury");
        frame.setLayout(new GridLayout(2,1));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Panels
        headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout());


        bodyPanel = new JPanel();
        //Panels
        headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout());
        bodyPanel = new JPanel();
        FlowLayout buttonLayout = new FlowLayout();
        buttonLayout.setVgap(5);
        buttonLayout.setHgap(5);
        bodyPanel.setLayout(buttonLayout);
        bodyPanel.setBorder(new EmptyBorder(0,80,0,80));

        //TextArea

        wordToGuessField = new JTextField(wordEncryptor());
        wordToGuessField.setPreferredSize(new Dimension(400,70));
        wordToGuessField.setHorizontalAlignment(SwingConstants.CENTER);
        wordToGuessField.setBackground(Color.gray);
        wordToGuessField.setForeground(Color.WHITE);
        wordToGuessField.setBorder(BorderFactory.createTitledBorder(null,"Word to guess",0, 0, new Font(null, Font.ITALIC, 14),Color.WHITE));
        wordToGuessField.setFont(new Font(null, Font.BOLD,25));
        wordToGuessField.setEditable(false);

        guessedLetterArea = new JTextArea();
        guessedLetterArea.setBackground(Color.gray);
        guessedLetterArea.setForeground(Color.WHITE);
        guessedLetterArea.setPreferredSize(wordToGuessField.getPreferredSize());
        guessedLetterArea.setBorder(BorderFactory.createTitledBorder(null,"Previously guessed letters",0, 0, new Font(null, Font.PLAIN, 14),Color.WHITE));
        guessedLetterArea.setFont(new Font(null, Font.BOLD,20));
        guessedLetterArea.setEditable(false);

        playerStatsField = new JTextField("");
        playerStatsField.setPreferredSize(new Dimension(600,40));
        playerStatsField.setHorizontalAlignment(SwingConstants.CENTER);
        playerStatsField.setFont(new Font(null, Font.BOLD,14));
        playerStatsField.setBackground(new Color(94,80,250));
        playerStatsField.setForeground(new Color(0xFFFFFF));
        playerStatsField.setEditable(false);
        playerStatsField.setBorder(new LineBorder(Color.WHITE, 3, false));
        playerStatsField.setText("Welcome " + userName.getUser() + " guess the word that is " + guessWord.length() + " letters long!");

        //Labels

        greetLabel = new JLabel();
        greetLabel.setFont(new Font(null,Font.BOLD, 13));

        //Buttons
//yyhhh
        buttons = new JButton[buttonLettersArray.length];

        //Add components
        frame.add(headPanel);
        frame.add(bodyPanel);
//        headPanel.add(greetLabel);
        headPanel.add(wordToGuessField);
        headPanel.add(guessedLetterArea);
        headPanel.add(playerStatsField);

        letterButtons();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    /**
     * Creates letter buttons
     */
    public void letterButtons(){
        for(int i = 0; i < buttonLettersArray.length; i++) {
            buttons[i] = new JButton(String.valueOf(buttonLettersArray[i]));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            bodyPanel.add(buttons[i]);
        }
    }

    /**
     * Creates the fully encrypted word to guess in the beginning of the game.
     */
    private String wordEncryptor() {
        for(int i = 0; i < guessWord.length(); i++){
            allLetters.add(i,'_');
        }
        String text = allLetters.toString().replace("[", "").replace("]", "").replace(",", "");
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton ) {
            String letter = e.getActionCommand();
            JButton pressedButton = (JButton)e.getSource();
            pressedButton.setText(letter);
            pressedButton.setEnabled(false);

            for(int i = 0; i < guessWord.length(); i++) {
                guessCorrect = false;
                try {
                    correctLetter(letter,guessWord,allLetters, userName.getUser());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                playerStatsField.setText("Correct guess! You can do it!");
            }
            try {

                wordToGuessField.setText(String.valueOf(correctLetter(letter,guessWord,allLetters,userName.getUser())));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!guessWord.contains(letter)) {
                playerLife = playerLife - 1;
                guessedLetterArea.append(letter);
                playerStatsField.setText("No " + letter + "! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
            }
            try {
                gameStatusController(userName.getUser(),letter);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The method set the correct letter in place in the array
     */
    public String correctLetter(String letter, String guessWord, ArrayList<Character> allLetters,  String user) throws Exception {
        char guess = letter.charAt(0);

        for (int i = 0; i < guessWord.length(); i++) {
            if (guess == guessWord.charAt(i)) {
                allLetters.set(i, guess);
            }
        }
        for(int i= 0; i < guessWord.length(); i++){
            allLetters.get(i);
        }
        String text = allLetters.toString().replace("[", "").replace("]", "").replace(",", "");
        return text;

    }
    /**
     This method checks if the game is over
     */
    private void gameStatusController(String user, String letter) throws Exception {


        if(victory == false && playerLife > 0){
            if (allLetters.contains('_')) {


            } else {

                playerStatsField.setText("Congratu1lations " + userName.getUser() + ". You are victorious!");
                JOptionPane.showMessageDialog(frame, "Congratulations " + user + ". You are victorious!","Game Over", JOptionPane.OK_OPTION);
                    Player.matchAdderCaller();
                    Player.winAdderCaller();
                if (playerLife == 10){
                        Player.flawlessAdderCaller();
                    JOptionPane.showMessageDialog(frame, "NO LIVES LOST! FLAWLESS VICTORY ACHIEVED!!!!!!" + user + " is a legend!","Game Over", JOptionPane.OK_OPTION);
                    System.out.println("\nNO LIVES LOST! FLAWLESS VICTORY ARCHIVED!!!!!!\n"  + userName.getUser() + " is a legend!");
                    playerStatsField.setText("NO LIVES LOST! FLAWLESS VICTORY ARCHIVED!!!!!! " + userName.getUser() + " is a legend!");
                }
                allLetters.clear();
                victory = true;
                frame.dispose();

                Menu.secondMenu(userName.getUser());
            }
        }

        if (playerLife == 0) {

//                System.out.print(Color.RED + "\nYou have been defeated! The word in question was: " + guessWord + "\n\nPress the Enter key to return to the main menu in shame");
            playerStatsField.setText("");
            JOptionPane.showMessageDialog(frame, "You have been defeated! The word in question was: " + guessWord,"Game Over", JOptionPane.OK_OPTION);

            allLetters.clear();
                Player.matchAdderCaller();
                Player.lossAdderCaller();
//
            victory = true;

            frame.dispose();
            Menu.secondMenu(userName.getUser());
        }


    }
    /**
     Randomizer uses a Math-random function to pick out a word from our "wordlist" at the top of "hangMan" method.
     */
    public static int randomizer(String [] randomArray){
        int rand = (int) (Math.random()*randomArray.length);
        return rand;
    }
    public static void startGame(String user) throws Exception {
        userName.setUser(user);

        new SinglePlayer();

    }

    public static void main(String[] args) throws Exception {
        new SinglePlayer();
    }


    /**
     This monstrosity of a method exists because I wish Java was easier...             //Julius Thomsen
     .. and it is not useful anymore. // The dude
     */

//    public static String characterDestroyer(String letter,ArrayList<Character>allLetters) {
//    if (!letter.isEmpty()) {
//        if (letter.contains("1")) {
//            System.out.println("You may not guess numbers!");
//        } else if (letter.contains("2")) {
//            System.out.println("You may not guess numbers!");
//        } else if (letter.contains("3")) {
//            System.out.println("You may not guess numbers!");
//        } else if (letter.contains("4")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("5")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("6")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("7")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("8")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("9")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("0")) {
//            System.out.println(Color.RED +"You may not guess numbers!");
//        } else if (letter.contains("!")) {
//            System.out.println(Color.RED +"You may not guess an exclamation point!");
//        } else if (letter.contains("?")) {
//            System.out.println(Color.RED +"You may not guess a question mark!");
//        } else if (letter.contains("#")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("¤")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("%")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("&")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("/")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("(")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains(")")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("=")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("*")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("-")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("+")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains(",")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains(".")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("<")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains(">")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("|")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("@")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("£")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("$")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("€")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("{")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("[")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("]")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("}")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("´´")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("\"")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains("\\")) {
//            System.out.println(Color.RED +"You may not guess a non-alphabetical character!");
//        } else if (letter.contains(" ")) {
//            System.out.println(Color.RED +"No whitespace!");
//        } else if (letter.isEmpty()) {
//            System.out.println(Color.RED +"No input was given!");
//        } else if (letter.contains("æ")) {
//            System.out.println(Color.RED +"Inga danskjävlar i spelet!");
//            System.exit(0);
//        } else if (letter.contains("ø")) {
//            System.out.println(Color.RED +"Inga danskjävlar i spelet!");
//            System.exit(0);
//        } else {
//            return letter;
//        }
//        for (int j = 0; j < allLetters.size(); j++) {
//            System.out.print(allLetters.get(j));
//        }
//
//    }
//        return null;
//    }
}
