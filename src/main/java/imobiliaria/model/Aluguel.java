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
                   double margemImobiliaria, Integer numContrato, ClienteUsuario usuario,
                   Double valorReal, Double valorSugerido, List<Pessoa> fiadores,
                   LocalDate fimContrato, List<Pessoa> indicadores, LocalDate inicioContrato) {
        super(clienteProprietario, dataTransacao, formaPagamento, funcionario, imovel,
                margemImobiliaria, numContrato, usuario, valorReal, valorSugerido);
        this.fiadores = fiadores;
        this.fimContrato = fimContrato;
        this.indicadores = indicadores;
        this.inicioContrato = inicioContrato;
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
}
