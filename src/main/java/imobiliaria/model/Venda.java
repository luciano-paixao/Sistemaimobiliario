package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;

public class Venda extends RegistroTransacao {

    public Venda(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, ClienteProprietario proprietario, Cliente interessado, Double valorSugerido) {
        super(tipoPagamento, imovel, funcionario, proprietario, interessado, valorSugerido);
    }

    @Override
    public void executar() {
        ClienteProprietario cp = new ClienteProprietario(getInteressado().getCpf(), getInteressado().getNome(), getInteressado().getEndereco(), getInteressado().getEmail(), getInteressado().getProfissao(), getInteressado().getSexo(), getInteressado().getEstadoCivil());
        cp.adiiconarImovel(this.getImovel());
        this.getImovel().adicionarProprietario(cp);
        this.getImovel().removerProprietario(this.getClienteProprietario());

        if (this.getClienteProprietario().getImoveis().isEmpty()) {
            Cliente c = new Cliente(getClienteProprietario().getCpf(), getClienteProprietario().getNome(), getClienteProprietario().getEndereco(), getClienteProprietario().getEmail(), getClienteProprietario().getProfissao(), getClienteProprietario().getSexo(), getClienteProprietario().getEstadoCivil());
            this.getImovel().getImobiliaria().adicionarCliente(c);
            this.getImovel().getImobiliaria().removerCliente(getClienteProprietario());
        }

        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
        calcularValorRealTransacao();
    }

    @Override
    public String toString() {
        return "Venda{} " + super.toString();
    }
}
