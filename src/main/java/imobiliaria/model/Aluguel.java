package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;
import java.util.List;

public class Aluguel extends RegistroTransacao {

    private List<Pessoa> fiadores;

    private List<Pessoa> indicacoes;

    private LocalDate inicioContrato;

    private LocalDate fimContrato;
    private LocalDate dataAluguel;

    private LocalDate dataAluguel;

    public Aluguel(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario, List<ClienteProprietario> proprietarios, Cliente interessado,
                   Double valorSugerido, List<Pessoa> fiadores, List<Pessoa> indicacoes, LocalDate inicioContrato) {
        super(tipoPagamento, imovel, funcionario, proprietarios, interessado, valorSugerido);
        this.fiadores = fiadores;
        this.indicacoes = indicacoes;
        this.inicioContrato = inicioContrato;
        this.fimContrato = inicioContrato.plusMonths(12);
        this.dataAluguel = fimContrato.plusMonths(1);
    }

    @Override
    public void executar() {
        this.getImovel().setDisponibilidade(false);
        this.getImovel().setFimOferta(LocalDate.now());

        transferirComissaoImobiliaria();
        transferirComissaoFuncionario();
        calcularValorRealTransacao();

        this.getImovel().getImobiliaria().trasacoes.add(this);
    }

    public List<Pessoa> getFiadores() {
        return fiadores;
    }

    public void setFiadores(List<Pessoa> fiadores) {
        this.fiadores = fiadores;
    }

    public List<Pessoa> getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(List<Pessoa> indicacoes) {
        this.indicacoes = indicacoes;
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

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "fiadores=" + fiadores +
                ", indicacoes=" + indicacoes +
                ", inicioContrato=" + inicioContrato +
                ", fimContrato=" + fimContrato +
                ", dataAluguel=" + dataAluguel +
                '}';
    }
}
