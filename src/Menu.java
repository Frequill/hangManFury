import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Menu extends MultiPlayer {
    public static Scanner in = new Scanner(System.in);

    //*************************************** Instance variables and menu object **************************************

    private int num;
    private String Alpha;
    private String sentence;
    private ArrayList<String> menuOptions = new ArrayList<>();

    /**
     Menu object that allows us to call menu without having to build a whole new menu
     */
    public Menu(){}

    /**
     Menu object that allows the user to make a menu from an object. Thanks, Bill.
     */
    public Menu(String name, int Int) {
        this.num = Int;
        String greeting = "Welcome to the " + name + " menu!";
        String star = (Color.YELLOW + "*" + Color.RESET);
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println("\n" + Color.GREEN + Color.BLACKGROUND + greeting + Color.RESET);
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println( "\n" + Color.BLACKGROUND + Color.BLUE + "Please choose one of the following options:" + Color.RESET + "\n" + Color.BLACKGROUND + Color.BLUE + "Input the corresponding number," + Color.RESET + "\n" + Color.BLACKGROUND + Color.BLUE + "mark with the Enter key" + Color.RESET );

        System.out.println();
        for (int i = 0; i < menuOptions.size(); i++){
            System.out.print(menuOptions.get(i));
        }
    }

    /**
     Prints options of menu to user
     */
    public void optionPrinter (ArrayList<String> menuOptions){
        for (int i = 0; i < menuOptions.size(); i++){
            System.out.println(menuOptions.get(i));
        }
    }

    public ArrayList<java.lang.String> getMenuOptions() {
        return menuOptions;
    }

    public static String [] userOptions = {"Add user 1", "Add user 2", "Add user 3", "Add user 4"};
    public String[] getUserOptions(){return userOptions;}


    //Thanks, Bill
    // ****************************************** Bill's bad ideas *****************************************
    public int getNum() {
        return num;
    }

    public String getAlpha() {
        return Alpha;
    }

    public String getSentence() {
        return sentence;
    }
    //******************************************************************************************************







    //***************************************** Menus that we use ******************************************
    public static void amountOfPlayersMenu() throws Exception {
        Menu menu = new Menu("add user",5);
        String[] split = menu.getUserOptions()[0].split(" ", 6);
        String[] split2 = menu.getUserOptions()[1].split(" ", 6);
        String[] split3 = menu.getUserOptions()[2].split(" ", 6);
        String[] split4 = menu.getUserOptions()[3].split(" ", 6);


        if (Player.modifyX.getPickUserData1() == -1){
            menu.getUserOptions()[0] = "Add user 1";
            menu.getUserOptions()[1] = "Add user 2";
            menu.getUserOptions()[2] = "Add user 3";
            menu.getUserOptions()[3] = "Add user 4";
        }


        // Splits of stats from usernames
        System.out.println(Color.YELLOW + "You can add up to four users to play multiplayer!" + Color.RESET);
        if (menu.getUserOptions()[3] != "Add user 4") {
            menu.getMenuOptions().add(0, Color.YELLOW + "4) " + Color.RESET+ split4[0]);
        }
        else{
            menu.getMenuOptions().add(0, Color.YELLOW + "4) " + Color.RESET+ menu.getUserOptions()[3]);
        }

        if (menu.getUserOptions()[2] != "Add user 3") {
            menu.getMenuOptions().add(0, Color.YELLOW + "3) " + Color.RESET+ split3[0]);
        }
        else{
            menu.getMenuOptions().add(0, Color.YELLOW + "3) " + Color.RESET+ menu.getUserOptions()[2]);
        }

        if (menu.getUserOptions()[1] != "Add user 2") {
            menu.getMenuOptions().add(0, Color.YELLOW + "2) " + Color.RESET+ split2[0]);
        }
        else{
            menu.getMenuOptions().add(0, Color.YELLOW + "2) " + Color.RESET+ menu.getUserOptions()[1]);
        }

        if (menu.getUserOptions()[0] != "Add user 1") {
            menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ split[0]);
        }
        else{
            menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ menu.getUserOptions()[0]);
        }

        menu.getMenuOptions().add(4,Color.YELLOW + "5) " + Color.RESET+ Color.PURPLE +"Clear selected users" + Color.RESET);

        menu.getMenuOptions().add(5,Color.YELLOW + "6) " + Color.RESET+ Color.RED +"Delete user" + Color.RESET);

        menu.getMenuOptions().add(6, Color.YELLOW + "7) " + Color.RESET+ Color.CYAN + "Back" + Color.RESET);
        menu.optionPrinter(menu.getMenuOptions());
        Menu.selectUsersFunction();

    }
    public static void firstMenu() throws Exception {
        Menu menu = new Menu("main",5);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ "Select user");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "New game");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "Load game ");
        menu.getMenuOptions().add(3, Color.YELLOW + "4) " + Color.RESET+ "High score list ");
        menu.getMenuOptions().add(4, Color.YELLOW + "5) " + Color.RESET+ Color.RED+"Exit game..." + Color.RESET);
        menu.optionPrinter(menu.getMenuOptions());
        Menu.mainMenuFunction();
    }
    public static String secondMenu(String user) throws Exception{
        String [] splitUser = user.split(" ",4);
        System.out.println("Selected profile: " + splitUser[0]);
        Menu menu = new Menu("main",5);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+  "Change user ");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "New game");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "load game...");
        menu.getMenuOptions().add(3, Color.YELLOW + "4) " + Color.RESET+ "High score list ");
        menu.getMenuOptions().add(4, Color.YELLOW + "5) " + Color.RESET+ Color.RED+ "Exit game..." + Color.RESET);
        menu.optionPrinter(menu.getMenuOptions());
        return user;
    }
    public static String userNameMenu(String user, int choice) throws Exception{
        Menu menu = new Menu();
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ "Existing user");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "New user ");
        menu.getMenuOptions().add(2,Color.YELLOW + "3) " + Color.RESET+ Color.CYAN + "Back" + Color.RESET);
        menu.optionPrinter(menu.getMenuOptions());
        user = Player.readUsername(user, choice);
        return user;
    }

    /* ******************************************* Functions ***********************************************
    This is how the menus work                                                                            */

    /**
     Allows the player or players to select how many users they want and which users they want.
     */
    public static void selectUsersFunction() throws Exception {
       Menu menu = new Menu();

        // user1, 2, 3 and 4 are initially set to NULL and are later changed based on how many users are selected
        String user1 = null;
        String user2 = null;
        String user3 = null;
        String user4 = null;


        String[] defultAddUserOptions = menu.getUserOptions();
        boolean run = true;
        int choice;
        while (run) {
            while(!in.hasNextInt()){
                System.out.println(Color.RED + "I did not understand that:" + Color.RESET);
                in.next();
            }
            choice = in.nextInt();
            if (choice == 1) {

                if(Player.modifyX.getPickUserData1() != -1){} //Just leave this alone!


                /* Actual menu where every option changes from "Add user1, 2, 3 or 4" to the actual username
                that the user choose. Really cool idea!                                                   */
                user1 = userNameMenu(user1, choice);
                defultAddUserOptions[0] = user1;
                amountOfPlayersMenu();
            } else if (choice == 2) {
                if (defultAddUserOptions[0] == "Add user 1") {
                    System.out.println("Please select at least a single user first!");
                } else {
                    user2 = userNameMenu(user2, choice);
                    defultAddUserOptions[1] = user2;
                    amountOfPlayersMenu();
                }
            } else if (choice == 3) {
                if (defultAddUserOptions[1] == "Add user 2") {
                    System.out.println("Please add user 2 first");
                } else {
                    user3 = userNameMenu(user3, choice);
                    defultAddUserOptions[2] = user3;
                    amountOfPlayersMenu();
                }
            } else if (choice == 4) {
                if (defultAddUserOptions[2] == "Add user 3") {
                    System.out.println("Please add user 3 first");
                } else {
                    user4 = userNameMenu(user4, choice);
                    defultAddUserOptions[3] = user4;
                    amountOfPlayersMenu();
                }

            // Allows user to clear all selected players with one button
            } else if (choice == 5){
                defultAddUserOptions[0] = "Add user 1"; defultAddUserOptions[1] = "Add user 2";
                defultAddUserOptions[2] = "Add user 3"; defultAddUserOptions[3] = "Add user 4";
                amountOfPlayersMenu();
            }
            else if (choice == 6) {
                Player.deleteUser();
            }
            else if (choice == 7){
                firstMenu();
                run = false;
            }
            else{
                if(choice < 1){
                    System.out.println(Color.RED + "You must select a *integer* greater than 0" + Color.RESET);
                }
                else if(choice > 5){
                    System.out.println(Color.RED + "You must select a *integer* lower than 6" + Color.RED);
                }
            }
        }

    }

    /**
     Loads in previously saved users when a game is loaded so that you don't have to reselect the same users
     again if you want to play one more time afterwards
     */
    public static void loadUsersFunction(String user1, String user2, String user3, String user4) throws Exception {
        Menu menu = new Menu();

        String[] defultAddUserOptions = menu.getUserOptions();

        defultAddUserOptions[0] = user1;
        defultAddUserOptions[1] = user2;

        if(user3 == null){

        }
        else if (user4 == null){
            defultAddUserOptions[2] = user3;
        }
        else if(user4 != null){
            defultAddUserOptions[2] = user3;
            defultAddUserOptions[3] = user4;
        }
    }






    /**
     This method allows user to make inputs in the various menus. It also makes sure that a user is selected
     before the game itself launches.
     */

    public static void mainMenuFunction() throws Exception {
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
                System.out.println(Color.RED + "\nPlease input an integer between 1 - 5:\n" + Color.RESET);
                choiceInput.next();
            }
            choice = choiceInput.nextInt();

            if (choice == 1) {
                amountOfPlayersMenu();
            } else if (choice == 2) {
                if (user1 == "Add user 1") {
                    System.out.println(Color.RED + "\nPlease select a user1 first!!!!!!!" + Color.RESET + "\n(Press Enter to return to menu)");
                    choiceInput.nextLine();
                    choiceInput.nextLine();
                    Menu.firstMenu();
                } else {
                    if (user2 == "Add user 2") {
                        modify.setHasSeenLoadMenu(0);
                        SinglePlayer.startGame(user1);
                        secondMenu(user1);
                    } else if (user3 == "Add user 3") {
                        modify.setHasSeenLoadMenu(0);
                        MultiPlayer.hangMan(user1, user2, null, null);
                        firstMenu();
                    } else if (user4 == "Add user 4") {
                        modify.setHasSeenLoadMenu(0);
                        MultiPlayer.hangMan(user1, user2, user3, null);
                        firstMenu();
                    } else if (user4 != "Add user 4") {
                        modify.setHasSeenLoadMenu(0);
                        MultiPlayer.hangMan(user1, user2, user3, user4);
                        firstMenu();
                    }
                }
            }
            else if(choice == 3){
                File savedGame = new File("src/lastSavedGame.txt");
                if (savedGame.length() == 0){
                    System.out.println("No saved game detected");
                    System.out.println("(Press Enter to return to main menu)");
                    in.nextLine();
                    firstMenu();
                }
                else{
                    modify.setHasSeenLoadMenu(1);
                    LoadGame.gameLoader();
                    //modify.setHasSeenLoadMenu(0);
                }
            }
            else if (choice == 4) {
                File highScorePath = new File("src/highScoreList.txt");
                Scanner readHighscore = new Scanner(highScorePath);

                ArrayList<String> highScoreList = new ArrayList<>();
                while (readHighscore.hasNextLine()) {
                    highScoreList.add(readHighscore.nextLine());
                }
                System.out.println(Color.YELLOW + "HIGH SCORE LIST" + Color.RESET);
                for(int i = 0; i < highScoreList.size(); i++){
                    System.out.println(Color.YELLOW + (i+1) + ") " + Color.RESET + highScoreList.get(i) + ":Points");
                }
                System.out.println(Color.YELLOW  + "6)" + Color.RESET + Color.BLUE + " Back" + Color.RESET);
                boolean run2 = true;
                while (run2) {
                    while (!in.hasNextInt()) {
                        System.out.println(Color.RED + "Please input the inger 6:" + Color.RESET);
                        in.next();
                    }
                    if (in.nextInt() == 6) {
                        firstMenu();
                        run2 = false;
                    } else {
                        System.out.println(Color.RED + "Please input the inger 6:" + Color.RESET);
                    }
                }

            }

        else if (choice == 5) {
                System.out.println( Color.RED + "Shutting down..." + Color.RESET);
                System.exit(0);
            }
                else {
                System.out.println(Color.RED + "\nPlease enter an *integer* greater than 0 and lower than 6:\n" + Color.RESET);
               }
            }
        }
}
