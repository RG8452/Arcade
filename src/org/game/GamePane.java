package org.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.Arcade;

/*
 * JH
 * This is a class that draws and handles the game panes that are displayed
 * in the main arcade menu. The game pane is the graphic part of the game
 * selector. It displays the game name and maybe a preview of the game as
 * a picture.
 */

public class GamePane
{
	private final int X_POS;			//Final X position
	private final int Y_POS;			//Final Y position
	private final int WIDTH, HEIGHT;	//Final width and height of the GamePane
	private final int BORDER_WIDTH;		//Final width of the border
	private String name;				//Name of game for the title
	private Color backgroundColor;		//Background color of the pane
	private Color borderColor;			//Color of the border around the pane
	private Color nameColor;            //Color of the title
	private BufferedImage pane;			//Buffered image of the pane
	
	//Constructor
	public GamePane(String name)
	{
		WIDTH = 500;
		HEIGHT = 600;
		BORDER_WIDTH = 10;
		X_POS = (int) (Arcade.fullScreen.getWidth() / 2 - WIDTH / 2);
		Y_POS = (int) Arcade.fullScreen.getHeight() / 6;
		
		this.name = name;
		
		backgroundColor = new Color(125, 0, 125, 50);
		borderColor = new Color(255, 255, 255);
		nameColor = new Color(255, 255, 255);
		
		pane = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		
		drawPane();
	}
	
	//Draws the whole pane
	public void drawPane()
	{	
		Graphics g = pane.getGraphics();

		//Draws the base pane
		g.setColor(backgroundColor);		//Sets the background color
		g.fillRect(0, 0, WIDTH, HEIGHT); 	//Draws the rectangle for the GamePane
		
		//Draws the border
		g.setColor(borderColor);	                    											//Sets the border color
		g.fillRect(0, 0, BORDER_WIDTH, HEIGHT);         											//Top left to bottom left
		g.fillRect(0, 0, WIDTH, BORDER_WIDTH);                  									//Top left to top right
		g.fillRect(WIDTH - BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, HEIGHT - BORDER_WIDTH);        //Top right to bottom right
		g.fillRect(0, HEIGHT - BORDER_WIDTH, WIDTH,BORDER_WIDTH); 									//Bottom right to bottom left
		
		//Draws the title/name of the game
		g.setColor(nameColor);
		g.setFont(new Font("Impact", Font.BOLD, 50));			//Fo
		int titleWidth = g.getFontMetrics().stringWidth(name);	//Gets the width of the game title
		int mid = 0 + (int) (WIDTH / 2);						//Gets the midpoint of the pane
		int titleX = mid - (int) (titleWidth / 2); 				//Gets the center location for the title
		
		g.drawString(name, titleX, (int) (HEIGHT / 6));
	}
	
	//Return the pane as a bufferedImage
	public void drawPane(Graphics g)
	{
	    g.drawImage(pane, X_POS, Y_POS, WIDTH, HEIGHT, null);
	}
	
	//Getters
	public int getX() {return X_POS;}
	public int getY() {return Y_POS;}
	public int getWidth() {return WIDTH;}
	public int getHeight() {return HEIGHT;}
	public int getBorderWidth() {return BORDER_WIDTH;}
	public String getName() {return name;}
	public Color getBackgroundColor() {return backgroundColor;}
	public Color getBorderColor() {return borderColor;}
	public Color getNameColor() {return nameColor;}
	
	//Setters
	public void setName(String name) {this.name = name;}
	public void setBackroundColor(Color backgroundColor) {this.backgroundColor = backgroundColor;}
	public void setBorderColor(Color borderColor) {this.borderColor = borderColor;}
	public void setNameColor(Color nameColor) {this.nameColor = nameColor;}
	
}
