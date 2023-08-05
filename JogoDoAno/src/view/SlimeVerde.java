package view;

import java.util.concurrent.locks.LockSupport;

import controller.Calculos;
import model.Char;
import model.monsters.Slime;

public class SlimeVerde extends Slime{

	public SlimeVerde(int vida, int ataque) {
		super(vida, ataque);
		super.setVida(Calculos.lancarDado() * 6);
		if(super.getVida() < 30) {
			super.setVida(30);;
		}
		super.setAtaque(Calculos.lancarDado() * 4);
		if(super.getAtaque() < 10) {
			super.setAtaque(10);
		}
		this.setNome("Slime Verde");
	}

	@Override
	public void receberDano(int dano, Char personagem) {
		super.setVida(super.getVida() - dano);

	}
	public void ataqueEspecial(int dado, int dano, Char personagem) {
		dano = 2;
		if (personagem.getVida() > 0) {
			if (dado >= 4) {
				System.err.println(this.getNome() + " tentou rastejar por cima de " + personagem.getNome());
				LockSupport.parkNanos(1_000_000_000);
			}
			if (dado <= 3 && personagem.getDefesa() >= 3) {
				System.out.println(personagem.getNome() + " escapou de " + this.getNome() + "!");
			} else {
				System.out.println(this.getNome() + " rastejou por cima de " + personagem.getNome());
				personagem.setVida(personagem.getVida() - dano);
				System.err.println("Vida atual de " + personagem.getNome() + ": " + personagem.getVida());
			} 
		}
	}

}
