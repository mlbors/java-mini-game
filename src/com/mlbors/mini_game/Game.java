package com.mlbors.mini_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mlbors.mini_game.graphics.Screen;

/**
 * Mini Game - Game.java
 * 
 * @author MLBors
 * @version 1.0.0.0
 */

public class Game extends Canvas implements Runnable {
	
	/**********************/
	/***** PROPERTIES *****/
	/**********************/
	
	/*****/
	/***** PUBLIC *****/
	/*****/
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Mini Game";
	
	/*****/
	/***** PRIVATE *****/
	/*****/
	
	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	
	private Thread thread;
	private JFrame frame;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private Screen screen;
	
	/****************************************/
	/****************************************/
	
	/***********************/
	/***** CONSTRUCTOR *****/
	/***********************/
	
	public Game() {
		
		Dimension size = new Dimension(width * scale, height* scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		
		frame = new JFrame();
		
	}
	
	/****************************************/
	/****************************************/
	
	/*****************/
	/***** START *****/
	/*****************/
	
	/**
	 * @return void
	 */
	
	public synchronized void start() {
		
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		
	}
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** STOP *****/
	/****************/
	
	/**
	 * @return void
	 */
	
	public synchronized void stop() {
		
		running = false;
		
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/****************************************/
	/****************************************/
	
	/*********************/
	/***** MAIN LOOP *****/
	/*********************/
	
	/**
	 * @return void
	 */

	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
				
			}
			
		}
		
		stop();
		
	}
	
	/****************************************/
	/****************************************/
	
	/******************/
	/***** UPDATE *****/
	/******************/
	
	/**
	 * @return void
	 */
	
	public void update() {
		
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
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render();
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
		
	}
	
	/****************************************/
	/****************************************/
	
	/****************/
	/***** MAIN *****/
	/****************/
	
	/**
	 * @return void
	 */
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
		
	}
	
}