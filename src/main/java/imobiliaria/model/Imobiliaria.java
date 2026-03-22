package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {

    private Double Totalcomissoes;

    private List<Imovel> imoveisAlugados;
    private List<Imovel> imoveisVendidos;
    private List<Imovel> imoveisParaAlugar;
    private List<Imovel> imoveisParaVender;
    private List<Funcionario> funcionarios;
    private List<ClienteUsuario> clienteUsuarios;
    private List<ClienteProprietario> clienteProprietarios;

    public Imobiliaria(){
        imoveisAlugados = new ArrayList<>();
        imoveisVendidos = new ArrayList<>();
        imoveisParaAlugar = new ArrayList<>();
        imoveisParaVender = new ArrayList<>();
        funcionarios = new ArrayList<>();
        this.clienteUsuarios = new ArrayList<>();
    }

    public void cadastarImovel(ClienteProprietario cliente){
        Scanner leitor = new Scanner(System.in);

        IO.println("Escolha o imovel que você desejar cadastrar");
        List<Imovel> imoveis = cliente.getImoveis();

        loop:
        for (Imovel imo: imoveis ){
            IO.println(imo);
            IO.println("Se for esse imovel digite 1 para selecionar ou 2 para o proximo");
            int num = leitor.nextInt();
            switch (num){
                case 1:
                    IO.println("digite 1 para vender ou 2 para alugar seu Imovel");
                    int opcao = leitor.nextInt();
                    switch (opcao){
                        case 1:
                            imo.setTipoDisponibilidade(TipoDisponibilidade.VENDER);
                            imo.setDisponibilidade(true);
                            adicionarImovelParaVenda(imo);
                            break loop;
                        case 2:
                            adicionarImovelParaAlugar(imo);
                            break loop;
                    }
                case 2:
                    continue; // volta pro Inicio do for
            }
        }
    }

    public void comprar(Cliente cliente){
        Scanner leitor = new Scanner(System.in);
        IO.println("Escolha o imovel que deseja vender\n");
        for (Imovel imo : imoveisParaVender){
            IO.println("Se deseja esse imovel digite 1 para selecionar ou 2 para o proximo \n");
            IO.println(imo + "\n");
            int opcao = leitor.nextInt();

            switch (opcao){
                case 1:
                    imoveisVendidos.add(imo);
                    removerImovelParaVender(imo);
                    imo.setProprietarios(null);
                    Cliente clientePropri = new ClienteProprietario();
                    clientePropri = cliente;
                    ClienteProprietario cli = (ClienteProprietario) clientePropri;
                    imo.adicionarProprietario(cli);


                    IO.println("Teste");
                    for (Imovel imoTeste : imoveisParaVender){
                        IO.println(imoTeste);
                    }

                    imo.venda

                    break;
                case 2:
                    continue;
            }
        }
    }

    public void Alugar(){

    }


    public void adicionarComissao(Double valor) {
        this.Totalcomissoes += valor;
    }

    public void adicionarImovelParaVenda(Imovel imovel) {
        this.imoveisParaVender.add(imovel);
    }

    public void removerImovelParaVender(Imovel imovel) {
        this.imoveisParaVender.remove(imovel);
    }

    public void adicionarImovelParaAlugar(Imovel imovel) {
        this.imoveisParaAlugar.add(imovel);
    }

    public void removerImovelParaAlugar(Imovel imovel) {
        this.imoveisParaAlugar.remove(imovel);
    }

    public void adicionarImovelVendido(Imovel imovel) {
        this.imoveisVendidos.add(imovel);
    }

    public void removerImovelVendido(Imovel imovel) {
        this.imoveisVendidos.remove(imovel);
    }

    public void adicionarImovelAlugado(Imovel imovel) {
        this.imoveisAlugados.add(imovel);
    }

    public void removerImovelAlugado(Imovel imovel) {
        this.imoveisAlugados.remove(imovel);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public void adicionarClienteUsuario(ClienteUsuario cliente) {
        this.clienteUsuarios.add(cliente);
    }

    public void removerClienteusario(ClienteUsuario cliente) {
        this.clienteUsuarios.remove(cliente);
    }

    public void adicionarClienteProprietario(ClienteProprietario cliente) {
        this.clienteProprietarios.add(cliente);
    }

    public void removerClienteProprietario(ClienteProprietario cliente) {
        this.clienteProprietarios.remove(cliente);
    }

    public Double getTotalcomissoes() {
        return Totalcomissoes;
    }


}
