import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean victory = false;
        int playerLife = 10;
        Scanner in = new Scanner(System.in);
        while(victory == false||playerLife == 0){

            String placeholder = "Newton".toLowerCase();
            System.out.println("Welcome to Hang Man guess the word that is " + placeholder.length() + " letters long!");
            String letter = in.next().toLowerCase();

            for(int i = 0; i<placeholder.length(); i++){
                if(letter.charAt(0) == placeholder.charAt(i)){
                    System.out.println(letter);
                }
                else if(letter.charAt(0) != placeholder.charAt(i)){
                    System.out.println("_");
                    lifeTaker(playerLife);
                    victory = true;
                }
                else{
                    System.out.println("BLÖ");

                }
            }
            //victory = true; // placeholder

        }
    }






    public static int lifeTaker(int playerLife){
        playerLife = playerLife -1;
        System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
        return playerLife;
    }

}
