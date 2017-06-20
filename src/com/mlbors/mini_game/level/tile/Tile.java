package com.mlbors.mini_game.level.tile;

import com.mlbors.mini_game.graphics.Screen;
import com.mlbors.mini_game.graphics.Sprite;

/**
 * Mini Game - RandomLevel.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Tile {

	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	public int x, y;
	public Sprite sprite;
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * @param Sprite sprite the tile sprite
	 */
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
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
		
	}
	
	/****************************************/
	/****************************************/
	
	/*****************/
	/***** SOLID *****/
	/*****************/
	
	public boolean solid() {
		return false;
	}
	
}
