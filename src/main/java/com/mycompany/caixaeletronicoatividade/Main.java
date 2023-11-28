/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixaeletronicoatividade;
import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem Vindo ao Caixa Eletrônico!!!\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Saque");
            System.out.println("3 - Depósito");
            System.out.println("4 - Transferência\n");
            System.out.print("Digite o número da opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> // Consultar Saldo
                    realizarOperacao(() -> Saldo.OpSaldo());
                case 2 -> // Saque
                    realizarOperacao(() -> new Saque().OpSaque());
                case 3 -> // Depósito
                    realizarOperacao(() -> new Deposito().OpDeposito());
                case 4 -> // Transferência
                    realizarOperacao(() -> new Transferencia().OpTransferencia());
                default -> System.out.println("Opção inválida.");
            }
            // Pergunta se quer continuar
            System.out.print("Deseja continuar? (Y/N): ");
            String resposta = scanner.next();

            if ("N".equalsIgnoreCase(resposta)) {
                continuar = false;
                System.out.println("Obrigado por usar o Caixa Eletrônico.");
            } else if (!"Y".equalsIgnoreCase(resposta)) {
                System.out.println("Opção inválida.");
                continuar = false;
            }
        }
    }
    private static void realizarOperacao(Runnable operacao) {
        operacao.run();
    }
}
