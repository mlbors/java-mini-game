package com.mlbors.mini_game.level.tile;

import com.mlbors.mini_game.graphics.Screen;
import com.mlbors.mini_game.graphics.Sprite;

/**
 * Mini Game - RandomLevel.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class VoidTile extends Tile {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** RENDER *****/
	/******************/
	
	/**
	 * @param Int x x scroll position
	 * @param Int y y scroll position
	 * @param Screen screen what to render
	 */
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
	
}
