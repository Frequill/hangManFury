import java.util.ArrayList;
import java.util.Scanner;

class Menu{
    public static Scanner in = new Scanner(System.in);
    private int Int;
    private char Alpha;
    private ArrayList<String> menuOptions = new ArrayList<>();
    private String String;

    public Menu(String name, int Int) {
        this.Int = Int;
        String greeting = ("Welcome to the " + name + " menu!");
        String star = ("*");
        for (int j = 0; j < greeting.length()+2; j++){
            System.out.print(star);
        }
        System.out.println("\n" + greeting);
        for (int j = 0; j < greeting.length()+2; j++){
            System.out.print(star);
        }
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

    public int getInt() {
        return Int;
    }

    public char getAlpha() {
        boolean run = true;
        while(run){
            while(!in.hasNextLine()) {
                System.out.println("Skriv in en bokstav");
                in.nextLine();
            }

            Alpha = in.next().charAt(0);

            run = false;
        }



        return Alpha;
    }

    public String getString() {
       boolean run = true;
       String input = null;
       while(run){
           try{
               run = false;
           }catch(Exception e){
               System.out.println("Det här är fucking dåligt gjort");
               in.nextLine();
           }
           input = in.nextLine();

       }
        return input ;
    }

    /*public Menu(int anInt, char alpha, java.lang.String string) {
        Int = anInt;
        Alpha = alpha;
        String = string;
    }*/

    public static void main(String[] args) throws Exception {
        System.out.println("********************\nWelcome to Hang man!\n********************");
        show();




        Scanner choiceInput = new Scanner(System.in);

        String user = null;
        boolean run = true;
        int choice = 0;

        while (run) {
            while(!choiceInput.hasNextInt()){
                System.out.println("\nPlease input a number between 1 - 3:\n");
                show();
                choiceInput.next();
            }

            choice = choiceInput.nextInt();

            if (choice == 1) {
                user = Player.readUsername(user);
                showPlusUser(user);
            }

                else if (choice == 2) {
                if (user == null) {
                    System.out.println("\nPlease select a user first!!!!!!!\n(Press Enter to return to menu)");
                    choiceInput.nextLine();
                    choiceInput.nextLine();
                    show();
                } else {
                    Game.hangMan(user);
                }
                break;
            }
                else if (choice == 3) {
                System.out.println("Shutting down...");
                run = false;
                break;
            }
                else {
                System.out.println("\nPlease enter a *number* greater than 0 and lower than 4:\n");
                show();
               }
            }
        }

    static void show(){
        System.out.println("Please choose:");
        System.out.println("1) Select user");
        System.out.println("2) Let's plays!");
        System.out.println("3) Exit game");
    }
    static void showPlusUser(String user){
        System.out.println("Selected profile: " + user);
        System.out.println("Please choose:");
        System.out.println("1) Change user:");
        System.out.println("2) Let's play!");
        System.out.println("3) Exit game");
    }
}
