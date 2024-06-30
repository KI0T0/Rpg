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
        if(getAtributoEspecial()<=0)
            System.out.println("Você se seus reflexos mais lentos!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
        else
            astucia = getAtributoEspecial() * 2; //talvez colocar algo mais randomico..
            /*indicar inimigo e o dano feito*/
            setAtributoEspecial(-3);
    }


    @Override
    public int atacar() {
        return (int) (Math.random()*(getForca() + 1.5 * getAtributoEspecial() + 0.5 * getXp()));
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
