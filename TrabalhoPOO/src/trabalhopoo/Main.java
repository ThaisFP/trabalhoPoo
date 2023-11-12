/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

import trabalhopoo.nagas.guerreiros.Devoradora;
import trabalhopoo.nagas.guerreiros.Empalador;
import trabalhopoo.nagas.guerreiros.Servo;
import trabalhopoo.protons.Protons;
import trabalhopoo.protons.guerreiros.Colosso;
import trabalhopoo.protons.guerreiros.Fanaticus;
import trabalhopoo.protons.guerreiros.Tormento;
import trabalhopoo.protons.guerreiros.Transportadora;
import trabalhopoo.terranos.guerreiros.Ambunave;
import trabalhopoo.terranos.guerreiros.CruzadorDeBatalha;
import trabalhopoo.terranos.guerreiros.Endiabrado;
import trabalhopoo.terranos.guerreiros.Soldado;
import trabalhopoo.zergs.guerreiros.Infestador;
import trabalhopoo.zergs.guerreiros.LordDasCastas;
import trabalhopoo.zergs.guerreiros.TatuBomba;
import trabalhopoo.zergs.guerreiros.Zergnideo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Guerreiro> lado1 = new LinkedList<>();
        LinkedList<Guerreiro> lado2 = new LinkedList<>();

        try {
            Leitura leitura = new Leitura(lado1, lado2);
            System.out.println(lado2);

            leitura.leitura(lado1, lado2);

            System.out.println("\n");
//          SOMA DOS PESOS (CADA FILA)
            double somaPesos1 = Guerreiro.calcularSomadosPesos(lado1);
            System.out.println("Terranos e Protons pesam - " + somaPesos1 + " unidades");
            double somaPesos2 = Guerreiro.calcularSomadosPesos(lado2);
            System.out.println("Zergs e Nagas pesam - " + somaPesos2 + " unidades");

//          MAIS VELHO ENTRE AS DUAS FILAS
            String nomeGurreiroMaisVelho = Guerreiro.maisVelho(lado1, lado2);
            System.out.println(nomeGurreiroMaisVelho + " é o mais velho.");

            Batalha batalha = new Batalha();
            batalha.batalhas(lado1, lado2);

        } catch(EmpateException excecao){
            System.out.println(excecao.getMessage());
        }
    }
}
