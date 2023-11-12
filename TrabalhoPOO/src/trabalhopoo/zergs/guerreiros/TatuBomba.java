/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.zergs.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.zergs.Zergs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thais
 */
public class TatuBomba extends Zergs {
    
    public TatuBomba(String nome, int idade, double peso) {
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

        int dano = inimigo.get(0).getEnergia() - 100;
        inimigo.get(0).setEnergia(dano);

        aliado.get(0).setEnergia(0);
    }

    @Override
    public String toString(){
        return "Tatu-Bomba{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
