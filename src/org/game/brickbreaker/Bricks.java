package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bricks {

    private int x;
    private int y;
    private int lives;
    private int type;
    private BufferedImage brickImage;
    public static final int SPACING = 4;
    public static final int WIDTH = 54;
    public static final int HEIGHT = 20;
    public Rectangle hitbox = new Rectangle(x, y, WIDTH, HEIGHT);
    
    

    public Bricks(int x, int y, int lives, int type)
    {
        this.x = x;
        this.y = y;
        this.lives = lives;	
        this.type = type;
        hitbox.setLocation(x, y);
        brickImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawBrick();
    }
    
    
    private void drawBrick() //a method that draws a brick onto the buffered image
    {
        Graphics g = brickImage.getGraphics();
        if (lives == 3)
        {
        	g.setColor(Color.cyan);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        }
        if (lives == 2)
        {
        	g.setColor(Color.green);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        }
        if(lives == 1)
        {
        	g.setColor(Color.YELLOW);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        	
        	g.setColor(Color.BLUE);
        	g.fillRect((int)hitbox.getX(), (int)hitbox.getY(), (int)hitbox.getWidth(), (int)hitbox.getHeight());
        }
        
        if(lives == 0)
        {
        	g.setColor(Color.black);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        }
        
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
    
    public void subtractLives(int hits)
    {
    	this.lives -= hits;
    	drawBrick();
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
