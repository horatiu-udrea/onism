import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PVector;

public class OnismApplet extends PApplet
{
    PVector redCenter = new PVector();
    PVector blueCenter = new PVector();
    PVector purpleCenter = new PVector();
    Set<BlueParticle> blueParticles;
    Set<RedParticle> redParticles;
    Queue<PurpleParticle> purpleParticles;
    int particleType;
    final static int BLUE = 1;
    final static int RED = 2;
    final static int PURPLE = 3;
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
        purpleParticles=new ArrayDeque<PurpleParticle>();
    }

    @Override
    public void draw()
    {
        background(0);
        if (particleType == PURPLE)
        {
            purpleCenter.x = mouseX;
            purpleCenter.y = mouseY;
        }
        float rate3 = constrain(map(dist(mouseX, mouseY, pmouseX, pmouseY), 0, 30, 4.5f, 1), 1, 4);
        int rateInt3 = ceil(rate3);
        if (frameCount % rateInt3 == 0)
        {
            for (int i = 0; i < 6; i++)
            {
                purpleParticles.add(new PurpleParticle(purpleCenter, random(10, 30), this));
            }
        }
        purpleParticles.forEach((particle) -> particle.draw(this));
        if (particleType == RED)
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
        if (particleType == BLUE)
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
                particleType = RED;
                break;
            case 'd':
                particleType = BLUE;
                break;
            case 's':
                particleType = PURPLE;
                break;
        }
    }
}
