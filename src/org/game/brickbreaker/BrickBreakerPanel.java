package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import org.Arcade;

public class BrickBreakerPanel extends JPanel
{
    //Border variables
    public static final int  BORDER_HEIGHT = 850;
    public static final int BORDER_WIDTH = 1500;
    public static final int X_POS = (int) ((Arcade.fullScreen.getWidth()) / 2 - (BORDER_WIDTH / 2));
    public static final int Y_POS = (int) ((Arcade.fullScreen.getHeight()) / 2 - (BORDER_HEIGHT / 2));
    
    //Paddle variables
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 15;
    private static int paddleXPos = (X_POS + BORDER_WIDTH / 2 - (PADDLE_WIDTH / 2));
    private static final int PADDLE_Y_POS = (Y_POS + BORDER_HEIGHT - 30 - (PADDLE_HEIGHT / 2));
    public static Rectangle hitbox = new Rectangle(paddleXPos, PADDLE_Y_POS, PADDLE_WIDTH, PADDLE_HEIGHT);
    private int mouseX = paddleXPos;
    
    //Ball variables
    private int ballX = paddleXPos + PADDLE_WIDTH / 2 - Ball.WIDTH / 2;
    private int ballY = PADDLE_Y_POS - Ball.WIDTH;
    private boolean ballMoving = false;
    
    //bricks variables
    private static final int SPACING = 5;
    public static final int ROWS = 15;
    public static final int COLS = 25;
    		
    public static Bricks[][] brickList = new Bricks[ROWS][COLS];//creates an array of type Bricks
    private Ball ball = new Ball(ballX, ballY, 3, 0);
    
    private static final long serialVersionUID = 1L;
    
    							//......................CCONSTRUCTOR METHOD........................
    
    public BrickBreakerPanel()  
    {
        BrickBreakerHandler handler = new BrickBreakerHandler(); //creates a handler for brick breaker game
        addKeyListener(handler);
        addMouseListener(handler);
        addMouseMotionListener(handler);
        setFocusable(true);
        setBackground(Color.green); //sets background color to green
        
        
        //adds all the objects to the array
        for(int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                int x = SPACING + SPACING * cols + Bricks.WIDTH * cols + X_POS + 10;
                int y = SPACING + SPACING * rows + Bricks.HEIGHT * rows + Y_POS + Bricks.HEIGHT * 2;
                brickList[rows][cols] = new Bricks(x, y, 1, 0);
            }
        }
        
     
    }
    
    							//.........................BALL METHODS.............................

    
    							//.......................GRAPHICS METHODS...........................
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //Repaint super JPanel
        
        //draws the background border in white
        g.setColor(Color.white);
        g.fillRect(X_POS, Y_POS, BORDER_WIDTH, BORDER_HEIGHT);
        
        //draws the black box on top of the border for the game
        g.setColor(Color.black);
        g.fillRect(X_POS + 10, Y_POS + 10, BORDER_WIDTH - 20, BORDER_HEIGHT - 20);

        //draws the paddle in gray color
        g.setColor(Color.gray);
        g.fillRoundRect(paddleXPos, PADDLE_Y_POS, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);
        
        //draw the array list of buffered images containing all the bricks
        for(int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                brickList[rows][cols].drawBrickImage(g); 
            }
        }
        
        //draws the ball in red color
        ball.drawBall(g);
    }
    
    
    
    
    private class BrickBreakerHandler implements KeyListener, MouseListener, MouseMotionListener
    {

        public void mouseClicked(MouseEvent e)
        {

        }

        // starts the game by moving the ball and letting the user to control the paddle
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case(KeyEvent.VK_SPACE):
                	
                    if(!ballMoving)
                    {
                        ballMoving = true;
                        ball.setXdir((int) (Math.random() * 10 + (-5)));
                        ball.setYdir(-5);
                        ball.moveBall();
                    }
            }
        }
        
        //This methods makes the paddle move with the mouse cursor
        @Override
        public void mouseMoved(MouseEvent e) 
        {
            mouseX = e.getX(); //sets a variable to the x position of the mouse
            if(ballMoving)
            {
            	if(mouseX < X_POS + 10 + PADDLE_WIDTH / 2)  //makes sure the paddle doesn't go past the border on the left side
            		paddleXPos = X_POS + 10;
            	else
            		paddleXPos = mouseX - PADDLE_WIDTH / 2;
            
            	if(mouseX > X_POS + BORDER_WIDTH - 10 - PADDLE_WIDTH / 2) //makes sure the paddle doesn't go past the border on the right side
            		paddleXPos = X_POS + BORDER_WIDTH - 10- PADDLE_WIDTH;
            	
            	hitbox.setLocation(paddleXPos, PADDLE_Y_POS);
            }
        }
        
        
        //unused methods
        public void keyTyped(KeyEvent e){}
        public void keyReleased(KeyEvent e){}
        public void mouseDragged(MouseEvent e) {}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
    }
}
