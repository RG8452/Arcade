package org.game.twenty48;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.game.Game;
import org.game.GamePane;

/*
 * This is the class that runs the game 2048
 */
public class Twenty48 extends Game
{
	private Twenty48Panel twenty48Panel;		//The main game JPanel
	private GamePane twenty48Pane;				//The game pane for this game

	
	//Constructor
	public Twenty48()
	{
	    twenty48Panel = new Twenty48Panel();
		twenty48Pane = new GamePane("2048");

		frameRate = 60;
		
	   // reset();
	}

	//Game start function
	public void start()
	{
	    finished = false;
	}
	
	//Main run method of this game
	public void run()
	{
	    
	}

	//Method called when the game ends
	public void end()
	{

	}

	//Resets the game
	public void reset()
	{
	    twenty48Panel.restart();
	}

	//Returns the JPanel of the game
	public JPanel getPanel()
	{
		return twenty48Panel;
	}

	//Draws this game's game pane
	public void getPane(Graphics g)
	{
		twenty48Pane.drawPane(g);
	}
}
