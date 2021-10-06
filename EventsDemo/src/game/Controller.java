package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    //defines variables and creates new objects of existed classes
    private static final float JUMPING_SPEED = 13.5f;
    private static final float WALKING_SPEED = 5;
    
    private Walker body;
    private static BodyImage walking;
    private static BodyImage cheer;
    private static BodyImage standing;
    private Game game;
    private GameLevel currentLevel;

    //Creates a construcor for controller taking body, gamelevel and game as parameters.
    public Controller(Walker body, GameLevel level, Game game) {
        this.body = body;
        currentLevel = level;
        this.game = game;

        //Stores images of my character

        walking = new BodyImage("data/zombie_walk1.png", 3.50f);
        cheer = new BodyImage("data/zombie_cheer1.png", 3.50f);
        standing = new BodyImage("data/zombie_stand.png", 3.50f);

    }
    
    /**
     * Handle key press events for walking and jumping, also it makes the character cheer when pressing X.
     * In addition, it handles the events for saving and loading.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //Controlling the main character using WASD and arrows
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // L = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left

        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            body.removeAllImages();
            body.addImage(walking);

        }
        else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left

        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            body.removeAllImages();
            body.addImage(walking);

        }
        else if (code == KeyEvent.VK_X){
            body.removeAllImages();
            body.addImage(cheer);

        }
        //By pressing S this saves the game's current state
        else if (code == KeyEvent.VK_S){
            GameSaver ws = new GameSaver("data/scores.txt");
            try {
                ws.saveGame(currentLevel);
            } catch (IOException ex){
                ex.printStackTrace();
            }
            //Reloads the game when the player presses R
        } else if (code == KeyEvent.VK_R){
            GameLoader sr = new GameLoader("data/scores.txt", game);
            try {
                GameLevel loadedGame = sr.loadGame();
                game.goToLevel(loadedGame);
            } catch (IOException ex){
                ex.getStackTrace();
            }
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(standing);
        }
        else if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(standing);
        }
        else if (code == KeyEvent.VK_X) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(standing);
        }

    }
    public void setBody(Walker body){
        this.body = body;
    }

    public void setWorld(GameLevel level){
        this.currentLevel = level;
    }
}
