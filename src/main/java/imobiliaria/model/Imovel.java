package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public abstract class Imovel {

    private TipoDisponibilidade tipoDisponibilidade;

    private Boolean disponbilidade;

    private LocalDate dataConstrucao;

    private List<ClienteProprietario> proprietarios;

    private Endereco endereco;

    private LocalDate inicioOferta;

    private LocalDate finalOferta;

    public Imovel(TipoDisponibilidade tipoDisponibilidade, LocalDate dataConstrucao, List<ClienteProprietario> proprietarios, Endereco endereco) {
        this.tipoDisponibilidade = tipoDisponibilidade;
        this.disponbilidade = true;
        this.dataConstrucao = dataConstrucao;
        this.proprietarios = proprietarios;
        this.endereco = endereco;
        this.inicioOferta = LocalDate.now();
    }
}
