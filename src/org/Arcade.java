package org;
/*
 * RG
 * This is the main class for the Arcade
 * This is where pretty much everything happens except the games
 * It will allow the user to select a game and begin playing
 * Users may also eventually be allowed to go back from game to main menu
 */

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arcade
{
	public static JFrame arcadeFrame;
	public static ArcadePanel arcadePanel;
	public static Dimension fullScreen;
	
	public static void main(String[] args)
	{
		arcadeFrame = new JFrame("A R C A D E");	//Set up frame
		arcadeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);	//Max Size

		arcadeFrame.setVisible(true);	//Set to visible and get dimension
		fullScreen = new Dimension((int)arcadeFrame.getSize().getWidth(), (int)arcadeFrame.getSize().getHeight());
		
		arcadePanel = new ArcadePanel();	//Instatiate Panel
		arcadeFrame.add(arcadePanel);	//Set up panel on frame
		arcadePanel.requestFocusInWindow();	//Deal with swapping in the panel
		arcadePanel.revalidate();
		arcadeFrame.revalidate();
		arcadeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Finish setting up frame
		arcadeFrame.setFocusTraversalKeysEnabled(true);
		arcadeFrame.repaint();	//Repaint
		arcadePanel.repaint();
	}
}
