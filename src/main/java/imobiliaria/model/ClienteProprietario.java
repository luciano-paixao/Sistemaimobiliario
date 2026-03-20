package main.java.imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

public class ClienteProprietario extends Cliente{

    private ArrayList<Imovel> imoveis = new ArrayList<>();

    public ClienteProprietario(String cpf, String nome, Endereco endereco, List<String> telefones) {
        super(cpf, nome, endereco, telefones);
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }
}
