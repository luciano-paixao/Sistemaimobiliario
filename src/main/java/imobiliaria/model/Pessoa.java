package main.java.imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String cpf;

    private String nome;

    private Endereco endereco;

    private List<String> telefones;

    public Pessoa(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = new ArrayList<String>();
    }

    public Pessoa(String cpf, String nome, Endereco endereco, List<String> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", telefones=" + telefones +
                '}';
    }
}
