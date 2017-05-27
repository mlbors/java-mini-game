package com.mlbors.mini_game.graphics;

/**
 * Mini Game - Screen.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Screen {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	public int[] pixels;
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private int width;
	private int height;
	
	private int counter = 0;
	private int xtime = 0;
	private int ytime = 0;
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * @param Int width screen width
	 * @param Int height screen height
	 */
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** RENDER *****/
	/******************/
	
	/**
	 * @return void
	 */
	
	public void render() {
		
		counter++;
		
		if (counter % 10 == 0) {
			xtime++;
		}
		
		if (counter % 5 == 0) {
			ytime++;
		}
		
		for (int y = 0; y < height; y++) {
			
			if (ytime >= height || ytime < 0) {
				break;
			}
			
			for (int x = 0; x < width; x++) {
				
				if (xtime >= width || xtime < 0) {
					break;
				}
				
				pixels[xtime+ytime*width] = 0xff00ff;
			}
			
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/*****************/
	/***** CLEAR *****/
	/*****************/
	
	/**
	 * @return void
	 */
	
	public void clear() {
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
		
	}

}
