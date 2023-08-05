package controller;

import model.Char;
import view.DragaoVerde;
import view.SlimeVerde;
import view.ZumbiVerde;

public class Principal {

	public static void main(String[] args) {
		
		Char tadeu = new Char(1200, 10, 10);
		Jogo.comecarJogo(tadeu);
		tadeu.exibirInformacoes();
		DragaoVerde dragao = new DragaoVerde(20,5);
		SlimeVerde slime = new SlimeVerde(20, 5);
		ZumbiVerde zumbi = new ZumbiVerde(20, 5);
		dragao.exibirInformacoes();
		slime.exibirInformacoes();
		zumbi.exibirInformacoes();
		Jogo.comecarBatalha(tadeu, slime);
		tadeu.curar(Calculos.lancarDado());
		
		

	}

}
