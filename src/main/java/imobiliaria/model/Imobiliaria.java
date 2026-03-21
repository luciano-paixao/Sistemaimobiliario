package main.java.imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {

    private Double comissoes;

    private List<Imovel> imoveis = new ArrayList<>();

    private List<Funcionario> funcionarios = new ArrayList<>();

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarComissao(Double valor) {
        this.comissoes += valor;
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

    public Double getComissoes() {
        return comissoes;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
