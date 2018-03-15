package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bricks {

    private int x;
    private int y;
    private int lives;
    private int type;
    private BufferedImage brickImage;
    public static final int WIDTH = 54;
    public static final int HEIGHT = 20;
    
    

    public Bricks(int x, int y, int lives, int type)
    {
        this.x = x;
        this.y = y;
        this.lives = lives;
        this.type = type;
        
        brickImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawBrick();
    }
    
    
    private void drawBrick() //a method that draws a brick onto the buffered image
    {
        Graphics g = brickImage.getGraphics();
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
    
    public void drawBrickImage(Graphics g) //draws the buffered image
    {
        g.drawImage(brickImage, x, y, null);
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public int getType()
    {
        return type;
    }
}
