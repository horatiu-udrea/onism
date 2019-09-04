import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.map;

public class PurpleParticle
{
    PVector position;
    float decay;
    PVector speed;
    PVector acceleration;
    float targetSize;
    float size;

    public PurpleParticle(PVector position, float size, PApplet p)
    {
        this.position = position.copy();
        this.speed = new PVector(p.random(-2, 2),p.random(-2, 2));
        this.acceleration = new PVector(p.random(-0.04f, 0.04f), p.random(-0.04f, 0.04f));

        this.targetSize = size;
    }

    public void draw(PApplet p)
    {
        size = constrain(map(decay, 0, 0.4f, 0, targetSize), 0, targetSize);
        p.noStroke();
        p.fill(100, 0, 100, map(decay, 0, 1, 255, 0));
        p.ellipse(position.x, position.y, size, size);
        decay += 0.01;
        decay = constrain(decay, 0, 1);
        position.add(speed);
        speed.add(acceleration);

    }
}
