package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;

public class Venda extends RegistroTransacao {

    public Venda(ClienteProprietario clienteProprietario, LocalDate dataTransacao,
                 String formaPagamento, Funcionario funcionario, Imovel imovel,
                 double margemImobiliaria, Double valorReal, Double valorSugerido) {
        super(clienteProprietario, dataTransacao, formaPagamento, funcionario, imovel, margemImobiliaria, valorReal, valorSugerido);
    }

    @Override
    public String toString() {
        return "Venda{ " + super.toString() + "} " ;
    }
}
