package Personagens;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int forca;
    protected int defesa;
//    adicionar lista de Habilidades futuramente




    public Personagem(){}

    public Personagem(String nome, int pontosVida, int forca, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
    }


    public void atacar(/*adicionar inimigo*/){

    }

    public abstract void  usarMagia(/*adicionar inimigo*/);


    public void defender(){
        setDefesa(defesa+5);
    }

    public void fugir(){
        System.out.println(getNome() + " fugiu da luta. COVARDE!!!");
    }



    public void calcularDano(/*adicionar inimigo (provavelmente)*/){

    }




//    getters and setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
