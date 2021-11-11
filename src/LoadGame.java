import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGame extends ResumeGame {

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
            Player.pickUser1Setter(Integer.parseInt(splitPickUsers[0]));
            Player.pickUser2Setter(Integer.parseInt(splitPickUsers[1]));

        if(splitPickUsers.length == 4){
            Player.pickUser3Setter(Integer.parseInt(splitPickUsers[2]));
            Player.pickUser4Setter(Integer.parseInt(splitPickUsers[3]));
        }
        else if (splitPickUsers.length == 3){
            Player.pickUser3Setter(Integer.parseInt(splitPickUsers[2]));
        }



        //***************************Users and UsersPoints***********************************
        String [] users = loadedGame.get(4).split(" ", 9);
        String [] usersPoints = loadedGame.get(3).split(" ", 9);


        if(!users[3].equals("null")){
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
            modify.getUsersPoints().add(2,Integer.parseInt(usersPoints[2]));
            modify.getUsersPoints().add(3,Integer.parseInt(usersPoints[3]));
        }
        else if (!users[2].equals("null")) {
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
            modify.getUsersPoints().add(2,Integer.parseInt(usersPoints[2]));
        }
        else{
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
        }

        //**************************************************************
        int playerLife = Integer.parseInt(loadedGame.get(6));
        modify.setPlayerLife(playerLife);



        int turnPlayer = Integer.parseInt(loadedGame.get(7));
        modify.setAmountOfPlayers(turnPlayer);



        String[] splitDumbGuesses = loadedGame.get(2).split(" ");
        for(int i = 0; i < splitDumbGuesses.length; i++){
            modify.getDumbGuesses().add(splitDumbGuesses[i].charAt(0));
        }


        String[] splitAllLetters = loadedGame.get(1).split(" ");
        for(int i = 0; i < splitAllLetters.length; i++){
            modify.getAllLetters().add(splitAllLetters[i].charAt(0));
        }



        String guessWord = loadedGame.get(5);

        modify.setGuessWord(guessWord);


        /*PrintWriter clearSavedGame = new PrintWriter(savedGame);
        clearSavedGame.print("");
        clearSavedGame.close();*/

        modify.setHasSeenLoadMenu(1);

        hangMan(users[0],users[1],users[2],users[3]);
    }
}
