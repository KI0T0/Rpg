package Personagens;

import Logica.Habilidades;
import Logica.Jogo;

import java.util.Random;

public class Inimigo extends Personagem{
    int jogadorXp;
    protected String tipo;
    protected static final String[] tipos = {"Fogo", "Gelo", "Trovão", "Normal"};

    public Inimigo(String nome, int jogadorXp) {
        super(nome, (int) (Math.random() * (jogadorXp + (double) jogadorXp / 3 + 5))+1, 0, 5, 5);
        this.jogadorXp = Jogo.ato;
        this.tipo = tipos[new Random().nextInt(tipos.length)];
        setXp(calcularXp());
    }

    private int calcularXp() {
        // Lógica para calcular o XP do inimigo com base no XP do jogador
        return (int) (Math.random() * (xp * jogadorXp));
    }
    @Override
    public int atacar() {
        return (int) (Math.random() * (jogadorXp * 4)) + getLevel() * 8;
    }

    @Override
    public int defender() {
        return (int) (Math.random() * (getDefesa() + jogadorXp / 4));
    }

    @Override
    public int usarMagia(Inimigo inimigo, Habilidades habilidade) {
        return 0;
    }


    @Override
    public void setAtributoEspecial(int skill) {

    }

    @Override
    public int getAtributoEspecial() {
        return 0;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

}
