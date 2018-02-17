package org;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/*
 * RG
 * This panel is the one that will display on the Arcade frame
 * It will handle key inputs and mouse inputs to scroll between games
 * It also does all drawing and such
 */

public class ArcadePanel extends JPanel
{
	private ArrayList<Button> buttons; //List of buttons

	//Constructor creates handlers and functions
	public ArcadePanel()
	{
		ArcadeListener al = new ArcadeListener(); //Handler object
		addKeyListener(al); //Add it on
		addMouseListener(al);
		setFocusable(true);
		setBackground(Color.black);
		buttons = new ArrayList<>(); //Instantiate button list

		int dX = 50; //Button drawing variables
		int dH = 150;
		int dW = 90;
		int dY = ((int) (Arcade.fullScreen.getHeight()) / 2) - dH;

		//Left arrow button with arrows for changing games left
		buttons.add(new Button(dX, dY, dW, dH << 1, "Left", new Color(255, 255, 255, 120), Color.white, 5) {
			@Override
			public void drawButton(Graphics g)
			{
				super.drawButton(g);

				g.setColor(Color.white);
				g.drawLine(this.getX() + (int) (this.getWidth() * 3 / 4) - 5, this.getY() + (int) (this.getHeight() / 4), this.getX() + (int) (this.getWidth() / 4) - 5, this.getY() + (int) (this.getHeight() / 2));
				g.drawLine(this.getX() + (int) (this.getWidth() / 4) - 5, this.getY() + (int) (this.getHeight() / 2), this.getX() + (int) (this.getWidth() * 3 / 4) - 5, this.getY() + (int) (this.getHeight() * 3 / 4));
				g.drawLine(this.getX() + (int) (this.getWidth() * 3 / 4 + 5), this.getY() + (int) (this.getHeight() / 4), this.getX() + (int) (this.getWidth() / 4) + 5, this.getY() + (int) (this.getHeight() / 2));
				g.drawLine(this.getX() + (int) (this.getWidth() / 4 + 5), this.getY() + (int) (this.getHeight() / 2), this.getX() + (int) (this.getWidth() * 3 / 4) + 5, this.getY() + (int) (this.getHeight() * 3 / 4));
			}
		});

		//Right button with overridden draw for >>, changes games right
		buttons.add(new Button((int) (Arcade.fullScreen.getWidth() - dX - dW), dY, dW, dH << 1, "Right", new Color(255, 255, 255, 120), Color.white, 5) {
			@Override
			public void drawButton(Graphics g)
			{
				super.drawButton(g);

				g.setColor(Color.white);
				g.drawLine(this.getX() + (int) (this.getWidth() / 4) - 5, this.getY() + (int) (this.getHeight() / 4), this.getX() + (int) (this.getWidth() * 3 / 4) - 5, this.getY() + (int) (this.getHeight() / 2));
				g.drawLine(this.getX() + (int) (this.getWidth() * 3 / 4) - 5, this.getY() + (int) (this.getHeight() / 2), this.getX() + (int) (this.getWidth() / 4) - 5, this.getY() + (int) (this.getHeight() * 3 / 4));
				g.drawLine(this.getX() + (int) (this.getWidth() / 4) + 5, this.getY() + (int) (this.getHeight() / 4), this.getX() + (int) (this.getWidth() * 3 / 4) + 5, this.getY() + (int) (this.getHeight() / 2));
				g.drawLine(this.getX() + (int) (this.getWidth() * 3 / 4) + 5, this.getY() + (int) (this.getHeight() / 2), this.getX() + (int) (this.getWidth() / 4) + 5, this.getY() + (int) (this.getHeight() * 3 / 4));
			}
		});

		//Play button to begin playing current game
		buttons.add(new Button((int) (Arcade.fullScreen.getWidth() / 2 - 100), (int) (Arcade.fullScreen.getHeight() - 200), 200, 100, "Play", new Color(0, 20, 240, 100), Color.white, 8));
	}

	//Overridden paint method to draw buttons and stuff
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Button b : buttons) //Draws outline & inside of all buttons
		{
			b.drawButton(g);
			b.drawButtonBorder(g);
		}

		g.setFont(new Font("TimesRoman", Font.BOLD, 50)); //Paint the word "PLAY"
		g.setColor(Color.white);
		buttons.get(2).drawMessage(g, "PLAY");
	}

	//Class to handle inputs
	private class ArcadeListener implements KeyListener, MouseListener
	{
		//keyListener methods
		public void keyPressed(KeyEvent e)
		{
			switch (e.getKeyCode())
			{
				case (KeyEvent.VK_SPACE): //SPACE begins playing currently selected game
					Arcade.curGame.start();
					Arcade.switchPanel(Arcade.curGame.getPanel());
					break;
				case (KeyEvent.VK_RIGHT): //RIGHT scrolls to the next game
					Arcade.scrollGame(1);
					break;
				case (KeyEvent.VK_LEFT): //LEFT scrolls to the previous name
					Arcade.scrollGame(-1);
					break;
				default:
					//System.out.println("UNRECOGNISED BUTTON");
			}
			Arcade.curPanel.repaint(); //Repaint panel on typing
		}

		public void mouseClicked(MouseEvent e)
		{
			//System.out.println(String.format("Clicked at %d, %d", e.getX(), e.getY()));

			for (Button b : buttons) //Loop through every button
			{
				if (b.inBounds(e.getX(), e.getY())) //If you've clicked a button
				{
					switch (b.getName()) //Depending on which button is clicked
					{
						case "Play": //If you clicked play
							Arcade.curGame.start(); //Begin the game
							Arcade.switchPanel(Arcade.curGame.getPanel()); //Swap panels
							break;
						case "Right": //If you clicked right
							Arcade.scrollGame(1);
							break;
						case "Left": //If you clicked left
							Arcade.scrollGame(-1);
							break;
						default: //Cannot be reached
							System.out.println("uh");
					}
				}
			}
			Arcade.curPanel.repaint(); //Repaint on click
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
