package view;

import java.util.concurrent.locks.LockSupport;

import controller.Calculos;
import model.Char;
import model.Dragao;

public class DragaoVerde extends Dragao {
	
	private String nome;
	private int vida;
	private int ataque;
	
	public DragaoVerde(int vida, int ataque) {
		this.nome = "Dragão Verde";
		this.vida = 20;
		this.ataque = 5;
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
		System.out.println("2)Dado lançado para o ataque de " + this.getNome() + "!!");
		System.out.println("2)Resultado do Dado: " + dado);
		personagem.defender(this);
		if (dado >= 5) {
	        this.ataqueEspecial(dado, dano, personagem);
	    }
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("Nome do Monstro: " + this.nome);
		System.out.println("Pontos de Vida: " + this.vida);
		System.out.println("Pontos de Ataque: " + this.ataque);
		if(Calculos.lancarDado() % 2 == 0) {
			System.out.println("--O monstro está fazendo cara de mau");
		} else {
			System.out.println("--O monstro está piscando...");
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
