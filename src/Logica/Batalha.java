package Logica;


import Personagens.Inimigo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Logica.Jogo.*;


public class Batalha {


    static int defesaOriginal = jogador.getDefesa();

    public static boolean ordemTurno() {
        return Math.random() < 0.5;
    }

    public static void batalha(Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);
        boolean jogadorPrimeiro = ordemTurno();

        //loop principal
        while ((jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0)) {

//          Vez do jogador
            if (jogadorPrimeiro) {
                limpaConsole();
                mensagem(inimigo.getNome() + "\nHP: " + inimigo.getPontosVida() + "/" + inimigo.getMaxVida());
                mensagem(jogador.getNome() + "\nHP: " + jogador.getPontosVida() + "/" + jogador.getMaxVida());
                System.out.println("Escolha uma ação:");
                imprimeSeparador(20);
                System.out.println("(1) Lute\n(2) Fuja!");
                int resposta = scanner.nextInt();

//              (1) Lute
                if (resposta == 1) {
                    System.out.println("Escolha uma ação:");
                    imprimeSeparador(20);
                    System.out.println("(1) Atacar\n(2) Usar Habilidade\n(3) Defender");

                    try {
                        resposta = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, entre apenas com a opção 1, 2 ou 3..");
                        scanner.nextLine();
                        aperteParaContinuar();
                    }

//                  (1) Atacar
                    if (resposta == 1) {
                        int dano = jogador.atacar() - inimigo.defender();
                        if (dano < 0)
                            dano = 0;
                        inimigo.setPontosVida(inimigo.getPontosVida() - dano);
                        limpaConsole();
                        mensagem("BATALHA");
                        System.out.println("Você causou " + dano + " de dano em " + inimigo.getNome() + "!");
                        imprimeSeparador(15);
                        aperteParaContinuar();

//                  (2) Usar Habilidade
                    } else if (resposta == 2) {
                        System.out.println("Escolha uma habilidade:");
                        List<Habilidades> habilidades = jogador.getHabilidade();
                        for (int i = 0; i < habilidades.size(); i++) {
                            System.out.println("(" + (i + 1) + ") " + habilidades.get(i).getNome());
                        }
                        try {
                            int habilidadeEscolhida = scanner.nextInt();
                            if (habilidadeEscolhida >= 1 && habilidadeEscolhida <= habilidades.size()) {
                                Habilidades habilidade = habilidades.get(habilidadeEscolhida - 1);
                                int danoHabilidade = jogador.usarMagia(inimigo, habilidade);
                                inimigo.setPontosVida(inimigo.getPontosVida() - danoHabilidade);

                                if (danoHabilidade > 0) {
                                    System.out.println("Você usou " + habilidade.getNome() + " e causou " + danoHabilidade + " de dano no inimigo.");
//                              Adicionado esse if == 0 pois pode ocorrer casos onde o Guerreiro use a sua habilidade uma segunda vez, se acalme e o dano seja negativo...
                                } else if (danoHabilidade == 0) {
                                    System.out.println("Você errou miseravelmente....");
                                }
                                aperteParaContinuar();

//                  (3) Defender)
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, entre apenas com a opção 1, 2 ou 3..");
                            scanner.nextLine();
                            aperteParaContinuar();
                        }
                    } else {
                        System.out.println("Você se defende do próximo ataque!");
                        jogador.setDefesa(jogador.getDefesa() + 5);
                    }

//              (2) Fugir
                } else if (ato != 5) {
                    limpaConsole();
                    if (Math.random() * 10 + 1 <= 3.5) {
                        mensagem("Você fugiu da batalha!");
                        aperteParaContinuar();
                        break;
                    } else {
                        mensagem("Você não conseguiu escapar!");
//              Jogador recebe dano por não conseguir fugir
                        jogador.setPontosVida(inimigo.getPontosVida() - inimigo.atacar());
                        if (jogador.getPontosVida() < 0) {
                            System.out.println("Você morreu!");
                            jogadorMorreu();
                        }
                    }
                } else {
                    mensagem("Seu corpo treme com o olhar o Necromante. Você não pode fugir!");
                    aperteParaContinuar();
                }
            } else {
                limpaConsole();
                mensagem("BATALHA");
                int danoRecebido = inimigo.atacar() - jogador.defender();
                if (danoRecebido < 0)
                    danoRecebido = 0;
                jogador.setPontosVida(jogador.getPontosVida() - danoRecebido);
                System.out.println(inimigo.getNome() + " causou em você " + danoRecebido + " de dano!");
                imprimeSeparador(15);
                aperteParaContinuar();
                if (jogador.getPontosVida() <= 0) {
                    jogadorMorreu();
                }
                jogador.setDefesa(defesaOriginal);
            }
            jogadorPrimeiro = !jogadorPrimeiro;
        }
        if (inimigo.getPontosVida() <= 0) {
            limpaConsole();
            mensagem("Você derrotou " + inimigo.getNome() + "!");
            jogador.setXp(inimigo.getXp());
            mensagem("Você ganhou " + inimigo.getXp() + "!");
            aperteParaContinuar();
        }
    }
}