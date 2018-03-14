package org.game.twenty48;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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
	private Tile[][] tiles = new Tile[4][4];;   //2D Array of all the Tile objects
	
	private BufferedImage gameBoard;
	private int gameBoardX = (BACKGROUND_X + (BACKGROUND_WIDTH / 2)) - (BOARD_WIDTH / 2);;
	private int gameBoardY = BACKGROUND_Y * 4;
	
	//Constructor
	public Twenty48Panel()
	{
		Twenty48Handler handler = new Twenty48Handler();
		
		addKeyListener(handler);
		addMouseListener(handler);
		setFocusable(true);
		setBackground(Color.cyan);	
		
		restart();
		drawGameBoard();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		g.drawImage(gameBoard, gameBoardX, gameBoardY, null);
		drawGameBoard();
	}

	private void drawGameBoard()
	{
		gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = gameBoard.getGraphics();
		
		g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		g.setColor(Color.green);
		        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col ++)
            {     
                tiles[row][col].getTileImage(g);
            }
        }
	}
	
	public void restart()
	{
        for(int row = 0; row < 4; row++)
        {
            for(int col = 0; col < 4; col ++)
            {
                int x = SPACING + SPACING * col + Tile.WIDTH * col;
                int y = SPACING + SPACING * row + Tile.HEIGHT * row;
                tiles[row][col] = new Tile(0, x, y);
            }
        }
        
        putRandomTile();
        putRandomTile();
	}
	
	public void moveLeft()
	{
	    System.out.println("Move Left");
        for(int row = 3; row > -1; row--)
        {
            for(int col = 3; col > -1; col --)
            {
                if(col != 0) addTiles(tiles[row][col - 1], tiles[row][col]);
            }
        }
	}
	
	public void moveRight()
	{
	    System.out.println("Move Right");
        for(int row = 0; row < 4; row++)
        {
            for(int col = 0; col < 4 ; col++)
            {
                if(col != 3) addTiles(tiles[row][col + 1], tiles[row][col]);
            }
        }
	}
	
	public void moveUp()
	{
	    System.out.println("Move Up");
        for(int col = 3; col > -1; col--)
        {
            for(int row = 3; row > -1 ; row--)
            {
                if(row != 0) addTiles(tiles[row - 1][col], tiles[row][col]);
            }
        }
	}
	
	public void moveDown()
	{
	       System.out.println("Move Down");
	       for(int col = 0; col < 4; col++)
	       {
	           for(int row = 0; row < 4; row++)
	           {
	               if(row != 3) addTiles(tiles[row + 1][col], tiles[row][col]);
	           }
	       }
	}
	
	public boolean addTiles(Tile addTo, Tile toBeAdded)
	{   
	    if(addTo.getValue() == 0)
	    {
	        addTo.setValue(toBeAdded.getValue());
	        toBeAdded.setValue(0);
	    }
	    if(addTo.getValue() == toBeAdded.getValue())
	    {
	        addTo.setValue(toBeAdded.getValue() + addTo.getValue());
	        toBeAdded.setValue(0);
	        return true;
	    }
	    else return false;
	}
	
	public void printBoard()
	{
        for(int row = 0; row < 4; row++)
        {
            System.out.println();
            System.out.print("[");
            for(int col = 0; col < 4; col ++)
            {
               System.out.print(tiles[row][col].getValue() + ", ");
            }
            System.out.print("]");
        }
	}
	
	public void putRandomTile()
	{
	    int row = getRandomSpot();
	    int col = getRandomSpot();
	    
	    if(tiles[row][col].getValue() == 0)
	        tiles[row][col].setValue(getRandomTileNum());
	    else
	        putRandomTile();
	    
	}
	
	public int getRandomTileNum()
	{
        int random;
        int tile = 2;
        switch(random = (int)(Math.random() * 5 + 1))
        {
            case 1:
                tile = 2;
                break;
            case 2:
                tile = 2;
                break;
            case 3:
                tile = 2;
                break;
            case 4:
                tile = 2;
                break;
            case 5:
                tile = 4;
                break;
        }
        return tile;
	}
	
	public int getRandomSpot()
	{
	    return (int)(Math.random() * 4);
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
		    printBoard();
		    putRandomTile();
		    System.out.println(getRandomSpot());
		    switch(e.getKeyCode())
		    {
		        case(KeyEvent.VK_LEFT):
		            moveLeft();
		            break;
		        case(KeyEvent.VK_RIGHT):
		            moveRight();
		            break;
		        case(KeyEvent.VK_UP):
		            moveUp();
		            break;
		        case(KeyEvent.VK_DOWN):
		            moveDown();
		            break;
		    }
		}

		public void keyReleased(KeyEvent e)
		{

		}

	}
}
