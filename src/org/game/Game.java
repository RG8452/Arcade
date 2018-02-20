package org.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.GamePane;

/*
 * RG
 * This is the abstract Game class that all of the games will extend
 * It allows for polymorphism and will have methods that all the games must have
 */

public abstract class Game
{
	protected String name; //Name of the game
	protected BufferedImage arcadeImg; //An image for the Arcade to draw before the game starts

	public abstract void start(); //Starts the game (initialization and such)

	public abstract void run(); //Running game loop

	public abstract void end(); //Occurs when the game ends, close everything down and such

	public abstract void reset(); //Resets all game data

	public abstract JPanel getPanel(); //Retrieves the preferred panel for the game drawing & controls
	
	public abstract void getPane(Graphics g); //Retrieves the game preview pane
}
