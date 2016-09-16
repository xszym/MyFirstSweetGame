package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.entitles.Player;
import com.mygdx.game.GraKlasa;
import com.mygdx.ui.PlayerButton;
import com.mygdx.ui.ResetScoreButton;
import com.mygdx.ui.Score1000;
import com.mygdx.ui.ScoreLabel;
import com.mygdx.ui.iClickCallback;

public class GamePlayScreen extends AbstractScreen
{
	private Image bgImg;
	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	private Label label1000;
	

	public GamePlayScreen(GraKlasa game)
	{
		super(game);
	}

	private void initScoreLabel()
	{
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	protected void init()
	{
		
		initBG();
		init1000();
		initPlayer();
		initResetButton();
		initPlayerButton();
		initScoreLabel();
		
	}

	
	
	private void init1000()
	{
		
		label1000 = new Score1000();
		stage.addActor(label1000);
		
		
	}



	private void initBG()
	{
		bgImg = new Image(new Texture("bg.jpg"));
		stage.addActor(bgImg);
		
	}

	private void initResetButton()
	{
		resetScoreButton = new ResetScoreButton(new iClickCallback()
		{

			@Override
			public void onClick()
			{
				game.resetGameStore();
			}
		});

		stage.addActor(resetScoreButton);

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
		if (game.getPoints()>999){
			label1000.setText(Score1000.gettekstprzy1000());
			
		}
		else {	
			label1000.setText("");
		}
		scoreLabel.setText("Points: " + game.getPoints());
		stage.act();
	}
}
