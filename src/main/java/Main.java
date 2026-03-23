package main.java;

import main.java.imobiliaria.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Imobiliaria i = new Imobiliaria();

        List<ClienteProprietario> p = new ArrayList<>();

        Funcionario funcionario = i.cadastrarFuncionario();
        System.out.println(funcionario);

        Cliente usuario = i.cadastarCliente();
        System.out.println(usuario);

        Cliente cliente = i.cadastarCliente();
        ClienteProprietario proprietario = (ClienteProprietario) cliente;
        p.add(proprietario);
        System.out.println(proprietario);

        Imovel imovel1 = i.cadastarImovel(p);
        System.out.println(imovel1);

        imovel1.getProprietarios().add(proprietario);
        proprietario.getImoveis().add(imovel1);

        System.out.println(funcionario.getComissoes());
        System.out.println(proprietario.getImoveis());
        System.out.println(i.getImoveisDisponiveis(i.getImoveis()));

        i.realizarTransacao(usuario, funcionario, imovel1);

        System.out.println(funcionario.getComissoes());
        System.out.println(i.getImoveisDisponiveis(i.getImoveis()));
    }
}