import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// ****************************************** Instance variables and object *******************************************
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
    public static ArrayList <Integer> allUserNumbers = new ArrayList();

    public static Player modifyX = new Player();

    //******************************************** Functions *********************************************

    /**
     This method stores different usernames in a text file for later use
     */
    public static String writeUsername() throws Exception {
        Scanner in = new Scanner(System.in);
        File toUsername = new File("src/username.txt");

        System.out.println("Please enter your username: (NO SPACES!!)");
        String usersInput = in.next();

        String newUser = usersInput+" 0"+" 0"+" 0";
        Writer out;
        out = new BufferedWriter(new FileWriter(toUsername,true));
        out.append("\n" + newUser);
        out.close();

        userArray(newUser);

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

        modifyX.pickUserData = allUsernames.size()-1;
        modifyX.setPickUserData(modifyX.pickUserData);
    }

    /**
     This method increases the users overall matches played!
     */
    public static void matchAdder(int userInQuestion) throws Exception {
        File usernameFile = new File("src/username.txt");
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 4);


        int x = Integer.parseInt(userSplitter[1]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[1] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
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
        String userName = allUsernames.get(userInQuestion);
        String[] userSplitter = userName.split(" ", 4);

        int x = Integer.parseInt(userSplitter[2]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[2] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);


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
        String[] userSplitter = userName.split(" ", 4);

        int x = Integer.parseInt(userSplitter[3]);
        x = x + 1;
        String x2 = String.valueOf(x);
        userSplitter[3] = x2;

        String finalResult = userSplitter[0] + " " + userSplitter[1] + " " + userSplitter[2] + " " +userSplitter[3];
        allUsernames.set(userInQuestion, finalResult);

        PrintWriter out = new PrintWriter(usernameFile);
        for (int i = 0; i < allUsernames.size(); i++){
            out.print(allUsernames.get(i) + "\n");
        }
        out.close();
    }

    // Three basic "callers" that allows us to access instance variables of the "Player" class from other classes

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

    public static String readUsername(String user) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userChoice = 0;


        while (run) {
            while (!input.hasNextInt()){
                System.out.println("\nPlease input an integer between 1 - 3:\n");
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
                int last = aList.size()+1;
                System.out.println(last+")" + " Back");
                boolean run2 = true;

                int pickUser = 0;
                while(run2) {
                   while (!input.hasNextInt()) {
                       System.out.println("Please input an appropriate integer! ");
                       input.next();
                   }
                   pickUser = input.nextInt();
                   if(pickUser < 1 || pickUser >= last+1){
                       System.out.println("Choice was out of bounds! ");
                   }
                   else if(allUserNumbers.contains(pickUser)){
                       System.out.println("You can`t reselect a profile that was used earlier!!");
                   }
                   else if(pickUser == last){
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
                modifyX.setPickUserData(pickUser);
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
                System.out.println("\nPlease enter an *integer* greater than 0 and lower than 3:\n");
            }
        }
        return null;
    }
}

