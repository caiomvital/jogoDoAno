package model;

public abstract class Zumbi implements Monstro {

	
	public void infectar(int dado, int dano, Char personagem) {
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
