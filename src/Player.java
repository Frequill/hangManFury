import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) throws Exception {
        readUsername();
        writeUsername();




    }
    static void writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        String usersInput= in.nextLine();
        File toPlaceholder = new File("src/placeholder.txt");
        PrintWriter output = new PrintWriter(toPlaceholder);
        output.println(usersInput);
        output.close();
        File usernames = new File("src/username.txt");
        // Make while loop that prints every line from placeholder.txt to username.txt
        while (){

        }
    }


    static void readUsername() throws Exception {
        System.out.println("Welcome!\nPlease input username\nOr select existing user: ");
        File usernames = new File("src/username.txt");
        Scanner readUsernames = new Scanner(usernames);

        while (readUsernames.hasNextLine()){
            String linePrinter = readUsernames.nextLine();
            System.out.println("\n" + linePrinter);
        }

    }
}