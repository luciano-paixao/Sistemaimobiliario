package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.List;

public class Terreno extends Imovel {

    private Double largura;

    private Double comprimento;

    private Double area;

    private Boolean aclive;

    private Boolean declive;

    public Terreno(TipoDisponibilidade tipoDisponibilidade, LocalDate dataConstrucao, List<ClienteProprietario> proprietarios, Endereco endereco, Double largura, Double comprimento, Boolean aclive, Boolean declive) {
        super(tipoDisponibilidade, dataConstrucao, proprietarios, endereco);
        this.largura = largura;
        this.comprimento = comprimento;
        this.area = largura * comprimento;
        this.aclive = aclive;
        this.declive = declive;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Boolean getAclive() {
        return aclive;
    }

    public void setAclive(Boolean aclive) {
        this.aclive = aclive;
    }

    public Boolean getDeclive() {
        return declive;
    }

    public void setDeclive(Boolean declive) {
        this.declive = declive;
    }
}
