import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//******************************************* Instance variables and object *******************************************
class Player {
     private String instanceVarUsername;
     private int pickUserData1 = -1;
     private int pickUserData2 = -1;
     private int pickUserData3 = -1;
     private int pickUserData4 = -1;

    public String getInstanceVarUsername(String user) {
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

    public static ArrayList <String> allUsernames = new ArrayList();
    public static ArrayList <Integer> allUserNumbers = new ArrayList();

    public static Player modifyX = new Player();

    //************************************************* Functions *****************************************************

    /**
     This method stores different usernames in a text file for later use
     */

    public static String writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        File toUsername = new File("src/username.txt");

        System.out.println("Please enter your username: (NO SPACES!!)");
        String usersInput = in.next();

        String newUser = usersInput + " 0" + " 0" + " 0" + " 0" + " 0";
        Writer out;
        out = new BufferedWriter(new FileWriter(toUsername,true));
        out.append("\n" + newUser);
        out.close();

        userArray(newUser);

        if (modifyX.getPickUserData1() == -1){
            modifyX.pickUserData1 = allUsernames.size()-1;
            modifyX.setPickUserData1(modifyX.pickUserData1);
        }
        else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() == -1){
            modifyX.pickUserData2 = allUsernames.size()-1;
            modifyX.setPickUserData2(modifyX.pickUserData2);
        }
        else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() != -1 && modifyX.getPickUserData3() == -1){
            modifyX.pickUserData3 = allUsernames.size()-1;
            modifyX.setPickUserData3(modifyX.pickUserData3);
        }
        else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() != -1 && modifyX.getPickUserData3() != -1 && modifyX.getPickUserData4() == -1){
            modifyX.pickUserData4 = allUsernames.size()-1;
            modifyX.setPickUserData4(modifyX.pickUserData4);
        }
        else{
            System.out.println("Edwins röv");
        }

        return newUser;
    }

    /**
     Method stores all "usernames" from username.txt file into an arraylist so that specific indesex (users) can be
     called upon later for stats increases or decreases...
     */

    public static void userArray(String userInput) throws Exception{
        File username = new File("src/username.txt");
        Scanner readUsername = new Scanner(username);


        if (allUsernames.isEmpty()) {
            while (readUsername.hasNextLine()) {
                allUsernames.add(readUsername.nextLine());
            }
        }

        else {
            if (allUsernames.contains(userInput)) {

            } else {
                allUsernames.add(userInput);
            }
        }
    }

    /**
     This method increases the users overall matches played!
     */

    public static void matchAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);


        int x = Integer.parseInt(userSplitter[1]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[1] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    /**
     This method increases the users overall matches won!
     */

    public static void winAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);;
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[2]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[2] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion , finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    /**
     This method increases the users overall matches lost :(
     */

    public static void lossAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[3]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[3] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }

    /**
     This method increases the flawless victories of a noble user!
     */

    public static void flawlessAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);


        int x = Integer.parseInt(userSplitter[4]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[4] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);


        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }

    /**
     This method keeps track of the points one attained from the last game multiplayer game, so it can be compared to high-scores
     */

    public static void multiplayerPointAdder(int userInQuestion, int userPoints) throws Exception {

        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 6);

        int x = Integer.parseInt(userSplitter[5]);
        x = userPoints;
        String x2 = String.valueOf(x);
        userSplitter[5] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3] + " " + userSplitter[4] + " " + userSplitter[5];
        allUsernames.set(userInQuestion, finalResult);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }


    // Three basic "callers" that allows us to access instance variables of the "Player" class from other classes

    public static void matchAdderCaller() throws Exception {
        matchAdder(modifyX.getPickUserData1());
    }

    public static void winAdderCaller() throws Exception {
        winAdder(modifyX.getPickUserData1());
    }
    public static void multiWinAdderCaller(int x, int index, String [] users) throws Exception {
        String [] splitUsers = users[index].split(" ", 6);
        String [] splitAllusernames1 = allUsernames.get(modifyX.getPickUserData1()).split(" ", 6);
        String [] splitAllusernames2 = allUsernames.get(modifyX.getPickUserData2()).split(" ", 6);

        if (x == 1 && splitAllusernames1[0].equals(splitUsers[0])) {
            winAdder(modifyX.getPickUserData1());
        }
        else if (x == 2 && splitAllusernames2[0].equals(splitUsers[0])) {
            winAdder(modifyX.getPickUserData2());
        }
        else if (users[3] != null){
            String [] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            String [] splitAllusernames4 = allUsernames.get(modifyX.getPickUserData4()).split(" ", 6);
            if (x==3 && splitAllusernames3[0].equals(splitUsers[0])){
                winAdder(modifyX.getPickUserData3());
            }
            else if (x==4 && splitAllusernames4[0].equals(splitUsers[0])) {
                winAdder(modifyX.getPickUserData4());
            }
        }
        else if (users[2] != null) {
            String [] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            if (x==3 && splitAllusernames3[0].equals(splitUsers[0])) {
                winAdder(modifyX.getPickUserData3());
            }
        }

    }

    public static void multiMatchAdderCaller(int x) throws Exception {
        if (x == 1) {
            matchAdder(modifyX.getPickUserData1());
        }
        else if (x == 2) {
            matchAdder(modifyX.getPickUserData2());
        }
        else if (x == 3){
            matchAdder(modifyX.getPickUserData3());
        }
        else if (x == 4) {
            matchAdder(modifyX.getPickUserData4());
        }

    }

    public static void lossAdderCaller() throws Exception {
        lossAdder(modifyX.getPickUserData1());
    }

    public static void multiLossAdderCaller(int x, int index , String[] users) throws Exception {
        String [] splitUsers = users[index].split(" ", 6);
        String [] splitAllusernames1 = allUsernames.get(modifyX.getPickUserData1()).split(" ", 6);
        String [] splitAllusernames2 = allUsernames.get(modifyX.getPickUserData2()).split(" ", 6);

        if (x == 1 && !Objects.equals(splitAllusernames1[0], splitUsers[0])) {
            lossAdder(modifyX.getPickUserData1());
        }
        else if (x == 2 && !Objects.equals(splitAllusernames2[0], splitUsers[0])) {
            lossAdder(modifyX.getPickUserData2());
        }
        else if (users[3] != null){
            String [] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            String [] splitAllusernames4 = allUsernames.get(modifyX.getPickUserData4()).split(" ", 6);
            if (x == 3 && !Objects.equals(splitAllusernames3[0], splitUsers[0])){
                lossAdder(modifyX.getPickUserData3());
            }
            else if (x == 4 &&!Objects.equals(splitAllusernames4[0], splitUsers[0])){
                lossAdder(modifyX.getPickUserData4());
            }
        }
        else if ( users[2] != null) {
            String [] splitAllusernames3 = allUsernames.get(modifyX.getPickUserData3()).split(" ", 6);
            if ( x == 3 && !Objects.equals(splitAllusernames3[0], splitUsers[0])) {
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

        }
            else if (x == 2) {
            multiplayerPointAdder(modifyX.getPickUserData2(), userPoints);

        }
             else if (x == 3){
                multiplayerPointAdder(modifyX.getPickUserData3(), userPoints);
        }
                else if (x == 4) {
                    multiplayerPointAdder(modifyX.getPickUserData4(), userPoints);
        }

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
                System.out.println(Color.RED + "\nPlease input an integer between 1 - 3:\n" + Color.RESET);
                input.next();
            }
            userChoice = input.nextInt();

            if (userChoice == 1) {

                File usernames = new File("src/username.txt");
                Scanner readUsernames = new Scanner(usernames);

                System.out.println("Profile name, Games played, Matches won, Matches lost, Flawless Victories!");
                //This arraylist saves all usernames from username.txt
                ArrayList<String> aList = new ArrayList<>();

                while (readUsernames.hasNextLine()) {
                    aList.add(readUsernames.nextLine());
                }
                readUsernames.close();

                for (int i = 1; i < aList.size(); i++) {
                    System.out.println(Color.YELLOW + i + ") " + Color.RESET + aList.get(i));

                }
                System.out.println(Color.YELLOW + aList.size()+ ")" + Color.RESET + " Back");
                boolean run2 = true;

                int pickUser = 0;
                while(run2) {
                   while (!input.hasNextInt()) {
                       System.out.println("Please input an appropriate integer! ");
                       input.next();
                   }
                   pickUser = input.nextInt();
                   if(pickUser < 1 || pickUser >= aList.size()+1){
                       System.out.println("Choice was out of bounds! ");
                   }
                   else if(allUserNumbers.contains(pickUser)){
                       System.out.println("You can`t reselect a profile that was used earlier!!");
                   }
                   else if(pickUser == aList.size()){
                       if (user == null) {
                           Menu.firstMenu();
                       }
                       else{
                           Menu.secondMenu(user);
                           return user;
                       }
                   }

                   else{
                       run2 = false;
                   }
               }
                userArray(aList.get(pickUser));
                allUserNumbers.add(pickUser);

                if (modifyX.getPickUserData1() == -1){
                    modifyX.setPickUserData1(pickUser);
                }
                else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() == -1){
                    modifyX.setPickUserData2(pickUser);
                }
                else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() != -1 && modifyX.getPickUserData3() == -1){
                    modifyX.setPickUserData3(pickUser);
                }
                else if (modifyX.getPickUserData1() != -1 && modifyX.getPickUserData2() != -1 && modifyX.getPickUserData3() != -1 && modifyX.getPickUserData4() == -1){
                    modifyX.setPickUserData4(pickUser);
                }


                user = aList.get(pickUser);
                String[]userSplitter = user.split(" ",4);  // Splits username from stats so the two can be showed separately
                String fullUser = userSplitter[0];

                return fullUser;

            } else if (userChoice == 2) {
                String username = writeUsername();
                return username;
            }else if (userChoice == 3) {
                if (user == null){
                    Menu.firstMenu();
                }
                else{
                    Menu.secondMenu(user);
                }

            }
            else {
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 4:\n");
            }
        }
        return null;
    }
}

