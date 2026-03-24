package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda extends RegistroTransacao {

    public Venda(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, List<ClienteProprietario> proprietarios, Cliente interessado) {
        super(tipoPagamento, imovel, funcionario, proprietarios, interessado);
    }

    @Override
    public void executar() {
        ClienteProprietario cp = new ClienteProprietario(getInteressado().getCpf(), getInteressado().getNome(), getInteressado().getEndereco(), getInteressado().getTelefones(), getInteressado().getEmail(), getInteressado().getProfissao(), getInteressado().getSexo(), getInteressado().getEstadoCivil());
        cp.getImoveis().add(this.getImovel());

        for (ClienteProprietario p : getClienteProprietario()) {
            if (p.getImoveis().isEmpty()) {
                Cliente c = new Cliente(p.getCpf(), p.getNome(), p.getEndereco(), p.getTelefones(), p.getEmail(), p.getProfissao(), p.getSexo(), p.getEstadoCivil());
                this.getImovel().getImobiliaria().getClientes().add(c);
                this.getImovel().getImobiliaria().getClientes().remove(p);
            }
        }

        this.getImovel().setProprietarios(new ArrayList<>());
        this.getImovel().adicionarProprietario(cp);

        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
        calcularValorRealTransacao();

        this.getImovel().getImobiliaria().getTrasacoes().add(this);
    }

    @Override
    public String toString() {
        return "\n** DADOS DA TRANSAÇÃO (VENDA) **\n" + super.toString();
    }
}