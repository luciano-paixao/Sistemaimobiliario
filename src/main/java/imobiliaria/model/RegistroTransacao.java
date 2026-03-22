package main.java.imobiliaria.model;

import java.time.LocalDate;

public class RegistroTransacao {

    private Integer numContrato;
    private static Integer contador;
    private LocalDate dataTransacao;
    private String formaPagamento;
    private Imovel imovel;
    private Funcionario funcionario;
    ClienteUsuario usuario;
    ClienteProprietario clienteProprietario;
    private Double valorSugerido;
    private Double valorReal;
    protected Double valorAux;
    private double margemImobiliaria;

// pata Aluguel
    public RegistroTransacao(ClienteProprietario clienteProprietario, LocalDate dataTransacao,
                             String formaPagamento, Funcionario funcionario, Imovel imovel,
                             double margemImobiliaria, ClienteUsuario usuario, Double valorSugerido) {
        this.clienteProprietario = clienteProprietario;
        this.dataTransacao = dataTransacao;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.imovel = imovel;
        this.margemImobiliaria = margemImobiliaria;
        this.contador++;
        this.numContrato = this.contador;
        this.usuario = usuario;
        this.valorSugerido = valorSugerido;
        this.valorAux = valorSugerido;
        this.valorReal = valorSugerido;
    }

    // Para venda
    public RegistroTransacao(ClienteProprietario clienteProprietario, LocalDate dataTransacao,
                             String formaPagamento, Funcionario funcionario, Imovel imovel,
                             double margemImobiliaria, Double valorReal, Double valorSugerido) {
        this.clienteProprietario = clienteProprietario;
        this.dataTransacao = dataTransacao;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.imovel = imovel;
        this.margemImobiliaria = margemImobiliaria;
        this.contador++;
        this.numContrato = this.contador;
        this.valorSugerido = valorSugerido;
        this.valorAux = valorSugerido;
        this.valorReal = valorSugerido;
    }



    public void lucroImobiliaria(){
        if(this.imovel instanceof Casa){
            margemImobiliaria = valorAux * 0.15;
            valorReal -= valorReal * 0.15;
        }else if(this.imovel instanceof Terreno){
            margemImobiliaria = valorAux * 0.10;
            valorReal -= valorReal * 0.10;
        }else if(this.imovel instanceof Apartamento){
            margemImobiliaria = valorAux * 0.12;
            valorReal -= valorReal * 0.12;
        }else if(this.imovel instanceof SalaComercial){
            margemImobiliaria = valorAux * 0.14;
            valorReal -= valorReal * 0.14;
        }
    }

    public void ComissaoFuncionario(){
        if(this.imovel instanceof Casa){
            this.funcionario.Totalcomissoes += valorAux * 0.05;
            valorReal -= valorReal * 0.05;
        }else if(this.imovel instanceof Terreno){
            this.funcionario.Totalcomissoes += valorAux * 0.01;
            valorReal -= valorReal * 0.01;
        }else if(this.imovel instanceof Apartamento){
            this.funcionario.Totalcomissoes += valorAux * 0.02;;
            valorReal -= valorReal * 0.02;
        }else if(this.imovel instanceof SalaComercial){
            this.funcionario.Totalcomissoes += valorAux * 0.04;
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

    @Override
    public String toString() {
        return "RegistroTransacao{" +
                "numContrato=" + numContrato +
                ", dataTransacao=" + dataTransacao +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", imovel=" + imovel +
                ", funcionario=" + funcionario +
                ", usuario=" + usuario +
                ", clienteProprietario=" + clienteProprietario +
                ", valorSugerido=" + valorSugerido +
                ", valorReal=" + valorReal +
                ", margemImobiliaria=" + margemImobiliaria +
                '}';
    }
}
