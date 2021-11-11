import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveGame extends Player {

public static void saveToFile(ArrayList<Character> allLetters, String guessWord,
ArrayList<Character> dumbGuesses, int playersLife, ArrayList<Integer> usersPoints, int amountOfPlayers, ArrayList<String> users) throws IOException {

       // Player playerClass = new Player();
        File lastSavedGame = new File("src/lastSavedGame.txt");
        int pickUser1;
        int pickUser2;
        int pickUser3;
        int pickUser4;

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
        test.add(users.get(0) + " " + users.get(1) + " " + users.get(2) + " " + users.get(3)); // Users actual full names in strings
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
        test.add(String.valueOf(amountOfPlayers)); // The current users turn


        //BufferedWriter out = new BufferedWriter(new FileWriter(lastSavedGame));

        for (int i = 0; i < test.size(); i++){
            out.write("\n" + test.get(i));
        }
        out.close();


        LoadGame.gameLoader();

    }
}