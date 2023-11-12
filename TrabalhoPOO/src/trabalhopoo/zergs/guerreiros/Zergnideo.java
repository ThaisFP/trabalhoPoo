package trabalhopoo.zergs.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.zergs.Zergs;

import java.util.LinkedList;
import java.util.List;
public class Zergnideo extends Zergs {

    public Zergnideo(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(50);
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

        int dano = inimigo.get(0).getEnergia() - 5;
        inimigo.get(0).setEnergia(dano);
    }

    @Override
    public String toString(){
        return "Zergnideo{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
