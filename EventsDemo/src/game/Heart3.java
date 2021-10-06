package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Heart3 extends StaticBody implements StepListener {


    private Heart heart;
    private Zombie zombie;




    /**
     * Initialise a new heart.
     * @param world The world.
     */

    public Heart3(World world, Zombie zombie) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/Heart.png", 2.8f));
        world.addStepListener(this);
        this.zombie = zombie;
    }
    @Override
    public void preStep(StepEvent e) {
        if (zombie.HealthBar == 50) {
            destroy();
        }


    }

    @Override
    public void postStep(StepEvent e) {
        //    view.setCentre(new Vec2(body.getPosition()));


    }


}

