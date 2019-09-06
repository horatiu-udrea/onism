import java.util.Iterator;

import processing.core.PApplet;

public class RedCenter extends ParticleCenter<RedParticle>
{
    public RedCenter(PApplet p)
    {
        super(p);
    }

    @Override
    public void draw()
    {
        float rate = PApplet.constrain(PApplet.map(PApplet.dist(p.mouseX, p.mouseY, p.pmouseX, p.pmouseY), 0, 30, 4.5f, 1), 1, 4);
        int rateInt = PApplet.ceil(rate);
        if (p.frameCount % rateInt == 0)
        {
            for (int i = 0; i < 6; i++)
            {
                particles.add(new RedParticle(position, p.random(10, 30), p));
            }
        }
        drawParticles();
    }

    protected void drawParticles()
    {
        Iterator<RedParticle> iterator = particles.iterator();
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
}
