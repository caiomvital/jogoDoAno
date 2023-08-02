package model;

import java.util.concurrent.locks.LockSupport;

public abstract class Slime implements Monstro {
	
	public void rastejar(int dado, int dano, Char personagem) {
		dano = 2;
		if (personagem.getVida() > 0) {
			if (dado > 4) {
				System.err.println(this.getNome() + " tentou rastejar por cima de " + personagem.getNome());
				LockSupport.parkNanos(1_000_000_000);
			}
			if (dado > 3 && personagem.getDefesa() >= 3) {
				System.out.println(personagem.getNome() + " escapou de " + this.getNome() + "!");
			} else {
				System.out.println(this.getNome() + " rastejou por cima de " + personagem.getNome());
				personagem.setVida(personagem.getVida() - dano);
				System.err.println("Vida atual de " + personagem.getNome() + ": " + personagem.getVida());
			} 
		}
	}

}
