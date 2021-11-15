import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


class SinglePlayer extends SinglePlayerGUIHelper implements ActionListener {
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

    // Global instance variables
    private String guessWord = wordHolder[randomizer(wordHolder)].toUpperCase();
    private ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
    private int playerLife = 10;
    private boolean guessCorrect = false;
    private ArrayList<Character> dumbGuesses = new ArrayList();
    private String letter = null;
    private boolean victory = false;

    //Screen WxH
    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;


    //Button Array for gui keyboard
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


    /**
     Basic setup and settings for Single player GUI
     */
    SinglePlayer() throws Exception {

        //Frame
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

        //Inputted incorrect letter area
        guessedLetterArea = new JTextArea();
        guessedLetterArea.setBackground(Color.gray);
        guessedLetterArea.setForeground(Color.WHITE);
        guessedLetterArea.setPreferredSize(wordToGuessField.getPreferredSize());
        guessedLetterArea.setBorder(BorderFactory.createTitledBorder(null,"Previously guessed letters",0, 0, new Font(null, Font.PLAIN, 14),Color.WHITE));
        guessedLetterArea.setFont(new Font(null, Font.BOLD,20));
        guessedLetterArea.setEditable(false);

        //Right/Wrong and greeting messages for player
        playerStatsField = new JTextField("");
        playerStatsField.setPreferredSize(new Dimension(600,40));
        playerStatsField.setHorizontalAlignment(SwingConstants.CENTER);
        playerStatsField.setFont(new Font(null, Font.BOLD,14));
        playerStatsField.setBackground(new Color(94,80,250));
        playerStatsField.setForeground(new Color(0xFFFFFF));
        playerStatsField.setEditable(false);
        playerStatsField.setBorder(new LineBorder(Color.WHITE, 3, false));
        playerStatsField.setText("Welcome " + userName.getUser() + " guess the word that is " + guessWord.length() + " letters long!");


        //Button
        buttons = new JButton[buttonLettersArray.length];

        //Add components
        frame.add(headPanel);
        frame.add(bodyPanel);
        headPanel.add(wordToGuessField);
        headPanel.add(guessedLetterArea);
        headPanel.add(playerStatsField);


        letterButtons();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    /**
     * Creates letter buttons for user keyboard
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

    /**
     Takes player input and determines weather the guess was correct or incorrect.
     Take lives if guess was wrongful.
     */
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
     Reveals letters that have been correctly guessed by player
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

            }

            //Lets player win the game if the word has been fully revealed
            else {
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

                //Jumps back to main menu in terminal
                Menu.secondMenu(userName.getUser());
            }
        }

        //Makes player lose if they run out of lives *Sad violin*
        if (playerLife == 0) {
            playerStatsField.setText("");
            JOptionPane.showMessageDialog(frame, "You have been defeated! The word in question was: " + guessWord,"Game Over", JOptionPane.OK_OPTION);

            Player.matchAdderCaller();
            Player.lossAdderCaller();

            victory = true;
            frame.dispose();

            //Jumps back to main menu in terminal
            Menu.secondMenu(userName.getUser());
        }


    }



    /**
     Randomizer uses a Math-random function to pick out a word from our "wordlist" at the top of "singlePlayer" class.
     */
    public static int randomizer(String [] randomArray){
        int rand = (int) (Math.random()*randomArray.length);
        return rand;
    }



    /**
     startGame method starts the game and brings your username
     */
    public static void startGame(String user) throws Exception {
        userName.setUser(user);
        new SinglePlayer();
    }
}
