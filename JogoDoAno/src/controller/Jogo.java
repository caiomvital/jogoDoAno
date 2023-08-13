package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Char;
import model.Monstro;
import model.monsters.Dragao;
import model.monsters.Slime;
import model.monsters.Zumbi;
import view.DragaoVerde;
import view.SlimeVerde;
import view.ZumbiVerde;

public class Jogo {
	
	private static List<Monstro> monstros;
	private static int contador = 0;
	
	public static final String MENU =
	        """
	        Bem-vindo ao Jogo do Ano!
	        ------------------------
	        Opções:
	        1) Iniciar Novo Jogo
	        2) Continuar Jogo
	        3) Sair
	        """;
	    
	static Scanner scan = new Scanner(System.in);
	
	public static void inicializarMonstros() {
        monstros = new ArrayList<>();
        monstros.add(new DragaoVerde(0, 0));
        monstros.add(new SlimeVerde(0, 0));
        monstros.add(new ZumbiVerde(0, 0));
        monstros.add(new DragaoVerde(0, 0));
        monstros.add(new SlimeVerde(0, 0));
        monstros.add(new ZumbiVerde(0, 0));
        monstros.add(new DragaoVerde(0, 0));
        monstros.add(new SlimeVerde(0, 0));
        monstros.add(new ZumbiVerde(0, 0));
        // Lembrete: Adicionar mais monstros à lista...
    }
	
	public static void comecarJogo(Char jogador) {
		
		System.out.println(MENU);
		int opcao = 0;
		boolean opcaoValida = true;
		do {
			System.out.println("Entre com uma das opções");
			opcao = scan.nextInt();
			switch(opcao) {
			case 1:
				
				System.out.println("Entre com o nome do Jogador");
				jogador.setNome(scan.next());
				opcaoValida = true;
				inicializarMonstros();
				break;
			case 2:
				//carregamento do jogo
				break;
			case 3:
				System.out.println("Até mais!");
				break;
			}
		} while(!opcaoValida);
		
	}
	
	// lógica da batalha
	public static boolean fimBatalha;
	
	public static void comecarBatalha(Char jogador, Monstro monstro, boolean adicionadoAoContador) {
		contador++;
        System.out.println("A batalha entre " + jogador.getNome() + 
        		" e " + monstro.getNome() + " começou!");
        System.out.println("Este é o " + contador + "º monstro!");
		do {
        	jogador.atacar(monstro, jogador);
            if (monstro.getVida() > 0) {
                monstro.causarDano(monstro.getAtaque(), jogador);
                
            }
            if (!adicionadoAoContador) {
                monstros.remove(monstro);
            }

            // exibe resultado da batalha
            if (jogador.getVida() <= 0) {
                System.out.println(jogador.getNome() + " foi derrotado! Fim de jogo.");
                fimBatalha = true;
            } else if (monstro.getVida() <= 0) {
                System.out.println(jogador.getNome() + " derrotou o " + monstro.getNome() + "!");
                System.out.println("### ### ### ###");
                int experiencia = Calculos.lancarDado();
                if(monstro instanceof Dragao) {
                	experiencia *= 4;
                } else if (monstro instanceof Slime) {
                	experiencia *= 2;
                } else if (monstro instanceof Zumbi) {
                	experiencia *= 3;
                }
                if(experiencia > 10) {
                	experiencia = 10;
                }
                jogador.setExperiencia(jogador.getExperiencia() + experiencia);
                System.out.printf(jogador.getNome() + " ganhou %d pontos de experiência.\n", experiencia);
                monstros.remove(monstro);
                if (monstros.isEmpty()) {
                    System.out.println("Parabéns! Você venceu o jogo!");
                    fimBatalha = true;
                } else {
                    int dado = Calculos.lancarDado();
                	if(dado >= monstros.size()) {
                		dado = monstros.size() -1;
                	}
                	while(!fimBatalha && !monstros.isEmpty()) {
                		monstro = monstros.get(dado);
                		System.out.println("Próximo monstro: " + monstro.getNome());
                		comecarBatalha(jogador, monstro, true);
                	}
                 
                }
                fimBatalha = true;
                
            }
        } while (!fimBatalha);
        
        fimBatalha = false;
    }
	// fim da lógica da batalha

}
