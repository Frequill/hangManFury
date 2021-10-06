import java.util.Scanner;

class Menu{

    public static void main(String[] args) throws Exception  {
        System.out.println("Welcome to Hang man!!");
        System.out.println("Please choose:");
        System.out.println("1) Select user");
        System.out.println("2) Let's plays!");
        Scanner choiceInput = new Scanner(System.in);
        int choice = choiceInput.nextInt();
        switch(choice){
            case 1:
                String user = Player.readUsername();
                System.out.println(user);
                break;
            case 2:
                System.out.println("You have choosen 2");
                break;
            default:
                System.out.println("NOOOOO!!");
        }
    }
}
