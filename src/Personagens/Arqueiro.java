package Personagens;

public class Arqueiro extends Personagem {
    public int destreza;

    public Arqueiro() {}

    public Arqueiro(String nome, int pontosVida, int forca, int defesa, int destreza) {
        super(nome, pontosVida, forca, defesa);
        this.destreza = destreza;
    }

    @Override
    public void usarMagia(/*indicar inimigo*/) {
        if(getDestreza()<=0){
            System.out.println("Você se seus reflexos mais lentos!\n" +
                    "Procure uma poção ou um lugar seguro para descansar!");
        }else{
            int astucia = getForca() * 2;
            /*indicar inimigo e o dano feito*/
            setDestreza(-3);
        }
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
