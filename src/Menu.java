import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Menu{
    public static Scanner in = new Scanner(System.in);

    //*************************************** Instance variables and menu object **************************************

    private int num;
    private String Alpha;
    private String sentence;
    private ArrayList<String> menuOptions = new ArrayList<>();


    public Menu(){

    }

    public Menu(String name, int Int) {
        this.num = Int;
        String greeting = (Color.BLUE + "Welcome to the " + name + " menu!" + Color.RESET);
        String star = (Color.YELLOW + "*" + Color.RESET);
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println("\n" + greeting);
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println( "\nPlease choose one of the following options:\nInput the corresponding number and mark with the Enter key" );

        System.out.println();
        for (int i = 0; i < menuOptions.size(); i++){
            System.out.print(menuOptions.get(i));
        }
    }
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


    public int getNum() {
        return num;
    }

    public String getAlpha() {
        return Alpha;
    }

    public String getSentence() {
        return sentence;
    }

    //************************************************ Menus ************************************************

    public static void amountOfPlayersMenu() throws Exception {
        Menu menu = new Menu("add user",5);
        String[] split = menu.getUserOptions()[0].split(" ", 6);
        String[] split2 = menu.getUserOptions()[1].split(" ", 6);
        String[] split3 = menu.getUserOptions()[2].split(" ", 6);
        String[] split4 = menu.getUserOptions()[3].split(" ", 6);



        // Splits of stats from usernames
        System.out.println("You can add up to four users to play multiplayer!");
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

        menu.getMenuOptions().add(4, Color.YELLOW + "5) " + Color.RESET+ "Back");
        menu.optionPrinter(menu.getMenuOptions());
        Menu.selectUsersFunction();

    }
    public static void firstMenu() throws Exception {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println("Datum: " + dtf.format(now));

        Menu menu = new Menu("main",4);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ "Select user");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "Play");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "High score list ");
        menu.getMenuOptions().add(3, Color.YELLOW + "4) " + Color.RESET+ "Exit game...");
        menu.optionPrinter(menu.getMenuOptions());
        Menu.mainMenuFunction();
    }
    public static String secondMenu(String user) throws Exception{
        String [] splitUser = user.split(" ",4);
        System.out.println("Selected profile: " + splitUser[0]);
        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+  "Change user ");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "Play");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "High score list ");
        menu.getMenuOptions().add(3, Color.YELLOW + "4) " + Color.RESET+ "Exit game...");
        menu.optionPrinter(menu.getMenuOptions());
        return user;
    }

    public static String userNameMenu(String user) throws Exception{
        Menu menu = new Menu("user",3);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ "Existing user");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "New user ");
        menu.getMenuOptions().add(2,Color.YELLOW + "3) " + Color.RESET+ "Back");
        menu.optionPrinter(menu.getMenuOptions());
        user = Player.readUsername(user);
        return user;
    }

    //******************************************** Functions ***********************************************
    //   (This is how the menus work)

    public static void selectUsersFunction() throws Exception {
       Menu menu = new Menu();

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

                user1 = userNameMenu(user1);
                defultAddUserOptions[0] = user1;
                amountOfPlayersMenu();
            } else if (choice == 2) {
                if (defultAddUserOptions[0] == "Add user 1") {
                    System.out.println("Please select at least a single user first!");
                } else {
                    user2 = userNameMenu(user2);
                    defultAddUserOptions[1] = user2;
                    amountOfPlayersMenu();
                }
            } else if (choice == 3) {
                if (defultAddUserOptions[1] == "Add user 2") {
                    System.out.println("Please add user 2 first");
                } else {
                    user3 = userNameMenu(user3);
                    defultAddUserOptions[2] = user3;
                    amountOfPlayersMenu();
                }
            } else if (choice == 4) {
                if (defultAddUserOptions[2] == "Add user 3") {
                    System.out.println("Please add user 3 first");
                } else {
                    user4 = userNameMenu(user4);
                    defultAddUserOptions[3] = user4;
                    amountOfPlayersMenu();
                }
            }
            else if (choice == 5){
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
                System.out.println(Color.RED + "\nPlease input an integer between 1 - 3:\n" + Color.RESET);
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
                    show();
                } else {
                    if (user2 == "Add user 2") {
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
                System.out.println(Color.YELLOW + "HIGH SCORE LIST" + Color.RESET);
                for(int i = 0; i < highScoreList.size(); i++){
                    System.out.println(Color.YELLOW + (i+1) + ") " + Color.RESET + highScoreList.get(i) + ":Points");
                }
                System.out.println(Color.YELLOW  + "6)" + Color.RESET + Color.GREEN + " Back" + Color.RESET);
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
        else if (choice == 4) {
                System.out.println( Color.RED + "Shutting down..." + Color.RESET);
                System.exit(0);
            }
                else {
                System.out.println(Color.RED + "\nPlease enter an *integer* greater than 0 and lower than 4:\n" + Color.RESET);
               }
            }
        }

    /**
     Shows first menu because Bill says to make it so!
     */
    static void show() throws Exception{
    firstMenu();
    }
    public static void showData() {
        System.out.println(Arrays.toString(userOptions));
    }
}
