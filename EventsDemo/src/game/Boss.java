package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Boss extends Walker implements StepListener{

    // This is the boss where is introudced in level 4.
    // Below is the polygonshape coordinates
    private static final Shape shape = new PolygonShape(
            0.87f,-1.77f, -0.92f,-1.77f, -0.94f,0.72f, -0.19f,1.24f, 0.95f,0.81f, 0.98f,-1.46f);

    private static final BodyImage image =
            new BodyImage("data/player_idle.png", 4.50f);




    public Boss(World world2) {
        super(world2, shape);
        addImage(image);
        world2.addStepListener(this);
        startWalking(-10);
    }
    //This is prestep allows the enemy to move by itself.

    public void preStep(StepEvent e) {
        if (getPosition().x <= -29) {
            startWalking(10);

        }
        if (getPosition().x >= 29) {
            startWalking(-10);
        }


    }
    @Override
    public void postStep(StepEvent e) {


    }




}
