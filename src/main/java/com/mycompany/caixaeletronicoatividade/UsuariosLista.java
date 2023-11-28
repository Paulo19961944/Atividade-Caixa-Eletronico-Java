package com.mycompany.caixaeletronicoatividade;
import java.util.ArrayList;

public class UsuariosLista {
    private final ArrayList<Usuarios> dadosUsuarios;

    public UsuariosLista() {
        dadosUsuarios = new ArrayList<>();
        dadosUsuarios.add(new Usuarios("Paulo", 1, "Hir@m@", 1, 25000.00f));
        dadosUsuarios.add(new Usuarios("Maria", 2, "PQ&&$$", 2, 20000.00f));
        dadosUsuarios.add(new Usuarios("Danrley", 3, "ML**&@", 3, 22000.00f));
        dadosUsuarios.add(new Usuarios("Darcio", 4, "MY&&**", 4, 25000.00f));
        dadosUsuarios.add(new Usuarios("Douglas", 5, "NF&&%%", 5, 20000.00f));
        dadosUsuarios.add(new Usuarios("Arthur", 6, "LP%&&!", 6, 16000.00f));
        dadosUsuarios.add(new Usuarios("Daniel", 7, "KIL##$", 7, 18000.00f));
        dadosUsuarios.add(new Usuarios("Augusto", 8, "JI**&$", 8, 12000.00f));
        dadosUsuarios.add(new Usuarios("Flávio", 9, "HI*&*%", 9, 28000.00f));
    }

    public Usuarios validarCredenciais(int conta, String senha) {
        for (Usuarios usuario : dadosUsuarios) {
            if (usuario.getConta() == conta && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuarios validarContaAgencia(int conta, int agencia) {
        for (Usuarios usuario : dadosUsuarios) {
            if (usuario.getConta() == conta && usuario.getAgencia() == agencia) {
                return usuario;
            }
        }
        return null;
    }
}
