package org.game.twenty48;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.game.Game;
import org.game.GamePane;

public class Twenty48 extends Game
{
	private Twenty48Panel twenty48Panel;
	private GamePane twenty48Pane;

	public Twenty48()
	{
	    twenty48Panel = new Twenty48Panel();
		twenty48Pane = new GamePane("2048");
		frameRate = 60;
	}

	@Override
	public void start()
	{
	    finished = false;
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
		return twenty48Panel;
	}

	public void getPane(Graphics g)
	{
		twenty48Pane.drawPane(g);
	}
}
