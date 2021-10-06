package game;

import city.cs.engine.*;

public class Trap extends Walker{

    // This makes a trap shape.
    private static final Shape shape = new PolygonShape(
            1.68f,0.73f, 1.71f,-0.86f, -1.69f,-0.89f, -1.69f,0.92f, 1.55f,0.85f);

    private static final BodyImage image =
            new BodyImage("data/Trap.png", 2.50f);




    public Trap(World world2) {
        super(world2, shape);
        addImage(image);
    }
}
