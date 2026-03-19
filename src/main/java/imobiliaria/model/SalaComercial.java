package main.java.imobiliaria.model;

public class SalaComercial extends Imovel {

    private Double area;

    private Integer quantidadeBanheiros;

    private Integer quantidadeComodos;

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
