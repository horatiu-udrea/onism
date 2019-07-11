import java.util.HashSet;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PVector;

public class OnismApplet extends PApplet
{
    PVector redCenter = new PVector();
    PVector blueCenter = new PVector();
    Set<BlueParticle> blueParticles;
    Set<RedParticle> redParticles;
    boolean red;
    boolean blue;

    public static void main(String[] args)
    {
        PApplet.main(OnismApplet.class, args);
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
        blueParticles = new HashSet<>();
        redParticles = new HashSet<>();
    }

    @Override
    public void draw()
    {
        background(255);
        if (red)
        {
            redCenter.x = mouseX;
            redCenter.y = mouseY;
        }
        float rate = constrain(map(dist(mouseX, mouseY, pmouseX, pmouseY), 0, 30, 4.5f, 1), 1, 4);
        int rateInt = ceil(rate);
        if (frameCount % rateInt == 0)
        {
            for (int i = 0; i < 6; i++)
            {
                redParticles.add(new RedParticle(redCenter, random(10, 30), this));
            }
        }
        redParticles.forEach((particle) -> particle.draw(this));
        if (blue)
        {
            blueCenter.x = mouseX;
            blueCenter.y = mouseY;
        }
        float rate2 = constrain(map(dist(mouseX, mouseY, pmouseX, pmouseY), 0, 30, 4.5f, 1), 1, 4);
        int rateInt2 = ceil(rate2);
        if (frameCount % rateInt2 == 0)
        {
            for (int i = 0; i < 6; i++)
            {
                blueParticles.add(new BlueParticle(blueCenter, random(10, 30), this));
            }
        }
        blueParticles.forEach((particle) -> particle.draw(this));
    }

    @Override
    public void keyPressed()
    {
        switch (key)
        {
            case 'a':
                redCenter.x += -1;
                red = true;
                blue = false;
                break;
            case 'd':
                blue = true;
                red = false;
                break;
        }
    }
}
