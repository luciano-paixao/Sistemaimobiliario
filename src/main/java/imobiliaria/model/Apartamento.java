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

    public Apartamento(TipoDisponibilidade tipoDisponibilidade, LocalDate dataConstrucao, List<ClienteProprietario> proprietarios, Endereco endereco, Integer quantidadeQuartos, Integer quantidadeSuites, Integer quantidadeSalasEstar, Integer quantidadeSalasJantar, Integer quantidadeVagasGaragem, Double area, Boolean armarioEmbutido, Integer andar, Double valorCondominio, Boolean portaria24hs) {
        super(tipoDisponibilidade, dataConstrucao, proprietarios, endereco);
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeSalasEstar = quantidadeSalasEstar;
        this.quantidadeSalasJantar = quantidadeSalasJantar;
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
        this.andar = andar;
        this.valorCondominio = valorCondominio;
        this.portaria24hs = portaria24hs;
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
}
