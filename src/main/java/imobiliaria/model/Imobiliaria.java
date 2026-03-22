package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.List;
import java.util.Scanner;

public class Imobiliaria {

    private Double totalComissoes;

    private List<Imovel> imoveis;

    private List<Funcionario> funcionarios;

    private List<Cliente> clientes;

    public void adicionarComissao(Double valor) {
        this.totalComissoes += valor;
    }

    public void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    public void removerImovel(Imovel imovel) {
        this.imoveis.remove(imovel);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public Double getTotalcomissoes() {
        return totalComissoes;
    }
}
