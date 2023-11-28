package com.mycompany.caixaeletronicoatividade;
import java.util.Scanner;

public class Saldo {
    public static void OpSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da sua Conta: ");
        int conta = scanner.nextInt();
        System.out.print("Digite a sua Senha: ");
        String password = scanner.next();

        UsuariosLista usuariosLista = new UsuariosLista();

        Usuarios usuarioValido = usuariosLista.validarCredenciais(conta, password);

        if (usuarioValido != null) {
            System.out.println("Saldo: " + usuarioValido.getSaldo() + " R$");
        } else {
            System.out.println("Credenciais inválidas. Não há conta no banco.");
        }
    }
}
