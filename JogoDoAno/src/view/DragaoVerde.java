package view;

import java.util.concurrent.locks.LockSupport;

import controller.Calculos;
import model.Char;
import model.monsters.Dragao;

public class DragaoVerde extends Dragao {
	
	public DragaoVerde(int vida, int ataque) {
		super(vida, ataque);
		super.setVida(Calculos.lancarDado() * 10);
		if(super.getVida() < 40) {
			super.setVida(40);;
		}
		super.setAtaque(Calculos.lancarDado() * 5);
		if(super.getAtaque() < 20) {
			super.setAtaque(20);
		}
		this.setNome("Dragão Verde");
	}
	
	@Override
	public void receberDano(int dano, Char personagem) {
		super.setVida(super.getVida() - dano);
		
	}

	@Override
	public void causarDano(int dano, Char personagem) {
		int dado = Calculos.lancarDado();
		System.out.println("2)Dado lançado para o ataque de " + this.getNome() + "!!");
		System.out.println("2)Resultado do Dado: " + dado);
		personagem.defender(this);
		if (dado >= 5) {
	        this.ataqueEspecial(dado, dano, personagem);
	    }
	}

	@Override
	public void ataqueEspecial(int dado, int dano, Char personagem) {
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
