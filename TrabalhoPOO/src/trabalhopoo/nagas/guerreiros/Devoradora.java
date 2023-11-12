/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.nagas.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.nagas.Nagas;
import trabalhopoo.zergs.guerreiros.Zergnideo;

import java.util.LinkedList;
import java.util.List;

public class Devoradora extends Nagas {

    public Devoradora(String nome, int idade, double peso) {
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

        if(aliado.size() == 1){
            int dano = inimigo.get(0).getEnergia();
            inimigo.get(0).setEnergia(dano);

        }else if(aliado.get(1) instanceof Empalador){
            aliado.remove(0);
            for (int i = 0; i < 4; i++){
                criarServos(aliado, inimigo);
            }

        }else{
            int devorar = aliado.get(1).getEnergia() * 2;
            int dano = inimigo.get(0).getEnergia() - devorar;
            inimigo.get(0).setEnergia(dano);
        }

        if(inimigo.get(0).getEnergia() <= 0){
            aliado.remove(1);
        }
    }

    @Override
    public String toString(){
        return "Devoradora{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }

    public void criarServos(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo){
        Servo servo1 = new Servo("Lore", 34, 45);
        aliado.add(0, servo1);
        aliado.get(0).atacar(aliado, inimigo);
        aliado.addLast(aliado.removeFirst());
    }
}
