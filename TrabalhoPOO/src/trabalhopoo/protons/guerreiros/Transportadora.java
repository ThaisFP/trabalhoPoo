package trabalhopoo.protons.guerreiros;

import trabalhopoo.Guerreiro;
import trabalhopoo.protons.Protons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Transportadora extends Protons {
    public ArrayList<Interceptador> interceptadores = new ArrayList<>();

    @Override
    public boolean ehOrganico() {
        return false;
    }

    public Transportadora(String nome, int idade, double peso) {
        super(nome, idade, peso);
        setEnergia(500);
    }

    public void criarInterceptadores(LinkedList<Guerreiro> aliado){
        if(interceptadores.size() < 8){
            interceptadores.add(new Interceptador(aliado.getFirst().getNome(), aliado.getFirst().getIdade(),
                    aliado.getFirst().getPeso(), 25));
        }
    }

    public void limparIntercetadores(){
        interceptadores.clear();
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo) {

        if(aliado.getFirst().morreu(aliado.getFirst())){
            return;
        }

        criarInterceptadores(aliado);

        inimigo.get(0).setEnergia(inimigo.get(0).getEnergia() - 25);

        recuperacaoGelada();
    }

    @Override
    public String toString(){
        return "Transportadora{NOME: '" + getNome() +" ', IDADE: '" + getIdade() + " ', PESO: '" + getPeso() + '}';
    }
}
