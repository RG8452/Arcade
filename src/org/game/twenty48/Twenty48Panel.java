package org.game.twenty48;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.Arcade;

/*
 * This class handles 2048 and will do all the listening and graphics
 */

public class Twenty48Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	//Constructor
	public Twenty48Panel()
	{
		Twenty48Handler handler = new Twenty48Handler();
		addKeyListener(handler);
		addMouseListener(handler);
		setFocusable(true);
		setBackground(Color.cyan);
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(Arcade.fullScreen.width / 4, Arcade.fullScreen.height / 6, Arcade.fullScreen.width / 2, Arcade.fullScreen.height / 12 * 11);
	}

	private class Twenty48Handler implements KeyListener, MouseListener
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
