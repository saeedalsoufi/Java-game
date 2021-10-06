package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class
Chickens extends DynamicBody {
    //Creates chickens
    private static final Shape shape = new CircleShape(0.2f);
    private static final BodyImage image =
            new BodyImage("data/Chicken.png", 1.0f);
    
    public Chickens(World world) {
        super(world, shape);
        setFillColor(Color.orange);
        addImage(image);
    }
}
