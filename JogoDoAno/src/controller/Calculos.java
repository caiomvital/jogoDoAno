package controller;

import java.util.Random;

import model.Char;
import model.Monstro;

public class Calculos {
	
	private static Random random = new Random();
	
	public static int lancarDado() {
		
		return random.nextInt(6) +1;
	}
	
	public void causarDano(Monstro inimigo, int dano, Char personagem) {
		inimigo.causarDano(dano, personagem);
		
	}

}
