package com.mygdx.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.entitles.Player;
import com.mygdx.game.GraKlasa;
import com.mygdx.ui.PlayerButton;
import com.mygdx.ui.ResetScoreButton;
import com.mygdx.ui.ScoreLabel;
import com.mygdx.ui.iClickCallback;

public class GamePlayScreen extends AbstractScreen
{

	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;

	public GamePlayScreen(GraKlasa game)
	{
		super(game);
	}

	private void initScoreLabel()
	{
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new ScoreLabel();
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
		scoreLabel.setText("Points: " + game.getPoints());
		stage.act();
	}
}
