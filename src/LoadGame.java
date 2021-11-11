import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGame extends Player {
    private static int hasSeenLoadMenu = 0;

    public static int getHasSeenLoadMenu() {
        return hasSeenLoadMenu;
    }

    public static void setHasSeenLoadMenu(int hasSeenLoadMenu) {
        LoadGame.hasSeenLoadMenu = hasSeenLoadMenu;
    }



    public static void gameLoader () throws FileNotFoundException {
        File savedGame = new File("src/lastSavedGame.txt");
        Scanner read = new Scanner(savedGame);

        ArrayList<String> loadedGame = new ArrayList<>();
        while (read.hasNextLine()) {
            loadedGame.add(read.nextLine());
        }
        //System.out.println(loadedGame);
        String[] splitPickUsers = loadedGame.get(0).split(" ", 4);

        modifyX.setPickUserData1(Integer.parseInt(splitPickUsers[0]));
        modifyX.setPickUserData2(Integer.parseInt(splitPickUsers[1]));

        if(splitPickUsers[3] != null){
            modifyX.setPickUserData3(Integer.parseInt(splitPickUsers[2]));
            modifyX.setPickUserData4(Integer.parseInt(splitPickUsers[3]));
        }
        else if (splitPickUsers[2] != null){
            modifyX.setPickUserData3(Integer.parseInt(splitPickUsers[2]));
        }

        String [] usersPoints = loadedGame.get(5).split(",", 9);

        System.out.println(usersPoints[0]);

        LoadGame.setHasSeenLoadMenu(hasSeenLoadMenu++);


        //ResumeGame.hangMan();

        // FUCK THIS GAME!!

    }


}
