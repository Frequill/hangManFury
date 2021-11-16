import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

//******************************************* Instance variables and object *******************************************
public class Player {
    // Global variables
    private String instanceVarUsername; //This variable is older than my grandma...

    // pickUserData 1,2,3 and 4 keeps track of what users are selected during multiplayer
    private int pickUserData1 = -1;
    private int pickUserData2 = -1;
    private int pickUserData3 = -1;
    private int pickUserData4 = -1;

    public String getInstanceVarUsername(String user) {  //You don't need this. Move on.
        instanceVarUsername = user;
        return instanceVarUsername;
    }


    public void setPickUserData1(int pickUserDataArgument) {
        this.pickUserData1 = pickUserDataArgument;
    }
    public int getPickUserData1() {
        return pickUserData1;
    }

    public void setPickUserData2(int pickUserDataArgument) {
        this.pickUserData2 = pickUserDataArgument;
    }
    public int getPickUserData2() {
        return pickUserData2;
    }

    public void setPickUserData3(int pickUserDataArgument) {
        this.pickUserData3 = pickUserDataArgument;
    }
    public int getPickUserData3() {
        return pickUserData3;
    }

    public void setPickUserData4(int pickUserDataArgument) {
        this.pickUserData4 = pickUserDataArgument;
    }
    public int getPickUserData4() {
        return pickUserData4;
    }

    public static ArrayList<String> allUsernames = new ArrayList();
    public static ArrayList<String> getAllUsernames() {
        return allUsernames;
    }
    public static ArrayList<Integer> allUserNumbers = new ArrayList();



    public static Player modifyX = new Player();

    //************************************************* Functions *****************************************************

    /**
     * This method stores different usernames (and their stats) in a text file for later use
     */

    public static String writeUsername(int choice) throws Exception {
        Scanner in = new Scanner(System.in);
        File toUsername = new File("src/username.txt");
        Scanner scanFile = new Scanner(toUsername);
        ArrayList<String> everyUser = new ArrayList<>();
        ArrayList<String> splitEvery = new ArrayList<>();

        System.out.println("Please enter your username:" + Color.RED + " (NO SPACES ALLOWED)" + Color.RESET);
        System.out.println(Color.YELLOW_BACKGROUND + Color.BLACK + "Type \"Back\" to return to user menu" + Color.RESET);
        String usersInput = in.next();

        while (scanFile.hasNextLine()){
            everyUser.add(scanFile.nextLine());
        }
        for(int i = 0; i < everyUser.size(); i++){
            String[] splitEveryUser = everyUser.get(i).split(" ");
            splitEvery.add(splitEveryUser[0]);

        }


        boolean nullKiller = true;
        while (nullKiller) {
            while (Objects.equals(usersInput, "null") || Objects.equals(usersInput, "Null")) {
                System.out.println(Color.RED + "You may not call yourself null due to technical difficulties..." + Color.RESET);

               usersInput = in.next();

            }
            if (splitEvery.contains(usersInput)){
                System.out.println(Color.RED + "This user already exist!" + Color.RESET + "\n(Please enter a new user!)");
                usersInput = in.next();
            }
            else if(usersInput.equals("Back")||usersInput.equals("back")){
                Menu.amountOfPlayersMenu();
                nullKiller = false;
            }
            else {
                nullKiller = false;
            }
        }


        String newUser = usersInput + " 0" + " 0" + " 0" + " 0" + " 0";
        Writer out;
        out = new BufferedWriter(new FileWriter(toUsername, true));
        out.append(newUser + "\n");
        out.close();

        userArray(newUser);

        if (choice == 1) {
            modifyX.pickUserData1 = allUsernames.size() - 1;
            modifyX.setPickUserData1(modifyX.pickUserData1);
        } else if (choice == 2) {
            modifyX.pickUserData2 = allUsernames.size() - 1;
            modifyX.setPickUserData2(modifyX.pickUserData2);
        } else if (choice == 3) {
            modifyX.pickUserData3 = allUsernames.size() - 1;
            modifyX.setPickUserData3(modifyX.pickUserData3);
        } else if (choice == 4) {
            modifyX.pickUserData4 = allUsernames.size() - 1;
            modifyX.setPickUserData4(modifyX.pickUserData4);
        } else {
            System.out.println("Edwins röv");
        }

        return newUser;
    }

    /**
     * Method stores all "usernames" from username.txt file into an arraylist so that specific indexes (users) can be
     * called upon later for stats increases or decreases...
     */

    public static void userArray(String userInput) throws Exception {
        File username = new File("src/username.txt");
        Scanner readUsername = new Scanner(username);


        if (allUsernames.isEmpty()) {
            while (readUsername.hasNextLine()) {
                allUsernames.add(readUsername.nextLine());
            }
        } else {
            if (allUsernames.contains(userInput)) {

            } else {
                allUsernames.add(userInput);
            }
        }
    }

    /**
     * This method increases the users overall matches played!
     */

    public static void matchAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);


        int x = Integer.parseInt(userSplitter[1]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[1] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " + userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++) {
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    /**
     * This method increases the users overall matches won!
     */

    public static void winAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        ;
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[2]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[2] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " + userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++) {
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    /**
     * This method increases the users overall matches lost :(
     */

    public static void lossAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[3]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[3] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " + userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++) {
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }

    /**
     * This method increases the flawless victories of a noble user!
     */

    public static void flawlessAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);


        int x = Integer.parseInt(userSplitter[4]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[4] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " + userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++) {
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }

    /**
     * This method keeps track of the points one attained from the last game multiplayer game, so it can be compared to high-scores
     */

    public static void multiplayerPointAdder(int userInQuestion, int userPoints) throws Exception {

        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[5]);
        x = userPoints;
        String x2 = String.valueOf(x);
        userSplitter[5] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " + userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++) {
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    /* Many basic "callers" that allowed us to access instance variables of the "Player" class from other classes
    (before we managed to figure out the concept of inheritance)

    The purpose of a "caller" is to call upon a method in the player class while also giving it an instance variable
    from the player class. */

    public static void matchAdderCaller() throws Exception {
        matchAdder(modifyX.getPickUserData1());
    }

    public static void winAdderCaller() throws Exception {
        winAdder(modifyX.getPickUserData1());
    }

    public static void multiWinAdderCaller(int x, int index, ArrayList<String> users) throws Exception {

        File username = new File("src/username.txt");
        Scanner readUsername = new Scanner(username);


        if (allUsernames.isEmpty()) {
            while (readUsername.hasNextLine()) {
                allUsernames.add(readUsername.nextLine());
            }
        }

        String[] splitUsers = users.get(index).split(" ", 6);
        String[] splitAllusernames1 = allUsernames.get(modifyX.getPickUserData1()).split(" ", 6);
        String[] splitAllusernames2 = allUsernames.get(modifyX.getPickUserData2()).split(" ", 6);




        if (x == 1 && splitAllusernames1[0].equals(splitUsers[0])) {
            winAdder(modifyX.getPickUserData1());
        } else if (x == 2 && splitAllusernames2[0].equals(splitUsers[0])) {
            winAdder(modifyX.getPickUserData2());
        } else if (users.get(3) != null && !users.get(3).equals("null")) {
            String[] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            String[] splitAllusernames4 = allUsernames.get(modifyX.getPickUserData4()).split(" ", 6);
            if (x == 3 && splitAllusernames3[0].equals(splitUsers[0])) {
                winAdder(modifyX.getPickUserData3());
            } else if (x == 4 && splitAllusernames4[0].equals(splitUsers[0])) {
                winAdder(modifyX.getPickUserData4());
            }
        } else if (users.get(2) != null && !users.get(2).equals("null")) {
            String[] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            if (x == 3 && splitAllusernames3[0].equals(splitUsers[0])) {
                winAdder(modifyX.getPickUserData3());
            }
        }

    }

    public static void multiMatchAdderCaller(int x) throws Exception {
        if (x == 1) {
            matchAdder(modifyX.getPickUserData1());
        } else if (x == 2) {
            matchAdder(modifyX.getPickUserData2());
        } else if (x == 3) {
            matchAdder(modifyX.getPickUserData3());
        } else if (x == 4) {
            matchAdder(modifyX.getPickUserData4());
        }

    }

    public static void lossAdderCaller() throws Exception {
        lossAdder(modifyX.getPickUserData1());
    }

    public static void multiLossAdderCaller(int x, int index, ArrayList<String> users) throws Exception {
        String[] splitUsers = users.get(index).split(" ", 6);
        String[] splitAllusernames1 = allUsernames.get(modifyX.getPickUserData1()).split(" ", 6);
        String[] splitAllusernames2 = allUsernames.get(modifyX.getPickUserData2()).split(" ", 6);

        if (x == 1 && !Objects.equals(splitAllusernames1[0], splitUsers[0])) {
            lossAdder(modifyX.getPickUserData1());
        }

        else if (x == 2 && !Objects.equals(splitAllusernames2[0], splitUsers[0])) {
            lossAdder(modifyX.getPickUserData2());
        }

        else if (users.get(3) != null) {
            String[] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            String[] splitAllusernames4 = allUsernames.get(modifyX.getPickUserData4()).split(" ", 6);
            if (x == 3 && !Objects.equals(splitAllusernames3[0], splitUsers[0])) {
                lossAdder(modifyX.getPickUserData3());
            }

            else if (x == 4 && !Objects.equals(splitAllusernames4[0], splitUsers[0])) {
                lossAdder(modifyX.getPickUserData4());
            }
        }

        else if (users.get(2) != null) {
            String[] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            if (x == 3 && !Objects.equals(splitAllusernames3[0], splitUsers[0])) {
                lossAdder(modifyX.getPickUserData3());
            }
        }

    }

    public static void flawlessAdderCaller() throws Exception {
        flawlessAdder(modifyX.getPickUserData1());
    }

    public static void multiplayerPointAdderCaller(int userPoints, int x) throws Exception {

        if (x == 1) {
            multiplayerPointAdder(modifyX.getPickUserData1(), userPoints);

        } else if (x == 2) {
            multiplayerPointAdder(modifyX.getPickUserData2(), userPoints);

        } else if (x == 3) {
            multiplayerPointAdder(modifyX.getPickUserData3(), userPoints);
        } else if (x == 4) {
            multiplayerPointAdder(modifyX.getPickUserData4(), userPoints);
        }

    }

    public static void pickUser1Setter(int data1) {
        modifyX.setPickUserData1(data1);
    }

    public static void pickUser2Setter(int data2) {
        modifyX.setPickUserData2(data2);
    }

    public static void pickUser3Setter(int data3) {
        modifyX.setPickUserData3(data3);
    }

    public static void pickUser4Setter(int data4) {
        modifyX.setPickUserData4(data4);
    }


    /**
     * This method shows the user all available usernames and allows user to select an already existing username
     */

    public static String readUsername(String user, int choice) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userChoice = 0;


        while (run) {
            while (!input.hasNextInt()) {
                System.out.println(Color.RED + "\nPlease input an integer between 1 - 3:\n" + Color.RESET);
                input.next();
            }
            userChoice = input.nextInt();

            if (userChoice == 1) {

                File usernames = new File("src/username.txt");
                Scanner readUsernames = new Scanner(usernames);

                System.out.println( Color.YELLOW +"Profile name, Games played, Matches won, Matches lost and Flawless Victories" + Color.RESET);
                //This arraylist saves all usernames from username.txt
                ArrayList<String> aList = new ArrayList<>();

                while (readUsernames.hasNextLine()) {
                    aList.add(readUsernames.nextLine());
                }
                readUsernames.close();

                // Prints the names and every stat except for score, because we saved it for high score list
                for (int i = 1; i < aList.size(); i++) {
                    String[] splitAList = aList.get(i).split(" ", 9);
                    System.out.println(Color.YELLOW + i + ") " + Color.RESET + splitAList[0] + " " + splitAList[1] + " " + splitAList[2] + " " + splitAList[3] + " " + splitAList[4]);
                }


                System.out.println(Color.YELLOW + aList.size() + ")" + Color.RESET + Color.CYAN + " Back" + Color.RESET);
                boolean run2 = true;

                int pickUser = 0;
                while (run2) {
                    while (!input.hasNextInt()) {
                        System.out.println("Please input an appropriate integer! ");
                        input.next();
                    }
                    pickUser = input.nextInt();
                    if (pickUser < 1 || pickUser >= aList.size() + 1) {
                        System.out.println("Choice was out of bounds! ");
                    } else if (pickUser == aList.size()) {
                        Menu.amountOfPlayersMenu();
                    } else if (pickUser == modifyX.getPickUserData1() || pickUser == modifyX.getPickUserData2() || pickUser == modifyX.getPickUserData3() || pickUser == modifyX.getPickUserData4()) {
                            System.out.println("You can`t select the same user twice!");
                    } else {
                        run2 = false;
                    }
                }
                userArray(aList.get(pickUser));
                allUserNumbers.add(pickUser);

                if (choice == 1) {
                    modifyX.setPickUserData1(pickUser);
                } else if (choice == 2) {
                    modifyX.setPickUserData2(pickUser);
                } else if (choice == 3) {
                    modifyX.setPickUserData3(pickUser);
                } else if (choice == 4) {
                    modifyX.setPickUserData4(pickUser);
                }


                user = aList.get(pickUser);
                String[] userSplitter = user.split(" ", 4);  // Splits username from stats so the two can be showed separately
                String fullUser = userSplitter[0];

                return fullUser;

            } else if (userChoice == 2) {
                String username = writeUsername(choice);
                return username;
            } else if (userChoice == 3) {
              Menu.amountOfPlayersMenu();
            } else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 4:\n");
            }
        }
        return null;
    }

    /**
     "deleteUser" method allows the user to remove a user from the "userNames" text file. Effectively allowing you
     to remove users that you no longer want to keep in your game.
     */
        public static void deleteUser () throws Exception {
            Scanner in = new Scanner(System.in);
            File savedGame = new File("src/lastSavedGame.txt");

            /* yesOrNo int, loop and bool warns the user that deleting a character will also delete the latest saved game
            (this had to be done to prevent some bugs, crashes and other errors) */
            System.out.println(Color.RED_BACKGROUND + Color.BLACK + "WARNING!" + Color.RESET + " User deletion will also delete the latest saved game!\nAre you sure you want to Delete a user now?\n" + Color.YELLOW + "1) " + Color.RESET  + Color.GREEN + "YES" + Color.RESET+ "\n" + Color.YELLOW + "2) " + Color.RESET  + Color.RED+ "NO" + Color.RESET);
            int yesOrNo;
            boolean askYesOrNo = true;
            while (askYesOrNo == true) {
                while (!in.hasNextInt()) {
                    System.out.println(Color.RED + "Please input an appropriate integer! " + Color.RESET);
                    in.next();
                }
                yesOrNo = in.nextInt();

                if (yesOrNo == 1) {
                    // This ensures that if users are deleted a saved game can't be reloaded and prevents a hard-crash
                    PrintWriter clearSavedGame = new PrintWriter(savedGame);
                    clearSavedGame.print("");
                    clearSavedGame.close();

                    int deleteUserChoice;

                    File usernames = new File("src/username.txt");
                    Scanner readUsernames = new Scanner(usernames);
                    ArrayList<String> deleteAllUsername = new ArrayList<>();


                    while (readUsernames.hasNextLine()) {
                        deleteAllUsername.add(readUsernames.nextLine());
                    }

                    System.out.println(Color.YELLOW_BACKGROUND + Color.BLACK + "Which user would you like to delete?" + Color.RESET);

                    for (int i = 1; i < deleteAllUsername.size(); i++) {
                        String[] splitAlist = deleteAllUsername.get(i).split(" ");
                        System.out.println(Color.YELLOW + i + ") " + Color.RESET + splitAlist[0]);
                    }
                    System.out.println(Color.YELLOW + deleteAllUsername.size() + ")" + Color.RESET + Color.CYAN + " Back" + Color.RESET);
                    boolean run = true;
                    while (run) {
                        while (!in.hasNextInt()) {
                            System.out.println(Color.RED + "Please input an integer between 1 - " + deleteAllUsername.size() + ":\n" + Color.RESET);
                            in.next();
                        }
                        deleteUserChoice = in.nextInt();

                        if (deleteUserChoice == deleteAllUsername.size()) {
                            Menu.amountOfPlayersMenu();
                        } else if (deleteUserChoice > 0 && deleteUserChoice < deleteAllUsername.size()){


                            deleteAllUsername.remove(deleteUserChoice);


                            PrintWriter out = new PrintWriter(usernames);
                            for (int i = 0; i < deleteAllUsername.size(); i++) {
                                out.print(deleteAllUsername.get(i) + "\n");
                            }
                            out.close();

                            readUsernames.close();

                            modifyX.setPickUserData1(-1);
                            modifyX.setPickUserData2(-1);
                            modifyX.setPickUserData3(-1);
                            modifyX.setPickUserData4(-1);

                            pickUser1Setter(-1);
                            pickUser2Setter(-1);
                            pickUser3Setter(-1);
                            pickUser4Setter(-1);

                            Menu.firstMenu();


                            run = false;
                            askYesOrNo = false;
                        }
                        else{
                            System.out.println(Color.RED + "\nPlease input an integer between 1 - " + deleteAllUsername.size() + ":\n" + Color.RESET);
                        }
                    }
                } else if (yesOrNo == 2) {
                    askYesOrNo = false;
                    Menu.amountOfPlayersMenu();
                } else {
                    System.out.println(Color.RED + "Invalid input!!" + Color.RESET);
                }
            }

    }
}


