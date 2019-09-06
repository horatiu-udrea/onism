import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PVector;

public class PurpleParticleSet
{
    protected Set<PurpleParticle> particles;
    protected PApplet p;

    public PurpleParticleSet(PApplet p)
    {
        this.p = p;
        particles = new HashSet<>();
    }

    public void render()
    {
        Iterator<PurpleParticle> iterator = particles.iterator();
        while (iterator.hasNext())
        {
            Particle particle = iterator.next();
            particle.draw(p);
            if (particle.isParticleDissolved())
            {
                iterator.remove();
            }
        }
    }

    public void add(PVector position, float size)
    {
        particles.add(new PurpleParticle(position, size, p));
    }
}
