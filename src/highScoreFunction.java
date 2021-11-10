import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class highScoreFunction {

    public static void fileReader(String users) throws IOException {
        File highScorePath = new File("src/highScoreList.txt");
        Scanner readHighscore = new Scanner(highScorePath);

        ArrayList<String> highScoreList = new ArrayList<>();
        while (readHighscore.hasNextLine()) {
            highScoreList.add(readHighscore.nextLine());
        }

        compareScore(highScoreList, users);
    }

    public static void compareScore(ArrayList<String> highScoreList, String users) throws IOException {
        String[] splitHighscore = users.split(" ", 6);
        int newHighscore = Integer.parseInt(splitHighscore[5]);

        for (int i = 0; i < highScoreList.size(); i++) {
            String[] allSavedScore = highScoreList.get(i).split(" ", 6);
            int integerallSavedScore = Integer.parseInt(allSavedScore[1]);
            if (integerallSavedScore < newHighscore) {
                highScoreList.add(i, splitHighscore[0] + " " + splitHighscore[5]);
                highScoreList.remove(5);
                i = highScoreList.size();
            }


        }
        fileWriter(highScoreList);


    }
    public static void fileWriter(ArrayList<String> highScoreList) throws IOException {
        File highScorePath = new File("src/highScoreList.txt");

        BufferedWriter out = new BufferedWriter(new FileWriter (highScorePath));
        for(int i = 0; i < highScoreList.size(); i++){
           out.write(highScoreList.get(i) + "\n");
        }
        out.close();
    }
}




