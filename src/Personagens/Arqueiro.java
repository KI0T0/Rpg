package Personagens;

import Logica.Habilidades;

public class Arqueiro extends Personagem {
    public int destreza;

    public Arqueiro() {}


    public Arqueiro(String nome) {
        super(nome, 7, 5, 4, 0);
        setAtributoEspecial(10);
        setHabilidade(new Habilidades("Flecha Trovoada","Trovão",15));
    }

    @Override
    public int usarMagia(Inimigo inimigo, Habilidades habilidade) {
        int dano = 0;
        if(getAtributoEspecial()<=0) {
            System.out.println("Você se seus reflexos mais lentos!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
            dano+=-1;
        } else {
            for (Habilidades hab : habilidades) {
                if (hab.getNome().equals("Flecha Trovoada")) {
                    dano += calcularDano(hab, inimigo);
                    setAtributoEspecial(getAtributoEspecial()-3);
                    break;
                }
            }
        }
        return dano;
    }


    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() + 5.0 * getLevel()));
        double chanceCriticoTotal = 0.25 + 0.01 * getAtributoEspecial();
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
        return this.destreza;
    }

    @Override
    public String getTipo() {
        return "Trovão";
    }

    @Override
    public void setAtributoEspecial(int destreza) {
        this.destreza = destreza;
    }

}
