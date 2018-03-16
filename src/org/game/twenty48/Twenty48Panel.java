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
	private final int BACKGROUND_WIDTH 	      = Arcade.fullScreen.width / 2;              //Background width
	private final int BACKGROUND_HEIGHT       = (Arcade.fullScreen.height / 6) * 5;       //Background height
	private final int BACKGROUND_X 		      = Arcade.fullScreen.width / 4;              //Background Y pos
	private final int BACKGROUND_Y 		      = Arcade.fullScreen.height / 12;            //Background X pos
	   
	//Game Board
	private final int ROWS 			= 4;                                                   //Amount of rows
	private final int COLS 			= 4;                                                   //Amount of cols
	private final int SPACING 		= 10;                                                  //Final int used for spacing
	private final int BOARD_HEIGHT 	= (COLS + 1) * SPACING + COLS * Tile.WIDTH;            //Height of the gameboard
	private final int BOARD_WIDTH 	= (ROWS + 1) * SPACING + ROWS * Tile.WIDTH;            //Width of the gameboard
	private BufferedImage gameBoard;                                                       //BufferedImage of the gameboard
	private int gameBoardX = (BACKGROUND_X + (BACKGROUND_WIDTH / 2)) - (BOARD_WIDTH / 2);  //X position of gameboard
	private int gameBoardY = BACKGROUND_Y * 4;                                             //Y position of gameboard
	
	//Tiles
	private Tile[][] tiles          = new Tile[4][4];                                      //2D Array of all the Tile objects
	
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

	//Draws the gameboard and tiles
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
	
	//Creates an empty board, then puts two random tiles
	public void restart()
	{
        for(int row = 0; row < 4; row++)    //Loops through all tiles
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
	
	//Moves tiles right
	public void moveLeft()
	{
        for(int row = 3; row > -1; row--)   //Loops through all tiles starting from the bottom right of the array
        {
            for(int col = 3; col > -1; col --)
            {
                if(col != 0) 
                    addTiles(tiles[row][col - 1], tiles[row][col], row, col, "left");
            }
        }
	}
	
	//Moves tiles right
	public void moveRight()
	{
        for(int row = 0; row < 4; row++)    //Loops through all tiles starting from the top left of array
        {
            for(int col = 0; col < 4 ; col++)
            {
                if(col != 3) 
                    addTiles(tiles[row][col + 1], tiles[row][col], row, col, "right");
            }
        }
	}
	
	//Moves tiles up
	public void moveUp()   
	{
        for(int col = 3; col > -1; col--)   //Loops through all tiles starting from bottom right of array
        {
            for(int row = 3; row > -1 ; row--)
            {
                if(row != 0) 
                    addTiles(tiles[row - 1][col], tiles[row][col], row, col, "up");
            }
        }
	}
	
	//Moves tiles down
	public void moveDown()
	{
	       for(int col = 0; col < 4; col++)    // Loops though all tiles starting from the top right of array
	       {
	           for(int row = 0; row < 4; row++)
	           {
	              if(row != 3) 
	                  addTiles(tiles[row + 1][col], tiles[row][col], row, col, "down");
	           }
	       }
	}
	
	//This does the checking for adding and moving into empty space
	public boolean addTiles(Tile addTo, Tile toBeAdded, int row, int col, String direction)
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
		
	//Prints the numbers in the console
	public void printBoard()
	{
	    System.out.println();
	    System.out.println("Current");
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
		
	//Puts a 2 or a 4 in a random spot on the board
	public void putRandomTile()
	{
	    int row = getRandomSpot();
	    int col = getRandomSpot();
	    
	    if(!isGridFull())
    	    if(tiles[row][col].getValue() == 0)
    	        tiles[row][col].setValue(getRandomTileNum());
    	    else
    	        putRandomTile(); 
	}
	
	//Checks if the grid id full
	public boolean isGridFull()
    {
        int amount = 0;
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col ++)
            {
                if(tiles[row][col].getValue() > 0)
                    amount++;
            }
        }
        return (amount == 16);
    }
	
	//Returns a 2 or a 4
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
	
	//Returns a random number in range 0, 3
	public int getRandomSpot()
	{
	    return (int)(Math.random() * 4);
	}
	
	private class Twenty48Handler implements KeyListener, MouseListener
	{
		public void keyPressed(KeyEvent e)
		{
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
		    
		    putRandomTile();
		}

		public void keyReleased(KeyEvent e) {}

        public void mouseClicked(MouseEvent e) {}

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}        

        public void keyTyped(KeyEvent e) {}
	}
}
