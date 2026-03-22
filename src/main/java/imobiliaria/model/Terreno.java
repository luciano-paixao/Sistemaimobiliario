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

    public Terreno(LocalDate dataConstrucao, Boolean disponibilidade, Endereco endereco,
                   List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade,
                   Boolean aclive, Double area, Double comprimento, Boolean declive, Double largura) {
        super(dataConstrucao, disponibilidade, endereco, proprietarios, tipoDisponibilidade);
        this.aclive = aclive;
        this.area = area;
        this.comprimento = comprimento;
        this.declive = declive;
        this.largura = largura;
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
