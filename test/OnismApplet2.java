import java.util.Iterator;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PVector;

public class OnismApplet2 extends PApplet
{
    RedCenter redCenter = new RedCenter(this);
    BlueCenter blueCenter = new BlueCenter(this);
    PurpleParticleSet purpleParticleSet = new PurpleParticleSet(this);
    int particleType;
    final static int BLUE = 1;
    final static int RED = 2;

    public static void main(String[] args)
    {
        PApplet.main(OnismApplet2.class, args);
    }

    @Override
    public void settings()
    {
        size(800, 800);
    }

    @Override
    public void setup()
    {
        frameRate(60);
        redCenter.setActive(true);
        blueCenter.setActive(false);
    }

    @Override
    public void draw()
    {
        background(0);
        Set<RedParticle> redParticles = redCenter.getParticles();
        Set<BlueParticle> blueParticles = blueCenter.getParticles();

        Iterator<RedParticle> redParticleIterator = redParticles.iterator();
        while (redParticleIterator.hasNext())
        {
            Particle redParticle = redParticleIterator.next();

            Iterator<BlueParticle> blueParticleIterator = blueParticles.iterator();
            while (blueParticleIterator.hasNext())
            {
                Particle blueParticle = blueParticleIterator.next();

                if (particlesCombine(
                        redParticle,
                        blueParticle
                ) && particleNotDecayed(redParticle) && particleNotDecayed(blueParticle))
                {
                    purpleParticleSet.add(
                            middlePosition(redParticle, blueParticle),
                            middleSize(redParticle, blueParticle)
                    );
                    redParticleIterator.remove();
                    blueParticleIterator.remove();
                    break;
                }
            }
        }

        redCenter.render();
        blueCenter.render();
        purpleParticleSet.render();
        if(keyPressed)
        {
            float speed = 10;
            switch (key)
            {
                case 'w':
                    blueCenter.position.y -= speed;
                    break;
                case 'a':
                    blueCenter.position.x -= speed;
                    break;
                case 's':
                    blueCenter.position.y += speed;
                    break;
                case 'd':
                    blueCenter.position.x += speed;
                    break;
            }
        }

    }

    private boolean particleNotDecayed(Particle particle)
    {
        return particle.getDecay() <= 1;
    }

    private float middleSize(Particle particle1, Particle particle2)
    {
        return lerp(particle1.getSize(), particle2.getSize(), 0.5f);
    }

    private PVector middlePosition(Particle particle1, Particle particle2)
    {
        return new PVector(
                lerp(particle1.getPosition().x, particle2.getPosition().x, 0.5f),
                lerp(particle1.getPosition().y, particle2.getPosition().y, 0.5f)
        );
    }

    private boolean particlesCombine(Particle particle1, Particle particle2)
    {
        return dist(
                particle1.getPosition().x,
                particle1.getPosition().y,
                particle2.getPosition().x,
                particle2.getPosition().y
        ) <= max(particle1.getSize(), particle2.getSize()) / 2;
    }

    @Override
    public void keyPressed()
    {

    }
}