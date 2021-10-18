import java.io.*;
import java.util.Scanner;

public class SaveWins {

    public Scanner writer = new Scanner(System.in);

        private void writeSaveData (int wins, int losses)

            File saveDataPath;
            File file = new File(saveDataPath, filname);
            try {
                (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(Integer.toString(wins));
                    writer.newLine();
                    writer.write(Integer.toString(losses));

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }


        private void setScores () {

            FileWriter output = null;

            try {

                File F = new File(saveDataPath, filename);
                output = new FileWriter(F);
                BufferedWriter writer = new BufferedWriter(output);
                writer.write(wins);
                writer.newLine();
                writer.write(losses);
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void loadScores () {
            try {

                File file1 = new File(saveDataPath, filename);

                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(new FileInputStream(file1))) {
                    String line = reader.readLine();

                wins = Integer.parseInt(line);

                line = reader.readLine();
                losses = Integer.parseInt(line);

                reader.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
}
