package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static Man man;

    private Zombie player;
    //private Bullet bullet;
    private MouseHandler rockShape;
    private Trap trap;
    private GameLevel world;
    private Game game;
    private Level2 level2;
    private static final int chickencount = 5;
 //   private







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

        //Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        //Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-2, 7.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -7.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(16, 0));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-16, 2));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-6, -2));
        Shape boxShape5 = new BoxShape(5, 0.5f);
        Body platform6 = new StaticBody(this, boxShape5);
        platform6.setPosition(new Vec2(24.85f, -8.5f));

        //left and right wall
        Shape boxShape3 = new BoxShape(0.5f, 10);
        Body RightWall = new StaticBody(this, boxShape3);
        RightWall.setPosition(new Vec2(30.5f, -7f));
        Shape boxShape2 = new BoxShape(0.5f, 10);
        Body LeftWall = new StaticBody(this, boxShape2);
        LeftWall.setPosition(new Vec2(-30.5f, -7.0f));

        //make a trap
        trap= new Trap( this);
        trap.setPosition(new Vec2(28.50f, -7f));
        trap.addCollisionListener(new TrapCollision(game.getPlayer()));

        man= new Man( this);
        man.setPosition(new Vec2(-5, -15));
        man.addCollisionListener(new ZombieCollision2(game.getPlayer()));


        for (int i = 0; i < 25; i++) {
            Body chickens = new Chickens(this);
            chickens.setPosition(new Vec2(i*2-25, 10));
            chickens.addCollisionListener(new Pickup(game.getPlayer()));


        }


        //make a chicken

        //bullet
        // bullet = new Bullet(this);
        //bullet.setPosition(new Vec2(8, -10));
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -15);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(1.5f, 9.5f);
    }

    @Override
    public boolean isCompleted() {
        return Zombie.getChickenCount() == chickencount;
    }

    @Override
    public int getLevelNumber(){
        return 1;
    }


}
