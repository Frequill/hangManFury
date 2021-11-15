import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Takes variables from "MultiPlayer" class
public class LoadGame extends MultiPlayer {

    /**
     "gameLoader" method retrieves all relevant information and loads back a saved game
     */
    public static void gameLoader () throws Exception {
        //Scans "lastSavedGame" to get the information needed to load a saved game
        File savedGame = new File("src/lastSavedGame.txt");
        Scanner read = new Scanner(savedGame);


        //"loadedGame" holds all the saved information
        ArrayList<String> loadedGame = new ArrayList<>();
        while (read.hasNextLine()) {
            loadedGame.add(read.nextLine());
        }



        //******************************** PickUsers *********************************
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
        //****************************************************************************



        //************************** Users and UsersPoints **********************************
        String[] users = loadedGame.get(4).split(",", 9);
        String[] usersPoints = loadedGame.get(3).split(" ", 9);





        // Retrieves the amount of life remaining from the saved game
        int playerLife = Integer.parseInt(loadedGame.get(6));
        modify.setPlayerLife(playerLife);


        // Makes sure that the player whose turn it was gets their turn again upon resume
        int turnPlayer = Integer.parseInt(loadedGame.get(7));
        modify.setPlayersTurn(turnPlayer-1); // -1 is important to fix a stupid bug (It wasn't a bug, it was a feature)


        //If-case ensures that game will work even if no wrongful guesses has been made
        if (loadedGame.get(2).equals("")){
            modify.getDumbGuesses().clear();
        }
        else {
            String[] splitDumbGuesses = loadedGame.get(2).split(" ");
            for (int i = 0; i < splitDumbGuesses.length; i++) {
                modify.getDumbGuesses().add(splitDumbGuesses[i].charAt(0));
            }
        }


        //"Splits" all the letters of the current word so that they can be checked individually
        String[] splitAllLetters = loadedGame.get(1).split(" ");
        for(int i = 0; i < splitAllLetters.length; i++){
            modify.getAllLetters().add(splitAllLetters[i].charAt(0));
        }

        //Retrieves and sets the word that the players are supposed to guess
        String guessWord = loadedGame.get(5);
        modify.setGuessWord(guessWord);




        /* The "lastSavedGame" text file is emptied when the game is loaded since it's never needed twice,
        (if a game is loaded the only way to get out is to win or to save again)
        This also fixes some annoying issues and a crash. */
        PrintWriter clearSavedGame = new PrintWriter(savedGame);
        clearSavedGame.print("");
        clearSavedGame.close();



        /* Variable "hasSeenLoadMenu" is always either "1" or "2". This means that the game can know whether
        a game is loaded or if a new game is created based on if it has "seen" this class or not.
        Thus, the game knows if it should retrieve or create new variables! */
        modify.setHasSeenLoadMenu(1);


        /* Retrives the current amount of users and all their respective points based on how many players were
        selected when the saved game was started. The "hangMan" meathod in the "MultiPlayer" class is also called
        with the relevant information!
         */
        if(users.length == 2){
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
            Menu.loadUsersFunction(users[0],users[1],null,null);
            hangMan(users[0],users[1],null,null);


        }
        else if (users.length == 3) {
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
            modify.getUsersPoints().add(2,Integer.parseInt(usersPoints[2]));
            Menu.loadUsersFunction(users[0],users[1],users[2],null);
            hangMan(users[0],users[1],users[2], null);
        }
        else if (users.length == 4){
            modify.getUsersPoints().add(0,Integer.parseInt(usersPoints[0]));
            modify.getUsersPoints().add(1,Integer.parseInt(usersPoints[1]));
            modify.getUsersPoints().add(2,Integer.parseInt(usersPoints[2]));
            modify.getUsersPoints().add(3,Integer.parseInt(usersPoints[3]));
            Menu.loadUsersFunction(users[0],users[1],users[2],users[3]);
            hangMan(users[0],users[1],users[2],users[3]);
        }
    }
}
