package org;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.game.Game;
import org.game.brickbreaker.BrickBreaker;
import org.game.snake.Snake;
import org.game.twenty48.Twenty48;

/*
 * RG
 * This is the main class for the Arcade
 * This is where pretty much everything happens except the games
 * It will allow the user to select a game and begin playing
 * Users may also eventually be allowed to go back from game to main menu
 */

public class Arcade
{
	public static JFrame arcadeFrame; //Frame the game runs on
	public static JPanel curPanel; //Panel to handle inputs and draw
	public static Dimension fullScreen; //Dimension which stores size of full screen
	public static Game curGame; //Current game being seen.
	public static int curGameIndex; //Index inside the allGames list
	public static double frameDelay = (1000 / 60); //Milliseconds to delay between each refresh
	public static int frame = 0; //Frame of play

	public static ArrayList<Game> allGames; //A list that contains an instance of every game

	public static void main(String[] args)
	{
		arcadeFrame = new JFrame("A R C A D E"); //Set up frame
		arcadeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Max Size
		arcadeFrame.setVisible(true); //Set to visible and get dimension
		Insets i = arcadeFrame.getInsets(); //Get size of insets from the screen and determine component size
		fullScreen = new Dimension((int) arcadeFrame.getSize().getWidth() - i.left - i.right, (int) arcadeFrame.getSize().getHeight() - i.top - i.bottom);

		allGames = new ArrayList<Game>(); //Creates an array of all the games
		addAllGames();

		curPanel = new ArcadePanel(); //Instantiate the panel.
		arcadeFrame.add(curPanel); //Set up panel on frame
		curPanel.requestFocusInWindow(); //Deal with swapping in the panel
		curPanel.revalidate(); //Validate hierarchy of panel and frame
		arcadeFrame.revalidate();
		arcadeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finish setting up frame
		arcadeFrame.setFocusTraversalKeysEnabled(true);
		arcadeFrame.repaint(); //Repaint
		curPanel.repaint();
	}

	//Swaps out panels for purpose of changing controls and draw methods
	public static void switchPanel(JPanel jp)
	{
		arcadeFrame.remove(curPanel); // Remove the panel from the frame
		curPanel = jp; // Set the panel to the new address
		curPanel.revalidate(); // Revalidates panel (no idea why but necessary)
		arcadeFrame.add(curPanel, BorderLayout.CENTER); // Put the panel back on the frame
		arcadeFrame.revalidate(); //Revalidate component hierarchy
		curPanel.requestFocusInWindow(); // Gives new panel focus once more
		curPanel.repaint(); // Repaint the panel to see the changes
	}

	//Runs the game on a continuous refresh loop with the game's passed frame rate
	public static void runGame()
	{
		//Multi-threading allows for infinite running of methods
		new Thread(() -> {
			while (!curGame.isFinished())
			{
				curGame.run();
				curGame.getPanel().repaint();
				try
				{
					Thread.sleep((int) frameDelay);
				}
				catch (Exception e)
				{
				}
			}
		}).start();
	}

	//Scrolls through the games available, using n as a direction
	public static void scrollGame(int n)
	{
		if (n == 1) curGameIndex = (curGameIndex >= allGames.size() - 1) ? 0 : curGameIndex + 1;
		else curGameIndex = (curGameIndex <= 0) ? allGames.size() - 1 : curGameIndex - 1;
		curGame = allGames.get(curGameIndex);
	}

	//Returns an ArrayList of all the Game objects
	public static void addAllGames()
	{
		allGames.add(new Twenty48());
		allGames.add(new Snake());
		allGames.add(new BrickBreaker());
		curGame = allGames.get(0); //Current game is set to 0 as default
		curGameIndex = 0;
	}
}
