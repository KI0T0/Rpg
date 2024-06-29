package Personagens;

public class Mago extends Personagem{
    public int pontosMagia;

    public Mago() {}

    public Mago(String nome, int pontosVida, int forca, int defesa, int pontosMagia) {
        super(nome, pontosVida, forca, defesa);
        setPontosMagia(pontosMagia);
    }


    @Override
    public void usarMagia(/*indicar inimigo*/) {
        if(getPontosMagia()<=0){
            System.out.println("Você se sente sem foco para utilizar sua magia!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
        }else{
            int danoMagico = getForca() * 2;
            /*indicar inimigo e o dano feito*/
            setPontosMagia(-10);
        }
    }

    public int getPontosMagia() {
        return pontosMagia;
    }

    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }
}
