package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    //This class allows the zombie to "pick up" chickens
    private Zombie zombie;
    private SoundClip ChickenSound;
    
    public Pickup(Zombie zombie) {
        this.zombie = zombie;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == zombie) {
            try {
                ChickenSound = new SoundClip("data/eating.wav");
                ChickenSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a){
                System.out.println(a);
            }
            zombie.incrementChickenCount();
            e.getReportingBody().destroy();
        }
    }
    
}
