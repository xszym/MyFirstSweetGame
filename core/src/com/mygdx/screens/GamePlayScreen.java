package com.mygdx.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.entitles.Player;
import com.mygdx.game.GraKlasa;
import com.mygdx.ui.PlayerButton;
import com.mygdx.ui.iClickCallback;

public class GamePlayScreen extends AbstractScreen
{

	private Player player;
	private PlayerButton playerButton; 
	private Button resetScoreButton;
	private Label scoreLabel;

	public GamePlayScreen(GraKlasa game)
	{
		super(game);
	}
		
		

	private void initScoreLabel()
	{
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont(); 
		scoreLabel = new Label("Punkty", labelStyle);
		scoreLabel.setX(20);
		scoreLabel.setY(630);
		stage.addActor(scoreLabel);
	}

	protected void init()
	{

		initPlayer();
		initResetButton();
		initPlayerButton();
		initScoreLabel();
		
	
		
	}

	private void initResetButton()
	{
		resetScoreButton = new Button(new ButtonStyle());
		resetScoreButton.setWidth(100);
		resetScoreButton.setHeight(100);
		resetScoreButton.setX(10);
		resetScoreButton.setY(10);
		resetScoreButton.setDebug(true);
		
		stage.addActor(resetScoreButton);
		
		resetScoreButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				
				game.resetGameStore();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

	}
	private void initPlayerButton()
	{
		playerButton = new PlayerButton(new iClickCallback()
		{
			
			@Override
			public void onClick()
			{
				
				player.reactOnClick();
				game.addPoints();
			}
		});
		
		stage.addActor(playerButton);

		

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
		scoreLabel.setText("Points: " + game.getPoints());
		stage.act();
	}
}
