import javax.sound.midi.Soundbank;
import java.io.*;

public class GameState {
    String flag = "flag";
    File file = new File("src//GameState.txt");
    public static void main(String[] args) {
    }
}

class SaveGameState extends GameState {
    public void SaveGameDataToFile(File file) {

        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(flag);

            objectStream.close();
            fileStream.close();

            System.out.println("Save game completed!");
        } catch (Exception e) {
            System.out.println("\nFailed to save game!");
        }
    }

class LoadGameState extends GameState {
        public void loadGameStateFromFile(File file) {

            FileInputStream fileStream = new FileInputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            savedFlag = (String) objectStream.readObject();
        }
    }
}
