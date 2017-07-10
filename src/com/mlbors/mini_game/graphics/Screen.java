package com.mlbors.mini_game.graphics;

import java.util.Random;

import com.mlbors.mini_game.level.tile.Tile;

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
	
	public int width;
	public int height;
	
	public int xOffset;
	public int yOffset;
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
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
			
			int yp = y + yOffset;
			
			if (yp < 0 || yp >= height) continue;
			
			for (int x = 0; x < width; x++) {
				
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.size];
				
			}
			
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** RENDER TILE *****/
	/***********************/
	
	/**
	 * @param Int xp x position
	 * @param Int yp y position
	 * @param Tile tile used tile
	 * @return void
	 */
	
	public void renderTile(int xp, int yp, Tile tile) {
		
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < tile.sprite.size; y++) {	
			
			int ya = y + yp;
			
			for (int x = 0; x < tile.sprite.size; x++) {	
				
				int xa = x + xp;
				
				if (xa < 0 || xa >= width || ya < 0 || ya >= width) break; 
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size];
				
			}
			
		}
	
	}
	
	/****************************************/
	/****************************************/
	
	/**********************/
	/***** SET OFFSET *****/
	/**********************/
	
	/**
	 * @param Int xOffset x offset
	 * @param Int yOffset y offset
	 */
	
	public void setOffset(int xOffset, int yOffset) {
		
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
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
