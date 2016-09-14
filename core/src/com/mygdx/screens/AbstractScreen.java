package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GraKlasa;

public abstract class AbstractScreen implements Screen
{
	protected GraKlasa game;
	
	protected Stage stage;
	
	private OrthographicCamera camera;
	
	protected SpriteBatch spirteBatch;
	
	public AbstractScreen(GraKlasa game){
		this.game = game;
		createCamera();
		stage = new Stage(new StretchViewport(GraKlasa.WIDTH, GraKlasa.HEIGHT)	);
		spirteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		init();
	}

	protected abstract void init();
	{
		// TODO Auto-generated method stub
		
	}

	private void createCamera()
	{
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GraKlasa.WIDTH, GraKlasa.HEIGHT);
		camera.update();
	}
	@Override
	public void render(float delta)
	{
		clearScreen();
		camera.update();
		spirteBatch.setProjectionMatrix(camera.combined);
		
	}

	public void clearScreen()
	{
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}
	@Override
	public void resume()
	{
		game.setPaused(false);
		
	}
	@Override
	public void pause()
	{
		game.setPaused(true);
		
	}
	@Override
	public void show()
	{
		
		
	}
	@Override
	public void hide(){}
	
	
	@Override
	public void dispose()
	{
		game.dispose();
		
	}
	@Override
	public void resize(int width, int height)
	{
		
		
	}
}
