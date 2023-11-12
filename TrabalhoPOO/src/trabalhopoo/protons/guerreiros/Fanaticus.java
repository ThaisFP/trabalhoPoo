/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.protons.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.protons.Protons;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thais
 */
public class Fanaticus extends Protons {
    
    public Fanaticus(String nome, int idade, double peso) {
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

        int dano = inimigo.get(0).getEnergia() - 30;
        inimigo.get(0).setEnergia(dano);

        recuperacaoGelada();
    }

    @Override
    public String toString(){
        return "Fanaticus{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
