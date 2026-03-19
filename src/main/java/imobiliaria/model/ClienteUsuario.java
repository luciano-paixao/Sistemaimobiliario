package main.java.imobiliaria.model;

import java.util.List;

public class ClienteUsuario extends Cliente {
    public ClienteUsuario(String cpf, String nome, Endereco endereco, List<String> telefones) {
        super(cpf, nome, endereco, telefones);
    }
}
