package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public class SalaComercial extends Imovel {

    private Double area;

    private Integer quantidadeBanheiros;

    private Integer quantidadeComodos;

    public SalaComercial(LocalDate dataConstrucao, Boolean disponibilidade, Endereco endereco,
                         List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade, Double valorSugerido,
                         Double area, Integer quantidadeBanheiros, Integer quantidadeComodos, LocalDate incioOferta, LocalDate fimOferta,
                         Imobiliaria imo) {
        super(dataConstrucao, endereco, proprietarios, tipoDisponibilidade, incioOferta, fimOferta, imo, valorSugerido);
        this.area = area;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeComodos = quantidadeComodos;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Integer quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public Integer getQuantidadeComodos() {
        return quantidadeComodos;
    }

    public void setQuantidadeComodos(Integer quantidadeComodos) {
        this.quantidadeComodos = quantidadeComodos;
    }
}
