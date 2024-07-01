package Personagens;

import Logica.Habilidades;

import java.util.ArrayList;

public class Guerreiro extends Personagem {
    public int furia;

    public Guerreiro() {
    }

    public Guerreiro(String nome) {
        super(nome, 12, 8, 6, 0);
        setAtributoEspecial(0);
        setHabilidade(new Habilidades("Golpe Poderoso", "Fogo", 10));
    }

    @Override
    public int usarMagia(Inimigo inimigo, Habilidades habilidade) {
        int dano=0;
        if (getAtributoEspecial() == 1) {
            System.out.println(getNome() + " se acalma e foca na batalha.");
            setAtributoEspecial(0);
            dano=-1;
        } else {
            setAtributoEspecial(1);
            for (Habilidades hab : habilidades) {
                if (hab.getNome().equals("Golpe Poderoso")) {
                    dano += calcularDano(hab, inimigo);
                    break;
                }
            }
        }
        return dano;
    }

    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() * (2.0 + 0.5 * getAtributoEspecial()) + 0.3 * getLevel()));
        if (chanceCritico <= 0.10) {
            danoBase *= 1.5;
        }
        return danoBase;
    }

    @Override
    public int defender() {
        int danoReduzido = (int) (Math.random() * (getDefesa() / 2.0)) + getForca();

        // Verifica se o guerreiro está em fúria
        if (getAtributoEspecial() == 1) {
            System.out.println(getNome() + " está em fúria e toma 20% a mais de dano!");
            danoReduzido = (int) (danoReduzido * 1.2); // Toma 20% a mais de dano
        }
        return danoReduzido;
    }

    @Override
    public void setAtributoEspecial(int furia) {
        this.furia = furia;
    }

    @Override
    public int getAtributoEspecial() {
        return this.furia;
    }

    @Override
    public String getTipo() {
        return "Fogo";
    }

}

