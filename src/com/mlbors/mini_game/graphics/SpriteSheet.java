package com.mlbors.mini_game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Mini Game - SprieSheet.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class SpriteSheet {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	public int[] pixels;
	public int size;
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private String path;
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	/**
	 * 
	 * @param String path path to spritesheet
	 * @param Int size size of the spritesheet
	 */
	
	public SpriteSheet(String path, int size) {
		
		this.path = path;
		this.size = size;
		pixels = new int[this.size * this.size];
		load();
	
	}
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** LOAD *****/
	/****************/
	
	private void load() {
		
		try {
			
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
