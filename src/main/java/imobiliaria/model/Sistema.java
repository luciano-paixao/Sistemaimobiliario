package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Sistema {
    public static void main(String[] args) {
        
        Imobiliaria imobi = new Imobiliaria();

        // =========== ENDEREÇOS ===========
        Endereco endereco1 = new Endereco("Jardim Primavera", "Rua das Flores", "123");
        Endereco endereco2 = new Endereco("Centro", "Av. Brasil", "456");
        Endereco endereco3 = new Endereco("Bela Vista", "Rua Sete de Setembro", "789");
        Endereco endereco4 = new Endereco("Boa Viagem", "Rua do Mar", "300");
        Endereco endereco5 = new Endereco("Jardim América", "Av. Paulista", "200");

         // =========== FUNCIONÁRIOS ===========

        Funcionario func1 = new Funcionario("123.456.789-00", "Ana Souza", endereco1, "GERENTE", 5000.0, "ana.souza", "senha123");
        Funcionario func2 = new Funcionario("987.654.321-00", "Carlos Lima", endereco2, "VENDEDOR", 2500.0, "carlos.lima", "senha456");
        Funcionario func3 = new Funcionario("456.789.123-00", "Mariana Costa", endereco3, "ANALISTA", 3800.0, "mariana.costa", "senha789");

        imobi.adicionarFuncionario(func1);
        imobi.adicionarFuncionario(func2);
        imobi.adicionarFuncionario(func3);

        // =========== CLIENTES ===========
        Cliente cli1 = new Cliente(
                "777.777.777-77", "Lucas",
                endereco1, List.of("(31) 3131-3131"),
                "lucas@email.com", "Analista de Sistemas",
                Sexo.MASCULINO, EstadoCivil.SOLTEIRO
        );

        Cliente cli2 = new Cliente(
                "888.888.888-88", "Juliana",
                endereco2, List.of("(85) 98989-8989"),
                "juliana@email.com", "Designer",
                Sexo.FEMININO, EstadoCivil.CASADO
        );

        imobi.getClientes().add(cli1);
        imobi.getClientes().add(cli2);

        // =========== PROPRIETÁRIOS ===========
        ClienteProprietario prop1 = new ClienteProprietario(
                "111.111.111-11", "João Silva",
                endereco4,
                List.of("(11) 91111-1111"),
                "joao@email.com", "Empresário",
                Sexo.MASCULINO, EstadoCivil.CASADO,
                new ArrayList<>()
        );

        ClienteProprietario prop2 = new ClienteProprietario(
                "222.222.222-22", "Maria Oliveira",
                endereco5,
                List.of("(21) 92222-2222"),
                "maria@email.com", "Médica",
                Sexo.FEMININO, EstadoCivil.SOLTEIRO,
                new ArrayList<>()
        );

        ClienteProprietario prop3 = new ClienteProprietario(
                "333.333.333-33", "Carlos Souza",
                endereco4,
                List.of("(81) 93333-3333"),
                "carlos@email.com", "Advogado",
                Sexo.MASCULINO, EstadoCivil.DIVORCIADO,
                new ArrayList<>()
        );

        imobi.getClientes().add(prop1);
        imobi.getClientes().add(prop2);
        imobi.getClientes().add(prop3);

        // =========== IMÓVEIS DO PROPRIETÁRIO 1 ===========
        Terreno terreno1 = new Terreno(
                LocalDate.of(2010, 5, 10),      // dataConstrucao
                new Endereco("Centro", "Rua das Acácias", "10"), // endereco
                List.of(prop1),                 // proprietario(s)
                TipoDisponibilidade.VENDER,     // tipoDisponibilidade
                imobi,                          // imobiliaria
                150000.0,                       // valorSugerido
                20.0,                           // largura
                25.0,                           // comprimento
                false,                          // aclive
                true                            // declive
        );

        SalaComercial sala1 = new SalaComercial(
                LocalDate.of(2015, 3, 20),
                new Endereco("Centro", "Av. Comercial", "55"),
                List.of(prop1),
                TipoDisponibilidade.LOCACAO,
                imobi,
                3000.0,
                80.0,
                2,
                5
        );

        Apartamento apto1 = new Apartamento(
                LocalDate.of(2018, 7, 15),
                new Endereco("Jardim Primavera", "Rua das Flores", "200"),
                List.of(prop1),
                TipoDisponibilidade.VENDER,
                imobi,
                450000.0,
                3, // quantidadeQuartos
                1, // quantidadeSuites
                1, // quantidadeSalasEstar
                2, // quantidadeSalasJantar
                1, // quantidadeVagasGaragem
                90.0, // area
                true, // armarioEmbutido
                5, // andar
                800.0, // valorCondominio
                true // portaria24hs
        );

        prop1.getImoveis().add(terreno1);
        prop1.getImoveis().add(sala1);
        prop1.getImoveis().add(apto1);

        // =========== IMÓVEIS DO PROPRIETÁRIO 2 ===========
        Casa casa2 = new Casa(
                LocalDate.of(2005, 8, 10),
                new Endereco("Jardim América", "Rua dos Ipês", "321"),
                List.of(prop2),
                TipoDisponibilidade.VENDER,
                imobi,
                600000.0,
                4, // quartos
                1, // suites
                1, // salasEstar
                2, // salasJantar
                3, // vagas
                200.0, // area
                true // armarioEmbutido
        );


        Terreno terreno2 = new Terreno(
                LocalDate.of(2000, 1, 1),
                new Endereco("Bairro Novo", "Estrada Rural", "Km 3"),
                List.of(prop2),
                TipoDisponibilidade.VENDER,
                imobi,
                200000.0,
                50.0,
                20.0,
                true,
                false
        );

        SalaComercial sala2 = new SalaComercial(
                LocalDate.of(2012, 11, 5),
                new Endereco("Centro", "Av. Principal", "900"),
                List.of(prop2),
                TipoDisponibilidade.LOCACAO,
                imobi,
                4500.0,
                120.0,
                3,
                8
        );

        prop2.getImoveis().add(casa2);
        prop2.getImoveis().add(sala2);
        prop2.getImoveis().add(terreno2);

        // =========== IMÓVEIS DO PROPRIETÁRIO 3 ===========
        Apartamento apto3 = new Apartamento(
                LocalDate.of(2020, 6, 30),
                new Endereco("Boa Viagem", "Av. Atlântica", "1500"),
                List.of(prop3),
                TipoDisponibilidade.VENDER,
                imobi,
                800000.0,
                3,
                2,
                1,
                2,
                2,
                110.0,
                true,
                10,
                1200.0,
                true
        );

        Casa casa3 = new Casa(
                LocalDate.of(2008, 4, 22),
                new Endereco("Pinheiros", "Rua Harmonia", "77"),
                List.of(prop3),
                TipoDisponibilidade.LOCACAO,
                imobi,
                3500.0,
                3,
                2,
                1,
                1,
                2,
                150.0,
                false
        );

        Terreno terreno3 = new Terreno(
                LocalDate.of(1998, 3, 14),
                new Endereco("Zona Norte", "Rua das Pedras", "40"),
                List.of(prop3),
                TipoDisponibilidade.VENDER,
                imobi,
                90000.0,
                15.0,
                20.0,
                false,
                false
        );

        prop3.getImoveis().add(apto3);
        prop3.getImoveis().add(casa3);
        prop3.getImoveis().add(terreno3);

        imobi.adicionarImovel(terreno1);
        imobi.adicionarImovel(terreno2);
        imobi.adicionarImovel(terreno3);
        imobi.adicionarImovel(terreno4);
        imobi.adicionarImovel(terreno5);

        imobi.adicionarImovel(casa2);
        imobi.adicionarImovel(casa4);
        imobi.adicionarImovel(casa3);

        imobi.adicionarImovel(sala1);
        imobi.adicionarImovel(sala2);
        imobi.adicionarImovel(sala5);

        imobi.adicionarImovel(apto1);
        imobi.adicionarImovel(apto4);
        imobi.adicionarImovel(apto3);

        menu(imobi);
    }

    public static void menu(Imobiliaria imobi) {

        JFrame frame = new JFrame("Imobiliária");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        // ===== MENU PRINCIPAL =====
        JPanel menuPanel = new JPanel(new GridLayout(0, 1));

        JButton btnFunc = new JButton("Cadastrar Funcionário");
        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnImovel = new JButton("Cadastrar Imóvel");
        JButton btnTransacao = new JButton("Comprar / Alugar");
        JButton btnSair = new JButton("Sair");

        menuPanel.add(btnFunc);
        menuPanel.add(btnCliente);
        menuPanel.add(btnImovel);
        menuPanel.add(btnTransacao);
        menuPanel.add(btnSair);

        // ===== PAINEL TRANSAÇÃO =====
        JPanel transacaoPanel = new JPanel(new GridLayout(0, 1));

        JComboBox<Cliente> comboClientes = new JComboBox<>(
                imobi.clientes.stream()
                        .filter(c -> !(c instanceof ClienteProprietario))
                        .toArray(Cliente[]::new)
        );

        JComboBox<Funcionario> comboFuncionarios = new JComboBox<>(
                imobi.funcionarios.stream()
                        .filter(f -> f.getCargo().equals("VENDEDOR"))
                        .toArray(Funcionario[]::new)
        );

        JComboBox<TipoDisponibilidade> comboTipo = new JComboBox<>(TipoDisponibilidade.values());

        JButton btnBuscarImoveis = new JButton("Buscar Imóveis");
        JComboBox<Imovel> comboImoveis = new JComboBox<>();

        JButton btnConfirmar = new JButton("Confirmar Transação");
        JButton btnVoltar = new JButton("Voltar");

        transacaoPanel.add(new JLabel("Cliente"));
        transacaoPanel.add(comboClientes);

        transacaoPanel.add(new JLabel("Funcionário"));
        transacaoPanel.add(comboFuncionarios);

        transacaoPanel.add(new JLabel("Tipo"));
        transacaoPanel.add(comboTipo);

        transacaoPanel.add(btnBuscarImoveis);
        transacaoPanel.add(comboImoveis);

        transacaoPanel.add(btnConfirmar);
        transacaoPanel.add(btnVoltar);

        // ===== AÇÕES =====

        btnFunc.addActionListener(e -> imobi.cadastrarFuncionario());

        btnCliente.addActionListener(e -> {
            imobi.cadastrarCliente(false);
        });

        btnImovel.addActionListener(e -> {
            List<ClienteProprietario> props = imobi.getClientes().stream()
                    .filter(c -> c instanceof ClienteProprietario)
                    .map(c -> (ClienteProprietario) c)
                    .toList();

            imobi.cadastrarImovel(props);
        });

        btnTransacao.addActionListener(e -> cardLayout.show(container, "TRANSACAO"));

        btnSair.addActionListener(e -> System.exit(0));

        btnVoltar.addActionListener(e -> cardLayout.show(container, "MENU"));

        btnBuscarImoveis.addActionListener(e -> {
            comboImoveis.removeAllItems();

            TipoDisponibilidade tipo = (TipoDisponibilidade) comboTipo.getSelectedItem();

            for (Imovel im : imobi.getImoveisDisponiveisTipo(tipo)) {
                comboImoveis.addItem(im);
            }
        });

        btnConfirmar.addActionListener(e -> {
            Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            Funcionario func = (Funcionario) comboFuncionarios.getSelectedItem();
            Imovel imovel = (Imovel) comboImoveis.getSelectedItem();

            if (cliente != null && func != null && imovel != null) {
                imobi.realizarTransacao(cliente, func, imovel);
            } else {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            }
        });

        // ===== CARDS =====
        container.add(menuPanel, "MENU");
        container.add(transacaoPanel, "TRANSACAO");

        frame.add(container);
        frame.setVisible(true);
    }
}
