package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level4 extends GameLevel {

    private static Boss boss;

    private Zombie zombie;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -16.5f));
        ground.setFillColor(Color.blue);
        //left and right wall
        Shape boxShape3 = new BoxShape(0.5f, 14);
        Body RightWall = new StaticBody(this, boxShape3);
        RightWall.setPosition(new Vec2(30.5f, -7f));
        RightWall.setFillColor(Color.blue);
        Shape boxShape2 = new BoxShape(0.5f, 14);
        Body LeftWall = new StaticBody(this, boxShape2);
        LeftWall.setPosition(new Vec2(-30.5f, -7.0f));
        LeftWall.setFillColor(Color.blue);
        //bullet
        // bullet = new Bullet(this);
        //bullet.setPosition(new Vec2(8, -10));

        boss= new Boss( this);
        boss.setPosition(new Vec2(-5, -8));
        boss.addCollisionListener(new ZombieCollision2(game.getPlayer()));


        //make a chicken
        for (int i = 0; i < 10; i++) {
            Body chickens = new Chickens(this);
            chickens.setPosition(new Vec2(i*2-25, 10));
            chickens.addCollisionListener(new Pickup(game.getPlayer()));


        }

        //platforms:
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-26.5f, 0f));
        platform4.setFillColor(Color.blue);


        Body platform1 = new MovingPlatform2(this);
        platform1.setPosition(new Vec2(15, -7f));
        platform1.setFillColor(Color.blue);
        Body platform2 = new MovingPlatform2(this);
        platform2.setPosition(new Vec2(3, 1f));
        platform2.setFillColor(Color.blue);
        Body platform3 = new MovingPlatform2(this);
        platform3.setPosition(new Vec2(-11, -3f));
        platform3.setFillColor(Color.blue);




    }





    @Override
    public Vec2 startPosition() {
        return new Vec2(15, -15);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-29f, 2f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getChickenCount() == 10;
    }

    @Override
    public int getLevelNumber(){
        return 4;
    }

}


