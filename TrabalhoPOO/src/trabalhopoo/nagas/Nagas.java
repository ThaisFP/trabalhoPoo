package trabalhopoo.nagas;

import trabalhopoo.Guerreiro;

import java.util.LinkedList;
import java.util.List;

public abstract class Nagas extends Guerreiro {

    public Nagas(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public abstract void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo);
}
