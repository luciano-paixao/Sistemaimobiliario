package main.java.imobiliaria.model;

import java.util.List;

public class Aluguel extends RegistroTransacao {

    List<Pessoa> fiadores;
    List<Pessoa> indicadores;

    public Aluguel(List<Pessoa> fiadores, List<Pessoa> indicadores) {
        this.fiadores = fiadores;
        this.indicadores = indicadores;
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
