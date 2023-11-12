package trabalhopoo;

import trabalhopoo.nagas.guerreiros.Devoradora;
import trabalhopoo.nagas.guerreiros.Servo;
import trabalhopoo.protons.guerreiros.Tormento;
import trabalhopoo.terranos.guerreiros.Ambunave;
import trabalhopoo.zergs.guerreiros.Infestador;
import trabalhopoo.zergs.guerreiros.LordDasCastas;
import trabalhopoo.zergs.guerreiros.TatuBomba;
import trabalhopoo.zergs.guerreiros.Zergnideo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Batalha {
    public void batalhas(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) throws EmpateException {

        Guerreiro ultimo1 = null;
        Guerreiro ultimo2 = null;

        Guerreiro ultimoAtacar = null;
        //    =============| BATALHA |=============
        while (!lado1.isEmpty() && !lado2.isEmpty()){
            int numeroAleatorio;
            Random numSorteado = new Random();
            numeroAleatorio = numSorteado.nextInt(2);

            if (numeroAleatorio == 0) {
                if(lado1.get(0).ehOrganico()){
                    for (int i = 0; i < lado2.size(); i++){
                        if (lado2.get(i) instanceof Servo){
                            lado2.get(i).atacar(lado2, lado1);
                        }
                    }
                }

                if (lado1.getFirst() instanceof Ambunave) {
                    lado1.getFirst().atacar(lado1, lado2);
                    lado2.getFirst().atacar(lado2, lado1);

                } else if (lado1.getFirst() instanceof Tormento) {
                    lado1.getFirst().atacar(lado1, lado2);
                    Tormento tormento = new Tormento(lado1.getFirst().getNome(), lado1.getFirst().getIdade(), lado1.getFirst().getPeso());
                    Tormento clone = tormento.clone();

                    lado1.add(lado1.remove(0));
                    lado1.add(0, clone);

                    lado2.getFirst().atacar(lado2, lado1);

                } else if (lado2.getFirst() instanceof Infestador) {
                    lado1.getFirst().atacar(lado1, lado2);
                    Zergnideo zergnideo = new Zergnideo(lado2.getFirst().getNome(), lado2.getFirst().getIdade(), lado2.getFirst().getPeso());
                    lado2.add(0, zergnideo);
                    lado2.getFirst().atacar(lado2, lado1);

                } else {
                    lado1.get(0).atacar(lado1, lado2);
                    lado2.get(0).atacar(lado2, lado1);
                }

            }else {
                if (lado2.getFirst() instanceof Infestador) {
                    lado2.getFirst().atacar(lado2, lado1);

                } else if (lado2.getFirst() instanceof TatuBomba) {
                    lado2.getFirst().atacar(lado2, lado1);
                } else if (lado2.getFirst() instanceof LordDasCastas) {
                    lado2.getFirst().atacar(lado2, lado1);
                    lado1.getFirst().atacar(lado1, lado2);

                } else if (lado1.getFirst() instanceof Tormento){
                    lado2.getFirst().atacar(lado2, lado1);
                    lado1.getFirst().atacar(lado2, lado1);

                }else if (lado2.getFirst() instanceof Devoradora) {
                    lado2.get(0).atacar(lado2, lado1);

                }else if(((lado1.getFirst() instanceof Ambunave) && (lado2.getFirst() instanceof Infestador))
                        || ((lado1.getFirst() instanceof Ambunave) && (lado2.getFirst() instanceof Devoradora))){
                    return;
                } else {
                    lado2.get(0).atacar(lado2, lado1);
                    lado1.get(0).atacar(lado1, lado2);
                }
            }
            ultimo1 = lado1.getFirst();
            ultimo2 = lado2.getFirst();

            ultimoAtacar = ataqueFinal(ultimo1, ultimo2);

//          ELIMINAR QUEM NAO TIVER MAIS ENERGIA
            eliminado(lado1);
            eliminado(lado2);
        }
        Guerreiro.ladoVencedor(lado1, lado2);
        Guerreiro.ultimoMembroPerdedor(ultimo1, ultimo2);
        Guerreiro.ultimoMembroAtaque(ultimoAtacar);

    }

    public void eliminado(List<Guerreiro> fila){
        for (int i = 0; i < fila.size(); i++){
            if (fila.get(i).morreu(fila.get(i))){
                fila.remove(i);
            }else{
                Guerreiro removido = fila.remove(i);
                fila.add(removido);
            }
        }
    }

    public Guerreiro ataqueFinal(Guerreiro lado1, Guerreiro lado2){
        if(lado1.morreu(lado1) && !lado2.morreu(lado2)){
            return lado2;
        } else if (lado2.morreu(lado2) && !lado1.morreu(lado1)) {
            return lado1;
        }else{
            return null;
        }
    }
}

