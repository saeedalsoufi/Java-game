package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class TrapCollision implements CollisionListener {

    //This class adds a collision so when my zombie hit the trap, the zombie gets destroyed.
    //Add a collision listener to trap in GameLevel.
    private Zombie zombie;

    public TrapCollision(Zombie zombie){
        this.zombie= zombie;

    }
    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody()== zombie){
            zombie.loseHealth(25);
            System.out.println(zombie.HealthBar);
            if (zombie.HealthBar == 0) {
                zombie.destroy();
            }
        }
    }


}

