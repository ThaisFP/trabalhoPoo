package trabalhopoo.terranos.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.terranos.Terranos;
import trabalhopoo.zergs.guerreiros.Infestador;

import java.util.LinkedList;
import java.util.List;

public class Endiabrado extends Terranos {
    
    public Endiabrado (String nome, int idade, double peso){
        super(nome, idade, peso);
    }

    @Override
    public boolean ehOrganico() {
        return false;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo) {
        int dano = 15;

        if(aliado.getFirst().morreu(aliado.getFirst())){
            return;
        }

        if(aliado.getFirst() instanceof Infestador){
//            ALIADOS ENDIABRADO
            if(inimigo.size() > 1 && inimigo.size() < 4){
                for (int i = 0; i < inimigo.size() - 1; i++) {
                    inimigo.get(i + 1).setEnergia(inimigo.get(i + 1).getEnergia() - dano);
                    dano = 15 - 5;
                }
            } else if (inimigo.size() == 1) {
                return;
            } else {
                for (int i = 0; i < 4; i++) {
                    inimigo.get(i + 1).setEnergia(inimigo.get(i + 1).getEnergia() - dano);
                    dano = 15 - 5;
                }
            }
        } else {
            if(inimigo.size() > 1 && inimigo.size() < 4){
                for (int i = 0; i < inimigo.size(); i++) {
                    inimigo.get(i).setEnergia(inimigo.get(i).getEnergia() - dano);
                    dano = 15 - 5;
                }
            } else if (inimigo.size() == 1) {
                inimigo.get(0).setEnergia(inimigo.get(0).getEnergia() - 15);
            }else {
                for (int i = 0; i < 4; i++) {
                    inimigo.get(i).setEnergia(inimigo.get(i).getEnergia() - dano);
                    dano = 15 - 5;
                }
            }
        }
    }

    @Override
    public String toString(){
        return "Endiabrado{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }


}
