import processing.core.PApplet;
import processing.core.PVector;

public abstract class Particle
{

    protected boolean particleDissolved;

    protected PVector position;

    protected float decay = 0;

    PVector speed;
    PVector acceleration;
    float targetSize;
    protected float size;

    public Particle(PVector position, PVector speed, PVector acceleration, float targetSize)
    {
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
        this.targetSize = targetSize;
    }

    public abstract void draw(PApplet p);
    public float getDecay()
    {
        return decay;
    }
    public boolean isParticleDissolved()
    {
        return particleDissolved;
    }

    public PVector getPosition()
    {
        return position;
    }

    public float getSize()
    {
        return size;
    }
}
