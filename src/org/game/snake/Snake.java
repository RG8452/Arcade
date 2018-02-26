package org.game.snake;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.game.Game;
import org.game.GamePane;

/*
 * This is the class that runs a game of snake
 * It generates a list of coordinates for each piece of the snake
 * The "apple" increases length and has random coords
 * The field on which the snake is located is 30 squared
 */
public class Snake extends Game
{
	public final int dotsPerSide = 30; //Dots on a given side of the board
	private SnakePanel snakePanel; //The panel to interact and draw
	private GamePane pane; //The pane to draw
	protected ArrayList<Point> pieceLocations; //List of all of the points on the snake
	protected Point applePoint; //The point where the apple is located
	private int extendLength = 0; //Variable which will help with extending the snake
	private boolean acted = false; //Boolean which shows if dir has already been changed this frame

	private enum DIRECTION //Enum for all possible movement directions
	{
		RIGHT, LEFT, UP, DOWN
	}

	private DIRECTION direction = DIRECTION.RIGHT; //Curent direction of motion

	//Constructor
	public Snake()
	{
		snakePanel = new SnakePanel();
		pane = new GamePane("Snake");
		frameRate = 10;
	}

	@Override
	public void start()
	{
		finished = false;
		pieceLocations = new ArrayList<>();
		reset();
	}

	@Override
	public void run()
	{
		if (gameOverCheck()) //If Game Over, then end the game.
		{
			end();
			return;
		}

		switch (direction)
		{
			case RIGHT: //If moving right, then add a piece at the beginning to the right of start and remove the end
				pieceLocations.add(0, new Point((int) pieceLocations.get(0).getX() + 1, (int) pieceLocations.get(0).getY()));
				if (!(extendLength > 0)) pieceLocations.remove(pieceLocations.size() - 1);
				else extendLength--;
				break;
			case LEFT: //Same with every other direction; last piece is only removed in snake is not lengthening
				pieceLocations.add(0, new Point((int) pieceLocations.get(0).getX() - 1, (int) pieceLocations.get(0).getY()));
				if (!(extendLength > 0)) pieceLocations.remove(pieceLocations.size() - 1);
				else extendLength--;
				break;
			case UP:
				pieceLocations.add(0, new Point((int) pieceLocations.get(0).getX(), (int) pieceLocations.get(0).getY() - 1));
				if (!(extendLength > 0)) pieceLocations.remove(pieceLocations.size() - 1);
				else extendLength--;
				break;
			case DOWN:
				pieceLocations.add(0, new Point((int) pieceLocations.get(0).getX(), (int) pieceLocations.get(0).getY() + 1));
				if (!(extendLength > 0)) pieceLocations.remove(pieceLocations.size() - 1);
				else extendLength--;
				break;
		}

		//If the player has hit the apple
		if ((int) pieceLocations.get(0).getX() == (int) applePoint.getX() && (int) pieceLocations.get(0).getY() == (int) applePoint.getY())
		{
			randomizeApple();
			extendLength += 3;
		}

		acted = false;
	}

	//Method which uses direction and stuff to see if the game is over
	private boolean gameOverCheck()
	{
		switch (direction)
		{
			case RIGHT:
				//Check OOB
				if (pieceLocations.get(0).getX() + 1 >= dotsPerSide) return true;
				//Check collision/intersection with any piece of the snake
				for (int loop = 1; loop < pieceLocations.size(); loop++)
				{
					if ((int) (pieceLocations.get(loop).getX()) == (int) (pieceLocations.get(0).getX() + 1)) 
					{
						if ((int) (pieceLocations.get(loop).getY()) == (int) (pieceLocations.get(0).getY())) return true;
					}
				}
				break;
			case LEFT: //All four directions are similar: OOB then collisions
				if (pieceLocations.get(0).getX() - 1 < 0) return true;
				for (int loop = 1; loop < pieceLocations.size(); loop++)
				{
					if ((int) (pieceLocations.get(loop).getX()) == (int) (pieceLocations.get(0).getX() - 1)) 
					{
						if ((int) (pieceLocations.get(loop).getY()) == (int) (pieceLocations.get(0).getY())) return true;
					}
				}
				break;
			case UP:
				if (pieceLocations.get(0).getY() - 1 < 0) return true;
				for (int loop = 1; loop < pieceLocations.size(); loop++)
				{
					if ((int) (pieceLocations.get(loop).getY()) == (int) (pieceLocations.get(0).getY() - 1)) 
					{
						if ((int) (pieceLocations.get(loop).getX()) == (int) (pieceLocations.get(0).getX())) return true;
					}
				}
				break;
			case DOWN:
				if (pieceLocations.get(0).getY() + 1 >= dotsPerSide) return true;
				for (int loop = 1; loop < pieceLocations.size(); loop++)
				{
					if ((int) (pieceLocations.get(loop).getY()) == (int) (pieceLocations.get(0).getY() + 1)) 
					{
						if ((int) (pieceLocations.get(loop).getX()) == (int) (pieceLocations.get(0).getX())) return true;
					}
				}
				break;
		}
		return false;
	}

	@Override
	public void end()
	{
		System.out.println("OWARII DA");
		finished = true;
	}

	@Override
	public void reset()
	{
		int randomStartX = (int) (Math.random() * (dotsPerSide - 5)) + 5; //Generate random snake spawn
		int randomStartY = (int) (Math.random() * (dotsPerSide - 5)) + 5;
		int randomDir = (randomStartX > dotsPerSide / 2) ? 0 : 1; //Generates the snake in random dir, based on direction
		pieceLocations.clear();
		switch (randomDir) //Generate the snake in whatever random direction
		{
			case 0:
				for (int z = 0; z < 4; z++)
					pieceLocations.add(new Point(randomStartX + z, randomStartY));
				break;
			case 1:
				for (int z = 0; z < 4; z++)
					pieceLocations.add(new Point(randomStartX - z, randomStartY));
				break;
		}
		randomizeApple();
		if (randomStartX > dotsPerSide / 2) direction = DIRECTION.LEFT;
		else direction = DIRECTION.RIGHT;
	}

	//Randomizes apple coords
	private void randomizeApple()
	{
		applePoint = new Point((int) (Math.random() * dotsPerSide), (int) (Math.random() * dotsPerSide)); //Random apple coords
	}

	//Sets the direction of the snake based on c, with different chars being different dirs
	public void setDirection(char c)
	{
		if (acted) return; //Boolean forces the player to only change direction once per frame
		else acted = true;

		switch (c) //You can turn in any direction, so long as it isn't opposite direction of motion
		{
			case 'R':
				if (!(direction == DIRECTION.LEFT)) direction = DIRECTION.RIGHT;
				break;
			case 'L':
				if (!(direction == DIRECTION.RIGHT)) direction = DIRECTION.LEFT;
				break;
			case 'D':
				if (!(direction == DIRECTION.UP)) direction = DIRECTION.DOWN;
				break;
			case 'U':
				if (!(direction == DIRECTION.DOWN)) direction = DIRECTION.UP;
				break;
		}
	}

	@Override
	public JPanel getPanel()
	{
		return snakePanel;
	}

	@Override
	public void getPane(Graphics g)
	{
		pane.drawPane(g);
	}
}
