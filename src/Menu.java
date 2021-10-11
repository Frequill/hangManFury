import java.util.Scanner;

class Menu{

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Hang man!!");
        show();
        Scanner choiceInput = new Scanner(System.in);

        String user = null;
        boolean run = true;

        while (run) {
            int choice = 1;

            try {
                choice = choiceInput.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1-3\n");
                choiceInput.nextLine();
                show();
            }

            if (choice == 1) {
                user = Player.readUsername(user);
                showPlusUser(user);
                break;
            }
                else if (choice == 2) {
                if (user == null) {
                    System.out.println("Please select a user first!!!!!!!\n(Press Enter to return to menu)");
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
                else if (choice < 1){
                System.out.println("Please enter a number greater than 0...");
                show();
               }
                else if (choice > 3){
                System.out.println("Please enter a number lower than 3...");
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

    static void getString(){

    }
    static void getAlpha(){

    }
    static void getInt(){

    }


}
