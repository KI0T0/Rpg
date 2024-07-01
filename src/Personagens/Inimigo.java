package Personagens;

public class Inimigo extends Personagem{
    int jogadorXp;

    public Inimigo(String nome, int jogadorXp) {
        super(nome,(int) (Math.random()*(double)(jogadorXp + jogadorXp/3 + 5)),0,0,(int)(Math.random()*(double)((jogadorXp /4+2)+1)));
        this.jogadorXp = jogadorXp;
    }


    @Override
    public int atacar() {
        return (int)(Math.random()*((double) jogadorXp /4+1) + (double)xp/4+3);
    }

    @Override
    public int defender() {
        return (int)(Math.random()*((double) jogadorXp /4 + 1) + (double) xp /4 + 3);
    }

    @Override
    public void usarMagia() {

    }

    @Override
    public void setAtributoEspecial(int skill) {

    }

    @Override
    public int getAtributoEspecial() {
        return 0;
    }


}
