import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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



    public static void gameLoader () throws Exception {
        File savedGame = new File("src/lastSavedGame.txt");
        Scanner read = new Scanner(savedGame);

        ArrayList<String> loadedGame = new ArrayList<>();
        while (read.hasNextLine()) {
            loadedGame.add(read.nextLine());
        }
        //System.out.println(loadedGame);


        //********************************PickUsers***********************************
        String[] splitPickUsers = loadedGame.get(0).split(" ", 8);

        modifyX.setPickUserData1(Integer.parseInt(splitPickUsers[0]));
        modifyX.setPickUserData2(Integer.parseInt(splitPickUsers[1]));

        if(splitPickUsers.length == 4){
            modifyX.setPickUserData3(Integer.parseInt(splitPickUsers[2]));
            modifyX.setPickUserData4(Integer.parseInt(splitPickUsers[3]));
        }
        else if (splitPickUsers.length == 3){
            modifyX.setPickUserData3(Integer.parseInt(splitPickUsers[2]));
        }



        //***************************Users and UsersPoints***********************************
        String [] users = loadedGame.get(4).split(" ", 9);
        String [] usersPoints = loadedGame.get(3).split(" ", 9);

        if (users[2] == null) {
            ResumeGame.modify.getUsersPoints().set(0,Integer.parseInt(usersPoints[0]));
            ResumeGame.modify.getUsersPoints().set(1,Integer.parseInt(usersPoints[1]));
        } else if (users[3] == null) {
            ResumeGame.modify.getUsersPoints().set(0,Integer.parseInt(usersPoints[0]));
            ResumeGame.modify.getUsersPoints().set(1,Integer.parseInt(usersPoints[1]));
            ResumeGame.modify.getUsersPoints().set(2,Integer.parseInt(usersPoints[2]));
        } else {
            ResumeGame.modify.getUsersPoints().set(0,Integer.parseInt(usersPoints[0]));
            ResumeGame.modify.getUsersPoints().set(1,Integer.parseInt(usersPoints[1]));
            ResumeGame.modify.getUsersPoints().set(2,Integer.parseInt(usersPoints[2]));
            ResumeGame.modify.getUsersPoints().set(3,Integer.parseInt(usersPoints[3]));

        }

        //**************************************************************
        int playerLife = Integer.parseInt(loadedGame.get(6));
        ResumeGame.modify.setPlayerLife(playerLife);



        int turnPlayer = Integer.parseInt(loadedGame.get(7));
        ResumeGame.modify.setAmountOfPlayers(turnPlayer);

        String[] splitDumbGuesses = loadedGame.get(2).split(" ", 9);
        for(int i = 0; i < splitDumbGuesses.length; i++){
            ResumeGame.modify.getDumbGuesses().add(splitDumbGuesses[i].charAt(0));
        }
        String[] splitAllLetters = loadedGame.get(1).split(" ", 9);
        for(int i = 0; i < splitAllLetters.length; i++){
            ResumeGame.modify.getAllLetters().add(splitAllLetters[i].charAt(0));
        }

        String guessWord = loadedGame.get(5);

        ResumeGame.modify.setGuessWord(guessWord);

        PrintWriter clearSavedGame = new PrintWriter(savedGame);

        clearSavedGame.print("");
        clearSavedGame.close();

        LoadGame.setHasSeenLoadMenu(hasSeenLoadMenu++);

        ResumeGame.hangMan(users[0],users[1],users[2],users[3]);











        //ResumeGame.hangMan();

        // FUCK THIS GAME!!

    }


}
