package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Ball 
{
    private int x;
    private int y;
    private int lives;
    private int type;
    private int xDir;
    private int yDir;
    private boolean moving;
    private boolean ballMoving = false;
    private BufferedImage ballImage;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    
    
    public Ball(int x, int y, int lives, int type)
    {
        this.x = x;
        this.y = y;
        this.ballMoving = moving;
        this.lives = lives;
        this.ballMoving = moving;
        this.type = type;
        
        ballImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawBall();
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask()
            {
                public void run()
                {
                    x += xDir;
                    y += yDir;
                    
                    System.out.println(y);
                    System.out.println(x);
                    
                }
            };
            
    public void moveBall()
    {
        timer.scheduleAtFixedRate(task, 13, 13);
    }
    
    private void drawBall()
    {
        Graphics g = ballImage.getGraphics();
        g.setColor(Color.red);
        g.fillOval(0, 0, WIDTH, HEIGHT);
        
    }
    
    public void drawBallImage(Graphics g)
    {
        g.drawImage(ballImage, x, y, null);
    }
    
    
    public void setMoving(boolean setMoving)
    {
    	moving = setMoving;
    }
    
    public void setXdir(int xDir)
    {
    	this.xDir = xDir;
    }
    
    public void setYdir(int yDir)
    {
    	 this.yDir = yDir;
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
