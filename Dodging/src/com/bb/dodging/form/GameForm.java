package com.bb.dodging.form;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.bb.dodging.util.KeyUtil;


public class GameForm extends JFrame {

	
	public GameForm(String version) {
		
		String title = "Dodging";
		if (version != null && version.length() > 0) {
			title = title + "_" + version;
		}
		
		this.setTitle(title);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.BLACK);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		
		
		// 창 닫으면 프로그램 종료
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		

		// 키입력
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				KeyUtil.onKeyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				KeyUtil.onKeyPressed(e);
			}
		});
	}
}
