import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveGame extends Player {

public static void saveToFile(ArrayList<Character> allLetters, String guessWord,
ArrayList<Character> dumbGuesses, int playersLife, ArrayList<Integer> usersPoints) throws IOException {

       // Player playerClass = new Player();
        File lastSavedGame = new File("src/lastSavedGame.txt");
        int pickUser1 = -1;
        int pickUser2 = -1;
        int pickUser3 = -1;
        int pickUser4 = -1;
        ArrayList<Integer> allPickUsers = new ArrayList<>();

        if (modifyX.getPickUserData4() != -1){
           pickUser1 = modifyX.getPickUserData1();
           pickUser2 = modifyX.getPickUserData2();
           pickUser3 = modifyX.getPickUserData3();
           pickUser4 = modifyX.getPickUserData4();

           allPickUsers.add(pickUser1);
           allPickUsers.add(pickUser2);
           allPickUsers.add(pickUser3);
           allPickUsers.add(pickUser4);
        }
        else if (modifyX.getPickUserData3() != -1){
            pickUser1 = modifyX.getPickUserData1();
            pickUser2 = modifyX.getPickUserData2();
            pickUser3 = modifyX.getPickUserData3();

            allPickUsers.add(pickUser1);
            allPickUsers.add(pickUser2);
            allPickUsers.add(pickUser3);

        }
        else if (modifyX.getPickUserData2() != -1){
            pickUser1 = modifyX.getPickUserData1();
            pickUser2 = modifyX.getPickUserData2();

            allPickUsers.add(pickUser1);
            allPickUsers.add(pickUser2);
        }
        else{
            pickUser1 = modifyX.getPickUserData1();

            allPickUsers.add(pickUser1);
        }

        ArrayList <String> test = new ArrayList<>();
        test.add(allPickUsers.toString());
        test.add(allLetters.toString());
        test.add (guessWord);
        test.add(dumbGuesses.toString());
        test.add(usersPoints.toString());
        test.add(String.valueOf(playersLife));

        //System.out.println(test);

        BufferedWriter out = new BufferedWriter(new FileWriter(lastSavedGame));

        for (int i = 0; i < test.size(); i++){
            out.write(test.get(i) + "\n");
        }
        out.close();

        /*System.out.println(pickUser1 + " " + pickUser2 + " " + pickUser3 + " " + pickUser4);
        System.out.println(allLetters);
        System.out.println(guessWord);
        System.out.println(dumbGuesses);
        System.out.println(usersPoints);
        System.out.println(playersLife + ":)");*/

        // Pickuser 1, 2, 3 och 4
        // usersPoints[]
        // Playerlife
        // guessword, allLetters OCH dumbGuesses

    }


}
