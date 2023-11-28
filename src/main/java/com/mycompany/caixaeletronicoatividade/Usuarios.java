package com.mycompany.caixaeletronicoatividade;

public class Usuarios {    
    private final String nome;
    private final int conta;
    private final String senha;
    private final int agencia;
    private float saldo;

    public Usuarios(String nome, int conta, String senha, int agencia, float saldo) {
        this.nome = nome;
        this.conta = conta;
        this.senha = senha;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getConta() {
        return conta;
    }

    public String getSenha() {
        return senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void sacar(float valor) {
        this.saldo -= valor;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    @Override
    public String toString() {
        return nome + "\t" + conta + "\t" + senha + "\t" + agencia + "\t" + saldo + " R$";
    }

    public int getAgencia() {
        return agencia;
    }
}
