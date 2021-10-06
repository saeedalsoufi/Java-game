package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Score extends StaticBody implements StepListener {


    private Game game;
    private Zombie zombie;




    /**
     * Initialise the score images. This makes it so everytime the player picks up a chicken
     * the score bar changes. Up to 4 chickens

     */

    public Score(World world, Zombie zombie) {
        super(world, new BoxShape(0.55f, 1f));
        addImage(new BodyImage("data/Score1.png", 1f));
        world.addStepListener(this);
        this.zombie = zombie;

    }
    @Override
    public void preStep(StepEvent e) {
        if (zombie.getChickenCount() == 1) {
            removeAllImages();
            addImage(new BodyImage("data/Score2.png", 1f));

        }
        if (zombie.getChickenCount() == 2) {
            removeAllImages();
            addImage(new BodyImage("data/Score3.png", 1f));

        }
        if (zombie.getChickenCount() == 3) {
            removeAllImages();
            addImage(new BodyImage("data/Score4.png", 1f));

        }
        if (zombie.getChickenCount() == 4) {
            removeAllImages();
            addImage(new BodyImage("data/Score5.png", 1f));

        }


    }

    @Override
    public void postStep(StepEvent e) {
        //    view.setCentre(new Vec2(body.getPosition()));


    }




}

