package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public class Apartamento extends Imovel {

    private Integer quantidadeQuartos;

    private Integer quantidadeSuites;

    private Integer quantidadeSalasEstar;

    private Integer quantidadeSalasJantar;

    private Integer quantidadeVagasGaragem;

    private Double area;

    private Boolean armarioEmbutido;

    private String descricao;

    private Integer andar;

    private Double valorCondominio;

    private Boolean portaria24hs;

    public Apartamento(LocalDate dataConstrucao, Boolean disponibilidade, Endereco endereco,
                       List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade,
                       Integer andar, Double area, Boolean armarioEmbutido, String descricao, Boolean portaria24hs,
                       Integer quantidadeQuartos, Integer quantidadeSalasEstar, Integer quantidadeSalasJantar,
                       Integer quantidadeSuites, Integer quantidadeVagasGaragem, Double valorCondominio) {
        super(dataConstrucao, disponibilidade, endereco, proprietarios, tipoDisponibilidade);
        this.andar = andar;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
        this.descricao = descricao;
        this.portaria24hs = portaria24hs;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSalasEstar = quantidadeSalasEstar;
        this.quantidadeSalasJantar = quantidadeSalasJantar;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
        this.valorCondominio = valorCondominio;
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

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(Double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public Boolean getPortaria24hs() {
        return portaria24hs;
    }

    public void setPortaria24hs(Boolean portaria24hs) {
        this.portaria24hs = portaria24hs;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "quantidadeQuartos=" + quantidadeQuartos +
                ", quantidadeSuites=" + quantidadeSuites +
                ", quantidadeSalasEstar=" + quantidadeSalasEstar +
                ", quantidadeSalasJantar=" + quantidadeSalasJantar +
                ", quantidadeVagasGaragem=" + quantidadeVagasGaragem +
                ", area=" + area +
                ", armarioEmbutido=" + armarioEmbutido +
                ", descricao='" + descricao + '\'' +
                ", andar=" + andar +
                ", valorCondominio=" + valorCondominio +
                ", portaria24hs=" + portaria24hs +
                super.toString() + '}';
    }
}
