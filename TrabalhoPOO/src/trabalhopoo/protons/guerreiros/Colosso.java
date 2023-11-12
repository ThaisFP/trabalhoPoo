package trabalhopoo.protons.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.protons.Protons;

import java.util.LinkedList;
import java.util.List;

public class Colosso extends Protons {
    
    public Colosso(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo) {

        if(aliado.getFirst().morreu(aliado.getFirst())){
            return;
        }

        int dano = inimigo.get(0).getEnergia() - 20;
        inimigo.get(0).setEnergia(dano);

        recuperacaoGelada();

    }

    @Override
    public boolean ehOrganico() {
        return false;
    }

    @Override
    public String toString(){
        return "Colosso{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }

}
