package com.example;

public class Equino extends Animal {
    private static int nextId = 1;
    private int id;

    public Equino(){
        this.id = nextId++;
    }

    public Equino(float altura, float comprimento, float largura, float peso) {
        super(altura, comprimento, largura, peso);
        this.id = nextId++;
    }
    
    public int getId() {
        return this.id;
    }
}
