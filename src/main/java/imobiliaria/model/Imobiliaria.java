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
        this.totalComissoes = 0.0;
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
        System.out.println("Data de ingresso: " + f.getDataIngresso() + "\n");

        this.funcionarios.add(f);

        return f;
    }

    public Boolean ehProprietario(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("CADASTRO DE CLIENTE");

        String escolha = "";

        do {
            System.out.print("Deseja cadastrar um [USUÁRIO] ou um [PROPRIETÁRIO]?");
            escolha = leitor.nextLine().toUpperCase();
        } while (!escolha.equals("USUÁRIO") && !escolha.equals("PROPRIETÁRIO"));

        return escolha.equals("PROPRIETÁRIO");
    }

    public Cliente cadastrarCliente(Boolean ehProprietario) {
        Scanner leitor = new Scanner(System.in);

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
        Sexo sexo = Sexo.valueOf(leitor.nextLine().toUpperCase());

        System.out.print("Digite o estado civil: ");
        EstadoCivil estadoCivil = EstadoCivil.valueOf(leitor.nextLine().toUpperCase());

        if (ehProprietario) {
            ClienteProprietario p = new ClienteProprietario(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
            this.clientes.add(p);
            return p;
        }

        Cliente c = new Cliente(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
        this.clientes.add(c);

        System.out.println("Cliente cadastrado com sucesso!");

        IO.println(c.toString());

        return c;
    }

    public void cadastarImovel() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CADASTRO DE CLIENTE");

        System.out.print("Escolha uma categoria [Casa, Apartamento, Terreno, SalaComercial]");
        String escolha = leitor.nextLine().toUpperCase();

        System.out.print("DATA DE CONSTRUÇÃO DO IMÓVEL:");
        System.out.println("Ano: ");
        Integer ano = leitor.nextInt();
        System.out.println("Mês: ");
        Integer mes = leitor.nextInt();
        System.out.println("Dia: ");
        Integer dia = leitor.nextInt();
        LocalDate data = LocalDate.of(ano, mes, dia);

        System.out.print("Digite o CPF: ");
        String cpf = leitor.nextLine();

        System.out.print("Digite o nome: ");
        String nome = leitor.nextLine();

        Endereco endereco = cadastrarEndereco();

        //PROPRIETARIOS
        List<ClienteProprietario> proprietarios = new ArrayList<>();
        System.out.print("Quantos proprietários deseja cadastrar? ");
        int n = leitor.nextInt();
        for(int i = 1; i <= n; i++) {
            ClienteProprietario c = (ClienteProprietario)cadastrarCliente(true);
            proprietarios.add(c);
        }

        System.out.print("[VENDA] ou [ALUGUEL]? ");
        TipoDisponibilidade tipoDispon = TipoDisponibilidade.valueOf(leitor.nextLine().toUpperCase());

        System.out.print("Qual o valor sugerido pelo proprietário? ");
        Double valorSugerido = leitor.nextDouble();

        switch (escolha) {
            case "CASA":
                System.out.print("\nDADOS ESPECÍFICOS: ");
                System.out.println("Área: ");
                Double area = leitor.nextDouble();
                System.out.println("Armario Embutido (s/n): ");
                String opcao = leitor.nextLine();
                Boolean armarioEmb = opcao.equals("s");

                System.out.println("Descrição (opcional): ");
                String descricao = leitor.nextLine();

                System.out.println("Número de quartos: ");
                Integer qtdQuartos = leitor.nextInt();
                System.out.println("Número de salas de estar: ");
                Integer qtdSalasEstar = leitor.nextInt();
                System.out.println("Número de salas de jantar: ");
                Integer qtdSalasJantar = leitor.nextInt();
                System.out.println("Número de suítes: ");
                Integer qtdSuites = leitor.nextInt();
                System.out.println("Número de vagas na garagem: ");
                Integer qtdvagas = leitor.nextInt();;

//                Casa casa =
//                        new Casa(data, endereco,
//                                    proprietarios, tipoDispon, valorSugerido,
//                                    area, armarioEmb, descricao, qtdQuartos,
//                                    qtdSalasEstar, qtdSalasJantar,qtdSuites,
//                                    qtdvagas, LocalDate.now(), null, imobi);
        }

//        Cliente c = new Cliente(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
//        this.clientes.add(c);

        System.out.println("Cliente cadastrado com sucesso!");

//        IO.println(c.toString());

        return;
    }

    public void realizarTransacao(Cliente cliente, Funcionario funcionario, Imovel imovel) {
        if (!imovel.getDisponibilidade()) throw new ConflitoDisponibilidade();

        JComboBox<TipoPagamento> combo = new JComboBox<>(TipoPagamento.values());
        TipoPagamento tipoPagamento = (TipoPagamento) combo.getSelectedItem();

        if (imovel.getTipoDisponibilidade() == TipoDisponibilidade.VENDER) {
            Venda v = new Venda(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente);
            v.executar();
            IO.println(v.toString());
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

    public Cliente buscarUsuario(String nome) {
        Cliente cliUser = getClientes().stream()
                .filter(c -> c.getNome().equals(nome))
                .findFirst()
                .orElse(null);
        if(cliUser instanceof ClienteProprietario) {
            System.out.println("Não foi achado nenhum cliente chamado " + nome);
            return null;
        }

        return cliUser;
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

    public List<Imovel> getImoveisDisponiveisSimples() {
        return this.imoveis;
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

    public List<Cliente> getClientes() {
        return clientes;
    }
}
