import java.util.ArrayList;
import java.util.Scanner;

class Menu{
    public static Scanner in = new Scanner(System.in);

    private int num;
    private String Alpha;
    private String sentence;
    private ArrayList<String> menuOptions = new ArrayList<>();

    public Menu(String name, int Int) {
        this.num = Int;
        String greeting = ("Welcome to the " + name + " menu!");
        String star = ("*");
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println("\n" + greeting);
        for (int j = 0; j < greeting.length(); j++){
            System.out.print(star);
        }
        System.out.println("\nPlease choose one of the following options:\nInput the corresponding number and mark with the Enter key");

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

    public int getNum() {
        return num;
    }
    public String getAlpha() {
        return Alpha;
    }

    public String getSentence() {
        return sentence;
    }

    //************************************* Menus **************************************

    public static void firstMenu() throws Exception {
        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0, "1) Select user");
        menu.getMenuOptions().add(1, "2) Play");
        menu.getMenuOptions().add(2, "3) Exit game...");
        menu.optionPrinter(menu.getMenuOptions());
        Menu.mainMenuFunction();
    }
    public static String secondMenu(String user) throws Exception{
        //Player matchSaver = new Player();
        //pickUser = matchSaver.getPickUserData();
        System.out.println("Selected profile: " + user);
        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0, "1) Change user ");
        menu.getMenuOptions().add(1, "2) Play");
        menu.getMenuOptions().add(2, "3) Exit game...");
        menu.optionPrinter(menu.getMenuOptions());
        return user;
    }

    public static String userNameMenu(String user) throws Exception{
        //Player matchSaver = new Player();
        //pickUser = matchSaver.getPickUserData();
        Menu menu = new Menu("user",2);
        menu.getMenuOptions().add(0, "1) Existing user");
        menu.getMenuOptions().add(1, "2) New user ");
        menu.optionPrinter(menu.getMenuOptions());
        user = Player.readUsername(user);
        return user;
    }

    //*********************************** Functions *************************************

    /**
     This method allows user to make inputs in the various menus. It also makes sure that a user is selected
     before the game itself launches.
     */

    public static void mainMenuFunction() throws Exception {
        String user = null;
        Scanner choiceInput = new Scanner(System.in);
        boolean run = true;
        int choice = 0;
        Player findPickUser = new Player();
        int pickUser = findPickUser.getPickUserData();

        while (run) {
            while(!choiceInput.hasNextInt()){
                System.out.println("\nPlease input an integer between 1 - 3:\n");
                choiceInput.next();
            }

            choice = choiceInput.nextInt();

            if (choice == 1) {
                user = userNameMenu(user);
                //System.out.println(matchSaver.getPickUserData());
                secondMenu(user);
            }
            else if (choice == 2) {
                if (user == null) {
                    System.out.println("\nPlease select a user first!!!!!!!\n(Press Enter to return to menu)");
                    choiceInput.nextLine();
                    choiceInput.nextLine();
                    firstMenu();
                } else {
                    Game.hangMan(user);
                    Player.saveMatch(pickUser);
                    secondMenu(user);
                }
            }
                else if (choice == 3) {
                System.out.println("Shutting down...");
                run = false;
            }
                else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 4:\n");
               }
            }
        }

    static void show() throws Exception{
    firstMenu();

    }
}
