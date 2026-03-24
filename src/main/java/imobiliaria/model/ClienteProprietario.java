package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;

import java.util.ArrayList;
import java.util.List;

public class ClienteProprietario extends Cliente {

    private ArrayList<Imovel> imoveis;

    public ClienteProprietario(String cpf, String nome, Endereco endereco, List<String> telefones, String email, String profissao, Sexo sexo, EstadoCivil estadoCivil) {
        super(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
        this.imoveis = new ArrayList<>();
    }

    public ClienteProprietario(String cpf, String nome, Endereco endereco, List<String> telefones, String email, String profissao, Sexo sexo, EstadoCivil estadoCivil, ArrayList<Imovel> imoveis) {
        super(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
        this.imoveis = imoveis;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    @Override
    public String toString() {
        return "ClienteProprietario{" +
                "imoveis=" + imoveis +
                super.toString() + '}';
    }
}
