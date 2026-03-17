package model;

import java.io.*;
import model.Arquivo;

public class Pessoa {
    private String nome;
    private int idade;

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public String toString(){
        return this.nome + "\t" + this.idade;
    }

    public static Pessoa[] carregar() throws IOException {
        Arquivo arquivo = new Arquivo("data/pessoas.csv");
        String[] linhas = arquivo.linhas();
        Pessoa[] pessoas = new Pessoa[linhas.length];

        for(int i = 0; i < linhas.length; i++) {
            String[] valores = linhas[i].split(";");
            pessoas[i] = new Pessoa();
            pessoas[i].setNome(valores[0]);
            pessoas[i].setIdade(Integer.parseInt(valores[1]));
        }

        return pessoas;
    }
}