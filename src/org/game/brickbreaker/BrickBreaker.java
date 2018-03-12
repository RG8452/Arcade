package org.game.brickbreaker;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.game.Game;
import org.game.GamePane;

public class BrickBreaker extends Game
{
    private BrickBreakerPanel bPanel;
    private GamePane pane;

    public BrickBreaker()
    {
        pane = new GamePane("Brick Breaker");
    }

    @Override
    public void start()
    {
        bPanel = new BrickBreakerPanel();
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
        return bPanel;
    }

    public void getPane(Graphics g)
    {
        pane.drawPane(g);
    }
}
