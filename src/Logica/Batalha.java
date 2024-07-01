package Logica;


import Personagens.Inimigo;

import java.util.Scanner;

import static Logica.Jogo.*;

public class Batalha {


    public static boolean ordemTurno() {
        return Math.random() < 0.5;
    }

    public static void batalha(Inimigo inimigo) {

        Scanner scanner = new Scanner(System.in);

        //loop principal
        while ((jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0)) {
            boolean jogadorPrimeiro = ordemTurno();
//          Vez do jogador
            if (jogadorPrimeiro) {
                limpaConsole();
                mensagem(inimigo.getNome() + "\nHP: " + inimigo.getPontosVida() + "/" + inimigo.getMaxVida());
                mensagem(jogador.getNome() + "\nHP: " + jogador.getPontosVida() + "/" + jogador.getMaxVida());
                System.out.println("Escolha uma ação:");
                imprimeSeparador(20);
                System.out.println("(1) Lute\n(2) Use poção\n(3) Fuja!");
                int resposta = scanner.nextInt();

//              (1) Lute
                if (resposta == 1) {
                    System.out.println("Escolha uma ação:");
                    imprimeSeparador(20);
                    System.out.println("(1) Atacar\n(2) Usar Habilidade\n(3) Defender");
                    resposta = scanner.nextInt();
//                  (1) Atacar
                    if (resposta == 1) {
                        int dano = jogador.atacar() - inimigo.defender();
                        if (dano < 0)
                            dano = 0;
//                  Checa se o dano recebido foi negativo
//                        if (danoRecebido < 0) {
////          Se for, dá um bonus de ataque ao jogador por ter defendido bem
//                            dano -= danoRecebido / 2;
//                            danoRecebido = 0;
//                        }

//                  Distribuição de dano entre jogador e inimigo
//
                        inimigo.setPontosVida(inimigo.getPontosVida() - dano);
                        limpaConsole();
                        mensagem("BATALHA");
                        System.out.println("Você causou " + dano + " de dano em " + inimigo.getNome() + "!");
                        imprimeSeparador(15);
                        aperteParaContinuar();
//                  (2) Usar Habilidade
                    } else if (resposta == 2) {
//                       Implementar Usar Habilidade

//                  (3) Defender)
                    } else {
//                       Implementar Defender
                    }

//              (2) Use poção
                }else if (resposta == 2) {
//          Usar Poção (voltar e implementar)

//              (3) Fugir
                } else {
                    if (ato != 5) {
                        limpaConsole();
                        if (Math.random() * 10 + 1 <= 3.5) {
                            mensagem("Você fugiu da batalha!");
                            aperteParaContinuar();
                            break;
                        } else {
                            mensagem("Você não conseguiu escapar!");
//              Jogador recebe dano por não conseguir fugir
                            jogador.setPontosVida(inimigo.getPontosVida() - inimigo.atacar());
                            if (jogador.getPontosVida() < 0)
                                System.out.println("Você morreu!");
                            jogadorMorreu();

                        }
                    }
                    else{
                        mensagem("Seu corpo treme com o olhar o Necromante. Você não pode fugir!");
                        aperteParaContinuar();
                    }
                }
            } else {
                int danoRecebido = inimigo.atacar() - jogador.defender();
                jogador.setPontosVida(jogador.getPontosVida() - danoRecebido);
                limpaConsole();
                mensagem("BATALHA");
                System.out.println(inimigo.getNome() + " causou em você " + danoRecebido + " de dano!");
                imprimeSeparador(15);
                aperteParaContinuar();
            }
        }
        if (jogador.getPontosVida() < 0) {
            jogadorMorreu();
        } else if (inimigo.getPontosVida() < 0)
            limpaConsole();
            mensagem("Você derrotou " + inimigo.getNome() + "!");
            jogador.setXp(jogador.getXp() + inimigo.getXp());
            mensagem("Você ganhou " + inimigo.getXp() + "!");
            aperteParaContinuar();
    }
}