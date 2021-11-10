import java.io.File;

public class SaveGame {

    public static void saveToFile(){

        Player playerClass = new Player();
        File lastSavedGame = new File("src/lastSavedGame");
        int pickUser1 = -1;
        int pickUser2 = -1;
        int pickUser3 = -1;
        int pickUser4 = -1;

        if (playerClass.getPickUserData4() != -1){
           pickUser1 = playerClass.getPickUserData1();
           pickUser2 = playerClass.getPickUserData2();
           pickUser3 = playerClass.getPickUserData3();
           pickUser4 = playerClass.getPickUserData4();
        }
        else if (playerClass.getPickUserData3() != -1){
            pickUser1 = playerClass.getPickUserData1();
            pickUser2 = playerClass.getPickUserData2();
            pickUser3 = playerClass.getPickUserData3();
        }
        else if (playerClass.getPickUserData2() != -1){
            pickUser1 = playerClass.getPickUserData1();
            pickUser2 = playerClass.getPickUserData2();
        }
        else{
            pickUser1 = playerClass.getPickUserData1();
        }


        // Pickuser 1, 2, 3 och 4
        // usersPoints[]
        // Playerlife
        // guessword, allLetters OCH dumbGuesses

    }


}
