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
    private Cliente comprador;
    private ClienteProprietario proprietario;
    private Double valorReal;
    private Double valorSugerido;

    public RegistroTransacao(TipoPagamento tipoPagamento, Imovel imovel, Funcionario funcionario,
                             ClienteProprietario proprietario, Cliente comprador, Double valorReal, Double valorSugerido) {
        this.numContrato = RegistroTransacao.contador++;
        this.dataTransacao = LocalDate.now();
        this.tipoPagamento = tipoPagamento;
        this.imovel = imovel;
        this.funcionario = funcionario;
        this.proprietario = proprietario;
        this.comprador = comprador;
        this.valorReal = valorReal;
        this.valorSugerido = valorSugerido;
    }

    public abstract void executar();

    public void transferirComissaoImobiliaria(){
        if(this.imovel instanceof Casa){
            imovel.getImobiliaria().adicionarComissao(valorReal * 0.15);
            //valorReal -= valorReal * 0.15;
        }if(this.imovel instanceof Terreno){
            imovel.getImobiliaria().adicionarComissao(valorReal * 0.10);
            //valorReal -= valorReal * 0.10;
        }if(this.imovel instanceof Apartamento){
            imovel.getImobiliaria().adicionarComissao(valorReal * 0.12);
            //valorReal -= valorReal * 0.12;
        }if(this.imovel instanceof SalaComercial){
            imovel.getImobiliaria().adicionarComissao(valorReal * 0.14);
            //valorReal -= valorReal * 0.14;
        }
    }

    public void transferirComissaoFuncionario(){
        if(this.imovel instanceof Casa){
            this.funcionario.adicionarComissao(valorReal * 0.05);
            //valorReal -= valorReal * 0.05;
        }if(this.imovel instanceof Terreno){
            this.funcionario.adicionarComissao(valorReal * 0.01);
            //valorReal -= valorReal * 0.01;
        }if(this.imovel instanceof Apartamento){
            this.funcionario.adicionarComissao(valorReal * 0.02);
            //valorReal -= valorReal * 0.02;
        }if(this.imovel instanceof SalaComercial){
            this.funcionario.adicionarComissao(valorReal * 0.04);
            //valorReal -= valorReal * 0.04;
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

    public Cliente getCliente() {
        return comprador;
    }

    public void setCliente(Cliente cliente) {
        this.comprador = cliente;
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
                ", usuario=" + comprador +
                ", clienteProprietario=" + proprietario +
                ", valorSugerido=" + valorSugerido +
                ", valorReal=" + valorReal +
                '}';
    }
}
