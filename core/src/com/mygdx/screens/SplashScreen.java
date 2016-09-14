package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.GraKlasa;

public class SplashScreen extends AbstractScreen
{
	private Texture splashImg;

	public SplashScreen(final GraKlasa game)
	{

		super(game);
		init();

		Timer.schedule(new Task()
		{

			@Override
			public void run()
			{
				game.setScreen(new GamePlayScreen(game));
			}
		}, 1);

	}

	protected void init()
	{
		splashImg = new Texture("splash2.png");
		

	}

	@Override
	public void render(float delta)
	{

		super.render(delta);
		
		spirteBatch.begin();
		spirteBatch.draw(splashImg, 0, 0);
		spirteBatch.end();
	}
}
