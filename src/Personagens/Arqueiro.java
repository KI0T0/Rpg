package Personagens;

public class Arqueiro extends Personagem {
    public int destreza;

    public Arqueiro() {}


    public Arqueiro(String nome) {
        super(nome, 7, 5, 4, 0);
        setAtributoEspecial(10);
    }

    @Override
    public void usarMagia(/*indicar inimigo*/) {
        int astucia;
        if(getAtributoEspecial()<=0) {
            System.out.println("Você se seus reflexos mais lentos!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
            setAtributoEspecial(-3);
        } else {
            astucia = getAtributoEspecial() * 2; //talvez colocar algo mais randomico..
            setAtributoEspecial(-3);
            /*indicar inimigo e o dano feito*/
        }

    }


    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() + 1.5 * getAtributoEspecial() + 0.5 * getXp()));
        double chanceCriticoTotal = 0.25 + 0.01 * getAtributoEspecial();
        if (chanceCritico <= chanceCriticoTotal) {
            danoBase *= 1.5; // 50% a mais de dano
        }
        return danoBase;
    }


    @Override
    public int defender() {
        return 0;
    }


    @Override
    public int getAtributoEspecial() {
        return destreza;

    }

    @Override
    public void setAtributoEspecial(int destreza) {
        this.destreza = destreza;
    }

    //    public int getDestreza() {
//        return destreza;
//    }
//
//    public void setDestreza(int destreza) {
//        this.destreza = destreza;
//    }
}
