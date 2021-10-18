import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Player {
     private String instanceVarUsername;
     private int pickUserData;

    public String getInstanceVarUsername(String user) {
        instanceVarUsername = user;
        return instanceVarUsername;
    }

    public void setPickUserData(int pickUserData2) {
        this.pickUserData = pickUserData2;
        System.out.println(this.pickUserData + "Detta är i setter" );
    }
    public int getPickUserData() {
        System.out.println(pickUserData + "Detta är i getter ");
        return pickUserData;

    }

    public static Player modifyX = new Player();

    /**
     This method stores different usernames in a text file for later use
     */

    public static String writeUsername() throws Exception {
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

         newUserScore();
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
                System.out.println("\nPlease input an integer between 1 - 2:\n");
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
                boolean run2 = true;

                int pickUser = 0;
                while(run2) {
                   while (!input.hasNextInt()) {
                       System.out.println("Please input an appropriate integer! ");
                       input.next();
                   }
                   pickUser = input.nextInt();
                   if(pickUser < 1 || pickUser >= aList.size()){
                       System.out.println("Choice was out of bounds! ");
                   }
                   else{
                       run2 = false;
                   }
               }

                modifyX.setPickUserData(pickUser);

                user = aList.get(pickUser);
                return user;

            } else if (userChoice == 2) {
                String username = writeUsername();
                return username;
            } else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 2:\n");
            }
        }
        return null;
    }


    //This method works in practice BUT I can't reach it from the "game" class... if I could it would work! (Martin knows more about getters than I do...)


    public static void saveMatchCaller() throws Exception {
        saveMatch(modifyX.getPickUserData());
    }


    public static void newUserScore() throws Exception {
        int defaultScore = 0;

        File toScoreMatchPlaceholder = new File("src/userMatchDataPlaceholder.txt");
        File toUserMatchData = new File("src/userMatchData.txt");

        //This Printwriter stores the users matches in the "userMatchDataPlaceholder" textfile
        PrintWriter output = new PrintWriter(toScoreMatchPlaceholder);
        output.println(defaultScore);
        output.close();

        Scanner readMatchDataPlaceholder = new Scanner(toScoreMatchPlaceholder);
        Scanner readMatchData = new Scanner(toUserMatchData);
        String newUserScore = readMatchDataPlaceholder.nextLine();
        String matchSaver = readMatchData.nextLine();
        readMatchDataPlaceholder.close();

        for (int i = 0; i < newUserScore.length(); i++) {
            PrintWriter out = new PrintWriter("src/userMatchData.txt");
            out.println(matchSaver + " " + newUserScore);
            out.close();
        }
    }


    public static void saveMatch(int pickUser)throws Exception{
        File userMatchData = new File("src/userMatchData.txt");
        Scanner readUserMatchData = new Scanner(userMatchData);

        ArrayList<String> thisWasInsideUserMatchData = new ArrayList<>();
        while (readUserMatchData.hasNextLine()){
            thisWasInsideUserMatchData.add(readUserMatchData.nextLine());
        }

        int intMatchData = Integer.parseInt(thisWasInsideUserMatchData.get(pickUser));
        int fullMatchData = intMatchData + 1;
        String ultimateResult = Integer.toString(fullMatchData);

        thisWasInsideUserMatchData.set(pickUser, ultimateResult);

        PrintWriter writeToUserMatchData = new PrintWriter(userMatchData);
        for (int i = 0; i < thisWasInsideUserMatchData.size(); i++){
            writeToUserMatchData.println(thisWasInsideUserMatchData.get(i));
        }
        writeToUserMatchData.close();
    }
}

