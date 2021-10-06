package game;

import java.io.FileWriter;
import java.io.IOException;

//Saves the state of the game itno a text file when the player decideds to save the game

public class GameSaver {
    private String fileName;

    public GameSaver(String fileName) {
        this.fileName = fileName;
    }


    public void saveGame(GameLevel gameLevel) throws IOException {
        FileWriter writer = null;
        System.out.println(gameLevel.getLevelNumber() + "," +
                gameLevel.getPlayer().getPosition().x + "," +
                gameLevel.getPlayer().getPosition().y +"\n");
        try {
            writer = new FileWriter(fileName);
            writer.write(gameLevel.getLevelNumber() + "," +
                    gameLevel.getPlayer().getPosition().x + "," +
                    gameLevel.getPlayer().getPosition().y +"\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
