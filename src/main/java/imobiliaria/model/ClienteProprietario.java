package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;

import java.util.ArrayList;
import java.util.List;

public class ClienteProprietario extends Cliente{

    private ArrayList<Imovel> imoveis;

    public ClienteProprietario(){
        super();
    }

    public ClienteProprietario(String cpf, String nome, Endereco endereco, List<String> telefones, String email, String profissao, Sexo sexo, EstadoCivil estadoCivil) {
        super(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
        imoveis = new ArrayList<>();
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    @Override
    public String toString() {
        return "ClienteProprietario{" +
                "Nome= " + this.getNome() +
                '}';
    }
}
