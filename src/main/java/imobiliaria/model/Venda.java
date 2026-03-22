package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;

public class Venda extends RegistroTransacao {

    public Venda(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, ClienteProprietario proprietario, Cliente comprador, Double valorReal, Double valorSugerido) {
        super(tipoPagamento, imovel, funcionario, proprietario, comprador, valorReal, valorSugerido);
    }

    @Override
    public void executar() {
        ClienteProprietario cp = new ClienteProprietario(getCliente().getCpf(), getCliente().getNome(), getCliente().getEndereco(),
                getCliente().getEmail(), getCliente().getProfissao(), getCliente().getSexo(), getCliente().getEstadoCivil());
        cp.adiiconarImovel(this.getImovel());
        this.getImovel().adicionarProprietario(cp);
        this.getImovel().removerProprietario(this.getClienteProprietario());

        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
    }

    @Override
    public String toString() {
        return "Venda{} " + super.toString();
    }
}
