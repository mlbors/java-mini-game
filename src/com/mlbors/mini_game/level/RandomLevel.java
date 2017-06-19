package com.mlbors.mini_game.level;

import java.util.Random;

/**
 * Mini Game - RandomLevel.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class RandomLevel extends Level {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private final Random random = new Random();
	
	/*****/
	/***** PROTECTED *****/
	/*****/
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * @param Int width level width
	 * @param Int height level height
	 */
	
	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	/****************************************/
	/****************************************/
	
	/**************************/
	/***** GENERATE LEVEL *****/
	/**************************/
	
	protected void generateLevel() {
		
		for (int y = 0; y < height; y++) {
			
			for (int x = 0; x < width; x++) {
				
				tiles[x + y * width] = random.nextInt(4);
				
			}
			
		}
		
	}

}
