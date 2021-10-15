import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Player {

    private String instanceVarUsername;

    public String getInstanceVarUsername(String user) {
        instanceVarUsername = user;
        return instanceVarUsername;
    }

    private static int pickUser = 0;

    public Player (int pickUser){
        this.pickUser = pickUser;
    }
    public static int getPickUser() {
        return pickUser;
    }

    /**
     * This method stores different usernames in a text file for later use
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

        for (int i = 0; i < newUsername.length(); i++) {
            PrintWriter out = new PrintWriter("src/username.txt");
            out.println(usernameSaver + " " + newUsername);
            out.close();
        }
        newUserScore();
        //addUserScore();
        //This selects the new user immediately
        return usersInput;
    }

    /**
     * This method exists to save userscore in default "zeroes" and then increase over time based on wins
     */

    static void newUserScore() throws Exception {
        int defaultScore = 0;

        File toScorePlaceholder = new File("src/userScorePlaceholder.txt");
        File toUserScore = new File("src/userScore.txt");

        //This Printwriter stores the users score in the "userScorePlaceholder" textfile
        PrintWriter output = new PrintWriter(toScorePlaceholder);
        output.println(defaultScore);
        output.close();

        Scanner readScorePlaceholder = new Scanner(toScorePlaceholder);
        Scanner readUserScore = new Scanner(toUserScore);
        String newUserScore = readScorePlaceholder.nextLine();
        String ScoreSaver = readUserScore.nextLine();
        readScorePlaceholder.close();

        for (int i = 0; i < newUserScore.length(); i++) {
            PrintWriter out = new PrintWriter("src/userScore.txt");
            out.println(ScoreSaver + " " + newUserScore);
            out.close();
        }
    }

    /**
     * This method shows the user all available usernames and allows user to select an already existing username
     */

    public static String readUsername(String user) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userChoice = 0;

        while (run) {
            while (!input.hasNextInt()) {
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
                //int pickUser = 0;

                while (run2) {
                    while (!input.hasNextInt()) {
                        System.out.println("Please input an appropriate integer! ");
                        input.next();
                    }
                    pickUser = input.nextInt();
                    if (pickUser < 1 || pickUser >= aList.size()) {
                        System.out.println("Choice was out of bounds! ");
                    } else {
                        run2 = false;
                    }
                }
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


    public static void addUserScore(int pickUser) throws Exception {
        pickUser = getPickUser();
        File userScore = new File("src/userScore.txt");
        Scanner readUserScore = new Scanner(userScore);
        PrintWriter out = new PrintWriter(userScore);

        ArrayList<String> userScoreinStringsList = new ArrayList<>();
        ArrayList<Integer> userScoresList = new ArrayList<>();

        while (readUserScore.hasNext()) {
            userScoreinStringsList.add(readUserScore.next());
        }
        for (int i = 1; i < userScoreinStringsList.size(); i++){
            int StringtoInt = Integer.parseInt(userScoreinStringsList.get(i));
            userScoresList.add(StringtoInt);
        }
        userScoresList.set(pickUser, +1);
        //PrintWriter out = new PrintWriter(userScore);


        for (int j = 0; j < userScoresList.size(); j++){
             out.write(userScoresList.get(j).toString());
            //String x = userScoresList.get(j).toString();
            //out.print(x);
            out.close();
        }


         /* for (int i2 = 0; i2 < userScoresList.size(); i2++){
            System.out.println(userScoresList.get(i2));
        }*/
    }



}

