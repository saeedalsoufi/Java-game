package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {

    //defines variables and creates new objects of existed classes
    private Zombie player;
    private Heart heart;
    private Heart2 heart2;
    private Heart3 heart3;
    private Heart4 heart4;
    private Score score;

    
    public Zombie getPlayer() {
        return player;
    }



    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        //Creates the main character
        player = new Zombie(this);
        player.setPosition(startPosition());
        //creates the hearts
        heart = new Heart(this, getPlayer());
        heart.setPosition(new Vec2(-29, 16));
        //Creates the score image
        score = new Score(this, getPlayer());
        score.setPosition(new Vec2(-22.5f, 14));
        ScoreImage scoreImage = new ScoreImage(this);
        scoreImage.setPosition(new Vec2(-28.5f, 14));
        //creates the hearts
        heart2 = new Heart2(this, getPlayer());
        heart2.setPosition(new Vec2(-26.5f, 16));
        heart3 = new Heart3(this, getPlayer());
        heart3.setPosition(new Vec2(-24f, 16));
        heart4 = new Heart4(this, getPlayer());
        heart4.setPosition(new Vec2(-21.5f, 16));
        //Creates the door
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));




    }

    //This pulls the positions info from each level


    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    public abstract int getLevelNumber();
}
