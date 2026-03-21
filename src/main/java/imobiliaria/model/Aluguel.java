package main.java.imobiliaria.model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel extends RegistroTransacao {

    private List<Pessoa> fiadores;
    private List<Pessoa> indicadores;
    private LocalDate inicioContrato;
    private LocalDate fimContrato;

    public Aluguel(List<Pessoa> fiadores, List<Pessoa> indicadores, LocalDate fimContrato) {
        this.fiadores = fiadores;
        this.indicadores = indicadores;
        this.inicioContrato = LocalDate.now();
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
}
