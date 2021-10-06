package game;

import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {

    private String fileName;
    private Game game;
    private Man man;
    private GameLevel world;

    /**
     * Initialise a new HighScoreReader
     *
     * @param fileName the name of the high-score file
     */
    public GameLoader(String fileName, Game g) {
        this.fileName = fileName;
        game = g;
    }

    /**
     * Loads the game into the state the player was in when the game was saved
     */
    public GameLevel loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {

            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            String[] tokens = line.split(",");
            int levelNumber = Integer.parseInt(tokens[0]);
            float xPlayer = Float.parseFloat(tokens[1]);
            float yPlayer = Float.parseFloat(tokens[2]);

            Vec2 posPlayer = new Vec2(xPlayer,yPlayer);

            GameLevel level = null;

            if (levelNumber == 1) {
                level = new Level1();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            } else if (levelNumber == 2) {
                level = new Level2();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            }else if (levelNumber == 3) {
                level = new Level3();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            }else if (levelNumber == 4) {
                level = new Level4();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            }
            return level;

        }

        finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
