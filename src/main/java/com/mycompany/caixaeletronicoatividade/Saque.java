package com.mycompany.caixaeletronicoatividade;
import java.util.ArrayList;
import java.util.Scanner;

public class Saque {
    private ArrayList<Cedulas> cedulasDisponiveis;

    public void OpSaque() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da sua Conta: ");
        int conta = scanner.nextInt();
        System.out.print("Digite a sua Senha: ");
        String password = scanner.next();

        UsuariosLista usuariosLista = new UsuariosLista();
        Usuarios usuario = usuariosLista.validarCredenciais(conta, password);

        if (usuario != null) {
            System.out.println("Saldo: " + usuario.getSaldo() + " R$");
            System.out.print("Digite o valor do saque: ");
            float valorSaque = scanner.nextFloat();

            if (valorSaque > 0 && valorSaque <= usuario.getSaldo()) {
                if (realizarSaque(valorSaque, usuario)) {
                    System.out.println("Saque de " + valorSaque + " R$ realizado com sucesso.");
                    usuario.sacar(valorSaque);
                    System.out.println("Novo saldo: " + usuario.getSaldo() + " R$");
                } else {
                    System.out.println("Cédulas indisponíveis para o valor solicitado. Dirija-se ao caixa ao lado.");
                }
            } else {
                System.out.println("Valor inválido para saque ou saldo insuficiente.");
            }
        } else {
            System.out.println("Credenciais inválidas. Não há conta no banco.");
        }
    }
        private boolean realizarSaque(float valor, Usuarios usuario) {
        cedulasDisponiveis = new ArrayList<>();
        cedulasDisponiveis.add(new Cedulas(100, 50));
        cedulasDisponiveis.add(new Cedulas(50, 50));
        cedulasDisponiveis.add(new Cedulas(20, 50));
        cedulasDisponiveis.add(new Cedulas(10, 50));

        for (Cedulas cedula : cedulasDisponiveis) {
            int quantidadeNecessaria = (int) (valor / cedula.getValor());
            int quantidadeDisponivel = cedula.getQuantidade();

            if (quantidadeNecessaria > 0 && quantidadeNecessaria <= quantidadeDisponivel) {
                System.out.println("Cédulas de " + cedula.getValor() + " R$: " + quantidadeNecessaria);
                valor -= quantidadeNecessaria * cedula.getValor();
                cedula.setQuantidade(quantidadeDisponivel - quantidadeNecessaria);
            } else if (quantidadeDisponivel > 0) {
                // Utilizar o máximo possível da cédula disponível
                int quantidadeUsada = Math.min(quantidadeDisponivel, quantidadeNecessaria);
                System.out.println("Cédulas de " + cedula.getValor() + " R$: " + quantidadeUsada);
                valor -= quantidadeUsada * cedula.getValor();
                cedula.setQuantidade(quantidadeDisponivel - quantidadeUsada);
            }
        }

        if (valor == 0) {
            usuario.getSaldo();
            return true; // Saque bem-sucedido
        } else {
            return false; // Cédulas indisponíveis para o valor solicitado
        }
    }

}
