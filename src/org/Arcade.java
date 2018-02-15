package org;
/*
 * RG
 * This is the main class for the Arcade
 * This is where pretty much everything happens except the games
 * It will allow the user to select a game and begin playing
 * Users may also eventually be allowed to go back from game to main menu
 */

import javax.swing.JFrame;

public class Arcade
{
	public static JFrame arcadeFrame;
	
	public static void main(String[] args)
	{
		arcadeFrame = new JFrame("ARCADE");
		arcadeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		arcadeFrame.setVisible(true);
	}
}
