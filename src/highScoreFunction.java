import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


class highScoreFunction {

    public static void fileReader() throws FileNotFoundException {
        File highScorePath = new File("src/highScoreList.txt");
        Scanner readHighscore = new Scanner(highScorePath);

        ArrayList<String> highScoreList = new ArrayList<>();
        while (readHighscore.hasNextLine()){
            highScoreList.add(readHighscore.nextLine());
        }

        System.out.println(highScoreList);
    }

    public static void compareScore(ArrayList<String> highScoreList){
        String temporaryStuff = "Karin 0 0 0 0 10";
        String[] splitHighscore = temporaryStuff.split(" ", 6);

        for (int i = 0; i < highScoreList.size(); i++){
            String[] splitActualList = highScoreList.get(i).split(" ", 6);

        }

        int scoreToChange = Integer.parseInt(splitHighscore[5]);


    }

    public static void fileWriter(){

    }



}
