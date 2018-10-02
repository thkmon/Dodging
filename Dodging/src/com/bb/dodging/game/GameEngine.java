package com.bb.dodging.game;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.bb.dodging.util.DrawUtil;
import com.bb.dodging.util.KeyUtil;

public class GameEngine {

	public static JFrame windowForm = null;
	public static BufferedImage graphicSurface = null;
	public static BufferedImage backgroundImg = null;
	public static BufferedImage man1Img = null;
	public static BufferedImage man2Img = null;
	
	public static int px = 0;
	public static int py = 260;
	
	
	public void playGame(JFrame windowForm) throws Exception {
		// 윈도우폼 준비
		this.windowForm = windowForm;
		
		// 그래픽용 표면 준비
		this.graphicSurface = DrawUtil.loadImage("data/img/background.png");
		
		// 그림 준비
		this.backgroundImg = DrawUtil.loadImage("data/img/background.png");
		this.man1Img = DrawUtil.loadImage("data/img/man1.png");
		this.man2Img = DrawUtil.loadImage("data/img/man2.png");
		
		Runnable gameRunnable = new Runnable() {
			
			@Override
			public void run() {
				gameThreadCore();
			}
		};
		
		Runnable drawRunnable = new Runnable() {
			
			@Override
			public void run() {
				drawThreadCore();
			}
		};
		
		Thread gameThread = new Thread(gameRunnable);
		Thread drawThread = new Thread(drawRunnable);
		
		gameThread.start();
		drawThread.start();
	}
	
	
	public void gameThreadCore() {
		
		int manPictureNum = 0;
		int galPictureNum = 0;
		
		try {
			while (true) {
				graphicSurface = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
				graphicSurface.getGraphics().drawImage(backgroundImg, 0, 0, null);
				
				int rgbValue = 0;
				for (int x=0; x<50; x++) {
					for (int y=0; y<50; y++) {
						if (manPictureNum == 0) {
							rgbValue = this.man1Img.getRGB(x, y);
						} else {
							rgbValue = this.man2Img.getRGB(x, y);
						}
						
						if (rgbValue != Color.BLUE.getRGB()) {
							graphicSurface.setRGB(px + x, py + y, rgbValue);
						}
					}
				}
				
				boolean bMoving = false;
				if (KeyUtil.onKeyDown) {
					if (py < 550) {
						py++;
					}
					bMoving = true;
				}
				
				if (KeyUtil.onKeyUp) {
					if (py > 0) {
						py--;
					}
					bMoving = true;
				}
				
				if (KeyUtil.onKeyLeft) {
					if (px > 0) {
						px--;
					}
					bMoving = true;
				}
				
				if (KeyUtil.onKeyRight) {
					if (px < 750) {
						px++;
					}
					bMoving = true;
				}
				
				if (bMoving) {
					if (manPictureNum == 0) {
						manPictureNum = 1;
					} else {
						manPictureNum = 0;
					}
				}
				
				if (galPictureNum == 0) {
					galPictureNum = 1;
				} else {
					galPictureNum = 0;
				}
				
				Thread.sleep(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void drawThreadCore() {
		
		try {
			String strFps = "";
			long beginTime = 0;
			long endTime = 0;
			long milsec = 0;
			
			while (true) {
				beginTime = System.currentTimeMillis();

				windowForm.getGraphics().drawImage(graphicSurface, 0, 0, null);
				windowForm.getGraphics().drawString("FPS : " + strFps, 40, 560);
				
				while (true) {
					endTime = System.currentTimeMillis();
					milsec = endTime - beginTime;
					
					if (milsec > 15) {
						break;
					} else {
						Thread.sleep(1);
					}
				}
				
				double fps = (1000.0 / milsec);
				strFps = String.valueOf(fps);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}