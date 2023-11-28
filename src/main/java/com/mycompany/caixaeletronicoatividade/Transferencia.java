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

public class Transferencia {
    public void OpTransferencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da sua Conta: ");
        int contaOrigem = scanner.nextInt();
        System.out.print("Digite a sua Senha: ");
        String senha = scanner.next();

        UsuariosLista usuariosLista = new UsuariosLista();
        Usuarios usuarioOrigem = usuariosLista.validarCredenciais(contaOrigem, senha);

        if (usuarioOrigem != null) {
            System.out.println("Usuário válido. Saldo: " + usuarioOrigem.getSaldo() + " R$");

            // Solicitar conta e agência de destino
            System.out.print("Digite o número da Conta de Destino: ");
            int contaDestino = scanner.nextInt();
            System.out.print("Digite o número da Agência de Destino: ");
            int agenciaDestino = scanner.nextInt();

            // Verificar se a conta de destino existe
            Usuarios usuarioDestino = usuariosLista.validarContaAgencia(contaDestino, agenciaDestino);

            if (usuarioDestino != null) {
                // Realizar transferência
                System.out.print("Digite o valor da transferência: ");
                float valorTransferencia = scanner.nextFloat();

                if (valorTransferencia > 0 && valorTransferencia <= usuarioOrigem.getSaldo()) {
                    usuarioOrigem.sacar(valorTransferencia);
                    usuarioDestino.depositar(valorTransferencia);

                    System.out.println("Transferência de " + valorTransferencia + " R$ realizada com sucesso.");
                    System.out.println("Novo saldo na conta de origem: " + usuarioOrigem.getSaldo() + " R$");
                } else {
                    System.out.println("Valor inválido para transferência ou saldo insuficiente.");
                }
            } else {
                System.out.println("Conta ou Agência de Destino não encontrada. Transferência não realizada.");
            }
        } else {
            System.out.println("Credenciais inválidas. Não há conta no banco.");
        }
    }
}

