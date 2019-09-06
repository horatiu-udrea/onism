import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.map;

public class RedParticle extends Particle
{
    public RedParticle(PVector position, float size, PApplet p)
    {
        super(
                position.copy(),
                new PVector(p.random(-1, 1), p.random(-1, 1.6f)),
                new PVector(0, -0.04f),
                size
        );
    }

    public void draw(PApplet p)
    {
        size = constrain(map(decay, 0, 0.4f, 0, targetSize), 0, targetSize);
        p.noStroke();
        p.fill(80, 0, 0, map(decay, 0, 1, 255, 0));
        p.ellipse(position.x, position.y, size, size);
        decay += 0.01;
        decay = constrain(decay, 0, 1);
        if (decay == 1)
        {
            particleDissolved = true;
        }
        position.add(speed);
        speed.add(acceleration);
        speed.x = speed.x / 1.03f;
    }
}
