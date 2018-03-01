package org.game.twenty48;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * This class is for the tiles on the game board
 */

public class Tile
{
    public static final int WIDTH = 125;
    public static final int HEIGHT = 125;
    
    private Color tileColor;
    private Color textColor;
    private Font font;              //Default font for the tiles
    private Font trippleDigit;      //Font for triple digit numbers
    private Font quadDigit;         //Font for quad digit numbers
    private int value;              //Value of the tile
    private int x;                  //X position
    private int y;                  //Y position
    private BufferedImage tileImage;
    
    public Tile(int value, int x, int y)
    {
        this.value = value;
        this.x = x;
        this.y = y;
        
        font = new Font("", Font.BOLD, 72);
        trippleDigit = new Font("", Font.BOLD, 54);
        quadDigit = new Font("", Font.BOLD, 45);
        
        tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawTile();
    }
    
    public void getTileImage(Graphics g)
    {
    	g.drawImage(tileImage, x, y, null);
    }
    
    private void drawTile()
    {
        Graphics g =  tileImage.getGraphics();
        
        if(value == 2)
        {
            tileColor = new Color(249,204,124);
            textColor = Color.BLACK;
        }
        else if(value == 4)
        {
            tileColor = new Color(255,198,86);
            textColor = Color.BLACK;
        }
        else if(value == 8)
        {
            tileColor = new Color(255,180,30);
            textColor = Color.BLACK;
        }
        else if(value == 16)
        {
            tileColor = new Color(225,255,30);
            textColor = Color.BLACK;
        }
        else if(value == 32)
        {
            tileColor = new Color(146,255,30);
            textColor = Color.BLACK;
        }
        else if(value == 64)
        {
            tileColor = new Color(30,255,116);
            textColor = Color.BLACK;
        }
        else if(value == 128)
        {
            tileColor = new Color(30,255,198);
            textColor = Color.BLACK;
        }
        else if(value == 256)
        {
            tileColor = new Color(30,172,255);
            textColor = Color.BLACK;
        }
        else if(value == 512)
        {
            tileColor = new Color(30,97,255);
            textColor = Color.BLACK;
        }
        else if(value == 1024)
        {
            tileColor = new Color(172,30,255);
            textColor = Color.BLACK;
        }
        else if(value == 2048)
        {
            tileColor = new Color(255,10,10);
            textColor = Color.BLACK;
        }   
        else if(value == 4096)
        {
            tileColor = Color.CYAN;
            textColor = Color.PINK;
        }
        else if(value == 4096 + 4096)
        {
            tileColor = Color.BLACK;
            textColor = Color.PINK;
        }
        else
        {
            tileColor = new Color(204,204,204);
            textColor = new Color(204,204,204);
        }
        
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0,  0, WIDTH, HEIGHT);
        
        g.setColor(tileColor);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(textColor);
        
        if(value > 8 && value <= 64)
        {
            g.setFont(font);
            g.drawString("" + value, WIDTH / 6, HEIGHT / 2 + 25);
        }
        else if(value > 64 && value <= 512)
        {
            g.setFont(trippleDigit);
            g.drawString("" + value, WIDTH / 8, HEIGHT / 2 + 20);
        }
        else if(value > 512)
        {
            g.setFont(quadDigit);
            g.drawString("" + value, WIDTH / 10, HEIGHT / 2 + 15);
        }
        else
        {
            g.setFont(font);
            g.drawString("" + value, WIDTH / 3, HEIGHT / 2 + 25);
        }
        
        g.dispose();
    }
    
    //Getters
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getValue()
    {
        return x;
    }
    
    //Setters
    public void setY(int y)
    {
        this.y = y;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setValue(int value)
    {
        this.value = x;
    }
}
