package controller;

import model.Char;
import model.Dragao;
import view.DragaoVerde;

public class Principal {

	public static void main(String[] args) {
		
		
		
		Char tadeu = new Char(200, 10, 10);
		Jogo.comecarJogo(tadeu);
		tadeu.exibirInformacoes();
		Dragao dragao = new DragaoVerde(20, 5);
		dragao.exibirInformacoes();
		
		Jogo.comecarBatalha(tadeu, dragao);
		tadeu.curar(Calculos.lancarDado());

	}

}
