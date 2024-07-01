package Personagens;

import Logica.Habilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {

    //    Atributos
    protected String nome;
    protected int pontosVida;
    protected int maxVida;
    protected int forca;
    protected int defesa;
    protected int level;
    protected int xp;
    protected int xpParaUpar;
    protected List<Habilidades> habilidades;


    //    Construtores
    public Personagem() {
    }

    public Personagem(String nome, int maxVida, int forca, int defesa, int xp) {
        this.nome = nome;
        this.maxVida = maxVida;
        this.forca = forca;
        this.defesa = defesa;
        this.pontosVida = maxVida;
        this.xp = xp;
        this.xpParaUpar = 20;
        this.level = 1;
        this.habilidades = new ArrayList<>();
    }

    //    Métodos que todas as classes possuem, porém é diferente para cada uma (por isso o abstract)
    public abstract int atacar(/*adicionar inimigo*/);

    public abstract int defender();

    public abstract int usarMagia(Inimigo inimigo, Habilidades habilidade);

    public abstract int getAtributoEspecial();

    public abstract void setAtributoEspecial(int skill);

    public abstract String getTipo();


    private void checaLevel() {
        while (this.xp >= this.xpParaUpar) {
            this.xp -= this.xpParaUpar;
            this.level++;
            this.xpParaUpar += 20; // Ajuste o aumento conforme necessário
            aumentarAtributos();
            System.out.println("Parabéns! Você subiu para o nível " + this.level + "!");
            System.out.println("Atributos atualizados:");
            System.out.println("  HP Máximo: " + getMaxVida());
            System.out.println("  Pontos de Vida: " + getPontosVida());
            System.out.println("  Defesa: " + getDefesa());
            System.out.println("  Força: " + getForca());
        }
    }

    private void aumentarAtributos() {
        setMaxVida(getMaxVida() + 10);
        this.pontosVida = this.getMaxVida();
        setDefesa(getDefesa() + 2);
        // Ajuste os valores de aumento conforme necessário
        setForca(getForca() + 3);
    }

    protected int calcularDano(Habilidades habilidade, Personagem alvo) {
        int dano = habilidade.getDanoBase();

        // Vantagens e fraquezas baseadas no tipo da habilidade
        if ((habilidade.getTipo().equals("Fogo") && alvo.getTipo().equals("Gelo")) ||
                (habilidade.getTipo().equals("Gelo") && alvo.getTipo().equals("Trovão")) ||
                (habilidade.getTipo().equals("Trovão") && alvo.getTipo().equals("Fogo"))) {
            dano *= 1.5; // 50% mais dano
        } else if ((habilidade.getTipo().equals("Fogo") && alvo.getTipo().equals("Trovão")) ||
                (habilidade.getTipo().equals("Gelo") && alvo.getTipo().equals("Fogo")) ||
                (habilidade.getTipo().equals("Trovão") && alvo.getTipo().equals("Gelo"))) {
            dano *= 0.75; // 25% menos dano
        }

        return dano;
    }

    //    getters e setters
    public int getLevel() {
        return this.level;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getMaxVida() {
        return this.maxVida;
    }

    public void setMaxVida(int maxVida) {
        this.maxVida = maxVida;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp += xp;
        checaLevel();
    }

    public List<Habilidades> getHabilidade() {
        return this.habilidades;
    }

    public void setHabilidade(Habilidades habilidade) {
        this.habilidades.add(habilidade);
    }

    public int getForca() {
        return this.forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getXpParaUpar() {
        return this.xpParaUpar;
    }
}
