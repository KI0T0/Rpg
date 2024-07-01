package Personagens;

public class Mago extends Personagem{
    public int pontosMagia;

    public Mago() {}

//    public Mago(String nome, int maxVida, int forca, int defesa, int xp, int pontosMagia) {
//        super(nome, maxVida, forca, defesa, xp);
//        this.pontosMagia = pontosMagia;
//    }

    public Mago(String nome) {
        super(nome, 6, 4, 3, 0);
        setAtributoEspecial(20);
    }


    @Override
    public void usarMagia(/*indicar inimigo*/) {
        if(getAtributoEspecial()<=0){
            System.out.println("Você se sente sem foco para utilizar sua magia!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
        }else{
            int danoMagico = (int)(Math.random()*((getForca() + getAtributoEspecial()))/2);
            /*indicar inimigo e o dano feito*/
            setAtributoEspecial(-5);
        }
    }


    @Override
    public int atacar() {
        double chanceCritico = Math.random();
        int danoBase = (int) (Math.random() * (getForca() + 2.0 * getAtributoEspecial() + 0.7 * getXp()));
        double chanceCriticoTotal = 0.15 + 0.01 * getAtributoEspecial();
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
        return pontosMagia;
    }
    @Override
    public void setAtributoEspecial(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }


//    public int getPontosMagia() {
//        return pontosMagia;
//    }
//
//    public void setPontosMagia(int pontosMagia) {
//        this.pontosMagia = pontosMagia;
//    }
}
