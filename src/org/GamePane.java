package org;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * JH
 * This is a class that draws and handles the game panes that are displayed
 * in the main arcade menu. The game pane is the graphic part of the game
 * selector. It displays the game name and maybe a preview of the game as
 * a picture.
 */

public class GamePane
{
	private int x, y;					//x and y
	private final int WIDTH, HEIGHT;	//Final width and height of the GamePane
	private final int BORDER_WIDTH;		//Final width of the border
	private String name;				//Name of game for the title
	private Color backgroundColor;		//Background color of the pane
	private Color borderColor;			//Color of the border around the pane
	private Color nameColor;            //Color of the title
	private BufferedImage pane;			//Buffered image of the pane
	
	//Constructor
	public GamePane(int x, int y, String name)
	{
		WIDTH = 500;
		HEIGHT = 600;
		BORDER_WIDTH = 10;
		
		this.x = x;
		this.y = y;
		
		this.name = name;
		
		backgroundColor = new Color(0, 255, 0);
		borderColor = new Color(0, 255, 0);
		nameColor = new Color(255, 0, 0);
		
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
		g.setColor(borderColor);	                    //Sets the border color
		g.fillRect(BORDER_WIDTH, BORDER_WIDTH, WIDTH - BORDER_WIDTH, HEIGHT - BORDER_WIDTH);         //Top left to bottom left
		g.fillRect(BORDER_WIDTH, BORDER_WIDTH, WIDTH - BORDER_WIDTH, BORDER_WIDTH);                  //Top left to bottom right
		g.fillRect(WIDTH - BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, HEIGHT - BORDER_WIDTH);         //Top right to bottom right
		g.fillRect(HEIGHT - BORDER_WIDTH, WIDTH - BORDER_WIDTH, WIDTH - BORDER_WIDTH, BORDER_WIDTH); //Bottom right to bottom left
		
		//Draws the title/name of the game
		g.setColor(nameColor);
		int titleWidth = g.getFontMetrics().stringWidth(name);	//Gets the width of the game title
		int mid = 0 + (int) (WIDTH / 2);						//Gets the midpoint of the pane
		int titleX = mid - (int) (titleWidth / 2); 				//Gets the center location for the title
		
		g.drawString(name, titleX, (int) (HEIGHT * 2 / 3));
	}
	
	//Return the pane as a bufferedImage
	public BufferedImage getPane()
	{
	    return pane;
	}
	
	//Getters
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return WIDTH;}
	public int getHeight() {return HEIGHT;}
	public int getBorderWidth() {return BORDER_WIDTH;}
	public String getName() {return name;}
	public Color getBackgroundColor() {return backgroundColor;}
	public Color getBorderColor() {return borderColor;}
	public Color getNameColor() {return nameColor;}
	
	//Setters
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setName(String name) {this.name = name;}
	public void setBackroundColor(Color backgroundColor) {this.backgroundColor = backgroundColor;}
	public void setBorderColor(Color borderColor) {this.borderColor = borderColor;}
	public void setNameColor(Color nameColor) {this.nameColor = nameColor;}
	
}
