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
           boolean guessCorrect = false;
           boolean guessIncorrect = false;
            for(int i=0; i < placeholder.length();i++){
                System.out.print("_ ");
            }

            String letter = in.next().toLowerCase();

            for(int i = 0; i<placeholder.length(); i++){
                if(letter.charAt(0) == placeholder.charAt(i)){
                   guessCorrect = true;
                }
                else if(letter.charAt(0) != placeholder.charAt(i)){
                    guessIncorrect = true;
                }
                else{
                    System.out.println("BLÖ");

                }
            }
            if(guessCorrect) {

                String result = correctLetter(letter, placeholder);
                System.out.println(result);
            }
            else if(guessIncorrect){
                lifeTaker(playerLife);
            }

            victory = true; // placeholder

        }
    }

    public static int lifeTaker(int playerLife){
        playerLife = playerLife -1;
        System.out.println("Incorrect guess! You have lost one life!" + "\n(" + playerLife + " lives remaining)");
        return playerLife;
    }
    public static String correctLetter (String letter, String placeholder){

        for(int i=0; i < placeholder.length();i++){
            if(letter.charAt(i) == placeholder.charAt(i)){

                return letter;
            }
            else if(letter.charAt(i) != placeholder.charAt(i)){
                return letter;
            }

        }


        return null;

    }

}
