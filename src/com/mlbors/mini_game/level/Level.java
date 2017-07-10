package com.mlbors.mini_game.level;

import com.mlbors.mini_game.graphics.Screen;
import com.mlbors.mini_game.level.tile.Tile;

/**
 * Mini Game - Level.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Level {

	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	/*****/
	/***** PROTECTED *****/
	/*****/
	
	protected int width, height;
	protected int[] tiles;
	
	/****************************************/
	/****************************************/
	
	/**************************************/
	/***** CONSTRUCTOR - RANDOM LEVEL *****/
	/**************************************/
	
	/**
	 * @param Int width level width
	 * @param Int height level height
	 */
	
	public Level(int width, int height) {
		
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
		
	}
	
	/****************************************/
	/****************************************/
	
	/*****************************/
	/***** CONSTRUCTOR - MAP *****/
	/*****************************/
	
	/**
	 * @param String path path to the map
	 */
	
	public Level(String path) {
		loadLevel(path);
	}
	
	/****************************************/
	/****************************************/
	
	/**************************/
	/***** GENERATE LEVEL *****/
	/**************************/
	
	protected void generateLevel() {
		
	}
	
	/****************************************/
	/****************************************/
	
	/**********************/
	/***** LOAD LEVEL *****/
	/**********************/
	
	/**
	 * @param String path path to the map
	 */
	
	private void loadLevel(String path) {
		
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** UPDATE *****/
	/******************/
	
	public void update() {
		
	}
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** TIME *****/
	/****************/
	
	private void time() {
		
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** RENDER *****/
	/******************/
	
	/**
	 * @param Int xScroll x scroll position
	 * @param Int yScroll y scroll position
	 * @param Screen screen what to render
	 */
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);
		
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		
		for (int y = y0; y < y1; y++) {
			
			for (int x = x0; x < x1; x++) {
				
				getTile(x, y).render(x, y, screen);
				
			}
			
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/********************/
	/***** GET TILE *****/
	/********************/
	
	/*
	 * @param Int x tile's x position
	 * @param Int y tile's y position
	 */
	
	public Tile getTile(int x, int y) {
		
		if (tiles[x + y * width] == 0) return Tile.grass;
		return Tile.voidTile;
		
	}
	
}
