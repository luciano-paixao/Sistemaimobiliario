package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

public class Venda extends RegistroTransacao {

    public Venda(int numeroContrato, Imovel imovel, ClienteUsuario cliente,
                 Funcionario funcionario, Double valorReal, TipoPagamento tipoPagamento) {

        super(numeroContrato, imovel, cliente, funcionario, valorReal);
    }
}
