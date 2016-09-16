package com.mygdx.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Score1000 extends Label
{
public Score1000(){
	super("" , prepareLabaelStyle());
	init();
}
private static LabelStyle prepareLabaelStyle()
{
	LabelStyle labelStyle = new LabelStyle();
	labelStyle.font = new BitmapFont();
	return labelStyle;
}

private void init()
{
	this.setX(120);
	this.setY(50);
	
}
public static String gettekstprzy1000(){
	String abc = "Brawo uda³o Ci sie zdobyc 1000 punktow \n JESTES UZALEZNIONA/Y";
	return abc;
}
}
