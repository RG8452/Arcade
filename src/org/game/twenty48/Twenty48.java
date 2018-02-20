package org.game.twenty48;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.GamePane;
import org.game.Game;

public class Twenty48 extends Game
{
    private Twenty48Panel tPanel;
    private GamePane pane;
    
    public Twenty48()
    {
        pane = new GamePane(500, 500, "2048");
    }
    
	@Override
	public void start()
	{
	    tPanel = new Twenty48Panel();
	}

	@Override
	public void run()
	{
		
		
	}

	@Override
	public void end()
	{
		
		
	}

	@Override
	public void reset()
	{
		
		
	}

	@Override
	public JPanel getPanel()
	{
		return tPanel;
	}
	
	public BufferedImage getPane()
	{
	    return pane.getPane();
	}
	
}
