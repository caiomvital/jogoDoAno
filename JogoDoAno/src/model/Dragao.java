package model.monsters;

import controller.Calculos;
import model.Char;
import model.Monstro;

public abstract class Dragao implements Monstro {

	private String nome;
    private int vida;
    private int ataque;

    public Dragao(int vida, int ataque) {
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

    @Override
    public void causarDano(int dano, Char personagem) {
        this.ataque = dano;
        int dado = Calculos.lancarDado();
        System.out.println("Dado lançado para o ataque de " + this.getNome() + "!!");
        System.out.println("Resultado do Dado: " + dado);
        personagem.defender(this);
        if (dado >= 5) {
            this.ataqueEspecial(dado, dano, personagem);
        }
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome do Monstro: " + this.getNome());
        System.out.println("Pontos de Vida: " + this.getVida());
        System.out.println("Pontos de Ataque: " + this.getAtaque());
        if (Calculos.lancarDado() % 2 == 0) {
            System.out.println(this.getNome() + " está fazendo cara de mau");
        } else {
            System.out.println(this.getNome() + " está piscando...");
        }
    }

    // Método abstrato para ser implementado nas subclasses de Dragao
    public abstract void ataqueEspecial(int dado, int dano, Char personagem);

	
}
