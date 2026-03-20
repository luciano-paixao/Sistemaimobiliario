package main.java.imobiliaria.model;

import java.time.LocalDate;
import java.util.List;

public class Funcionario extends Pessoa {

    private LocalDate dataIngresso;

    private String cargo;

    private Double salarioBase;

    private String usuario;

    private String senha;

    private Double comissoes;

    public Funcionario(String cpf, String nome, Endereco endereco, List<String> telefones, LocalDate dataIngresso,
                       String cargo, Double salarioBase, String usuario, String senha) {
        super(cpf, nome, endereco, telefones);
        this.dataIngresso = dataIngresso;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.usuario = usuario;
        this.senha = senha;
        this.comissoes = 0.0;
    }

    public Double calcularSalario() {
        return salarioBase + comissoes;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getComissoes() {
        return comissoes;
    }

    public void setComissoes(Double comissoes) {
        this.comissoes = comissoes;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "dataIngresso=" + dataIngresso +
                ", cargo='" + cargo + '\'' +
                ", salarioBase=" + salarioBase +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
