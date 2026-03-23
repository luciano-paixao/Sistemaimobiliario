package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Casa extends Imovel {

    private Integer quantidadeQuartos;

    private Integer quantidadeSuites;

    private Integer quantidadeSalasEstar;

    private Integer quantidadeSalasJantar;

    private Integer quantidadeVagasGaragem;

    private Double area;

    private Boolean armarioEmbutido;

    private String descricao;

    public Casa(LocalDate dataConstrucao,
                Endereco endereco,
                List<ClienteProprietario> proprietarios,
                TipoDisponibilidade tipoDisponibilidade,
                Imobiliaria imobiliaria,
                Integer quantidadeQuartos,
                Integer quantidadeSuites,
                Integer quantidadeSalasEstar,
                Integer quantidadeSalasJantar,
                Integer quantidadeVagasGaragem,
                Double area,
                Boolean armarioEmbutido) {

        super(dataConstrucao, endereco, proprietarios, tipoDisponibilidade, imobiliaria);

        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeSalasEstar = quantidadeSalasEstar;
        this.quantidadeSalasJantar = quantidadeSalasJantar;
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
    }

    public Casa(LocalDate dataConstrucao,
                Endereco endereco,
                List<ClienteProprietario> proprietarios,
                TipoDisponibilidade tipoDisponibilidade,
                Imobiliaria imobiliaria,
                Double valorSugerido,
                Integer quantidadeQuartos,
                Integer quantidadeSuites,
                Integer quantidadeSalasEstar,
                Integer quantidadeSalasJantar,
                Integer quantidadeVagasGaragem,
                Double area,
                Boolean armarioEmbutido) {

        super(dataConstrucao, endereco, proprietarios, tipoDisponibilidade, imobiliaria, valorSugerido);

        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeSalasEstar = quantidadeSalasEstar;
        this.quantidadeSalasJantar = quantidadeSalasJantar;
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
    }

    public Integer getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Integer quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Integer getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(Integer quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public Integer getQuantidadeSalasEstar() {
        return quantidadeSalasEstar;
    }

    public void setQuantidadeSalasEstar(Integer quantidadeSalasEstar) {
        this.quantidadeSalasEstar = quantidadeSalasEstar;
    }

    public Integer getQuantidadeSalasJantar() {
        return quantidadeSalasJantar;
    }

    public void setQuantidadeSalasJantar(Integer quantidadeSalasJantar) {
        this.quantidadeSalasJantar = quantidadeSalasJantar;
    }

    public Integer getQuantidadeVagasGaragem() {
        return quantidadeVagasGaragem;
    }

    public void setQuantidadeVagasGaragem(Integer quantidadeVagasGaragem) {
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Boolean getArmarioEmbutido() {
        return armarioEmbutido;
    }

    public void setArmarioEmbutido(Boolean armarioEmbutido) {
        this.armarioEmbutido = armarioEmbutido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "quantidadeQuartos=" + quantidadeQuartos +
                ", quantidadeSuites=" + quantidadeSuites +
                ", quantidadeSalasEstar=" + quantidadeSalasEstar +
                ", quantidadeSalasJantar=" + quantidadeSalasJantar +
                ", quantidadeVagasGaragem=" + quantidadeVagasGaragem +
                ", area=" + area +
                ", armarioEmbutido=" + armarioEmbutido +
                ", descricao='" + descricao + '\'' +
                super.toString() + '}';
    }
}
