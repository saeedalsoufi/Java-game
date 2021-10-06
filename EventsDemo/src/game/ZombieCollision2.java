package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ZombieCollision2 implements CollisionListener {
    //This class adds a collision so when a body hit the zombie, the zombie gets destroyed.
    //Add a collision listener to enemy in GameWorld.
    private Zombie zombie;

    public ZombieCollision2(Zombie zombie){
        this.zombie= zombie;

    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == zombie) {
            zombie.loseHealth(25);
            System.out.println(zombie.HealthBar);
            if (zombie.HealthBar == 0) {
                zombie.destroy();
            }
        }
    }

}


