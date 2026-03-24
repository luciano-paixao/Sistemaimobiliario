package main.java.imobiliaria.model.filtros;

import main.java.imobiliaria.model.Cliente;

import java.util.function.Predicate;

public class ClienteFiltro {

    public static Predicate<Cliente> porNome(String nome) {
        return c -> c.getNome().toLowerCase().contains(nome.toLowerCase());
    }

    public static Predicate<Cliente> porCpf(String cpf) {
        return c -> c.getCpf().equals(cpf);
    }
}