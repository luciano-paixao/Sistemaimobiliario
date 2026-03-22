package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;
import java.util.List;

public class Venda extends RegistroTransacao {

    public Venda(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, List<ClienteProprietario> proprietarios, Cliente interessado, Double valorSugerido) {
        super(tipoPagamento, imovel, funcionario, proprietarios, interessado, valorSugerido);
    }

    @Override
    public void executar() {
        ClienteProprietario cp = new ClienteProprietario(getInteressado().getCpf(), getInteressado().getNome(), getInteressado().getEndereco(), getInteressado().getEmail(), getInteressado().getProfissao(), getInteressado().getSexo(), getInteressado().getEstadoCivil());
        cp.adiiconarImovel(this.getImovel());

        for (ClienteProprietario p : getClienteProprietario()) {
            if (p.getImoveis().isEmpty()) {
                Cliente c = new Cliente(p.getCpf(), p.getNome(), p.getEndereco(), p.getEmail(), p.getProfissao(), p.getSexo(), p.getEstadoCivil());
                this.getImovel().getImobiliaria().adicionarCliente(c);
                this.getImovel().getImobiliaria().removerCliente(p);
            }
        }

        this.getImovel().setProprietarios(null);
        this.getImovel().adicionarProprietario(cp);

        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
        calcularValorRealTransacao();

        this.getImovel().getImobiliaria().trasacoes.add(this);
    }

    @Override
    public String toString() {
        return "Venda{} " + super.toString();
    }
}
