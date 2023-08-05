package view;

import controller.Calculos;
import model.Char;
import model.monsters.Zumbi;

public class ZumbiVerde extends Zumbi {

	public ZumbiVerde(int vida, int ataque) {
		super(vida, ataque);
		super.setVida(Calculos.lancarDado() * 6);
		if(super.getVida() < 30) {
			super.setVida(30);;
		}
		super.setAtaque(Calculos.lancarDado() * 4);
		if(super.getAtaque() < 10) {
			super.setAtaque(10);
		}
		this.setNome("Zumbi Verde");
	}
	
	@Override
	public void ataqueEspecial(int dado, int dano, Char personagem) {
		dano = 2;
		if(dado > 3) {
			System.out.println("Zumbi tentou infectar");
		} if (dado > 4 && personagem.getDefesa() >= 4) {
			System.out.println(personagem.getNome() + " escapou da infecção!");
		} else {
			personagem.setVida(personagem.getVida() - dano);
			System.out.println(personagem.getNome() + " recebeu " + dano + " de dano!");
		}
		
	}

}
