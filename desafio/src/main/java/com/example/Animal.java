package com.example;

import java.util.Scanner;

public class Animal {
    Scanner input = new Scanner(System.in);
    // protected static int nextId = 1;
    // protected int id;
    protected float altura;
    protected float comprimento;
    protected float largura;
    protected float peso;
    protected String status;
    protected float precoVenda;

    public Animal() {
        // this.id = nextId++;
    }

    public Animal(float altura, float comprimento, float largura, float peso) {
        while (altura <= 0) {
            System.out.println("A altura não pode ser menor ou igual a 0. Por favor, digite uma altura válida: ");
            altura = input.nextFloat();
        }
        this.altura = altura;
        while (comprimento <= 0) {
            System.out.println("O comprimento não pode ser menor ou igual a 0. Por favor, digite um comprimento válido: ");
            comprimento = input.nextFloat();
        }
        this.comprimento = comprimento;
        while (largura <= 0) {
            System.out.println("A largura não pode ser menor ou igual a 0. Por favor, digite uma largura válida: ");
            largura = input.nextFloat();
        }
        this.largura = largura;
        while (peso <= 0) {
            System.out.println("O peso não pode ser menor ou igual a 0. Por favor, digite um peso válido: ");
            peso = input.nextFloat();
        }
        this.peso = peso;
        this.status = "Ativo";
        // this.id = nextId++;
    }

    // public int getId() {
    //     return this.id;
    // }

    public float getAltura(){
        return this.altura;
    }

    public float getComprimento(){
        return this.comprimento;
    }

    public float getLargura(){
        return this.largura;
    }

    public float getPeso(){
        return this.peso;
    }

    public String getStatus(){
        return this.status;
    }

    public float getPrecoVenda(){
        return this.precoVenda;
    }



    public void setAltura(float altura){
        if (altura > 0) {
            this.altura = altura;
        }
        
    }

    public void setComprimento(float comprimento){
        if (comprimento > 0) {
            this.comprimento = comprimento;
        }
        
    }

    public void setLargura(float largura){
        if (largura > 0) {
            this.largura = largura;
        }
        
    }

    public void setPeso(float peso){
        if (peso > 0) {
            this.peso = peso;
        }
        
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPrecoVenda(float precoVenda){
        this.precoVenda = precoVenda;
    }

    // Método para avaliar o animal
    public void avaliar(float novaAltura, float novoComprimento, float novaLargura, float novoPeso) {
        if (novaAltura >= this.altura && novoComprimento >= this.comprimento && novaLargura >= this.largura && novoPeso >= this.peso) {
            this.altura = novaAltura;
            this.comprimento = novoComprimento;
            this.largura = novaLargura;
            this.peso = novoPeso;
        } else {
            System.out.println("Alerta: As novas medidas não podem ser menores que as anteriores. O animal precisa ser examinado por um veterinário.");
        }
    }
}
