package Personagens;

import Logica.Habilidades;

import java.util.ArrayList;

public class Mago extends Personagem{
    public int pontosMagia;

    public Mago() {}

    public Mago(String nome) {
        super(nome, 6, 4, 3, 0);
        setAtributoEspecial(20);
        setHabilidade(new Habilidades("Estaca de gelo","Gelo",30));
    }

    @Override
    public int usarMagia(Inimigo inimigo, Habilidades habilidade) {
        int dano=0;
        if (getAtributoEspecial() <= 0) {
            System.out.println("Você se sente sem foco para utilizar sua magia!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
            dano+=-1;
        } else {
            for (Habilidades hab : habilidades) {
                if (hab.getNome().equals("Estaca de gelo")) {
                    dano += calcularDano(hab, inimigo);
                    setAtributoEspecial(getAtributoEspecial()-5);
                    break;
                }
            }
        }
        return dano;
    }

    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() + 3 * getLevel()));
        double chanceCriticoTotal = 0.15 + 0.01 * getAtributoEspecial();
        if (chanceCritico <= chanceCriticoTotal) {
            danoBase *= 1.5; // 50% a mais de dano
        }
        return danoBase;
    }

    @Override
    public int defender() {
        int reducaoDefesa = (int) (Math.random() * (getDefesa() / 2.0)) + 1;
        return reducaoDefesa + getForca();
    }

    @Override
    public int getAtributoEspecial() {
        return this.pontosMagia;
    }

    @Override
    public String getTipo() {
        return "Gelo";
    }

    @Override
    public void setAtributoEspecial(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }

}
