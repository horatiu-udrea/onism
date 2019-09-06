import java.util.HashSet;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class ParticleCenter<T extends Particle>
{
    protected boolean active = false;
    protected PVector position = new PVector(0, 0);
    protected PApplet p;

    protected Set<T> particles;

    public ParticleCenter(PApplet p)
    {
        this.p = p;
        particles = new HashSet<>();
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public void render()
    {
        if (active)
        {
            position.y = p.mouseY;
            position.x = p.mouseX;
        }
        draw();
    }

    public Set<T> getParticles()
    {
        return particles;
    }

    protected abstract void draw();
}
