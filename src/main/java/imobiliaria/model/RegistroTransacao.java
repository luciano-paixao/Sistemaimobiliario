package main.java.imobiliaria.model;

import java.time.LocalDate;

public class RegistroTransacao {

    private Integer numContrato;
    private static Integer contador;
    private LocalDate dataTransacao;
    private String formaPagamento;
    private Imovel imovel;
    private Funcionario funcionario;
    // clienteUsuario usuario;
    // Cliente cliente;
    private Double valorSugerido;
    private Double valorReal;
    private double margemImobiliaria;

    public void lucroImobiliaria(){
        if(this.imovel instanceof Casa){
            margemImobiliaria = valorReal * 0.15;
            valorReal -= valorReal * 0.15;
        }if(this.imovel instanceof Terreno){
            margemImobiliaria = valorReal * 0.10;
            valorReal -= valorReal * 0.10;
        }if(this.imovel instanceof Apartamento){
            margemImobiliaria = valorReal * 0.12;
            valorReal -= valorReal * 0.12;
        }if(this.imovel instanceof SalaComercial){
            margemImobiliaria = valorReal * 0.14;
            valorReal -= valorReal * 0.14;
        }
    }

    public void ComissaoFuncionario(){
        if(this.imovel instanceof Casa){
            // Funcionario.comissao + valorReal * 0.05;
            valorReal -= valorReal * 0.05;
        }if(this.imovel instanceof Terreno){
            // Funcionario.comissao + valorReal * 0.01;
            valorReal -= valorReal * 0.01;
        }if(this.imovel instanceof Apartamento){
            // Funcionario.comissao + valorReal * 0.02;
            valorReal -= valorReal * 0.02;
        }if(this.imovel instanceof SalaComercial){
            // Funcionario.comissao + valorReal * 0.04;
            valorReal -= valorReal * 0.04;
        }
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        RegistroTransacao.contador = contador;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public double getMargemImobiliaria() {
        return margemImobiliaria;
    }

    public void setMargemImobiliaria(double margemImobiliaria) {
        this.margemImobiliaria = margemImobiliaria;
    }

    public Integer getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(Integer numContrato) {
        this.numContrato = numContrato;
    }

    public Double getValorReal() {
        return valorReal;
    }

    public void setValorReal(Double valorReal) {
        this.valorReal = valorReal;
    }

    public Double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(Double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }
}
