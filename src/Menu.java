import java.util.Scanner;

class Menu{
    public static Scanner in = new Scanner(System.in);
    private int Int;
    private char Alpha;
    private String String;

    public int getInt() {
        boolean run = true;
        while (run) {
            while (!in.hasNext) {
                    System.out.println("Please input a number: ");
                    in.next();
            }
            Int = in.nextInt();
            run = false;
        }
        return Int;
    }


    public char getAlpha() {
        Alpha = in.next().charAt(0);

        return Alpha;
    }

    public String getString() {
        String = in.nextLine();
        return String;
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
