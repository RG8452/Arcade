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
    
    private static final int  BORDER_HEIGHT = 850;
    private static final int BORDER_WIDTH = 1500;
    private static final int X_POS = (int) ((Arcade.fullScreen.getWidth()) / 2 - (BORDER_WIDTH / 2));
    private static final int Y_POS = (int) ((Arcade.fullScreen.getHeight()) / 2 - (BORDER_HEIGHT / 2));
    
    private static final long serialVersionUID = 1L;
    private double scale = 4; //The scale of the box that holds the game; the bigger the number, the bigger the box
    

    public BrickBreakerPanel()
    {
        BrickBreakerHandler handler = new BrickBreakerHandler();
        addKeyListener(handler);
        addMouseListener(handler);
        setFocusable(true);
        setBackground(Color.green);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //Repaint super JPanel
        g.setColor(Color.white); //The next few lines draw a white box that holds the game
        int leftX = (int)(Arcade.fullScreen.width/scale), topY = (int)((Arcade.fullScreen.height >> 1) - ((Arcade.fullScreen.width>>1)-leftX)); //TL coords
        int boxSide = Arcade.fullScreen.width - (leftX<<1); //The box will be a square with this as a side length
        g.fillRect(X_POS, Y_POS, BORDER_WIDTH, BORDER_HEIGHT);
        g.setColor(Color.black);
        
        g.fillRect(X_POS + 10, Y_POS + 10, BORDER_WIDTH - 20, BORDER_HEIGHT - 20);

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
