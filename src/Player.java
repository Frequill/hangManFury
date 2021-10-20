import java.io.*;
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
    }
    public int getPickUserData() {
        return pickUserData;
    }

    public static ArrayList <String> allUsernames = new ArrayList();

    public static Player modifyX = new Player();

    /**
     This method stores different usernames in a text file for later use
     */

    public static String writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);

        File toUsername = new File("src/username.txt");

        System.out.println("Please enter your username: (NO SPACES!!)");

        String usersInput = in.next();


        Writer out;
        out = new BufferedWriter(new FileWriter(toUsername,true));
        out.append("\n" + usersInput + " 0" + " 0" + " 0");
        out.close();

        usersInput = usersInput + " 0" + " 0" + " 0";
        userArray(usersInput);



        return usersInput;
    }

    public static void userArray(String userInput) throws Exception{
        File username = new File("src/username.txt");
        Scanner readUsername = new Scanner(username);

        if (allUsernames.isEmpty()) {
            while (readUsername.hasNextLine()) {
                allUsernames.add(readUsername.nextLine());
            }
        }

        else {
            allUsernames.add(userInput);
        }
    }

    public static void matchAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 5);

        int x = Integer.parseInt(userSplitter[1]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[1] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.println(allUsernames.get(i));
        }
        out.close();
    }




    public static void winAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 4);

        int x = Integer.parseInt(userSplitter[2]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[2] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.println(allUsernames.get(i));
        }
        out.close();
    }




    public static void lossAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 4);

        int x = Integer.parseInt(userSplitter[3]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[3] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.println(allUsernames.get(i));
        }
        out.close();
    }




    public static void matchAdderCaller() throws Exception {
        matchAdder(modifyX.getPickUserData());
    }

    public static void winAdderCaller() throws Exception {
        winAdder(modifyX.getPickUserData());
    }

    public static void lossAdderCaller() throws Exception {
        lossAdder(modifyX.getPickUserData());
    }

    // *************************************   ALLTING HÄR NEDÅT ÄR BULLSHIT **********************************
        /*Scanner in = new Scanner(System.in);

        File toPlaceholder = new File("src/thePlaceholder.txt");
        File toUsername = new File("src/username.txt");

        PrintWriter output = new PrintWriter(toPlaceholder);

        System.out.println("Please enter your username: (NO SPACES!!)");
        String usersInput = in.nextLine();
        output.println(usersInput);
        output.close();

        //This Printwriter stores the users username in the "thePlaceholder" textfile.



        PrintWriter jojo = new PrintWriter(toUsername);

        Scanner readPlaceholder = new Scanner(toPlaceholder);
        String newUsername = readPlaceholder.nextLine();

        ArrayList<String> usernameSaver = new ArrayList<>();

        while(readPlaceholder.hasNextLine()) {
            usernameSaver.add(readPlaceholder.nextLine());
        }

        System.out.println(usernameSaver.size());

        for(int i = 0; i < usernameSaver.size(); i++){
            System.out.println(usernameSaver.get(i));
            jojo.println(usernameSaver.get(i));
        }
        System.out.println("jojo stängs!!!!");
        jojo.close();

        usernameSaver.add(newUsername);
        System.out.println(usernameSaver);
        PrintWriter out = new PrintWriter ("src/username.txt");
        for(int i = 0; i < usernameSaver.size(); i++){

            out.println(usernameSaver.get(i));
            // out.println(usernameSaver + " " + newUsername);
        }
        out.println(newUsername);
        out.close();

        newUserScore();

        //This selects the new user immediately
        return usersInput;
    }*/

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

                System.out.println("Profile name, Games played, Matches won, Matches lost");
                //This arraylist saves all usernames from username.txt
                ArrayList<String> aList = new ArrayList<>();

                while (readUsernames.hasNext()) {
                    aList.add(readUsernames.nextLine());
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
                userArray(aList.get(pickUser));

                modifyX.setPickUserData(pickUser);
                user = aList.get(pickUser);
                //String []splitUser = user.split(" ", 3);
                //String trueUser = splitUser [0];
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



    /*public static void newUserScore() throws Exception {
        int defaultScore = 0;

        File toScoreMatchPlaceholder = new File("src/userMatchDataPlaceholder.txt");
        File toUserMatchData = new File("src/userMatchData.txt");
        ArrayList <String> matchSaver = new ArrayList<>();

        //This Printwriter stores the users matches in the "userMatchDataPlaceholder" textfile
        PrintWriter output = new PrintWriter(toScoreMatchPlaceholder);
        output.println(defaultScore);
        output.close();

        Scanner readMatchDataPlaceholder = new Scanner(toScoreMatchPlaceholder);

        String newUserScore = readMatchDataPlaceholder.nextLine();
        readMatchDataPlaceholder.close();

        PrintWriter out = new PrintWriter("src/userMatchData.txt");
        for (int i = 0; i < matchSaver.size(); i++) {
            out.println(matchSaver.get(i));
        }
        out.println( newUserScore);
        out.close();
    }*/


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

