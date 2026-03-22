package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;

public class Venda extends RegistroTransacao {

    public Venda(ClienteProprietario clienteProprietario, LocalDate dataTransacao, String formaPagamento, Funcionario funcionario, Imovel imovel, double margemImobiliaria, Integer numContrato, Double valorReal, Double valorSugerido) {
        super(clienteProprietario, dataTransacao, formaPagamento, funcionario, imovel, margemImobiliaria, numContrato, valorReal, valorSugerido);
    }

    @Override
    public String toString() {
        return "Venda{} " + super.toString();
    }
}
