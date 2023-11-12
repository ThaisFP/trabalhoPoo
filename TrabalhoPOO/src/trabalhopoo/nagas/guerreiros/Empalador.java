package trabalhopoo.nagas.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.nagas.Nagas;

import java.util.LinkedList;
import java.util.List;

public class Empalador extends Nagas {

    public Empalador(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(400);
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

        int dano = inimigo.get(0).getEnergia() - 50;
        inimigo.get(0).setEnergia(dano);

        if(aliado.get(0).getEnergia() <= 100 && aliado.size() > 1){
            aliado.remove(1);
            aliado.getFirst().setEnergia(400);
        }
    }

    @Override
    public String toString(){
        return "Empalador{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }

}
