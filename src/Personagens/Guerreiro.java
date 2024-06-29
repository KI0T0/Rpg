package Personagens;

public class Guerreiro extends Personagem{
    public boolean furia;

    public Guerreiro() {}

    public Guerreiro(String nome, int pontosVida, int forca, int defesa) {
        super(nome, pontosVida, forca, defesa);
    }

    @Override
    public void usarMagia(/*inserir inimigo*/){
        if(isFuria()) {
            System.out.println(getNome() + " se acalma e foca na batalha.");
            setFuria(false);
        }else {
            setFuria(true);
        }
    }


    public boolean isFuria() {
        return furia;
    }
    public void setFuria(boolean furia) {
        this.furia = furia;
    }
}

