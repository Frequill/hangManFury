import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome!\nPlease input username\nOr select existing user: ");
        File usernames = new File("src/username.txt");
        Scanner readUsernames = new Scanner(usernames);

        while (readUsernames.hasNextLine()){
            String linePrinter = readUsernames.nextLine();
            System.out.println("\n" + linePrinter);
        }



    }
}