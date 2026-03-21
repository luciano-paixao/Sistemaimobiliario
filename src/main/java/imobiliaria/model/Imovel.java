package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public abstract class Imovel {

    private TipoDisponibilidade tipoDisponibilidade;
    private Boolean disponibilidade;
    private LocalDate dataConstrucao;
    private List<ClienteProprietario> proprietarios;
    private LocalDate inicioOferta;
    private static LocalDate finalOferta;
    private Endereco endereco;

    public Imovel(TipoDisponibilidade tipoDisponibilidade,
                  LocalDate dataConstrucao,
                  Endereco endereco,
                  List<ClienteProprietario> proprietarios,
                  LocalDate inicioOferta,
                  LocalDate finalOferta) {

        this.tipoDisponibilidade = tipoDisponibilidade;
        this.disponibilidade = true;


        if (dataConstrucao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de construção inválida.");
        }
        this.dataConstrucao = dataConstrucao;

        this.endereco = endereco;
        this.proprietarios = proprietarios;


        if (inicioOferta.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de início da oferta inválida.");
        }
        this.inicioOferta = inicioOferta;


        if (finalOferta.isBefore(inicioOferta)) {
            throw new IllegalArgumentException("Data final da oferta não pode ser antes do início.");
        }
        this.finalOferta = finalOferta;
    }
}
