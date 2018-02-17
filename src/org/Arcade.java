package org;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.game.Game;

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
	protected static Game curGame; //Current game beeing seen.

	public static void main(String[] args)
	{
		arcadeFrame = new JFrame("A R C A D E"); //Set up frame
		arcadeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Max Size

		arcadeFrame.setVisible(true); //Set to visible and get dimension
		fullScreen = new Dimension((int) arcadeFrame.getSize().getWidth(), (int) arcadeFrame.getSize().getHeight());

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
		arcadeFrame.add(curPanel, BorderLayout.CENTER); // Put the panel back on the frame
		curPanel.requestFocusInWindow(); // Gives new panel focus once more
		curPanel.revalidate(); // Revalidates panel (no idea why but necessary)
		curPanel.repaint(); // Repaint the panel to see the changes
	}

	//Scrolls through the games available, using n as a direction
	public static void scrollGame(int n)
	{
		//TODO: Set up a set(?) of Games, and implement method to scroll through it
	}
}
