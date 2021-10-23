import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Player {
     private String instanceVarUsername;
     private int pickUserData;
     private int G;

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

    public static ArrayList <String> allUsernames = new ArrayList<>();

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
        out.append("\n").append(usersInput).append(" 0").append(" 0").append(" 0");
        out.close();

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
        modifyX.setPickUserData(allUsernames.size()-1);
        modifyX.G = allUsernames.size()-1;
    }


    public static void matchAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", -1);

        int x = Integer.parseInt(userSplitter[1]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[1] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (String allUsername : allUsernames) {
            out.println(allUsername);
        }
        out.close();
    }



    public static void winAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", -1);

        int x = Integer.parseInt(userSplitter[2]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[2] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (String allUsername : allUsernames) {
            out.println(allUsername);
        }
        out.close();
    }



    public static void lossAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", -1);

        int x = Integer.parseInt(userSplitter[3]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[3] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        /*This is for test purpouses! *///System.out.println(allUsernames);

        PrintWriter out = new PrintWriter(usernameFile);
        for (String allUsername : allUsernames) {
            out.println(allUsername);
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

    /**
     This method shows the user all available usernames and allows user to select an already existing username
     */

    public static String readUsername() throws Exception {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userChoice;


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

                while (readUsernames.hasNextLine()) {
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
                   else if(modifyX.G == pickUser){
                       System.out.println("Try again motherfucker");
                   }
                   else{
                       run2 = false;
                   }
               }
                userArray(aList.get(pickUser));

                modifyX.setPickUserData(pickUser);
                String user = aList.get(pickUser);
                String[]userSplitter = user.split(" ",-1);
                String fullUser = userSplitter[0];
                modifyX.G = pickUser;
                return fullUser;

            } else if (userChoice == 2) {
                String username = writeUsername();
                return username;
            } else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 2:\n");
            }
        }
        return null;
    }
}

