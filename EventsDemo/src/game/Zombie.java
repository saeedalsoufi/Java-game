package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Zombie extends Walker {


    // This makes a zombie character
    private static final Shape shape = new PolygonShape(
            0.87f,-1.77f, -0.92f,-1.77f, -0.94f,0.72f, -0.19f,1.24f, 0.95f,0.81f, 0.98f,-1.46f);

    private static final BodyImage standing =
            new BodyImage("data/zombie_stand.png", 3.50f);

    private static int ChickenCount;



    public Zombie(World world) {
        super(world, shape);
        addImage(standing);
        ChickenCount = 0;
    }




    public int HealthBar= 100;

    public void loseHealth( int damage){ HealthBar = HealthBar - damage; }

    public int getHealthBar() { return HealthBar; }

    public void incrementChickenCount() {
        //This method increases the chicken count and prints the count out when the zombie picks a chicken.
        ChickenCount++;
        System.out.println("Tasty!  Chicken count = " + ChickenCount);
    }
    public static int getChickenCount() {
        return ChickenCount;
    }

}
