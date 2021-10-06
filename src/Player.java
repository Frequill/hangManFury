import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) throws Exception {
       // readUsername();
        writeUsername();



    }
    static void writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter username ");
        String usersInput = in.nextLine();
        File toPlaceholder = new File("src/thePlaceholder.txt");
        PrintWriter output = new PrintWriter(toPlaceholder);
        output.println(usersInput);
        output.close();
        File usernames = new File("src/username.txt");

        Scanner scanner = new Scanner(new File("src/thePlaceholder.txt"));
        Scanner scanner2 = new Scanner(new File("src/username.txt"));
        String words = scanner.nextLine();
        String toUsername = scanner2.nextLine();

       // while (scanner.hasNextLine()){

         //   System.out.println(words);
      //  }
        scanner.close();

        for(int i = 0; i < words.length(); i++){
        PrintWriter out = new PrintWriter ("src/username.txt");
        out.println(  words  +  " " + toUsername );
        out.close();
        }


    }

    static void readUsername() throws Exception {
        System.out.println("Welcome!\nPlease add new user\nOr select existing user: ");
        File usernames = new File("src/username.txt");
        Scanner readUsernames = new Scanner(usernames);

        while (readUsernames.hasNextLine()){
            String linePrinter = readUsernames.nextLine();
            System.out.println("\n" + linePrinter);
        }

    }
}
