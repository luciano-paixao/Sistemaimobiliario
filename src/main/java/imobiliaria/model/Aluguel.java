package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;
import java.util.List;

public class Aluguel extends RegistroTransacao {

    private List<Pessoa> fiadores;

    private List<Pessoa> indicacoes;

    private LocalDate inicioContrato;

    private LocalDate fimContrato;

    public Aluguel(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, ClienteProprietario proprietario, Cliente comprador,
                   Double valorReal, Double valorSugerido, List<Pessoa> fiadores, List<Pessoa> indicacoes, LocalDate inicioContrato, LocalDate fimContrato) {
        super(tipoPagamento, imovel, funcionario, proprietario, comprador, valorReal, valorSugerido);
        this.fiadores = fiadores;
        this.indicacoes = indicacoes;
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
    }

    @Override
    public void executar() {
//        ClienteProprietario cp = new ClienteProprietario(getCliente().getCpf(), getCliente().getNome(), getCliente().getEndereco(),
//                getCliente().getEmail(), getCliente().getProfissao(), getCliente().getSexo(), getCliente().getEstadoCivil());
//        cp.adiiconarImovel(this.getImovel());
//        this.getImovel().adicionarProprietario(cp);
//        this.getImovel().removerProprietario(this.getClienteProprietario());

        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
    }

    public List<Pessoa> getFiadores() {
        return fiadores;
    }

    public void setFiadores(List<Pessoa> fiadores) {
        this.fiadores = fiadores;
    }

    public List<Pessoa> getIndicadores() {
        return indicacoes;
    }

    public void setIndicadores(List<Pessoa> indicadores) {
        this.indicacoes = indicadores;
    }

    public LocalDate getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(LocalDate fimContrato) {
        this.fimContrato = fimContrato;
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(LocalDate inicioContrato) {
        this.inicioContrato = inicioContrato;
    }
}
