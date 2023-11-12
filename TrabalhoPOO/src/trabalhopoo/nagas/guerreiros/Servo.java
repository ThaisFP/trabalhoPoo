package trabalhopoo.nagas.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.nagas.Nagas;

import java.util.LinkedList;
import java.util.List;

public class Servo extends Nagas {
    
    public Servo(String nome, int idade, double peso) {
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

        int brotoDeVeneno = inimigo.get(0).getEnergia() - 1;
        inimigo.get(0).setEnergia(brotoDeVeneno);

    }

    @Override
    public String toString(){
        return "Servo{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
