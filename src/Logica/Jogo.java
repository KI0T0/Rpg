package Logica;
import Personagens.*;
import java.util.Scanner;
import static Logica.Batalha.batalha;

public class Jogo {
    static Scanner scanner = new Scanner(System.in);
    static Personagem jogador;
    static Personagem inimigo;
    public static boolean rodando;


//          Eventos aleatórios
    public static String[] eventos = {"Batalha","Batalha","Batalha","Descanço","Descanço"};


//          Nome dos inimigos
    public static String[] inimigos = {"Lobo","Goblin","Bandido","Zumbi","Necromancer"};




    //      Método para receber os comandos
    public static int lerComando(String prompt, int escolhaUser) {
        int entrada;

        do {
            System.out.println(prompt);
            try {
                entrada = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                entrada = -1;
                System.out.println("Opção inválida!");
            }
        } while (entrada < 1 || entrada > escolhaUser);
        return entrada;
    }

    //      Método para limpar console
    public static void limpaConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();

    }
//      Método para imprimir um separador com tamanho n

    public static void imprimeSeparador(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //      Método para imprimir cabeçalho
    public static void mensagem(String texto) {
        imprimeSeparador(30);
        System.out.println(texto);
        imprimeSeparador(30);
    }


//      Método para parar o jogo até o usuário inputar algo

    public static void aperteParaContinuar() {
        System.out.println("Pressione para continuar...");
        scanner.next();
    }


//      Método para iniciar o jogo

    public static void startGame() {
        boolean nomeSetado = false;
        boolean classeSetada = false;
        String nome;
        int classe;
        limpaConsole();
        imprimeSeparador(40);
        imprimeSeparador(30);
        System.out.println("Projeto RPG - T-Academy");
        imprimeSeparador(9);
        System.out.println("-------- Idealizado por Felipe Gonçalves");
        imprimeSeparador(30);
        imprimeSeparador(40);
        aperteParaContinuar();

//      Receber o nome do jogador
        do {
            limpaConsole();
            mensagem("Qual o seu nome?");
            nome = scanner.next();
//      Confirma nome
            limpaConsole();
            mensagem("Seu nome é " + nome + "?\nSim = 1\nNão = 2");
            int resposta = scanner.nextInt();
            if (resposta == 1)
                nomeSetado = true;
        } while (!nomeSetado);

//      Escolhe a classe do jogador
        do {
            limpaConsole();
            mensagem("Qual a sua classe?");
            imprimeSeparador(40);
            mensagem("Escolha:");
            System.out.println("(1) Guerreiro");
            System.out.println("(2) Arqueiro");
            System.out.println("(3) Mago");
            classe = scanner.nextInt();
            limpaConsole();

            switch (classe) {
                case 1:
                    mensagem("Você escolheu a classe Guerreiro?");
                    System.out.println("HP: 12");
                    System.out.println("Força: 7");
                    System.out.println("Defesa: 6");
                    System.out.println("Atributo Especial: Fúria");
                    break;
                case 2:
                    mensagem("Você escolheu a classe Arqueiro?");
                    System.out.println("HP: 7");
                    System.out.println("Força: 5");
                    System.out.println("Defesa: 4");
                    System.out.println("Atributo Especial: Destreza");
                    break;
                case 3:
                    mensagem("Você escolheu a classe Mago?");
                    System.out.println("HP: 6");
                    System.out.println("Força: 4");
                    System.out.println("Defesa: 3");
                    System.out.println("Atributo Especial: Pontos de Magia");

            }
            mensagem("(1)Sim\n(2)Não");
            int resposta = scanner.nextInt();
            if (resposta == 1)
                classeSetada = true;
        } while (!classeSetada);

//      Cria o jogador de fato, com sua classe correspondente
        switch (classe) {
            case 1:
                jogador = new Guerreiro(nome);
                break;
            case 2:
                jogador = new Arqueiro(nome);
                break;
            case 3:
                jogador = new Mago(nome);
                break;
        }
//      Serve para manter o jogo rodando pelo loopJogo()
        rodando = true;
//      Inicia o loop principal
        loopJogo();
    }


//      Método para continuar o jogo
        public static void continueOJogo () {

        }

//      Mostre as informações do seu personagem
        public static void infoPersonagem () {
            limpaConsole();
            mensagem("PERSONAGEM");
            System.out.println(jogador.getNome() + " HP: " + jogador.getPontosVida() + "/" + jogador.getMaxVida());
            imprimeSeparador(20);
            System.out.println("XP: " + jogador.getXp());
            /*adicionar mais coisas futuramente*/
            aperteParaContinuar();
        }

//      Batalha aleatória
        public static void batalhaRandom(){
            limpaConsole();
            mensagem("Você encontrou uma criatura. Prepare-se para a batalha!!");
            aperteParaContinuar();
            batalha(new Inimigo(inimigos[(int)(Math.random()*inimigos.length)], jogador.getXp()));
        }

//      Método da batalha

//
//        public static void batalha(Inimigo inimigo){
//            //loop principal
//            while(true){
//                limpaConsole();
//                mensagem(inimigo.getNome() + "\nHP: " + inimigo.getPontosVida()+"/" + inimigo.getMaxVida());
//                mensagem(jogador.getNome() + "\nHP: " + jogador.getPontosVida()+"/" + jogador.getMaxVida());
//                System.out.println("Escolha uma ação:");
//                imprimeSeparador(20);
//                System.out.println("(1) Lute\n(2) Use poção\n(3) Fuja!");
//                int resposta = scanner.nextInt();
//                if(resposta == 1){
////              (1) Lute
////                  Necessário calcular o dano
//                    int dano = jogador.atacar() - inimigo.defender();
//                    int danoRecebido = inimigo.atacar() - jogador.defender();
////                  Checa se o dano recebido foi negativo
//                    if(danoRecebido < 0){
////                  Se for, dá um bonus de ataque ao jogador por ter defendido bem
//                        dano -= danoRecebido/2;
//                        danoRecebido = 0;
//                    }
//                    if(dano < 0)
//                        dano = 0;
////                  Distribuição de dano entre jogador e inimigo
//                    jogador.setPontosVida(jogador.getPontosVida() - danoRecebido);
//                    inimigo.setPontosVida(inimigo.getPontosVida() - dano);
////                  Mostre o resultado da batalha
//                    limpaConsole();
//                    mensagem("BATALHA");
//                    System.out.println("Você causou " + dano + " de dano em " + inimigo.getNome() + "!");
//                    imprimeSeparador(15);
//                    System.out.println(inimigo.getNome() + " causou em você " + danoRecebido + " de dano!");
//                    aperteParaContinuar();
//                    if(jogador.getPontosVida() < 0){
//                        jogadorMorreu();
//                        break;
//                    }else if(inimigo.getPontosVida() < 0){
//                        limpaConsole();
//                        mensagem("Você derrotou " + inimigo.getNome() + "!");
//                        jogador.setXp(jogador.getXp()+inimigo.getXp());
//                        mensagem("Você ganhou " + inimigo.getXp() + "!");
//                        aperteParaContinuar();
//                        break;
//                    }
//                } else if (resposta == 2) {
////                      Usa poção (voltar e implementar)
//
//                }else{
////                   Fugir
//                     limpaConsole();
//                     if(Math.random() * 10 + 1 <= 3.5){
//                         mensagem("Você fugiu da batalha!");
//                         aperteParaContinuar();
//                         break;
//                     }else{
//                         mensagem("Você não conseguiu escapar!");
////                       Jogador recebe dano por não conseguir fugir
//                         jogador.setPontosVida(inimigo.getPontosVida() - inimigo.atacar());
//                         if(jogador.getPontosVida() < 0)
//                             jogadorMorreu();
//                     }
//                }
//
//
//            }
//        }
    public static void jogadorMorreu(){
        limpaConsole();
        mensagem("Você morreu!");
        mensagem("Você ganhou " + jogador.getXp() + "XP nessa jorndada. Tente novamente...");
        rodando = false;
    }
//      Menu principal
        public static void mostraMenu () {
            limpaConsole();
            mensagem("MENU");
            System.out.println("Escolha uma ação:");
            imprimeSeparador(20);
            System.out.println("(1) Continue sua campanha");
            System.out.println("(2) Informações sobre seu personagem");
            System.out.println("(3) Saia do jogo");
        }

//      Loop principal
        public static void loopJogo () {
            while (rodando) {
                mostraMenu();
                int entrada = scanner.nextInt();
                if (entrada == 1)
                    continueOJogo();
                else if (entrada == 2)
                    infoPersonagem();
                else
                    rodando = false;
            }
        }

}