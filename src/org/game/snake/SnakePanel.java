package org.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.Arcade;

/*
 * This panel handles Snake and will do all listening and drawing
 * Each dot is assumed to be equivalent to the width of the box containing the game divided by the number of pellets
 */
public class SnakePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private double scale = 3.5;	//The scale of the box that holds the game; the bigger the number, the bigger the box
	
	//Default constructor
	public SnakePanel()
	{
		SnakeHandler psychoMantis = new SnakeHandler();	//Create handler
		addKeyListener(psychoMantis);	//Add handler
		addMouseListener(psychoMantis);
		setFocusable(true);
		setBackground(Color.blue);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); //Repaint super JPanel
		g.setColor(Color.white); //The next few lines draw a white box that holds the game
		int leftX = (int)(Arcade.fullScreen.width/scale), topY = (int)((Arcade.fullScreen.height >> 1) - ((Arcade.fullScreen.width>>1)-leftX)); //TL coords
		int boxSide = Arcade.fullScreen.width - (leftX<<1); //The box will be a square with this as a side length
		g.fillRect(leftX - 7, topY - 7, boxSide + 14, 7); //TL to TR
		g.fillRect(leftX - 7, topY, 7, boxSide + 7); //TL to BL
		g.fillRect(leftX + boxSide, topY, 7, boxSide + 7); //TR to BR
		g.fillRect(leftX, topY + boxSide, boxSide, 7); //BL to BR
		
		g.setColor(Color.black);
		g.fillRect(leftX, topY, boxSide, boxSide);

		Snake ref = (Snake) (Arcade.curGame); //Stores the snake game from the arcade as a reference
		double dotSize = (double)boxSide / ref.dotsPerSide;
		
		g.setColor(Color.red); //Draws in the apple
		g.fillRect((int)(ref.applePoint.x * dotSize + 2 + leftX), (int)(ref.applePoint.y * dotSize + 2 + topY), (int)dotSize - 4, (int)dotSize - 4);

		g.setColor(Color.white); //Draw in every single dot in the snake
		for (Point p : ref.pieceLocations)
		{
			g.fillRect((int)(p.x * dotSize + 2 + leftX), (int)(p.y * dotSize + 2 + topY), (int)dotSize - 4, (int)dotSize - 4);
		}
		
//		drawGrid(g, dotSize, leftX, topY, boxSide);
	}
	
	//Draws in a grid to see where dots are going to fit
	private void drawGrid(Graphics g, double dSize, int x, int y, int bs)
	{
		g.setColor(Color.green);
		for(int i=1; i<=((Snake)Arcade.curGame).dotsPerSide; i++)
		{
			g.drawLine((int)(x + dSize*i), y, (int)(x + dSize*i), y + bs);
			g.drawLine(x, (int)(y + dSize*i), x + bs, (int)(y + dSize*i));
		}
	}

	//Private class for all listening and handling
	private class SnakeHandler implements KeyListener, MouseListener
	{
		//@formatter:off
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e){}
        public void keyTyped(KeyEvent e) {}
        //@formatter:on

		public void mouseClicked(MouseEvent e)
		{

		}

		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_RIGHT:
					((Snake)Arcade.curGame).setDirection('R');
					break;
				case KeyEvent.VK_LEFT:
					((Snake)Arcade.curGame).setDirection('L');
					break;
				case KeyEvent.VK_UP:
					((Snake)Arcade.curGame).setDirection('U');
					break;
				case KeyEvent.VK_DOWN:
					((Snake)Arcade.curGame).setDirection('D');
					break;
			}
		}

		public void keyReleased(KeyEvent e)
		{

		}
	}
}
