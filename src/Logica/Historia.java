package Logica;
import static Logica.Jogo.*;


public class Historia {
    public static void mostraAtoI(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("ATO I - A FLORESTA");
        imprimeSeparador(30);
        System.out.println("Você acorda em uma floresta densa, sem lembrar como chegou ali.");
        System.out.println("O som de galhos quebrando alerta você de um perigo iminente.");
        System.out.println("Um lobo feroz aparece, seus olhos brilhando na escuridão.");
        System.out.println("Você se prepara para a batalha, sabendo que precisa sobreviver.");
        aperteParaContinuar();
    }
    public static void mostraAtoII(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("ATO II - A VILA");
        imprimeSeparador(30);
        System.out.println("Após derrotar o lobo, você encontra um caminho que leva a uma vila abandonada.");
        System.out.println("Lá, você encontra sinais de luta recente e sente um calafrio na espinha.");
        System.out.println("De repente, um goblin aparece das sombras, armado e pronto para atacar.");
        System.out.println("Você empunha sua arma, determinado a continuar sua jornada.");
        aperteParaContinuar();
    }
    public static void mostraAtoIII(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("ATO III - O DESFILADEIRO");
        imprimeSeparador(30);
        System.out.println("Após derrotar o goblin, você continua sua jornada e chega a um desfiladeiro perigoso.");
        System.out.println("No meio do caminho, você é emboscado por um grupo de bandidos.");
        System.out.println("O líder dos bandidos avança, confiando na força do seu grupo.");
        System.out.println("Você sabe que essa luta será difícil, mas não pode desistir agora.");
        aperteParaContinuar();
    }
    public static void mostraAtoIV(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("ATO IV - O CEMITÉRIO");
        imprimeSeparador(30);
        System.out.println("Superando os bandidos, você entra em um cemitério antigo e assustador.");
        System.out.println("Um zumbi surge do solo, suas mãos podres se estendendo para você.");
        System.out.println("O ar ao redor é pesado e sombrio, aumentando a sensação de perigo.");
        System.out.println("Você se prepara para lutar contra o morto-vivo, sentindo o peso da missão.");
        aperteParaContinuar();
    }
    public static void mostraAtoV(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("ATO V - A CRIPTA");
        imprimeSeparador(30);
        System.out.println("Depois de derrotar o zumbi, você encontra a entrada de uma cripta sinistra.");
        System.out.println("Dentro, você se depara com o Necromancer, o mestre por trás dos horrores que enfrentou.");
        System.out.println("A presença dele é avassaladora, mas você sabe que essa é a batalha final.");
        System.out.println("Com coragem e determinação, você enfrenta o Necromancer para acabar com seu reinado de terror.");
        aperteParaContinuar();
    }

    public static void mostraFim(){
        limpaConsole();
        imprimeSeparador(30);
        System.out.println("PARABÉNS!! Você salvou o mundo ao derrotar o Necromancer!");
        imprimeSeparador(30);
        System.out.println("Jogo desenvolvido por Felipe Gonçalves. GitHub: https://github.com/KI0T0");
        System.out.println("Agradecimentos:\nMinha esposa, por cuidar da minha filha enquanto programava");
        System.out.println("Professor Rannyer Thom, pelos aprendizados repassados nos últimos dias");
    }
}
