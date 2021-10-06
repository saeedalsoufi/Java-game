package game;

import city.cs.engine.*;

//Spinning platform that changes angel

public class MovingPlatform2 extends StaticBody implements StepListener {
    private static final Shape platform3 = new BoxShape(3, 0.5f);
    public MovingPlatform2(World w)    {
        super(w, platform3);
        w.addStepListener(this);
        //this changes the angel of the platform using steplistener to make the platform spins
    }
    @Override
    public void preStep(StepEvent stepEvent)    {
        setAngle(getAngle() + 0.01f);
    }
    @Override
    public void postStep(StepEvent stepEvent)   {
    }



}