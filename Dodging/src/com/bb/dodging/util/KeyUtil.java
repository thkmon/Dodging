package com.bb.dodging.util;

import java.awt.event.KeyEvent;


public class KeyUtil {
	
	public static final int UP = 38;
	public static final int DOWN = 40;
	public static final int LEFT = 37;
	public static final int RIGHT = 39;
	
	public static final int A = 65;
	public static final int S = 83;
	public static final int W = 87;
	public static final int D = 68;
	
	public static final int Z = 90;
	public static final int X = 88;
	
	public static final int ENTER = 10;
	public static final int SPACE = 32;
	public static final int ESC = 27;
	
	public static final int SHIFT = 16;
	public static final int CTRL = 17;
	public static final int ALT = 18;
	
	public static boolean onKeyUp = false;
	public static boolean onKeyDown = false;
	public static boolean onKeyLeft = false;
	public static boolean onKeyRight = false;
	public static boolean onKeyEnter = false;
	public static boolean onKeyCancel = false;
	
	
	public static void onKeyReleased(KeyEvent e) {
		
		try {
			
			int keyCode = e.getKeyCode();
//			System.out.println("KeyUtil onKeyPressed : keyCode == [" + keyCode + "]");
			
			if (keyCode == UP || keyCode == W) {
				onKeyUp = false;
			}
			
			if (keyCode == DOWN || keyCode == S) {
				onKeyDown = false;
			}
			
			if (keyCode == LEFT || keyCode == A) {
				onKeyLeft = false;
			}
			
			if (keyCode == RIGHT || keyCode == D) {
				onKeyRight = false;
			}
			
			if (keyCode == ENTER || keyCode == SPACE || keyCode == Z) {
			}
			
			if (keyCode == ESC || keyCode == X) {
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void onKeyPressed(KeyEvent e) {
		
		try {
			
			int keyCode = e.getKeyCode();
//			System.out.println("KeyUtil onKeyPressed : keyCode == [" + keyCode + "]");
			
			if (keyCode == UP || keyCode == W) {
				onKeyUp = true;
			}
			
			if (keyCode == DOWN || keyCode == S) {
				onKeyDown = true;
			}
			
			if (keyCode == LEFT || keyCode == A) {
				onKeyLeft = true;
			}
			
			if (keyCode == RIGHT || keyCode == D) {
				onKeyRight = true;
			}
			
			if (keyCode == ENTER || keyCode == SPACE || keyCode == Z) {
			}
			
			if (keyCode == ESC || keyCode == X) {
				System.exit(0);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
