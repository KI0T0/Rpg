package Personagens;

public class Guerreiro extends Personagem{
    public int furia;

    public Guerreiro() {}

    public Guerreiro(String nome) {
        super(nome, 12, 8, 6, 0);
        setAtributoEspecial(0);
    }

    @Override
    public void usarMagia(/*inserir inimigo*/){
        if(getAtributoEspecial()>0) {
            System.out.println(getNome() + " se acalma e foca na batalha.");
            setAtributoEspecial(0);
        }else {
            setAtributoEspecial(1);
        }
    }


    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() * (1 + 0.5 * getAtributoEspecial()) + 0.3 * getXp()));
        if (chanceCritico <= 0.10) {
            danoBase *= 1.5;
        }
        return danoBase;
    }

    @Override
    public int defender() {
        return (int) (Math.random()*((double) getXp() /4 + 1) + (double) getXp() /4 + 3);
    }

    @Override
    public void setAtributoEspecial(int furia) {
        this.furia = furia;
    }

    @Override
    public int getAtributoEspecial() {
        return furia;
    }



    //    public boolean getFuria() {
//        return furia;
//    }
//    public void setFuria(boolean furia) {
//        this.furia = furia;
//    }
}

