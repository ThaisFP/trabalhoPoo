package trabalhopoo.terranos.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.nagas.guerreiros.Devoradora;
import trabalhopoo.nagas.guerreiros.Empalador;
import trabalhopoo.nagas.guerreiros.Servo;
import trabalhopoo.protons.guerreiros.Fanaticus;
import trabalhopoo.protons.guerreiros.Tormento;
import trabalhopoo.terranos.Terranos;
import trabalhopoo.zergs.guerreiros.Infestador;
import trabalhopoo.zergs.guerreiros.LordDasCastas;
import trabalhopoo.zergs.guerreiros.TatuBomba;
import trabalhopoo.zergs.guerreiros.Zergnideo;

import java.util.LinkedList;
import java.util.List;

public class Ambunave extends Terranos {

    public Ambunave(String nome, int idade, double peso) {
        super(nome, idade, peso);
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

        if(inimigo.get(0) instanceof Infestador){
            inimigosOrganicos(inimigo);
        }else{
            aliadosOrganicos(aliado);
        }
    }

    @Override
    public String toString(){
        return "Ambunave{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }

    public void aliadosOrganicos(LinkedList<Guerreiro> ladoAliado){
        for (Guerreiro guerreiro : ladoAliado){
            if(guerreiro.ehOrganico()){
                int dano = guerreiro.getEnergia() + 50;
                if ((dano >= 100) && (guerreiro instanceof Soldado)){
                    guerreiro.setEnergia(100);
                }else if((dano >= 200) && (guerreiro instanceof Fanaticus)){
                    guerreiro.setEnergia(200);
                }else if ((dano >= 50) && (guerreiro instanceof Tormento)){
                    guerreiro.setEnergia(50);
                }else{
                    guerreiro.setEnergia(dano);
                }
            }
        }
    }

    public void inimigosOrganicos(List<Guerreiro> ladoInimigo){
        for (Guerreiro guerreiro : ladoInimigo){
            if(guerreiro.ehOrganico()){
                int dano = guerreiro.getEnergia() + 50;
                if ((dano >= 100) && (guerreiro instanceof TatuBomba)
                        || (guerreiro instanceof Infestador) || (guerreiro instanceof Servo) || (guerreiro instanceof Devoradora)){
                    guerreiro.setEnergia(100);
                }else if((dano >= 200) && (guerreiro instanceof LordDasCastas)){
                    guerreiro.setEnergia(200);
                }else if ((dano >= 50) && (guerreiro instanceof Zergnideo)){
                    guerreiro.setEnergia(50);
                }else if((dano >= 400) && (guerreiro instanceof Empalador)){
                    guerreiro.setEnergia(400);
                }else{
                    guerreiro.setEnergia(dano);
                }
            }
        }
    }
}
