import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Menu extends JFrame implements ActionListener {
    public static Scanner in = new Scanner(System.in);

    //*************************************** Instance variables and menu object **************************************


    private final ArrayList<String> menuOptions = new ArrayList<>();

    //GUI
    JPanel headPanel, bodyPanel;
    JLabel menuTitle;


    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;

    //Default constructor
    Menu(){}

    // Menu Constructor
    public Menu(String name, int Int) {

        //frame settings

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));
        setVisible(true);

        //Panels
        headPanel = new JPanel();

        bodyPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,1);
        gridLayout.setVgap(10);
        bodyPanel.setLayout(gridLayout);
        bodyPanel.setBorder(new EmptyBorder(0,100,0,100));

        //Labels
        menuTitle = new JLabel("Hangman");
        menuTitle.setFont(new Font(null, Font.BOLD, 40));


        //Buttons
//        = new JButton();

        //Adds all components
        add(headPanel);
        add(bodyPanel);
        headPanel.add(menuTitle);

        for (int i = 0; i < menuOptions.size(); i++){

            System.out.print(menuOptions.get(i));
        }

    }


    /**
     * Prints out a menu from the "menuOptions" arraylist
     */
    public void menuPrinter(ArrayList<String> menuOptions) throws Exception {

        for(int i = 0; i< getMenuOptions().size(); i++) {
            bodyPanel.add(new JButton(menuOptions.get(i)));

        }
    }

    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }


    public static String [] userOptions = {"Add user 1", "Add user 2", "Add user 3", "Add user 4"};


    public String[] getUserOptions(){return userOptions;}




    //************************************************ Menus ************************************************

    public static void amountOfPlayersMenu() throws Exception {
        Menu menu = new Menu("add user",5);
        String[] split = menu.getUserOptions()[0].split(" ", 6);
        String[] split2 = menu.getUserOptions()[1].split(" ", 6);
        String[] split3 = menu.getUserOptions()[2].split(" ", 6);
        String[] split4 = menu.getUserOptions()[3].split(" ", 6);
"main",4

        // Splits of stats from usernames
        System.out.println("You can add up to four users to play multiplayer!");
        if (menu.getUserOptions()[3] != "Add user 4") {
            menu.getMenuOptions().add(0,  "4) " + split4[0]);
        }
        else{
            menu.getMenuOptions().add(0,  "4) " + menu.getUserOptions()[3]);
        }

        if (menu.getUserOptions()[2] != "Add user 3") {
            menu.getMenuOptions().add(0,"3) " + split3[0]);
        }
        else{
            menu.getMenuOptions().add(0,"3) " + menu.getUserOptions()[2]);
        }

        if (menu.getUserOptions()[1] != "Add user 2") {
            menu.getMenuOptions().add(0,"2) " + split2[0]);
        }
        else{
            menu.getMenuOptions().add(0,"2) " +  menu.getUserOptions()[1]);
        }

        if (menu.getUserOptions()[0] != "Add user 1") {
            menu.getMenuOptions().add(0,"1) " + split[0]);
        }
        else{
            menu.getMenuOptions().add(0,"1) " + menu.getUserOptions()[0]);
        }

        menu.getMenuOptions().add(4,"5) " + "Back");
        menu.menuPrinter(menu.getMenuOptions());
        Menu.selectUsersFunction();

    }
    public static void firstMenu() throws Exception {

        Menu menu = new Menu("main",4);
        menu.getMenuOptions().add(0,   "Select user");
        menu.getMenuOptions().add(1,   "Play");
        menu.getMenuOptions().add(2,   "High score list ");
        menu.getMenuOptions().add(3,   "Exit game");
        menu.menuPrinter(menu.getMenuOptions());
        Menu.mainMenuFunction();
    }
    public static String secondMenu(String user) throws Exception{
        String [] splitUser = user.split(" ",4);
        System.out.println("Selected profile: " + splitUser[0]);
        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0,   "Change user ");
        menu.getMenuOptions().add(1,   "Play");
        menu.getMenuOptions().add(2,   "High score list ");
        menu.getMenuOptions().add(3,   "Exit game...");
        menu.menuPrinter(menu.getMenuOptions());
        return user;
    }

    public static String userNameMenu(String user) throws Exception{
        Menu menu = new Menu("user",3);
        menu.getMenuOptions().add(0,   "Existing user");
        menu.getMenuOptions().add(1,   "New user ");
        menu.getMenuOptions().add(2,  "Back");
        menu.menuPrinter(menu.getMenuOptions());
        user = Player.readUsername(user);
        return user;
    }

    //******************************************** Functions ***********************************************
    //   (This is how the menus work)
    /**
     This method allows user to make inputs in the various menus. It also makes sure that a user is selected
     before the game itself launches.
     */

    public static void mainMenuFunction() throws Exception  {
        Menu userGetter = new Menu();
        String user1 = userGetter.getUserOptions()[0];
        String user2 = userGetter.getUserOptions()[1];
        String user3 = userGetter.getUserOptions()[2];
        String user4 = userGetter.getUserOptions()[3];

        Scanner choiceInput = new Scanner(System.in);
        boolean run = true;
        int choice = 0;

        while (run) {
            while (!choiceInput.hasNextInt()) {
                System.out.println("\nPlease input an integer between 1 - 3:\n");
                choiceInput.next();

            }
            choice = choiceInput.nextInt();

            if (choice == 1) {
                amountOfPlayersMenu();
            } else if (choice == 2) {
                if (user1 == "Add user 1") {
                    System.out.println( "\nPlease select a user first!!!!!!!" + "\n(Press Enter to return to menu)");
                    JOptionPane.showMessageDialog(null,"Please select a user first!!!");
                    choiceInput.nextLine();
                    choiceInput.nextLine();

                } else {
                    if (user2 == "Add user 2") {
                        new Game();
                        Game.hangMan(user1);
                        secondMenu(user1);
                    } else if (user3 == "Add user 3") {
                        Multiplayer.hangMan(user1, user2, null, null);
                        firstMenu();
                    } else if (user4 == "Add user 4") {
                        Multiplayer.hangMan(user1, user2, user3, null);
                        firstMenu();
                    } else if (user4 != "Add user 4") {
                        Multiplayer.hangMan(user1, user2, user3, user4);
                        firstMenu();
                    }
                }
            } else if (choice == 3) {
                File highScorePath = new File("src/highScoreList.txt");
                Scanner readHighscore = new Scanner(highScorePath);

                ArrayList<String> highScoreList = new ArrayList<>();
                while (readHighscore.hasNextLine()) {
                    highScoreList.add(readHighscore.nextLine());
                }
                System.out.println("HIGH SCORE LIST");
                for(int i = 0; i < highScoreList.size(); i++){
                    System.out.println((i+1) + ") " + highScoreList.get(i) + ":Points");
                }
                System.out.println( "6)"  + " Back");
                boolean run2 = true;
                while (run2) {
                    while (!in.hasNextInt()) {
                        System.out.println("Please input the inger 6:");
                        in.next();
                    }
                    if (in.nextInt() == 6) {
                        firstMenu();
                        run2 = false;
                    } else {
                        System.out.println("Please input the inger 6:");
                    }
                }

            }
            else if (choice == 4) {
                System.out.println("Shutting down...");
                int quitOption = JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,null,0);
                if (quitOption == 0) {
                    System.exit(0);
                }
            }
            else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 4:\n");
            }
        }
    }
    public static void selectUsersFunction() throws Exception {
       Menu menu = new Menu();

        String user1 = null;
        String user2 = null;
        String user3 = null;
        String user4 = null;

        String[] defaultAddUserOptions = menu.getUserOptions();
        boolean run = true;
        int choice;
        while (run) {
            while(!in.hasNextInt()){
                System.out.println( "I did not understand that:");
                in.next();
            }
            choice = in.nextInt();
            if (choice == 1) {

                user1 = userNameMenu(user1);
                defaultAddUserOptions[0] = user1;
                amountOfPlayersMenu();
            } else if (choice == 2) {
                if (defaultAddUserOptions[0] == "Add user 1") {
                    System.out.println("Please add user 1 first");
                } else {
                    user2 = userNameMenu(user2);
                    defaultAddUserOptions[1] = user2;
                    amountOfPlayersMenu();
                }
            } else if (choice == 3) {
                if (defaultAddUserOptions[1] == "Add user 2") {
                    System.out.println("Please add user 2 first");
                } else {
                    user3 = userNameMenu(user3);
                    defaultAddUserOptions[2] = user3;
                    amountOfPlayersMenu();
                }
            } else if (choice == 4) {
                if (defaultAddUserOptions[2] == "Add user 3") {
                    System.out.println("Please add user 3 first");
                } else {
                    user4 = userNameMenu(user4);
                    defaultAddUserOptions[3] = user4;
                    amountOfPlayersMenu();
                }
            }
            else if (choice == 5){
                firstMenu();
                run = false;
            }
            else{
                if(choice < 1){
                    System.out.println( "You must select a *integer* greater than 0");
                }
                else if(choice > 5){
                    System.out.println( "You must select a *integer* lower than 6");
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuOptions.get(0)){
            System.out.println("ggg");
        }
    }
}
class
