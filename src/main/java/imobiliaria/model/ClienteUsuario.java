package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;

import java.util.List;

public class ClienteUsuario extends Cliente {
    public ClienteUsuario(String cpf, String nome, Endereco endereco, List<String> telefones) {
        super(cpf, nome, endereco, telefones);
    }

    public ClienteUsuario(String cpf, String nome, Endereco endereco, List<String> telefones, String email, String profissao, Sexo sexo, EstadoCivil estadoCivil) {
        super(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
    }
}
