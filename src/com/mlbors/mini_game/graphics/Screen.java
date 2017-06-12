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
	
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	
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
		
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** RENDER *****/
	/******************/
	
	/**
	 * @param Int xOffset x increment
	 * @param Int yOffset y increment
	 * @return void
	 */
	
	public void render(int xOffset, int yOffset) {
				
		for (int y = 0; y < height; y++) {
			
			int yy = y + yOffset;
			
			for (int x = 0; x < width; x++) {
				
				int xx = x + xOffset;
				
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				//pixels[x+y*width] = tiles[tileIndex];
				pixels[x+y*width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.size];
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
