package trabalhopoo.zergs.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.zergs.Zergs;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LordDasCastas extends Zergs {

    public LordDasCastas(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(200);
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

        int numAleatorio;
        Random ataqueAleatorio = new Random();
        numAleatorio = ataqueAleatorio.nextInt(3);
        if (numAleatorio == 0) {
            for (int i = 0; i < 3; i++){
                criarZergnideo(aliado, inimigo);
            }
        } else if (numAleatorio == 1) {
            for (int i = 0; i < 2; i++) {
                criarTatuBomba(aliado, inimigo);
            }
        } else {
            criarInfestador(aliado, inimigo);
        }
    }

    @Override
    public String toString(){
        return "Lord das Castas{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }

    public void criarZergnideo(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo){
        Zergnideo zergnideo1 = new Zergnideo(aliado.getFirst().getNome(), aliado.getFirst().getIdade(), 0);
        aliado.addFirst(zergnideo1);
        aliado.getFirst().atacar(aliado, inimigo);
        aliado.add(aliado.remove(0));
    }

    public void criarTatuBomba(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo){
        TatuBomba tatuBomba1 = new TatuBomba(aliado.getFirst().getNome(), aliado.getFirst().getIdade(), 0);
        aliado.addFirst(tatuBomba1);
        aliado.getFirst().atacar(aliado, inimigo);
        aliado.add(aliado.remove(0));
    }

    public void criarInfestador(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo){
        Infestador infestador = new Infestador(aliado.getFirst().getNome(), aliado.getFirst().getIdade(), 0);
        aliado.addFirst(infestador);
        aliado.getFirst().atacar(aliado, inimigo);
        aliado.add(aliado.remove(0));
    }
}
