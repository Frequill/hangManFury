import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Takes variables from "Player" class
public class SaveGame extends Player {

    /**
     Method "saveToFile" gathers all information required for saving a game, such as lives lost, current word, who's turn it is etc. Pretty basic.
     */

    public static void saveToFile(ArrayList<Character> allLetters, String guessWord,
    ArrayList<Character> dumbGuesses, int playersLife, ArrayList<Integer> usersPoints,
    int playersTurn, ArrayList<String> users) throws IOException {

        //Files and scanner for "userNames" text files. "lastSavedGame" stores all loadable information and "userNames"-
        //is used to load in all existing usernames so that they can be used after a game is loaded
        File lastSavedGame = new File("src/lastSavedGame.txt");
        File userNames = new File("src/username.txt");
        Scanner scanUserNames = new Scanner(userNames);

        //allUsernames holds all existing usernames from the "userNames" text file
        ArrayList<String> allUsernames = new ArrayList<>();

    while (scanUserNames.hasNextLine()) {
        allUsernames.add(scanUserNames.nextLine());
    }
    scanUserNames.close();


        //"pickUser" variables are used to keep track of which profiles are selected by the players in a saved game
        int pickUser1 = -1;
        int pickUser2 = -1;
        int pickUser3 = -1;
        int pickUser4 = -1;


         //Basic BufferedWriter...
         BufferedWriter out = new BufferedWriter(new FileWriter(lastSavedGame));




         //If-case checks weather two, three or four players were used in last game. If a "pickUser" is equal to 0,
         //we know that that slot is not occupied.
        if (modifyX.getPickUserData4() != -1){
           pickUser1 = modifyX.getPickUserData1();
           pickUser2 = modifyX.getPickUserData2();
           pickUser3 = modifyX.getPickUserData3();
           pickUser4 = modifyX.getPickUserData4();
            out.write(pickUser1 + " " + pickUser2 + " " + pickUser3 + " " + pickUser4);
        }
        else if (modifyX.getPickUserData3() != -1){
            pickUser1 = modifyX.getPickUserData1();
            pickUser2 = modifyX.getPickUserData2();
            pickUser3 = modifyX.getPickUserData3();
            out.write(pickUser1 + " " + pickUser2 + " " + pickUser3);


        }
        else if (modifyX.getPickUserData2() != -1){
            pickUser1 = modifyX.getPickUserData1();
            pickUser2 = modifyX.getPickUserData2();
            out.write(pickUser1 + " " + pickUser2);

        }
        else{
            pickUser1 = modifyX.getPickUserData1();
            out.write(pickUser1);
        }




        //allSavedInfo holds all the text from "lastSavedGame" text file, so it can be "loaded in"
        ArrayList <String> allSavedInfo = new ArrayList<>();

        // Saves current users based on how many users are active.
        if(modifyX.getPickUserData4() != -1){
        allSavedInfo.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()) + "," + allUsernames.get(modifyX.getPickUserData3()) + "," + allUsernames.get(modifyX.getPickUserData4()));
        } else if(modifyX.getPickUserData3() != -1){
            allSavedInfo.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()) + "," + allUsernames.get(modifyX.getPickUserData3()));
        } else if(modifyX.getPickUserData2() != -1){
            allSavedInfo.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()));
        } else if(modifyX.getPickUserData2() == -1){
            allSavedInfo.add(allUsernames.get(modifyX.getPickUserData1()));
        }

        //Underneath all stats are printed to the "lastSavedGame" text file so that the information can be loaded later

        //allLetters holds all letters the players need to guess to "win" that word.
        out.write("\n");
        for(int i = 0; i < allLetters.size(); i++){
            out.write(allLetters.get(i) + " ");
        }
        //dumbGuesses holds all incorrect inputs the players make.
        out.write("\n");
        for(int i = 0; i < dumbGuesses.size(); i++){
            out.write(dumbGuesses.get(i) + " ");
        }

        //userPoints holds every players current points.
        out.write("\n");
        for(int i = 0; i < usersPoints.size(); i++){
            out.write(usersPoints.get(i) + " ");
        }
        //Incorrect guesses made by the players
        allSavedInfo.add (guessWord);// Users current points
        allSavedInfo.add(String.valueOf(playersLife)); // amount of life




        //playersTurn keeps track of whose turn it is to guess the next letter. (It works much better than it looks)
        if (playersTurn == 2 || playersTurn == 3 || playersTurn == 4) {
            allSavedInfo.add(String.valueOf(playersTurn));
        } else if (playersTurn == 1){ // playersTurn is an INTEGER, users.get is an INDEX, users is an ARRAYLIST
            if (users.get(3) != null){
                allSavedInfo.add(String.valueOf(4));
            }
            else if (users.get(3) == null && users.get(2) != null){
                allSavedInfo.add(String.valueOf(3));
            }
            else if (users.get(2) == null && users.get(1) != null){
                allSavedInfo.add(String.valueOf(2));
            }
        }



        //Finally, stores all information into "lastSavedGame.txt"
        for (int i = 0; i < allSavedInfo.size(); i++){
            out.write("\n" + allSavedInfo.get(i));
        }
        out.close();
    }
}
