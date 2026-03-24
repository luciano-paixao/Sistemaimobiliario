package main.java.imobiliaria.model.filtros;

import main.java.imobiliaria.model.Funcionario;


import java.util.function.Predicate;

public class FuncionarioFiltro {

    public static Predicate<Funcionario> porNome(String nome) {
        return f -> f.getNome().toLowerCase().contains(nome.toLowerCase());
    }

    public static Predicate<Funcionario> porCpf(String cpf) {
        return f -> f.getCpf().equals(cpf);
    }

    public static Predicate<Funcionario> porCargo(String cargo) {
        return f -> f.getCargo().equals(cargo);
    }
}