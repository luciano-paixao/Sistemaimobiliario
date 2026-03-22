package main.java.imobiliaria.model;

import java.time.LocalDate;
import java.util.List;

public class Funcionario extends Pessoa {

    private LocalDate dataIngresso;

    private String cargo;

    private Double salarioBase;

    private String usuario;

    private String senha;

    private Double totalComissoes;

    public Funcionario(String cpf, String nome, Endereco endereco, String cargo, Double salarioBase, String usuario, String senha) {
        super(cpf, nome, endereco);
        this.dataIngresso = LocalDate.now();;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.usuario = usuario;
        this.senha = senha;
        this.totalComissoes = 0.0;
    }

    public Funcionario(String cpf, String nome, Endereco endereco, List<String> telefones, LocalDate dataIngresso, String cargo, Double salarioBase, String usuario, String senha) {
        super(cpf, nome, endereco, telefones);
        this.dataIngresso = dataIngresso;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.usuario = usuario;
        this.senha = senha;
        this.totalComissoes = 0.0;
    }

    public Boolean login(String usuario, String senha){
        if (usuario.equals(this.usuario) && senha.equals(this.senha)){
            return true;
        }else {
            return false;
        }
    }

    public Double calcularSalario() {
        return salarioBase + totalComissoes;
    }

    public void adicionarComissao(Double valor) {
        this.totalComissoes += valor;
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
        return totalComissoes;
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
