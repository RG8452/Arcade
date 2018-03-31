package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    private static int paddleX;
    private static int paddleY;
    private static int paddleWidth;
    private static int paddleHeight;
    
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public Rectangle hitbox = new Rectangle(x, y, WIDTH, HEIGHT);
    
    
    private static final int LEFT_BOUNDARY = BrickBreakerPanel.X_POS + 10;
    private static final int RIGHT_BOUNDARY = BrickBreakerPanel.X_POS + BrickBreakerPanel.BORDER_WIDTH - 10;
    private static final int TOP_BOUNDARY = BrickBreakerPanel.Y_POS + 10;
    private static final int BOTTOM_BOUNDARY = BrickBreakerPanel.Y_POS + BrickBreakerPanel.BORDER_HEIGHT - 10;
    
    
    public Ball(int x, int y, int lives, int type)
    {
        this.x = x;
        this.y = y;
        this.lives = lives;
        this.type = type;
        
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask()
            {
                public void run()
                {
                    x += xDir;
                    y += yDir;
                    hitbox.setLocation(x, y);;
                    
                    checkBoundaries();
                }
            };
            
    private void checkBoundaries()
    {
        if(x < LEFT_BOUNDARY || x + WIDTH > RIGHT_BOUNDARY)
            xDir *= -1;
        
        if(y < TOP_BOUNDARY)
            yDir *= -1;
        
        if(y + HEIGHT > BOTTOM_BOUNDARY)
            timer.cancel();
        
        if(hitbox.intersects(BrickBreakerPanel.hitbox))
            yDir *= -1;
        
        for(Bricks[] b: BrickBreakerPanel.brickList)
        {
            for(Bricks bb: b)
            {
                if(hitbox.intersects(bb.hitbox) && bb.getLives() > 0)
                {
                    yDir *= -1;
                    bb.subtractLives(1);
                    return;
                }
            }
        }
    }
    
    public void moveBall()
    {
        timer.scheduleAtFixedRate(task, 13, 13);
    }
    
    public void drawBall(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
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
