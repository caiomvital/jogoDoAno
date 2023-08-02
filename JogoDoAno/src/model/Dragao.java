package model;

import java.util.concurrent.locks.LockSupport;

public abstract class Dragao implements Monstro {

	public void cuspirFogo(int dado, int dano, Char personagem) {
		dano = 3;
		if (personagem.getVida() > 0) {
			if (dado > 3) {
				System.err.println(this.getNome() + " se prepara para cuspir fogo!");
				LockSupport.parkNanos(1_000_000_000);
			}
			if (dado > 5 && personagem.getDefesa() >= 4) {
				System.out.println(personagem.getNome() + " escapou do fogo!");
			} else {
				System.out.println(personagem.getNome() + " foi atingido pelo fogo!");
				personagem.setVida(personagem.getVida() - dano);
				System.err.println("Vida atual de " + personagem.getNome() + ": " + personagem.getVida());
			} 
		}
	}
}
