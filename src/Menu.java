import java.util.Scanner;

class Menu{

    public static void main(String[] args) throws Exception  {
        System.out.println("Welcome to Hang man!!");
        show();
        Scanner choiceInput = new Scanner(System.in);

        String user = null;
        boolean run = true;
        while(run) {
            int choice = choiceInput.nextInt();
            switch (choice) {
                case 1:
                    user = Player.readUsername(user);
                    showPlusUser(user);
                    break;
                case 2:
                    if (user== null) {
                        System.out.println("Please select a user first!!!!!!!\n(Press Enter to return to menu)");
                        choiceInput.nextLine();
                        choiceInput.nextLine();
                        show();

                    } else {
                        Game.hangMan(user);
                    }
                    break;
                case 3:
                    System.out.println("Thank you for playing!!");
                    run = false;
                    break;
                default:
                    System.out.println("NOOOOO!!");
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
