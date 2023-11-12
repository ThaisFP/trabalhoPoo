/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.protons;

import trabalhopoo.Guerreiro;
import trabalhopoo.protons.guerreiros.Colosso;

import java.util.LinkedList;
import java.util.List;

public abstract class Protons extends Guerreiro {
    
    public Protons(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public void recuperacaoGelada(){
        if(getEnergia() > 0){
            if(getEnergia() < (50 / 100) * 100){
                double energiaRecuperada = (5 / 100) * 100;
                setEnergia((int) (energiaRecuperada + getEnergia())) ;
                System.out.println(getNome() + " recuperou energia. Energia atual: " + getEnergia());
            }
        }
    }
}
