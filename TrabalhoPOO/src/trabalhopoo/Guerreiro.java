package trabalhopoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Guerreiro extends Natureza{
    private String nome;
    private int idade;
    private double peso;
    private int energia;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public int getEnergia(){
        return energia;
    }

    public int setEnergia(int energia) {
        this.energia = energia;
        return energia;
    }

    public abstract void atacar(LinkedList<Guerreiro> aliado, LinkedList<Guerreiro> inimigo);

    public static double calcularSomadosPesos (List<Guerreiro> lista){
        double somaPesos = 0;

        for (Guerreiro guerreiro : lista){
            somaPesos += guerreiro.peso;
        }

        return somaPesos;
    }

    public static String maisVelho (List<Guerreiro> lado1, List<Guerreiro> lado2){
        int idadeMaisVelho = 0;
        String nomeGuerreiro = null;

        for (Guerreiro guerreiro : lado1){
            if(guerreiro.idade > idadeMaisVelho){
                idadeMaisVelho = guerreiro.idade;
                nomeGuerreiro = guerreiro.nome;
            }
        }
        for (Guerreiro guerreiro : lado2){
            if(guerreiro.idade > idadeMaisVelho){
                idadeMaisVelho = guerreiro.idade;
                nomeGuerreiro = guerreiro.nome;
            }
        }
        return nomeGuerreiro;
    }

    public static void ladoVencedor(List<Guerreiro> lado1, List<Guerreiro> lado2) throws EmpateException{
        if(lado1.isEmpty() && !lado2.isEmpty()){
            System.out.println("Zergs e Nagas Venceram!");
        }else if(lado2.isEmpty() && !lado1.isEmpty()){
            System.out.println("Protons e Terranos venceram!");
        } else {
            throw new EmpateException("Empate");
        }
    }

    public static void ultimoMembroPerdedor(Guerreiro lado1, Guerreiro lado2){
        Guerreiro ultimoPerdedor = null;

        if (lado1 != null && lado2.morreu(lado2)) {
            ultimoPerdedor = lado2;
        }
        if (lado2 != null && lado1.morreu(lado1)) {
            ultimoPerdedor = lado1;
        }

        if (ultimoPerdedor != null) {
            imprimirInfo(ultimoPerdedor);
        }
    }

    public static void ultimoMembroAtaque(Guerreiro ultimoAtacante){
        imprimirInfo(ultimoAtacante);
    }

    public boolean morreu(Guerreiro guerreiro){
        if(guerreiro.getEnergia() <= 0) {
            return true;
        }
        return false;
    }

    public static void imprimirInfo(Guerreiro dadosGuerreiro){
        System.out.println(dadosGuerreiro.getNome() + ", " + dadosGuerreiro.getIdade() + ", " + dadosGuerreiro.getPeso());
    }

}

