package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Enemy2 extends Walker implements StepListener{

    // This is the enemy that is introuduced in level 2 and stays till level 3 is finished.
    // Below is the polygonshape coordinates
    private static final Shape shape = new PolygonShape(
            0.87f,-1.77f, -0.92f,-1.77f, -0.94f,0.72f, -0.19f,1.24f, 0.95f,0.81f, 0.98f,-1.46f);

    private static final BodyImage image =
            new BodyImage("data/adventurer_stand.png", 3.50f);




    public Enemy2(World world2) {
        super(world2, shape);
        addImage(image);
        world2.addStepListener(this);
        startWalking(-7);
    }
    //This is prestep allows the enemy to move by itself.

    public void preStep(StepEvent e) {
        if (getPosition().x >= 29) {
            startWalking(-7);

        }
        if (getPosition().x <= 19.5f) {
            startWalking(7);
        }



    }
    @Override
    public void postStep(StepEvent e) {
        //    view.setCentre(new Vec2(body.getPosition()));



    }




}
