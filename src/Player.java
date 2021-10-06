import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) throws Exception {
        readUsername();
    }



    /**
    This method stores different usernames in a textile for later use
     */

    static void writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String usersInput = in.nextLine();

        File toPlaceholder = new File("src/thePlaceholder.txt");
        File toUsername = new File("src/username.txt");

        //This Printwriter stores the users username in the "thePlaceholder" textfile
        PrintWriter output = new PrintWriter(toPlaceholder);
        output.println(usersInput);
        output.close();

        Scanner readPlaceholder = new Scanner(toPlaceholder);
        Scanner readUsername = new Scanner(toUsername);
        String newUsername = readPlaceholder.nextLine();
        String usernameSaver = readUsername.nextLine();
        readPlaceholder.close();

        for(int i = 0; i < newUsername.length(); i++){
        PrintWriter out = new PrintWriter ("src/username.txt");
        out.println( newUsername  +  " " + usernameSaver );
        out.close();
        }
    }



    /**
     This method shows the user all available usernames and allows user to select an already existing username
     */

    static void readUsername() throws Exception {
        System.out.println("Please choose: \n1) Existing users\n2) Create new user");
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        if (userChoice == 1){
            File usernames = new File("src/username.txt");
            Scanner readUsernames = new Scanner(usernames);


            while (readUsernames.hasNextLine()){
                String linePrinter = readUsernames.nextLine();
                System.out.println("\n" + linePrinter);
            }
        }
        else if (userChoice == 2){
            writeUsername();
        }
        else {
            System.out.println("VAFAN GÖRRU???");
        }


    }
}
