package org;
/*
 * RG
 * This panel is the one that will display on the Arcade frame
 * It will handle key inputs and mouse inputs to scroll between games
 * It also does all drawing and such
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ArcadePanel extends JPanel
{
	private ArrayList<Button> buttons;	//List of buttons
	
	//Constructor creates handlers and functions
	public ArcadePanel()
	{
		ArcadeListener al = new ArcadeListener();
		addKeyListener(al);
		addMouseListener(al);
		setFocusable(true);
		setBackground(Color.black);
		buttons = new ArrayList<>();
		
		int dX = 50;	//Button drawing variables
		int dH = 150;
		int dW = 90;
		int dY = ((int)(Arcade.fullScreen.getHeight())/2) - dH;
		
		//Left arrow button with arrows for changing games left
		buttons.add(new Button(dX, dY, dW, dH<<1, "Left", new Color(255, 255, 255, 120), Color.white, 5) {
			@Override
			public void drawButton(Graphics g)
			{
				super.drawButton(g);
				
				g.setColor(Color.white);
				g.drawLine(this.getX() + (int)(this.getWidth() * 3 / 4) - 5, this.getY() + (int)(this.getHeight() / 4), this.getX() + (int)(this.getWidth() / 4) - 5, this.getY() + (int)(this.getHeight() / 2));
				g.drawLine(this.getX() + (int)(this.getWidth() / 4) - 5, this.getY() + (int)(this.getHeight() / 2), this.getX() + (int)(this.getWidth() * 3 / 4) - 5, this.getY() + (int)(this.getHeight() * 3 / 4));
				g.drawLine(this.getX() + (int)(this.getWidth() * 3 / 4 + 5), this.getY() + (int)(this.getHeight() / 4), this.getX() + (int)(this.getWidth() / 4) + 5, this.getY() + (int)(this.getHeight() / 2));
				g.drawLine(this.getX() + (int)(this.getWidth() / 4 + 5), this.getY() + (int)(this.getHeight() / 2), this.getX() + (int)(this.getWidth() * 3 / 4) + 5, this.getY() + (int)(this.getHeight() * 3 / 4));
			}
		});
		
		//Right button with overridden draw for >>, changes games right
		buttons.add(new Button((int)(Arcade.fullScreen.getWidth() - dX - dW), dY, dW, dH<<1, "Right", new Color(255, 255, 255, 120), Color.white, 5) {
			@Override
			public void drawButton(Graphics g)
			{
				super.drawButton(g);
				
				g.setColor(Color.white);
				g.drawLine(this.getX() + (int)(this.getWidth() / 4) - 5, this.getY() + (int)(this.getHeight() / 4), this.getX() + (int)(this.getWidth() * 3 / 4) - 5, this.getY() + (int)(this.getHeight() / 2));
				g.drawLine(this.getX() + (int)(this.getWidth() * 3 / 4) - 5, this.getY() + (int)(this.getHeight() / 2), this.getX() + (int)(this.getWidth() / 4) - 5, this.getY() + (int)(this.getHeight() * 3 / 4));
				g.drawLine(this.getX() + (int)(this.getWidth() / 4) + 5, this.getY() + (int)(this.getHeight() / 4), this.getX() + (int)(this.getWidth() * 3 / 4) + 5, this.getY() + (int)(this.getHeight() / 2));
				g.drawLine(this.getX() + (int)(this.getWidth() * 3 / 4) + 5, this.getY() + (int)(this.getHeight() / 2), this.getX() + (int)(this.getWidth() / 4) + 5, this.getY() + (int)(this.getHeight() * 3 / 4));
			}
		});
	}

	//Overridden paint method to draw buttons and stuff
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(Button b: buttons) b.drawButton(g);
	}

	//Class to handle inputs
	private class ArcadeListener implements KeyListener, MouseListener
	{
		//keyListener methods
		public void keyPressed(KeyEvent e)
		{

		}

		public void mouseClicked(MouseEvent e)
		{
			System.out.println(String.format("Clicked at %d, %d", e.getX(), e.getY()));
		}

		//@formatter:off
		//Extraneous overrides
		public void keyReleased(KeyEvent e) {}
   		public void keyTyped(KeyEvent e) {}
   		public void mousePressed(MouseEvent e){}
   		public void mouseReleased(MouseEvent e){}
   		public void mouseEntered(MouseEvent e){}
   		public void mouseExited(MouseEvent e){}
   		//@formatter:on
	}
}
