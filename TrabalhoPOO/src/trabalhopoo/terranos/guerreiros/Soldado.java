/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.terranos.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.Organico;
import trabalhopoo.terranos.Terranos;
import trabalhopoo.zergs.guerreiros.Infestador;

import java.util.LinkedList;
import java.util.List;

public class Soldado extends Terranos {

    public Soldado(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(40);
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

        if(inimigo.getFirst().morreu(inimigo.getFirst())){
            return;
        }

        if (aliado.get(0) instanceof Infestador) {
            if(inimigo.size() > 2){
                inimigo.get(1).setEnergia(inimigo.get(1).getEnergia() - 20);
            }

        } else{
            inimigo.get(0).setEnergia(inimigo.get(0).getEnergia() - 20);
        }
    }

    @Override
    public String toString(){
        return "Soldado{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
