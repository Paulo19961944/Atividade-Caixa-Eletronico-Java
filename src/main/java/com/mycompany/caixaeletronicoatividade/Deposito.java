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

public class Deposito {
    public void OpDeposito() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da sua Conta: ");
        int contaOrigem = scanner.nextInt();
        System.out.print("Digite a sua Senha: ");
        String senha = scanner.next();

        UsuariosLista usuariosLista = new UsuariosLista();
        Usuarios usuarioOrigem = usuariosLista.validarCredenciais(contaOrigem, senha);

        if (usuarioOrigem != null) {
            System.out.println("Usuário válido. Saldo: " + usuarioOrigem.getSaldo() + " R$");

            // Seleciona conta e agência de destino
            System.out.print("Digite o número da Conta de Destino: ");
            int contaDestino = scanner.nextInt();
            System.out.print("Digite o número da Agência de Destino: ");
            int agenciaDestino = scanner.nextInt();

            // Verifica se a conta de destino existe
            Usuarios usuarioDestino = usuariosLista.validarContaAgencia(contaDestino, agenciaDestino);

            if (usuarioDestino != null) {
                // Realiza depósito
                System.out.print("Digite o valor do depósito: ");
                float valorDeposito = scanner.nextFloat();

                if (valorDeposito > 0) {
                    usuarioDestino.depositar(valorDeposito);
                    System.out.println("Depósito de " + valorDeposito + " R$ realizado com sucesso na conta de destino.");
                } else {
                    System.out.println("Valor inválido para depósito.");
                }
            } else {
                System.out.println("Conta ou Agência de Destino não encontrada. Depósito não realizado.");
            }
        } else {
            System.out.println("Credenciais inválidas. Não há conta no banco.");
        }
    }
}
