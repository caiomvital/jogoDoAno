package model;

public interface Monstro {
	
	void receberDano(int dano, Char personagem);
    void causarDano(int dano, Char personagem);
    void ataqueEspecial(int dado, int dano, Char personagem);
    int getAtaque();
    String getNome();
    int getVida();
    void exibirInformacoes();
    
}
