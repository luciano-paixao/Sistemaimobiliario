package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;
import main.java.imobiliaria.model.enums.TipoPagamento;
import main.java.imobiliaria.model.exceptions.ConflitoDisponibilidade;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {

    Double totalComissoes;

    List<Imovel> imoveis;

    List<Funcionario> funcionarios;

    List<Cliente> clientes;

    List<RegistroTransacao> transacoes;

    public Imobiliaria() {
        this.imoveis = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public Funcionario cadastrarFuncionario() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CADASTRO DE FUNCIONÁRIO");

        System.out.print("Digite o CPF: ");
        String cpf = leitor.nextLine();

        System.out.print("Digite o nome: ");
        String nome = leitor.nextLine();

        // Endereço
        System.out.print("Digite a rua: ");
        String rua = leitor.nextLine();

        System.out.print("Digite o número: ");
        String numero = leitor.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = leitor.nextLine();

        Endereco endereco = new Endereco(bairro, rua, numero);

        List<String> telefones = cadastrarTelefone();

        System.out.print("Digite o cargo: ");
        String cargo = leitor.nextLine();

        System.out.print("Digite o salário base: ");
        Double salarioBase = Double.parseDouble(leitor.nextLine());

        System.out.print("Digite o usuário: ");
        String usuario = leitor.nextLine();

        System.out.print("Digite a senha: ");
        String senha = leitor.nextLine();

        Funcionario f = new Funcionario(cpf, nome, endereco, telefones, cargo, salarioBase, usuario, senha);

        System.out.println("\nFuncionário cadastrado com sucesso!");
        System.out.println("Data de ingresso: " + f.getDataIngresso());

        this.funcionarios.add(f);

        return f;
    }

    public Cliente cadastarCliente() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CADASTRO DE CLIENTE");

        System.out.print("Deseja cadastrar um [USUÁRIO] ou um [PROPRIETÁRIO]?");
        String escolha = leitor.nextLine().toUpperCase();

        System.out.print("Digite o CPF: ");
        String cpf = leitor.nextLine();

        System.out.print("Digite o nome: ");
        String nome = leitor.nextLine();

        Endereco endereco = cadastrarEndereco();

        System.out.print("Digite o email: ");
        String email = leitor.nextLine();

        System.out.print("Digite a profissão: ");
        String profissao = leitor.nextLine();

        System.out.print("Digite o sexo: ");
        Sexo sexo = Sexo.valueOf(leitor.nextLine());

        System.out.print("Digite o estado civil: ");
        EstadoCivil estadoCivil = EstadoCivil.valueOf(leitor.nextLine().toUpperCase());

        if (escolha.equals("PROPRIETARIO")) {
            ClienteProprietario p = new ClienteProprietario(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
            this.clientes.add(p);
            return p;
        }

        Cliente c = new Cliente(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
        this.clientes.add(c);

        System.out.println("Cliente cadastrado com sucesso!");

        return c;
    }
    /**
    public void cadastarImovel() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CADASTRO DE IMÓVEL");
        //Imovel(LocalDate dataConstrucao, Endereco endereco, List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade)
    }
     **/

    public void realizarTransacao(Cliente cliente, Funcionario funcionario, Imovel imovel) {
        if (!imovel.getDisponibilidade()) throw new ConflitoDisponibilidade();

        JComboBox<TipoPagamento> combo = new JComboBox<>(TipoPagamento.values());
        TipoPagamento tipoPagamento = (TipoPagamento) combo.getSelectedItem();

        if (imovel.getTipoDisponibilidade() == TipoDisponibilidade.VENDER) {
            Venda v = new Venda(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente);
            v.executar();
        } else {
            //List<Pessoa> fiadores, List<Pessoa> indicacoes, LocalDate inicioContrato, LocalDate fimContrato
            int n = Integer.parseInt(JOptionPane.showInputDialog("Número de fiadores"));
            List<Pessoa> fiadores = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Pessoa fiador = cadastrarPessoa();
                fiadores.add(fiador);
            }

            n = Integer.parseInt(JOptionPane.showInputDialog("Número de indicações (mínimo dois)"));
            List<Pessoa> indicacoes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Pessoa indicacao = cadastrarPessoa();
                fiadores.add(indicacao);
            }

            //Adicionar card para incializar as datas corretamente
            int ano = 2000;
            int mes = 1;
            int dia = 1;
            LocalDate inicioContrato = LocalDate.of(ano, mes, dia);

            Aluguel a = new Aluguel(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente, fiadores, indicacoes, inicioContrato);
            a.executar();
        }
    }

    public Endereco cadastrarEndereco() {
        String bairro = JOptionPane.showInputDialog("Bairro");
        String rua = JOptionPane.showInputDialog("Rua");
        String numero = JOptionPane.showInputDialog("Número");
        return new Endereco(bairro, rua, numero);
    }

    public List<String> cadastrarTelefone() {
        List<String> telefones = new ArrayList<>();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos telefones deseja cadastrar?"));
        if (n == 0) return null;
        for (int i = 0; i < n; i++) {
            String t = JOptionPane.showInputDialog("Número de telefone [(xx) xxxx-xxxx]");
            telefones.add(t);
        }
        return telefones;
    }

    public Pessoa cadastrarPessoa() {
        String cpf = JOptionPane.showInputDialog("CPF");
        String nome = JOptionPane.showInputDialog("Nome");
        Endereco endereco = cadastrarEndereco();
        List<String> telefones = cadastrarTelefone();
        return new Pessoa(cpf, nome, endereco, telefones);
    }

    public List<Imovel> getImoveisDisponiveis() {
        return this.imoveis.stream().filter(i -> i.getDisponibilidade() == true).toList();
    }

    public List<Imovel> getImoveisIndisponiveis() {
        return this.imoveis.stream().filter(i -> i.getDisponibilidade() == false).toList();
    }

    public void adicionarComissao(Double valor) {
        this.totalComissoes += valor;
    }

    public void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    public void removerImovel(Imovel imovel) {
        this.imoveis.remove(imovel);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public Double getTotalcomissoes() {
        return totalComissoes;
    }
}
