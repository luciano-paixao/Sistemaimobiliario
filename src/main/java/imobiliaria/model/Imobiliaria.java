package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {

    private Double totalComissoes;

    private List<Imovel> imoveis;

    private List<Funcionario> funcionarios;

    private List<Cliente> clientes;

    public Imobiliaria() {
        this.imoveis = new ArrayList<Imovel>();
        this.funcionarios = new ArrayList<Funcionario>();
        this.clientes = new ArrayList<Cliente>();
    }

    public void cadastrarFuncionario() {
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

        // Telefones
        List<String> telefones = new ArrayList<>();
        System.out.print("Quantos telefones deseja cadastrar? ");
        int qtdTelefones = Integer.parseInt(leitor.nextLine());

        for (int i = 1; i <= qtdTelefones; i++) {
            System.out.print("Digite o telefone " + i + ": ");
            telefones.add(leitor.nextLine());
        }

        System.out.print("Digite o cargo: ");
        String cargo = leitor.nextLine();

        System.out.print("Digite o salário base: ");
        Double salarioBase = Double.parseDouble(leitor.nextLine());

        System.out.print("Digite o usuário: ");
        String usuario = leitor.nextLine();

        System.out.print("Digite a senha: ");
        String senha = leitor.nextLine();

        Funcionario funcionario = new Funcionario(cpf, nome, endereco, cargo, salarioBase, usuario, senha);

        System.out.println("\nFuncionário cadastrado com sucesso!");
        System.out.println("Data de ingresso: " + funcionario.getDataIngresso());

        this.funcionarios.add(funcionario);
    }

    public void cadastarCliente() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CADASTRO DE CLIENTE");

        System.out.print("Deseja cadastrar um [USUÁRIO] ou um [PROPRIETÁRIO]?");
        String escolha = leitor.nextLine().toUpperCase();

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
            // Chamar cadastrarImovel()
        }

        Cliente c = new Cliente(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
        this.clientes.add(c);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastarImovel() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CADASTRO DE IMÓVEL");
        //Imovel(LocalDate dataConstrucao, Endereco endereco, List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade)
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
