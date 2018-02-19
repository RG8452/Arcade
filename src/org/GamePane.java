package org;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * JH
 * This is a class that draws and handles the game panes that are displayed
 * in the main arcade menu. The game pane is the graphic part of the game
 * selector. It displays the game name and maybe a preview of the game as
 * a picture. This class will also handle if the pane is to be displayed.
 */

public class GamePane
{
	private int x, y;					//x and y
	private final int WIDTH, HEIGHT;	//Final width and height of the GamePane
	private final int BORDER_WIDTH;		//Final width of the border
	private boolean visible;			//Sets if the current pane is visible
	private String name;				//Name of game for the title
	private Color backgroundColor;		//Background color of the pane
	private Color borderColor;			//Color of the border around the pane
	private BufferedImage pane;			//Buffered image of the pane
	
	//Constructor
	public GamePane(int x, int y, String name, Color backgroundColor, Color borderColor)
	{
		WIDTH = 500;
		HEIGHT = 600;
		BORDER_WIDTH = 10;
		
		this.x = x;
		this.y = y;
		
		this.name = name;
		
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		
		pane = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}
	
	//Draws the whole pane
	public void drawPane()
	{	
		Graphics g = pane.getGraphics();
		
		if(visible)
		{
			//Draws the base pane
			g.setColor(backgroundColor);		//Sets the background color
			g.fillRect(x, y, WIDTH, HEIGHT); 	//Draws the rectangle for the GamePane
			
			//Draws the border
			g.setColor(borderColor);	//Sets the border color
			g.fillRect(x - BORDER_WIDTH, y - BORDER_WIDTH, WIDTH + 2 * BORDER_WIDTH, BORDER_WIDTH);	//Top left to top right
			g.fillRect(x - BORDER_WIDTH, y, BORDER_WIDTH, HEIGHT + BORDER_WIDTH);					//Top left to back left
			g.fillRect(x + WIDTH, y, BORDER_WIDTH, HEIGHT + BORDER_WIDTH);							//Top right to bottom right
			g.fillRect(x, y + HEIGHT, WIDTH, BORDER_WIDTH);											//Bottom left to bottom right
			
			//Draws the title/name of the game
			int titleWidth = g.getFontMetrics().stringWidth(name);	//Gets the width of the game title
			int mid = x + (int) (WIDTH / 2);						//Gets the midpoint of the pane
			int titleX = mid - (int) (titleWidth / 2); 				//Gets the center location for the title
			
			g.drawString(name, titleX,	y + (int) (HEIGHT * 2 / 3));
		}
		else
		{
			
		}
	}
	
	public void isVisible(boolean visible)
	{
		this.visible = visible;
	}
}
