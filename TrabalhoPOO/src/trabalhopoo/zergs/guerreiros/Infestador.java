/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.zergs.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.nagas.Nagas;
import trabalhopoo.terranos.guerreiros.Ambunave;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thais
 */
public class Infestador extends Nagas {
    
    public Infestador(String nome, int idade, double peso) {
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

        if (inimigo.get(0) instanceof Ambunave ) {
            inimigo.get(0).atacar(aliado, inimigo);
        } else {
            inimigo.get(0).atacar(aliado, inimigo);
        }
    }

    @Override
    public String toString(){
        return "Infestador{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
