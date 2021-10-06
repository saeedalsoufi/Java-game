package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level3 extends GameLevel {

    private static Man man;

    private Zombie zombie;
    //private Bullet bullet;
    private MouseHandler rockShape;
    private Trap trap;
    private Enemy2 enemy2;

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
        ground.setFillColor(Color.GREEN);
        //left and right wall
        Shape boxShape3 = new BoxShape(0.5f, 13);
        Body RightWall = new StaticBody(this, boxShape3);
        RightWall.setPosition(new Vec2(30.5f, -7f));
        RightWall.setFillColor(Color.GREEN);
        Shape boxShape2 = new BoxShape(0.5f, 13);
        Body LeftWall = new StaticBody(this, boxShape2);
        LeftWall.setPosition(new Vec2(-30.5f, -7.0f));
        LeftWall.setFillColor(Color.green);
        Body platform2 = new MovingPlatform(this);
        platform2.setPosition(new Vec2(-3, -7.5f));
        platform2.setFillColor(Color.green);
        Body platform8 = new MovingPlatform2(this);
        platform8.setPosition(new Vec2(4, 4f));
        platform8.setFillColor(Color.green);
        //bullet
        // bullet = new Bullet(this);
        //bullet.setPosition(new Vec2(8, -10));

        //platforms:
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-4, 11.5f));
        platform1.setFillColor(Color.green);
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(16, -2));
        platform3.setFillColor(Color.green);
        Shape boxShape6 = new BoxShape(6.5f, 0.5f);
        Body platform7 = new StaticBody(this, boxShape6);
        platform7.setPosition(new Vec2(-23.5f, 4));
        platform7.setFillColor(Color.green);
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-12, -2));
        platform5.setFillColor(Color.green);
        Shape boxShape5 = new BoxShape(7, 0.5f);
        Body platform6 = new StaticBody(this, boxShape5);
        platform6.setPosition(new Vec2(22.85f, -8.5f));
        platform6.setFillColor(Color.green);

        //make a trap
        trap= new Trap( this);
        trap.setPosition(new Vec2(-28.50f, 5f));
        trap.addCollisionListener(new TrapCollision(game.getPlayer()));


        man= new Man( this);
        man.setPosition(new Vec2(-5, -15));
        man.addCollisionListener(new ZombieCollision2(game.getPlayer()));
        //make a chicken
        for (int i = 0; i < 25; i++) {
            Body chickens = new Chickens(this);
            chickens.setPosition(new Vec2(i*2-25, 10));
            chickens.addCollisionListener(new Pickup(game.getPlayer()));
        }
        enemy2= new Enemy2( this);
        enemy2.setPosition(new Vec2(23.50f, -6.5f));
        enemy2.addCollisionListener(new ZombieCollision2(game.getPlayer()));




    }

    public Man getEnemyy() { return man; }





    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -15);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-6.5f, 13.5f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getChickenCount() == 10;
    }

    @Override
    public int getLevelNumber(){
        return 3;
    }

}


