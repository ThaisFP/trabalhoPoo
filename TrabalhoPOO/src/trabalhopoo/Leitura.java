package trabalhopoo;

import trabalhopoo.nagas.guerreiros.Devoradora;
import trabalhopoo.nagas.guerreiros.Empalador;
import trabalhopoo.nagas.guerreiros.Servo;
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
import java.util.LinkedList;
import java.util.Scanner;

public class Leitura {
    public Leitura(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
    }

    public void leitura(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) {
        try {
            // captura de arquivo LADO1
            FileInputStream file = new FileInputStream("lado1.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                int tipo = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextInt();

                switch (tipo) {
                    case 1 -> lado1.add(new Soldado(nome, idade, peso));
                    case 2 -> lado1.add(new Endiabrado(nome, idade, peso));
                    case 3 -> lado1.add(new Ambunave(nome, idade, peso));
                    case 4 -> lado1.add(new CruzadorDeBatalha(nome, idade, peso));
                    case 5 -> lado1.add(new Fanaticus(nome, idade, peso));
                    case 6 -> lado1.add(new Tormento(nome, idade, peso));
                    case 7 -> lado1.add(new Colosso(nome, idade, peso));
                    case 8 -> lado1.add(new Transportadora(nome, idade, peso));
                    default -> {
                    }
                }
            }

            // captura de arquivo LADO2
            FileInputStream file2 = new FileInputStream("lado2.txt");
            Scanner scan2 = new Scanner(file2);

            while (scan2.hasNext()) {
                int tipo = scan2.nextInt();
                String nome = scan2.next();
                int idade = scan2.nextInt();
                double peso = scan2.nextInt();

                switch (tipo) {
                    case 1 -> lado2.add(new Zergnideo(nome, idade, peso));
                    case 2 -> lado2.add(new TatuBomba(nome, idade, peso));
                    case 3 -> lado2.add(new Infestador(nome, idade, peso));
                    case 4 -> lado2.add(new LordDasCastas(nome, idade, peso));
                    case 5 -> lado2.add(new Servo(nome, idade, peso));
                    case 6 -> lado2.add(new Devoradora(nome, idade, peso));
                    case 7 -> lado2.add(new Empalador(nome, idade, peso));
                    default -> {
                    }
                }
            }

            scan.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado!");
        }
    }
}
