import java.util.Scanner;

class Menu{

    public static void main(String[] args) throws Exception  {

        show();
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
    static void show(){
        System.out.println("Welcome to Hang man!!");
        System.out.println("Please choose:");
        System.out.println("1) Select user");
        System.out.println("2) Let's plays!");
    }
    static void getString(){

    }
    static void getAlpha(){

    }
    static void getInt(){

    }

}
