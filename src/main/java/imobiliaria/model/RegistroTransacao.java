package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoPagamento;

import java.time.LocalDate;

public abstract class RegistroTransacao {

    private Integer numContrato;

    private static Integer contador;

    private LocalDate dataTransacao;

    private TipoPagamento tipoPagamento;

    private Imovel imovel;

    private Funcionario funcionario;

    private Cliente interessado;

    private ClienteProprietario proprietario;

    private Double valorSugerido;

    private Double valorReal;

    public RegistroTransacao(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario,
                             ClienteProprietario proprietario, Cliente interessado, Double valorSugerido) {
        this.numContrato = RegistroTransacao.contador++;
        this.dataTransacao = LocalDate.now();
        this.tipoPagamento = tipoPagamento;
        this.imovel = imovel;
        this.funcionario = funcionario;
        this.proprietario = proprietario;
        this.interessado = interessado;
        this.valorSugerido = valorSugerido;
        this.valorReal = valorSugerido;
    }

    public abstract void executar();

    public void transferirComissaoImobiliaria(){
        if(this.imovel instanceof Casa){
            imovel.getImobiliaria().adicionarComissao(valorSugerido * 0.15);
            valorReal += valorSugerido * 0.15;
        }if(this.imovel instanceof Terreno){
            imovel.getImobiliaria().adicionarComissao(valorSugerido * 0.10);
            valorReal += valorSugerido * 0.10;
        }if(this.imovel instanceof Apartamento){
            imovel.getImobiliaria().adicionarComissao(valorSugerido * 0.12);
            valorReal += valorSugerido * 0.12;
        }if(this.imovel instanceof SalaComercial){
            imovel.getImobiliaria().adicionarComissao(valorSugerido * 0.14);
            valorReal += valorSugerido * 0.14;
        }
    }

    public void transferirComissaoFuncionario(){
        if(this.imovel instanceof Casa){
            this.funcionario.adicionarComissao(valorSugerido * 0.05);
        }if(this.imovel instanceof Terreno){
            this.funcionario.adicionarComissao(valorSugerido * 0.01);
        }if(this.imovel instanceof Apartamento){
            this.funcionario.adicionarComissao(valorSugerido * 0.02);
        }if(this.imovel instanceof SalaComercial){
            this.funcionario.adicionarComissao(valorSugerido * 0.04);
        }
    }

    public void calcularValorRealTransacao() {
        if(this.imovel instanceof Casa){
            valorReal += valorSugerido * 0.20;
        }if(this.imovel instanceof Terreno){
            valorReal += valorSugerido * 0.11;
        }if(this.imovel instanceof Apartamento){
            valorReal += valorSugerido * 0.14;
        }if(this.imovel instanceof SalaComercial){
            valorReal += valorSugerido * 0.18;
        }
    }

    public Integer getNumContrato() {
        return numContrato;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getInteressado() {
        return interessado;
    }

    public void setInteressado(Cliente interessado) {
        this.interessado = interessado;
    }

    public ClienteProprietario getClienteProprietario() {
        return proprietario;
    }

    public void setClienteProprietario(ClienteProprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(Double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    public Double getValorReal() {
        return valorReal;
    }

    public void setValorReal(Double valorReal) {
        this.valorReal = valorReal;
    }

    @Override
    public String toString() {
        return "RegistroTransacao{" +
                "numContrato=" + numContrato +
                ", dataTransacao=" + dataTransacao +
                ", formaPagamento='" + tipoPagamento + '\'' +
                ", imovel=" + imovel +
                ", funcionario=" + funcionario +
                ", clienteInteressado=" + interessado +
                ", clienteProprietario=" + proprietario +
                ", valorSugerido=" + valorSugerido +
                ", valorReal=" + valorReal +
                '}';
    }
}
