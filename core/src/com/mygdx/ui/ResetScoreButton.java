package com.mygdx.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ResetScoreButton extends Button
{
	public ResetScoreButton(final iClickCallback callback)
	{
		super(new ButtonStyle());

		init(callback);
	}

	private void init(final iClickCallback callback)
	{

		this.setWidth(100);
		this.setHeight(100);
		this.setX(10);
		this.setY(10);
		this.setDebug(true);

		this.addListener(new ClickListener()
		{
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{

				callback.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
