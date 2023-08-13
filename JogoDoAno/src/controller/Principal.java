package controller;

import java.util.Scanner;

import model.Char;
import view.DragaoVerde;
import view.SlimeVerde;
import view.ZumbiVerde;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		Char tadeu = new Char(1200, 1000, 10);
		Jogo.comecarJogo(tadeu);
		System.out.println("Teste do Jogo");
		System.out.println("Entre com o ataque do personagem");
		tadeu.setAtaque(scan.nextInt());
		System.out.println("Entre com a vida do personagem");
		tadeu.setVida(scan.nextInt());
		if(tadeu.getVida() > 100) {
			tadeu.setVida(100);
			System.out.println("Vida Máxima: 100");
		}
		tadeu.exibirInformacoes();
		Jogo.comecarBatalha(tadeu, new SlimeVerde(0, 0) , true);
		tadeu.curar(Calculos.lancarDado());
		
		
		

	}

}
