package com.mygdx.screens;

import com.mygdx.entitles.Player;
import com.mygdx.game.GraKlasa;

public class GamePlayScreen extends AbstractScreen
{

	private Player player;

	public GamePlayScreen(GraKlasa game)
	{
		super(game);
		init();

	}

	protected void init()
	{
		initPlayer();
	}

	private void initPlayer()
	{
		player = new Player();
		stage.addActor(player);
	}

	@Override
	public void render(float delta)
	{

		super.render(delta);
		update();
		
		spirteBatch.begin();
		stage.draw();
		spirteBatch.end();
	}

	private void update()
	{
		stage.act();
	}
}
