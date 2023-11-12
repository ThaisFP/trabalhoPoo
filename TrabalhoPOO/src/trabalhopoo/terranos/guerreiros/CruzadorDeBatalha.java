package trabalhopoo.terranos.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.terranos.Terranos;

import java.util.LinkedList;
import java.util.List;

public class CruzadorDeBatalha extends Terranos {

    int qtdAtaque;
    public CruzadorDeBatalha(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(1000);
    }

    @Override
    public boolean ehOrganico() {
        return false;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo) {

        if(aliado.getFirst().morreu(aliado.getFirst())){
            return;
        }

        qtdAtaque++;

        if(qtdAtaque <= 2){
            inimigo.get(0).setEnergia(inimigo.get(0).getEnergia() - 50);
        }else{
            inimigo.getFirst().setEnergia(0);
            qtdAtaque = 0;
        }
    }

    @Override
    public String toString(){
        return "Cruzador de Batalha{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
