package com.mlbors.mini_game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Mini Game - Keyboard.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Keyboard implements KeyListener {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	public boolean up, down, left, right;
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private boolean[] keys = new boolean[120];
	
	/****************************************/
	/****************************************/
	
	/*******************/
	/***** UPDATED *****/
	/*******************/
	
	public void update() {
		
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
	}
	
	/****************************************/
	/****************************************/
	
	/*********************/
	/***** KEY TYPED *****/
	/*********************/
	
	/**
	 * @param KeyEvent e event
	 */
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** KEY PRESSED *****/
	/***********************/
	
	/**
	 * @param KeyEvent e event
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	/****************************************/
	/****************************************/
	
	/************************/
	/***** KEY RELEASED *****/
	/************************/
	
	/**
	 * @param KeyEvent e event
	 */

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
