package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.screens.SplashScreen;

public class GraKlasa extends Game {
	
	public final static String GAME_PREFS = "com.mygdx.xszym.prefs";
	public final static String GAME_SCORE = "com.mygdx.xszym.prefs.score";
	
	private int points;
	
	private Preferences pref;

	public final static String GAME_NAME = "Serduszko :<3";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	

	private boolean paused;
	
	@Override
	public void create () {
	
		init();
		this.setScreen(new SplashScreen(this));
	}


	private void init()
	{
		
		pref = Gdx.app.getPreferences(GAME_PREFS);		
		loadscore();
	}


	private void loadscore()
	{
		points = pref.getInteger(GAME_SCORE);
		
	}


	public void addPoints()
	{
		points++;
		updateSaveScoreinPref();

	}


	private void updateSaveScoreinPref()
	{
		pref.putInteger(GAME_SCORE, points);
		pref.flush();
	}
	
	public int getPoints()
	{
		return points;
	}


	
	public boolean isPaused()
	{
		return paused;
	}

	public void setPaused(boolean paused)
	{
		this.paused = paused;
	}


	public void resetGameStore()
	{
		points = 0;
		updateSaveScoreinPref();
		
	}
}
