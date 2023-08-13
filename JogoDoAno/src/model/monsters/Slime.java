package model.monsters;

import controller.Calculos;
import model.Char;
import model.Monstro;

public abstract class Slime implements Monstro {
	
	private String nome;
    private int vida;
    private int ataque;

    public Slime(int vida, int ataque) {
    	 this.vida = vida;
         this.ataque = ataque;
	}

	public String getNome() {
        return nome;
    }
	public void setNome(String nome) {
		this.nome = nome;
	}

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public void receberDano(int dano, Char personagem) {
        this.vida -= dano;
    }

    public void causarDano(int dano, Char personagem) {
		this.ataque = dano;
		int dado = Calculos.lancarDado();
		System.out.println("2)Dado lançado para o ataque de " + this.getNome() + "!!");
		System.out.println("2)Resultado do Dado: " + dado);
		personagem.defender(this);
		if (dado >= 5 && (this.getVida() < this.getVida() / 4)) {
	        this.ataqueEspecial(dado, dano, personagem);
	    }
	}

    public void exibirInformacoes() {
		System.out.println("Nome do Monstro: " + this.nome);
		System.out.println("Pontos de Vida: " + this.vida);
		System.out.println("Pontos de Ataque: " + this.ataque);
		if(Calculos.lancarDado() % 2 == 0) {
			System.out.println("O " + this.nome + " está rastejando por aí...");
		} else {
			System.out.println("O " + this.nome + " está olhando para o lado...");
		}
		
	}

    // Método abstrato para ser implementado nas subclasses de Dragao
    public abstract void ataqueEspecial(int dado, int dano, Char personagem);

	
	
	

}
