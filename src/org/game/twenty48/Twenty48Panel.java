package org.game.twenty48;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.Arcade;

/*
 * This class handles 2048 and will do all the listening and graphics
 */

public class Twenty48Panel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Game Background
	private final int BACKGROUND_WIDTH 	= Arcade.fullScreen.width / 2;
	private final int BACKGROUND_HEIGHT  = (Arcade.fullScreen.height / 6) * 5;
	private final int BACKGROUND_X 		= Arcade.fullScreen.width / 4;
	private final int BACKGROUND_Y 		= Arcade.fullScreen.height / 12;
	
	//Game Board
	private final int ROWS 			= 4;
	private final int COLS 			= 4;
	private final int SPACING 		= 10;
	private final int BOARD_HEIGHT 	= (COLS + 1) * SPACING + COLS * Tile.WIDTH;
	private final int BOARD_WIDTH 	= (ROWS + 1) * SPACING + ROWS * Tile.WIDTH;
	
	private BufferedImage gameBoard;
	
	private int gameBoardX;
	private int gameBoardY;
	
	//Constructor
	public Twenty48Panel()
	{
		Twenty48Handler handler = new Twenty48Handler();
		
		addKeyListener(handler);
		addMouseListener(handler);
		setFocusable(true);
		setBackground(Color.cyan);	
			
		gameBoardX = (BACKGROUND_X + (BACKGROUND_WIDTH / 2)) - (BOARD_WIDTH / 2);
		gameBoardY = BACKGROUND_Y * 4;
		
		drawGameBoard();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		
		g.drawImage(gameBoard, gameBoardX, gameBoardY, null);
		
		Tile tile = new Tile(0, 50, 50);
	}

	private void drawGameBoard()
	{
		gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = gameBoard.getGraphics();
		
		g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
	}
	
	private class Twenty48Handler implements KeyListener, MouseListener
	{

		public void mouseClicked(MouseEvent e)
		{

		}

		public void mousePressed(MouseEvent e)
		{

		}

		public void mouseReleased(MouseEvent e)
		{

		}

		public void mouseEntered(MouseEvent e)
		{

		}

		public void mouseExited(MouseEvent e)
		{

		}

		public void keyTyped(KeyEvent e)
		{

		}

		public void keyPressed(KeyEvent e)
		{

		}

		public void keyReleased(KeyEvent e)
		{

		}

	}
}
