package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;
import main.java.imobiliaria.model.enums.TipoPagamento;
import main.java.imobiliaria.model.exceptions.ConflitoDisponibilidade;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {

    Double totalComissoes;

    List<Imovel> imoveis;

    List<Funcionario> funcionarios;

    List<Cliente> clientes;

    List<RegistroTransacao> trasacoes;

    public Imobiliaria() {
        this.imoveis = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.trasacoes = new ArrayList<>();
    }

    public void cadastrarFuncionario() {

        String cpf = JOptionPane.showInputDialog("CPF do funcionário");

        String nome = JOptionPane.showInputDialog("Nome do funcionário");

        String cargo = JOptionPane.showInputDialog("Cargo do funcionário");

        Double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Salário base do funcionário"));

        Endereco endereco = cadastrarEndereco();

        List<String> telefones = cadastrarTelefone();

        String usuario = JOptionPane.showInputDialog("Digite o usuário");

        String senha = JOptionPane.showInputDialog("Digite a senha");

        int resposta = JOptionPane.showConfirmDialog(null, "Cadastrar funcionário?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            Funcionario f = new Funcionario(cpf, nome, endereco, telefones, cargo, salarioBase, usuario, senha);
            this.funcionarios.add(f);
        } else if (resposta == JOptionPane.NO_OPTION) {
            cadastrarFuncionario();
        }
    }

    public void cadastarCliente() {
//        JPanel painelPrincipal = new JPanel();
//        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
//
//        CardLayout cardLayout = new CardLayout();
//        JPanel painelCards = new JPanel(cardLayout);
//
//        String[] tiposCliente = {"Usuário", "Proprietário"};
//        JComboBox<String> comboEscolha = new JComboBox<>(tiposCliente);
//        comboEscolha.addActionListener(e -> {
//            String escolha = (String) comboEscolha.getSelectedItem();
//            cardLayout.show(painelCards, escolha.toUpperCase());
//        });
//
//        painelPrincipal.add(comboEscolha);
//        painelPrincipal.add(painelCards);

        String escolha = JOptionPane.showInputDialog("Deseja cadastrar um [usuário] ou [proprietário]").toUpperCase();

        String cpf = JOptionPane.showInputDialog("CPF do cliente");

        String nome = JOptionPane.showInputDialog("Nome do cliente");

        String email = JOptionPane.showInputDialog("Email do cliente");

        String profissao = JOptionPane.showInputDialog("Profissão do cliente");

        Endereco endereco = cadastrarEndereco();

        JComboBox<Sexo> comboSexo = new JComboBox<>(Sexo.values());
        Sexo sexo = (Sexo) comboSexo.getSelectedItem();

        JComboBox<EstadoCivil> comboEstadoCivil = new JComboBox<>(EstadoCivil.values());
        EstadoCivil estadoCivil = (EstadoCivil) comboEstadoCivil.getSelectedItem();

        if (escolha.equals("PROPRIETARIO")) {
            ClienteProprietario p = new ClienteProprietario(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
            this.clientes.add(p);
            //chamar cadastrarImovel()
        } else if (escolha.equals("USUARIO")) {
            Cliente c = new Cliente(cpf, nome, endereco, email, profissao, sexo, estadoCivil);
            this.clientes.add(c);
        } else throw new IllegalArgumentException();

        System.out.println("Cliente cadastrado com sucesso!");;
    }

    /**
     * public void cadastarImovel() {
     * Scanner leitor = new Scanner(System.in);
     * System.out.println("CADASTRO DE IMÓVEL");
     * //Imovel(LocalDate dataConstrucao, Endereco endereco, List<ClienteProprietario> proprietarios, TipoDisponibilidade tipoDisponibilidade)
     * }
     **/

    public void realizarTransacao(Cliente cliente, Funcionario funcionario, Imovel imovel) {
        if (!imovel.getDisponibilidade()) throw new ConflitoDisponibilidade();

        JComboBox<TipoPagamento> combo = new JComboBox<>(TipoPagamento.values());
        TipoPagamento tipoPagamento = (TipoPagamento) combo.getSelectedItem();

        if (imovel.getTipoDisponibilidade() == TipoDisponibilidade.VENDER) {
            Venda v = new Venda(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente, 10000.0);
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

            Aluguel a = new Aluguel(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente, 1000.0, fiadores, indicacoes, inicioContrato);
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

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<RegistroTransacao> getTrasacoes() {
        return trasacoes;
    }
}
