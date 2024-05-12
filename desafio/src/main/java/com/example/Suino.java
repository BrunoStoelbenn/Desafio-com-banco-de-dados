package com.example;

public class Suino extends Animal{
    private static int nextId = 1;
    private int id;

    public Suino(){
        this.id = nextId++;
    }

    public Suino(float altura, float comprimento, float largura, float peso) {
        super(altura, comprimento, largura, peso);
        this.id = nextId++;
    }

    public int getId() {
        return this.id;
    }
}