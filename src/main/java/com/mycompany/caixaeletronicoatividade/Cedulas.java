package com.mycompany.caixaeletronicoatividade;

public class Cedulas {
    private final int valor;
    private int quantidade;

    public Cedulas(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
