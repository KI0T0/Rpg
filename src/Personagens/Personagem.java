package Personagens;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int maxVida;
    protected int forca;
    protected int defesa;
    protected int xp;
    //    adicionar lista de Habilidades futuramente



//    Construtores
    public Personagem(){}

    public Personagem(String nome, int maxVida, int forca, int defesa, int xp) {
        this.nome = nome;
        this.maxVida = maxVida;
        this.forca = forca;
        this.defesa = defesa;
        this.pontosVida = maxVida;
        this.xp = xp;
    }

//    Métodos que todas as classes possuem, porém é diferente para cada uma (por isso o abstract)
    public abstract int atacar(/*adicionar inimigo*/);
    public abstract int defender();
    public abstract void usarMagia(/*adicionar inimigo*/);
    public abstract void setAtributoEspecial(int skill);
    public abstract int getAtributoEspecial();




    public void fugir(){
        System.out.println(getNome() + " fugiu da luta. COVARDE!!!");
    }

    public void calcularDano(/*adicionar inimigo (provavelmente)*/){

    }




//    getters e setters


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

    public int getMaxVida(){
        return maxVida;
    }

    public void setMaxVida(){
        this.maxVida = maxVida;
    }

    public int getXp(){
        return xp;
    }

    public void setXp(int i){
        this.xp = xp;
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
