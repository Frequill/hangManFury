import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Menu{
    public static Scanner in = new Scanner(System.in);

    //*************************************** Instance variables and menu object **************************************

    private int num;
    private String Alpha;
    private String sentence;
    private ArrayList<String> menuOptions = new ArrayList<>();


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

    public static void firstMenu() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Datum: " + dtf.format(now));

        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+ "Select user");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "Play");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "Exit game...");
        menu.optionPrinter(menu.getMenuOptions());
        Menu.mainMenuFunction();
    }
    public static String secondMenu(String user) throws Exception{
        String [] splitUser = user.split(" ",4);
        System.out.println("Selected profile: " + splitUser[0]);
        Menu menu = new Menu("main",3);
        menu.getMenuOptions().add(0, Color.YELLOW + "1) " + Color.RESET+  "Change user ");
        menu.getMenuOptions().add(1, Color.YELLOW + "2) " + Color.RESET+ "Play");
        menu.getMenuOptions().add(2, Color.YELLOW + "3) " + Color.RESET+ "Exit game...");
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

    /**
     This method allows user to make inputs in the various menus. It also makes sure that a user is selected
     before the game itself launches.
     */

    public static void mainMenuFunction() throws Exception {
        String user = null;
        Scanner choiceInput = new Scanner(System.in);
        boolean run = true;
        int choice = 0;

        while (run) {
            while(!choiceInput.hasNextInt()){
                System.out.println(Color.RED +"\nPlease input an integer between 1 - 3:\n" + Color.RESET);
                choiceInput.next();
            }
            choice = choiceInput.nextInt();

            if (choice == 1) {
                user = userNameMenu(user);
                secondMenu(user);
            }
            else if (choice == 2) {
                if (user == null) {
                    System.out.println(Color.RED + "\nPlease select a user first!!!!!!!" + Color.RESET + "\n(Press Enter to return to menu)");
                    choiceInput.nextLine();
                    choiceInput.nextLine();
                    show();
                } else {
                    Game.hangMan(user);
                    secondMenu(user);
                }
            }
                else if (choice == 3) {
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
}
