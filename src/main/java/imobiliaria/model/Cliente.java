package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;

import java.util.List;

public class Cliente extends Pessoa {

    private String email;
    private String profissao;
    private Sexo sexo;
    private EstadoCivil estadoCivil;

    public Cliente(){
        super();
    }

    public Cliente(String cpf, String nome, Endereco endereco, List<String> telefones, String email, String profissao, Sexo sexo, EstadoCivil estadoCivil) {
        super(cpf, nome, endereco, telefones);
        this.email = email;
        this.profissao = profissao;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", profissao='" + profissao + '\'' +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                '}';
    }
}
