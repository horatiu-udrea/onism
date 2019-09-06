import processing.core.PApplet;

public class OnismApplet1 extends PApplet
{
    PurpleCenter purpleCenter = new PurpleCenter(this);
    RedCenter redCenter = new RedCenter(this);
    BlueCenter blueCenter = new BlueCenter(this);
    int particleType;
    final static int BLUE = 1;
    final static int RED = 2;
    final static int PURPLE = 3;

    public static void main(String[] args)
    {
        PApplet.main(OnismApplet1.class, args);
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
    }

    @Override
    public void draw()
    {
        background(0);
        purpleCenter.setActive(particleType == PURPLE);
        purpleCenter.render();
        redCenter.setActive(particleType == RED);
        redCenter.render();
        blueCenter.setActive(particleType == BLUE);
        blueCenter.render();
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
