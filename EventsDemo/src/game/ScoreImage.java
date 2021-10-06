package game;

import city.cs.engine.*;

public class ScoreImage extends StaticBody {

    /**
     * Initialise the score word image
     * @param world The world.
     */
    public ScoreImage(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/Score.png", 2.8f));
    }
}
