package trabalhopoo.protons.guerreiros;

public class Interceptador extends Transportadora {
    int ataque;

    public Interceptador(String nome, int idade, double peso, int ataque){
        super(nome, idade, peso);
        this.ataque = ataque;
    }
}
