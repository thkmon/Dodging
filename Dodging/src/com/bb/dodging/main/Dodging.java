package com.bb.dodging.main;

import com.bb.dodging.form.GameForm;
import com.bb.dodging.game.GameEngine;


public class Dodging {

	
	public static void main(String[] args) {

		String version = "181003";
		
		Dodging dodging = new Dodging();
		dodging.showWindowForm(version);
	}
	
	
	public void showWindowForm(String version) {
		
		try {
			GameForm gameForm = new GameForm(version);
			
			GameEngine gameEngine = new GameEngine();
			gameEngine.playGame(gameForm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
