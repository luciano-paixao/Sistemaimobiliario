package main.java.imobiliaria.model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel extends RegistroTransacao {

    private List<Pessoa> fiadores;
    private List<Pessoa> indicadores;
    private LocalDate inicioContrato;
    private LocalDate fimContrato;

    public Aluguel(ClienteProprietario clienteProprietario, LocalDate dataTransacao,
                   String formaPagamento, Funcionario funcionario, Imovel imovel,
                   double margemImobiliaria, ClienteUsuario usuario, Double valorSugerido,
                   List<Pessoa> fiadores, List<Pessoa> indicadores, LocalDate inicioContrato,
                   LocalDate fimContrato) {
        super(clienteProprietario, dataTransacao, formaPagamento, funcionario, imovel, margemImobiliaria, usuario, valorSugerido);
        this.fiadores = fiadores;
        this.indicadores = indicadores;
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
    }

    public List<Pessoa> getFiadores() {
        return fiadores;
    }

    public void setFiadores(List<Pessoa> fiadores) {
        this.fiadores = fiadores;
    }

    public List<Pessoa> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Pessoa> indicadores) {
        this.indicadores = indicadores;
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

    @Override
    public String toString() {
        return "Aluguel{" +
                "fiadores=" + fiadores +
                ", indicadores=" + indicadores +
                ", inicioContrato=" + inicioContrato +
                ", fimContrato=" + fimContrato +
                ", usuario=" + usuario +
                ", clienteProprietario=" + clienteProprietario +
                ", valorAux=" + valorAux +
                "} " + super.toString();
    }
}
