package com.mlbors.mini_game.graphics;

import java.util.Random;

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
	public int[] tiles = new int[64 * 64];
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private int width;
	private int height;
	
	private Random random = new Random();
	
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
		
		for (int i = 0; i < 64 * 64; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
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
				
		for (int y = 0; y < height; y++) {
			
			if (y >= height || y < 0) {
				break;
			}
			
			for (int x = 0; x < width; x++) {
				
				if (x >= width || x < 0) {
					break;
				}
				
				int tileIndex = (x >> 4) + (y >> 4) * 64;
				pixels[x+y*width] = tiles[tileIndex];
				
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
