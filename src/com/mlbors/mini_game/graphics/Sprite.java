package com.mlbors.mini_game.graphics;

/**
 * Mini Game - Sprie.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Sprite {
	
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
	
	public int size;
	private int x, y;
	private SpriteSheet sheet;
	
	/****************************************/
	/****************************************/
	
	/*****************/
	/***** GRASS *****/
	/*****************/
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** VOID *****/
	/****************/
	
	public static Sprite voidSprite = new Sprite(16, 0);
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * @param Int size size of the sprite
	 * @param Int colour
	 */
	
	public Sprite(int size, int colour) {
		this.size = size;
		pixels = new int[this.size * this.size];
		setColour(colour);
	}
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * @param Int size size of the sprite
	 * @param Int x x coordinate
	 * @param Int y y coordinate
	 * @param SpriteSheet sheet the spritesheet
	 */
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.size = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		
		pixels = new int[this.size * this.size];
		
		load();
		
	}
	
	/****************************************/
	/****************************************/
	
	/**********************/
	/***** SET COLOUR *****/
	/**********************/
	
	/**
	 * @param Int colour
	 */
	
	private void setColour(int colour) {
		
		for (int i = 0; i < this.size * this.size; i++) {
			
			pixels[i] = colour;
			
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** LOAD *****/
	/****************/
	
	private void load() {
		
		for (int y = 0; y < size; y++) {
			
			for (int x = 0; x < size; x++) {
				pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.size];
			}
			
		}
		
	}

}
