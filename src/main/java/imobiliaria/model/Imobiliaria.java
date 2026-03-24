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
import java.util.Scanner;
import java.util.function.Predicate;

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
        this.totalComissoes = 0.0;
    }

    public void realizarTransacao(Cliente cliente, Funcionario funcionario, Imovel imovel) {
        if (!imovel.getDisponibilidade()) throw new ConflitoDisponibilidade();

        JComboBox<TipoPagamento> combo = new JComboBox<>(TipoPagamento.values());
        TipoPagamento tipoPagamento = (TipoPagamento) combo.getSelectedItem();

//        int random = (int)(Math.random() * 100);
//        TipoPagamento tipoPagamento = null;
//        if(random < 25)
//            tipoPagamento = TipoPagamento.PIX;
//        if(random < 50)
//            tipoPagamento = TipoPagamento.TRANSFERENCIA;
//        if(random < 75)
//            tipoPagamento = TipoPagamento.BOLETO;
//        if(random < 100)
//            tipoPagamento = TipoPagamento.DINHEIRO;

        int result = JOptionPane.showConfirmDialog(null, combo, "Tipo de Pagamento", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return;

        if (imovel.getTipoDisponibilidade() == TipoDisponibilidade.VENDER) {
            Venda v = new Venda(tipoPagamento, imovel, funcionario, imovel.getProprietarios(), cliente);
            v.executar();
            System.out.println(v);
        } else {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Número de fiadores"));
            List<Pessoa> fiadores = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Pessoa fiador = cadastrarPessoa();
                fiadores.add(fiador);
            }

            do {
                n = Integer.parseInt(JOptionPane.showInputDialog("Número de indicações (mínimo dois)"));
            } while(n < 2);
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
            System.out.println(a);
        }
    }

    public Imovel cadastrarImovel(List<ClienteProprietario> proprietarios) {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        String[] tiposImovel = {"Casa", "Apartamento", "Terreno", "Sala Comercial"};
        JComboBox<String> comboTipo = new JComboBox<>(tiposImovel);

        CardLayout cardLayout = new CardLayout();
        JPanel painelCards = new JPanel(cardLayout);

        Endereco endereco = cadastrarEndereco();

        JComboBox<TipoDisponibilidade> comboTipoDisponibilidade = new JComboBox<>(TipoDisponibilidade.values());

        /**---------CASA---------**/
        JPanel painelCasa = new JPanel(new GridLayout(0, 1));

        JTextField areaCasa = new JTextField();
        JTextField quantidadeQuartosCasa = new JTextField();
        JTextField quantidadeSalasEstarCasa = new JTextField();
        JTextField quantidadeSalasJantarCasa = new JTextField();
        JTextField quantidadeSuitesCasa = new JTextField();
        JTextField quantidadeVagasGaragemCasa = new JTextField();
        JTextField valorSugeridoCasa = new JTextField();

        painelCasa.add(new JLabel("Área"));
        painelCasa.add(areaCasa);
        painelCasa.add(new JLabel("Quantidade de Quartos"));
        painelCasa.add(quantidadeQuartosCasa);
        painelCasa.add(new JLabel("Quantidade de Salas de Estar"));
        painelCasa.add(quantidadeSalasEstarCasa);
        painelCasa.add(new JLabel("Quantidade de Salas de Jantar"));
        painelCasa.add(quantidadeSalasJantarCasa);
        painelCasa.add(new JLabel("Quantidade de Suites"));
        painelCasa.add(quantidadeSuitesCasa);
        painelCasa.add(new JLabel("Quantidade de Vagas na Garagem"));
        painelCasa.add(quantidadeVagasGaragemCasa);
        painelCasa.add(new JLabel("Por quanto deseja anunciar essa casa?"));
        painelCasa.add(valorSugeridoCasa);

        /**---------APARTAMENTO---------**/

        JPanel painelApartamento = new JPanel(new GridLayout(0, 1));

        JTextField andar = new JTextField();
        JTextField areaApartamento = new JTextField();
        JTextField quantidadeQuartosApartamento = new JTextField();
        JTextField quantidadeSalasEstarApartamento = new JTextField();
        JTextField quantidadeSalasJantarApartamento = new JTextField();
        JTextField quantidadeSuitesApartamento = new JTextField();
        JTextField quantidadeVagasGaragemApartamento = new JTextField();
        JTextField valorCondominio = new JTextField();
        JTextField valorSugeridoApartamento = new JTextField();

        painelApartamento.add(new JLabel("Andar"));
        painelApartamento.add(andar);
        painelApartamento.add(new JLabel("Área"));
        painelApartamento.add(areaApartamento);
        painelApartamento.add(new JLabel("Quantidade de Quartos"));
        painelApartamento.add(quantidadeQuartosApartamento);
        painelApartamento.add(new JLabel("Quantidade de Salas de Estar"));
        painelApartamento.add(quantidadeSalasEstarApartamento);
        painelApartamento.add(new JLabel("Quantidade de Salas de Jantar"));
        painelApartamento.add(quantidadeSalasJantarApartamento);
        painelApartamento.add(new JLabel("Quantidade de Suites"));
        painelApartamento.add(quantidadeSuitesApartamento);
        painelApartamento.add(new JLabel("Quantidade de Vagas na Garagem"));
        painelApartamento.add(quantidadeVagasGaragemApartamento);
        painelApartamento.add(new JLabel("Valor do Condomínio"));
        painelApartamento.add(valorCondominio);
        painelApartamento.add(new JLabel("Por quanto deseja anunciar esse apartamento?"));
        painelApartamento.add(valorSugeridoApartamento);

        /**---------TERRENO---------**/

        JPanel painelTerreno = new JPanel(new GridLayout(0, 1));

        JTextField comprimento = new JTextField();
        JTextField largura = new JTextField();
        JTextField valorSugeridoTerreno = new JTextField();

        painelTerreno.add(new JLabel("Comprimento"));
        painelTerreno.add(comprimento);
        painelTerreno.add(new JLabel("Largura"));
        painelTerreno.add(largura);
        painelTerreno.add(new JLabel("Por quanto deseja anunciar esse terreno?"));
        painelTerreno.add(valorSugeridoTerreno);

        /**---------SALA COMERCIAL---------**/

        JPanel painelSalaComercial = new JPanel(new GridLayout(0, 1));

        JTextField areaSalaComercial = new JTextField();
        JTextField quantidadeBanheiros = new JTextField();
        JTextField quantidadeComodos = new JTextField();
        JTextField valorSugeridoSalaComercial = new JTextField();

        painelSalaComercial.add(new JLabel("Área"));
        painelSalaComercial.add(areaSalaComercial);
        painelSalaComercial.add(new JLabel("Quantidade de Banheiros"));
        painelSalaComercial.add(quantidadeBanheiros);
        painelSalaComercial.add(new JLabel("Quantidade de Cômodos"));
        painelSalaComercial.add(quantidadeComodos);
        painelSalaComercial.add(new JLabel("Por quanto deseja anunciar essa sala comercial?"));
        painelSalaComercial.add(valorSugeridoSalaComercial);

        /**---------------------------------**/

        painelCards.add(painelCasa, "Casa");
        painelCards.add(painelApartamento, "Apartamento");
        painelCards.add(painelTerreno, "Terreno");
        painelCards.add(painelSalaComercial, "Sala Comercial");

        comboTipo.addActionListener(e -> cardLayout.show(painelCards, (String) comboTipo.getSelectedItem()));

        painelPrincipal.add(new JLabel("Tipo de Imóvel"));
        painelPrincipal.add(comboTipo);
        painelPrincipal.add(new JLabel("Disponibilidade"));
        painelPrincipal.add(comboTipoDisponibilidade);
        painelPrincipal.add(painelCards);

        int result = JOptionPane.showConfirmDialog(null, painelPrincipal, "Cadastrar Imóvel?", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return null;

        String tipoSelecionado = (String) comboTipo.getSelectedItem();
        TipoDisponibilidade tipo = (TipoDisponibilidade) comboTipoDisponibilidade.getSelectedItem();

        int resposta = JOptionPane.showConfirmDialog(null, "Cadastrar Imóvel?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            switch (tipoSelecionado) {
                case "Casa" -> {
                    Casa c = new Casa(
                            LocalDate.now(),
                            endereco,
                            proprietarios,
                            tipo,
                            this,
                            Double.parseDouble(valorSugeridoCasa.getText()),
                            Integer.parseInt(quantidadeQuartosCasa.getText()),
                            Integer.parseInt(quantidadeSuitesCasa.getText()),
                            Integer.parseInt(quantidadeSalasEstarCasa.getText()),
                            Integer.parseInt(quantidadeSalasJantarCasa.getText()),
                            Integer.parseInt(quantidadeVagasGaragemCasa.getText()),
                            Double.parseDouble(areaCasa.getText()),
                            true
                    );
                    this.imoveis.add(c);
                    return c;
                }
                case "Apartamento" -> {
                    Apartamento a = new Apartamento(
                            LocalDate.now(),
                            endereco,
                            proprietarios,
                            tipo,
                            this,
                            Double.parseDouble(valorSugeridoApartamento.getText()),
                            Integer.parseInt(quantidadeQuartosApartamento.getText()),
                            Integer.parseInt(quantidadeSuitesApartamento.getText()),
                            Integer.parseInt(quantidadeSalasEstarApartamento.getText()),
                            Integer.parseInt(quantidadeSalasJantarApartamento.getText()),
                            Integer.parseInt(quantidadeVagasGaragemApartamento.getText()),
                            Double.parseDouble(areaApartamento.getText()),
                            false,
                            Integer.parseInt(andar.getText()),
                            Double.parseDouble(valorCondominio.getText()),
                            false
                    );
                    this.imoveis.add(a);
                    return a;
                }
                case "Terreno" -> {
                    Terreno t = new Terreno(
                            LocalDate.now(),
                            endereco,
                            proprietarios,
                            tipo,
                            this,
                            Double.parseDouble(valorSugeridoTerreno.getText()),
                            Double.parseDouble(largura.getText()),
                            Double.parseDouble(comprimento.getText()),
                            false,
                            true
                    );
                    this.imoveis.add(t);
                    return t;
                }
                default -> {
                    SalaComercial sc = new SalaComercial(
                            LocalDate.now(),
                            endereco,
                            proprietarios,
                            tipo,
                            this,
                            Double.parseDouble(valorSugeridoSalaComercial.getText()),
                            Double.parseDouble(areaSalaComercial.getText()),
                            Integer.parseInt(quantidadeBanheiros.getText()),
                            Integer.parseInt(quantidadeComodos.getText())
                    );
                    this.imoveis.add(sc);
                    return sc;
                }
            }
        } else if (resposta == JOptionPane.NO_OPTION) return null;

        return null;
    }

    public Funcionario cadastrarFuncionario() {

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
            return f;
        } else if (resposta == JOptionPane.NO_OPTION) return null;

        return null;
    }

    public Cliente cadastrarCliente(Boolean ehProprietario) {

        String cpf = JOptionPane.showInputDialog("CPF do cliente");
        String nome = JOptionPane.showInputDialog("Nome do cliente");
        String email = JOptionPane.showInputDialog("Email do cliente");
        String profissao = JOptionPane.showInputDialog("Profissão do cliente");
        Endereco endereco = cadastrarEndereco();
        List<String> telefones = cadastrarTelefone();

        JComboBox<Sexo> comboSexo = new JComboBox<>(Sexo.values());
        JOptionPane.showMessageDialog(null, comboSexo);
        Sexo sexo = (Sexo) comboSexo.getSelectedItem();

        JComboBox<EstadoCivil> comboEstadoCivil = new JComboBox<>(EstadoCivil.values());
        JOptionPane.showMessageDialog(null, comboEstadoCivil);
        EstadoCivil estadoCivil = (EstadoCivil) comboEstadoCivil.getSelectedItem();

        int resposta = JOptionPane.showConfirmDialog(null, "Cadastrar cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION && ehProprietario) {
            ClienteProprietario p = new ClienteProprietario(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
            this.clientes.add(p);
            return p;
        } else if (resposta == JOptionPane.YES_OPTION && !ehProprietario) {
            Cliente c = new Cliente(cpf, nome, endereco, telefones, email, profissao, sexo, estadoCivil);
            this.clientes.add(c);
            return c;
        } else if (resposta == JOptionPane.NO_OPTION) return null;
        else throw new RuntimeException();
    }

    public Endereco cadastrarEndereco() {

        JPanel panel = new JPanel(new GridLayout(0, 1));

        JTextField bairroField = new JTextField();
        JTextField ruaField = new JTextField();
        JTextField numeroField = new JTextField();

        panel.add(new JLabel("Bairro"));
        panel.add(bairroField);
        panel.add(new JLabel("Rua"));
        panel.add(ruaField);
        panel.add(new JLabel("Número"));
        panel.add(numeroField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Endereço", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) return null;

        return new Endereco(
                bairroField.getText(),
                ruaField.getText(),
                numeroField.getText()
        );
    }

    public List<String> cadastrarTelefone() {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos telefones?"));
        if (n <= 0) return new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        List<JTextField> campos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            JTextField campo = new JTextField();
            panel.add(new JLabel("Telefone " + (i + 1)));
            panel.add(campo);
            campos.add(campo);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Telefones", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return null;

        List<String> telefones = new ArrayList<>();
        for (JTextField campo : campos) {
            telefones.add(campo.getText());
        }

        return telefones;
    }

    public Pessoa cadastrarPessoa() {

        JPanel panel = new JPanel(new GridLayout(0, 1));

        JTextField cpfField = new JTextField();
        JTextField nomeField = new JTextField();

        panel.add(new JLabel("CPF"));
        panel.add(cpfField);
        panel.add(new JLabel("Nome"));
        panel.add(nomeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro Pessoa", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return null;

        Endereco endereco = cadastrarEndereco();
        List<String> telefones = cadastrarTelefone();

        return new Pessoa(
                cpfField.getText(),
                nomeField.getText(),
                endereco,
                telefones
        );
    }

    public List<Imovel> filtrarImoveis(Predicate<Imovel> criterio) {
        return imoveis.stream()
                .filter(criterio)
                .toList();
    }

    public List<Funcionario> filtrarFuncionarios(Predicate<Funcionario> criterio) {
        return funcionarios.stream()
                .filter(criterio)
                .toList();
    }

    public List<Cliente> filtrarClientes(Predicate<Cliente> criterio) {
        return clientes.stream()
                .filter(criterio)
                .toList();
    }

    public Boolean ehProprietario() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CADASTRO DE CLIENTE");

        String escolha = "";

        do {
            System.out.print("Deseja cadastrar um [USUÁRIO] ou um [PROPRIETÁRIO]?");
            escolha = leitor.nextLine().toUpperCase();
        } while (!escolha.equals("USUÁRIO") && !escolha.equals("PROPRIETÁRIO"));

        return escolha.equals("PROPRIETÁRIO");
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

    public void adicionarComissao(Double valor) {
        this.totalComissoes += valor;
    }

    public List<Imovel> getImoveisDisponiveisTipo(TipoDisponibilidade tipo) {
        return this.imoveis.stream()
                .filter(i -> i.getDisponibilidade() == true)
                .filter(i -> i.getTipoDisponibilidade().equals(tipo))
                .toList();
    }

    public List<Imovel> getImoveis() {
        return this.imoveis;
    }

    public Double getTotalcomissoes() {
        return totalComissoes;
    }

    public List<RegistroTransacao> getTrasacoes() {
        return trasacoes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}