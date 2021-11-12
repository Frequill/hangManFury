import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveGame extends Player {

public static void saveToFile(ArrayList<Character> allLetters, String guessWord,
ArrayList<Character> dumbGuesses, int playersLife, ArrayList<Integer> usersPoints, int amountOfPlayers, ArrayList<String> users) throws IOException {

       // Player playerClass = new Player();
        File lastSavedGame = new File("src/lastSavedGame.txt");
        File userNames = new File("src/username.txt");
    Scanner scanUserNames = new Scanner(userNames);

    ArrayList<String> allUsernames = new ArrayList<>();

    while (scanUserNames.hasNextLine()) {
        allUsernames.add(scanUserNames.nextLine());
    }
    scanUserNames.close();


        int pickUser1 = -1;
        int pickUser2 = -1;
        int pickUser3 = -1;
        int pickUser4 = -1;

    BufferedWriter out = new BufferedWriter(new FileWriter(lastSavedGame));

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
            //allPickUsers.add(pickUser1);
        }

        ArrayList <String> test = new ArrayList<>();
        if(modifyX.getPickUserData4() != -1){
        test.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()) + "," + allUsernames.get(modifyX.getPickUserData3()) + "," + allUsernames.get(modifyX.getPickUserData4()));
        } else if(modifyX.getPickUserData3() != -1){
            test.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()) + "," + allUsernames.get(modifyX.getPickUserData3()));
        } else if(modifyX.getPickUserData2() != -1){
            test.add(allUsernames.get(modifyX.getPickUserData1()) + "," + allUsernames.get(modifyX.getPickUserData2()));
        } else if(modifyX.getPickUserData2() == -1){
            test.add(allUsernames.get(modifyX.getPickUserData1()));
        }




        out.write("\n");
        for(int i = 0; i < allLetters.size(); i++){
            out.write(allLetters.get(i) + " ");
        }
        // Word
        out.write("\n");
        for(int i = 0; i < dumbGuesses.size(); i++){
            out.write(dumbGuesses.get(i) + " ");
        }

        out.write("\n");
        for(int i = 0; i < usersPoints.size(); i++){
            out.write(usersPoints.get(i) + " ");
        }
        // Incorrect guesses made by the players
        test.add (guessWord);// Users current points
        test.add(String.valueOf(playersLife)); // amount of life

        if (amountOfPlayers == 2 || amountOfPlayers == 3 || amountOfPlayers == 4){
            test.add(String.valueOf(amountOfPlayers)); // The current users turn
        }

        else if (amountOfPlayers == 1){ // amountOfPlayers is an INTEGER, users.get is an INDEX, users is an ARRAYLIST
            if (users.get(3) != null){
                test.add(String.valueOf(4));
            }
            else if (users.get(3) == null && users.get(2) != null){
                test.add(String.valueOf(3));
            }
            else if (users.get(2) == null && users.get(1) != null){
                test.add(String.valueOf(2));
            }
        }


        //BufferedWriter out = new BufferedWriter(new FileWriter(lastSavedGame));

        for (int i = 0; i < test.size(); i++){
            out.write("\n" + test.get(i));
        }
        out.close();

        

    }
}
