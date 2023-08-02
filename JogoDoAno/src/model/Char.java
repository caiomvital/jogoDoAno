package model;



import java.util.concurrent.locks.LockSupport;

import controller.Calculos;

public class Char {
	
	private String nome;
	private String classe;
	private int vida;
	private int vidaMaxima;
	private int ataque;
	private int defesa;
	private double experiencia;
	
	public Char(int vida, 
				int ataque,
				int defesa) {
		this.nome = "Tadeu";
		this.classe = "Cavaleiro";
		this.vida = vida;
		this.vidaMaxima = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.experiencia = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
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
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public double getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(double experiencia) {
		this.experiencia = experiencia;
	}
	
	public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }
	
	public void atacar(Monstro inimigo, Char personagem) {
		
		int dado = Calculos.lancarDado();
		System.err.println("Dado lançado para o ataque!!");
		System.out.println("Resultado do Dado: " + dado);
        int dano = (int) ((this.ataque * dado) / 10); // Multiplica o ataque pelo valor do dado e divide por 10

        inimigo.receberDano(dano, personagem);
        System.out.println(this.nome + " começou a atacar...");
        LockSupport.parkNanos(1_000_000_000);
        System.out.println(this.nome + " causou " + dano + " de dano em " + inimigo.getNome());
        System.err.println("Vida atual de " + inimigo.getNome() + ": " + inimigo.getVida());
    }
	
	public void defender(Monstro inimigo) {
	    System.out.println(inimigo.getNome() + " começou a atacar...");
	    LockSupport.parkNanos(1_000_000_000);
	    int dado = Calculos.lancarDado();
		System.out.println("1)Dado lançado para a defesa!!");
		System.out.println("1)Resultado do Dado: " + dado);
	    if ((dado * 2) >= this.defesa) {
	        System.out.println(this.nome + " defendeu o ataque!");
	        receberDano(1);
	        System.err.println("Vida atual de " + this.nome + ": " + this.getVida());
	    } else {
	    	System.out.println(this.nome + " recebeu " + inimigo.getAtaque() + " de dano de " + inimigo.getNome());
	        receberDano(inimigo.getAtaque());
	        System.err.println("Vida atual de " + this.nome + ": " + this.getVida());
	    }
	}
	
	public void curar(int quantidadeRecuperada) {
        if (quantidadeRecuperada > 0 && this.vida > 0) {
            // Calcula a quantidade máxima que o personagem pode curar (não ultrapassar vidaMaxima)
            int quantidadeMaximaCura = vidaMaxima - vida;

            // Verifica se a quantidade solicitada é maior que a quantidade máxima que pode curar
            if (quantidadeRecuperada > quantidadeMaximaCura) {
                quantidadeRecuperada = quantidadeMaximaCura;
            }

            // Atualiza a vida do personagem
            this.vida += quantidadeRecuperada;
            
            System.out.println(this.nome + " começou a se curar...");
            LockSupport.parkNanos(1_000_000_000);
            System.out.println(this.nome + " se curou e recuperou " + quantidadeRecuperada + " pontos de vida!");
            System.out.println("Vida atual de " + this.nome + ": " + this.vida);
        } else {
            System.out.println(this.nome + " não tem capacidade de cura disponível no momento.");
        }
    }
	
	public void exibirInformacoes() {
		System.out.println("Nome do Personagem: " + this.nome);
		System.out.println("Pontos de Vida: " + this.vida);
		System.out.println("Pontos de Ataque: " + this.ataque);
		System.out.println("Pontos de Defesa: " + this.defesa);
	}
	
	
	

}
