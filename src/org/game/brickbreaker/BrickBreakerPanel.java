package org.game.brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.Arcade;

public class BrickBreakerPanel extends JPanel
{
    //Border variables
    private static final int  BORDER_HEIGHT = 850;
    private static final int BORDER_WIDTH = 1500;
    private static final int X_POS = (int) ((Arcade.fullScreen.getWidth()) / 2 - (BORDER_WIDTH / 2));
    private static final int Y_POS = (int) ((Arcade.fullScreen.getHeight()) / 2 - (BORDER_HEIGHT / 2));
    
    //Paddle variables
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 15;
    private static int paddleXPos = (X_POS + BORDER_WIDTH / 2 - (PADDLE_WIDTH / 2));
    private static int paddleYPos = (Y_POS + BORDER_HEIGHT - 30 - (PADDLE_HEIGHT / 2));;
    
    //Ball variables
    private static final int BALL_WIDTH = 20;
    private static final int BALL_HEIGHT = 20;
    private static int ballXPos = (paddleXPos + PADDLE_WIDTH / 2 - BALL_WIDTH / 2);
    private static int ballYPos = (paddleYPos - BALL_HEIGHT);
    
    private static final int SPACING = 5;
    private static final int ROWS = 15;
    private static final int COLS = 25;
    
    
    private Bricks[][] brickList = new Bricks[ROWS][COLS];
    
    private static final long serialVersionUID = 1L;
    private double scale = 4; //The scale of the box that holds the game; the bigger the number, the bigger the box
    

    public BrickBreakerPanel()
    {
        BrickBreakerHandler handler = new BrickBreakerHandler(); //creates a handler for brick breaker game
        addKeyListener(handler);
        addMouseListener(handler);
        setFocusable(true);
        setBackground(Color.green); //sets background color to green
        
        for(int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                int x = SPACING + SPACING * cols + Bricks.WIDTH * cols + X_POS + 10;
                int y = SPACING + SPACING * rows + Bricks.HEIGHT * rows + Y_POS + Bricks.HEIGHT * 2;
                brickList[rows][cols] = new Bricks(x, y, 1, 0);
                System.out.println(x + " " + y);
            }
        }
     
    }

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
        g.fillRoundRect(paddleXPos, paddleYPos, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);
        
        //draws the ball in red color
        g.setColor(Color.red);
        g.fillOval(ballXPos, ballYPos, BALL_WIDTH, BALL_HEIGHT);
        
        
        for(int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                brickList[rows][cols].drawBrickImage(g);
                
            }
        }
    }

    private class BrickBreakerHandler implements KeyListener, MouseListener
    {

        public void mouseClicked(MouseEvent e)
        {

        }

        public void mousePressed(MouseEvent e)
        {

        }

        public void mouseReleased(MouseEvent e)
        {

        }

        public void mouseEntered(MouseEvent e)
        {

        }

        public void mouseExited(MouseEvent e)
        {

        }

        public void keyTyped(KeyEvent e)
        {

        }

        public void keyPressed(KeyEvent e)
        {

        }

        public void keyReleased(KeyEvent e)
        {

        }

    }
}
