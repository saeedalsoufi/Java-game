package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    //This class summons bowling balls when a mouse press is clicked

    private static final float RADIUS = 1f;

    private static final Shape RockShape
            = new CircleShape(RADIUS);

    private static final BodyImage RockImage
            = new BodyImage("data/bowl.png", 2*RADIUS);


    private WorldView view;

    public MouseHandler(WorldView view ) {
        this.view = view;
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse has been pressed.");
        DynamicBody ball = new DynamicBody(view.getWorld(), RockShape);
        ball.addImage(RockImage);
        ball.setPosition(view.viewToWorld(e.getPoint()));
      //  enemy.destroy();
       // ball.addCollisionListener(new ArrowCollision(enemy));
    }


}



