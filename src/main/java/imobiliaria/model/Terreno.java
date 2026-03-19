package main.java.imobiliaria.model;

public class Terreno extends Imovel {

    private Double area;

    private Double largura;

    private Double comprimento;

    private Boolean aclive;

    private Boolean declive;

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
