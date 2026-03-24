package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Terreno extends Imovel {

    private Double largura;

    private Double comprimento;

    private Double area;

    private Boolean aclive;

    private Boolean declive;

    public Terreno(LocalDate dataConstrucao, Endereco endereco, List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade, Imobiliaria imobiliaria, Double valorSugerido, Double largura, Double comprimento, Boolean aclive, Boolean declive) {
        super(dataConstrucao, endereco, proprietarios, tipoDisponibilidade, imobiliaria, valorSugerido);
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

    @Override
    public String toString() {
        return "Terreno{" +
                "largura=" + largura +
                ", comprimento=" + comprimento +
                ", area=" + area +
                ", aclive=" + aclive +
                ", declive=" + declive +
                super.toString() + '}';
    }
}
