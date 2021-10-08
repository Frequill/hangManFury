import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Player {
    String user;


    /**
     This method stores different usernames in a textile for later use
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
//Fixa det här era dumma jävlar. Men gör inte på Johannas vis. Antingen retunera user till game eller skriv om userName metoden.
    public String readUsername() throws Exception {
        System.out.println("Please choose: \n1) Existing users\n2) Create new user");
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        if (userChoice == 1){
            File usernames = new File("src/username.txt");
            Scanner readUsernames = new Scanner(usernames);

            //This arraylist saves all usernames from username.txt
            ArrayList<String> aList = new ArrayList<>();

            while (readUsernames.hasNext()){
                aList.add(readUsernames.next());
            }
            readUsernames.close();

            for (int i = 1; i < aList.size(); i++){
                System.out.println(i +") "+ aList.get(i));
            }

            int pickUser = input.nextInt();
            user = aList.get(pickUser);
            System.out.println("You have selected the " + user + " profile!");

            return user;

        }
        else if (userChoice == 2){
            String username = writeUsername();
            return username;
        }
        else {
            System.out.println("VAFAN GÖRRU???");
        }

        return null;

    }

    public String userToGame (){
        return user;
    }
}
