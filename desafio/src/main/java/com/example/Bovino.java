package com.example;

public class Bovino extends Animal{
    private static int nextId = 1;
    private int id;

    public Bovino(){
        this.id = nextId++;
    }

    public Bovino(float altura, float comprimento, float largura, float peso) {
        super(altura, comprimento, largura, peso);
        this.id = nextId++;
    }

    public int getId() {
        return this.id;
    }
}
