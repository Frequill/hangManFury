import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Player {

     private String instanceVarUsername;

    public String getInstanceVarUsername(String user) {
        instanceVarUsername = user;
        return instanceVarUsername;
    }

    /**
     This method stores different usernames in a textfile for later use
     */

    static String writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your username: (NO SPACES!!)");
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
            out.println( usernameSaver + " " + newUsername );
            out.close();
        }
        //This selects the new user immediately
        return usersInput;
    }



    /**
     This method shows the user all available usernames and allows user to select an already existing username
     */

    public static String readUsername(String user) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userChoice = 0;

        while (run) {
            while (!input.hasNextInt()){
                System.out.println("\nPlease input a number between 1 - 2:\n");
                System.out.println("Please choose: \n1) Existing users\n2) Create new user");
                input.next();
            }
            userChoice = input.nextInt();

            if (userChoice == 1) {
                File usernames = new File("src/username.txt");
                Scanner readUsernames = new Scanner(usernames);

                //This arraylist saves all usernames from username.txt
                ArrayList<String> aList = new ArrayList<>();

                while (readUsernames.hasNext()) {
                    aList.add(readUsernames.next());
                }
                readUsernames.close();

                for (int i = 1; i < aList.size(); i++) {
                    System.out.println(i + ") " + aList.get(i));
                }

                int pickUser = input.nextInt();
                user = aList.get(pickUser);
                //System.out.println("You have selected the " + user + " profile!");

                return user;

            } else if (userChoice == 2) {
                String username = writeUsername();
                return username;
            } else {
                System.out.println("\nPlease enter a *number* greater than 0 and lower than 2:\n");
            }
        }
        return null;
    }
}

