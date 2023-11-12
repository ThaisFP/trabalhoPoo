package trabalhopoo.protons.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.protons.Protons;

import java.util.LinkedList;
import java.util.List;

public class Tormento extends Protons implements Cloneable {
    
    public Tormento(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public boolean ehOrganico() {
        return super.ehOrganico();
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo) {

        if(aliado.getFirst().morreu(aliado.getFirst())){
            return;
        }

        int dano = aliado.get(0).getEnergia() - 30;
        inimigo.get(0).setEnergia(dano);

        recuperacaoGelada();
    }

    public Tormento clone(){
        try {
            setEnergia(50);
            return (Tormento) super.clone();
        }catch (CloneNotSupportedException erro){
            return null;
        }
    }

    @Override
    public String toString(){
        return "Tormento{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
