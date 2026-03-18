package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public abstract class Imovel {

    private TipoDisponibilidade tipoDisponibilidade;
    private Boolean disponbilidade;
    private LocalDate DataConstrucao;
    private Double valorSugerido;
    private Double valorReal;
   // private Cliente Proprietario
    private LocalDate inicioOferta;
    private LocalDate finalOfetar;
    //private List<Pessoa> fiadores;
    //private List<Pessoa> indicaores;
    //private Endereco endereco;

}
