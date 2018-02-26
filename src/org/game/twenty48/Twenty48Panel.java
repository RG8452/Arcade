package org.game.twenty48;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Twenty48Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	public Twenty48Panel()
	{
		Twenty48Handler handler = new Twenty48Handler();
		addKeyListener(handler);
		addMouseListener(handler);
		setFocusable(true);
	}

	protected void paintComponent(Graphics g)
	{
		
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
