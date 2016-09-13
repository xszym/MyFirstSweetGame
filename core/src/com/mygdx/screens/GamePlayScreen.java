package com.mygdx.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.entitles.Player;
import com.mygdx.game.GraKlasa;

public class GamePlayScreen extends AbstractScreen
{

	private Player player;
	private Button playerButton;

	public GamePlayScreen(GraKlasa game)
	{
		super(game);
		init();
		initPlayerButton();

	}

	protected void init()
	{
		initPlayer();
	}
	
	private void initPlayerButton()
	{
		playerButton = new Button(new ButtonStyle());
		playerButton.setWidth(460);
		playerButton.setHeight(360);
		playerButton.setX(10);
		playerButton.setY(170);
		playerButton.setDebug(true);
		
		stage.addActor(playerButton);
		
		playerButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
			System.err.println("klik?");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
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
