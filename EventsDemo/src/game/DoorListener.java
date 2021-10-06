package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    private SoundClip DoorSound;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    //Adds a collision so when the player collides with the door, with enough chickens collected-
    //the next level starts

    @Override
    public void collide(CollisionEvent e) {
        Zombie player = game.getPlayer();
        if (e.getOtherBody() == player) {
            try {
                DoorSound = new SoundClip("data/glass-hit.wav");
                DoorSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a){
                System.out.println(a);
            }
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
