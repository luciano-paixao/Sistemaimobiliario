package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Sistema {


    public static void main(String[] args) {

        // ==================== IMOBILIARIA ====================
        Imobiliaria imobi = new Imobiliaria(); // ajuste conforme seu construtor

// ==================== ENDEREÇOS ====================
        Endereco endCliente1 = new Endereco("Centro", "Rua das Palmeiras", "100");
        Endereco endCliente2 = new Endereco("Jardim América", "Av. Paulista", "200");
        Endereco endCliente3 = new Endereco("Boa Viagem", "Rua do Mar", "300");

// ==================== CLIENTES PROPRIETÁRIOS (lista de imóveis vazia por enquanto) ====================
        ClienteProprietario prop1 = new ClienteProprietario(
                "111.111.111-11", "João Silva",
                endCliente1,
                List.of("(11) 91111-1111"),
                "joao@email.com", "Empresário",
                Sexo.MASCULINO, EstadoCivil.CASADO,
                new ArrayList<>()
        );

        ClienteProprietario prop2 = new ClienteProprietario(
                "222.222.222-22", "Maria Oliveira",
                endCliente2,
                List.of("(21) 92222-2222"),
                "maria@email.com", "Médica",
                Sexo.FEMININO, EstadoCivil.SOLTEIRO,
                new ArrayList<>()
        );

        ClienteProprietario prop3 = new ClienteProprietario(
                "333.333.333-33", "Carlos Souza",
                endCliente3,
                List.of("(81) 93333-3333"),
                "carlos@email.com", "Advogado",
                Sexo.MASCULINO, EstadoCivil.DIVORCIADO,
                new ArrayList<>()
        );

// ==================== IMÓVEIS DO PROPRIETÁRIO 1 ====================
        Terreno terreno1 = new Terreno(
                LocalDate.of(2010, 5, 10),
                new Endereco("Centro", "Rua das Acácias", "10"),
                150000.0,
                List.of(prop1),
                TipoDisponibilidade.VENDER,
                LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31),
                imobi,
                false, 500.0, 25.0, true, 20.0
        );

        SalaComercial sala1 = new SalaComercial(
                LocalDate.of(2015, 3, 20),
                true,
                new Endereco("Centro", "Av. Comercial", "55"),
                List.of(prop1),
                TipoDisponibilidade.LOCACAO,
                3000.0,
                80.0, 2, 5,
                LocalDate.of(2024, 2, 1), LocalDate.of(2025, 2, 1),
                imobi
        );

        Apartamento apto1 = new Apartamento(
                LocalDate.of(2018, 7, 15),
                true,
                new Endereco("Jardim Primavera", "Rua das Flores", "200"),
                List.of(prop1),
                TipoDisponibilidade.VENDER,
                450000.0,
                5, 90.0, true, "Apartamento com vista para o parque",
                true, 3, 1, 1, 2, 1, 800.0,
                LocalDate.of(2024, 3, 1), LocalDate.of(2025, 3, 1),
                imobi
        );

        prop1.getImoveis().add(terreno1);
        prop1.getImoveis().add(sala1);
        prop1.getImoveis().add(apto1);

// ==================== IMÓVEIS DO PROPRIETÁRIO 2 ====================
        Casa casa2 = new Casa(
                LocalDate.of(2005, 8, 10),
                new Endereco("Jardim América", "Rua dos Ipês", "321"),
                List.of(prop2),
                TipoDisponibilidade.VENDER,
                600000.0,
                200.0, true, "Casa espaçosa com quintal",
                4, 1, 1, 2, 3,
                LocalDate.of(2024, 1, 15), LocalDate.of(2025, 1, 15),
                imobi
        );

        SalaComercial sala2 = new SalaComercial(
                LocalDate.of(2012, 11, 5),
                true,
                new Endereco("Centro", "Av. Principal", "900"),
                List.of(prop2),
                TipoDisponibilidade.LOCACAO,
                4500.0,
                120.0, 3, 8,
                LocalDate.of(2024, 4, 1), LocalDate.of(2025, 4, 1),
                imobi
        );

        Terreno terreno2 = new Terreno(
                LocalDate.of(2000, 1, 1),
                new Endereco("Bairro Novo", "Estrada Rural", "Km 3"),
                200000.0,
                List.of(prop2),
                TipoDisponibilidade.VENDER,
                LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1),
                imobi,
                true, 1000.0, 50.0, false, 20.0
        );

        prop2.getImoveis().add(casa2);
        prop2.getImoveis().add(sala2);
        prop2.getImoveis().add(terreno2);

// ==================== IMÓVEIS DO PROPRIETÁRIO 3 ====================
        Apartamento apto3 = new Apartamento(
                LocalDate.of(2020, 6, 30),
                true,
                new Endereco("Boa Viagem", "Av. Atlântica", "1500"),
                List.of(prop3),
                TipoDisponibilidade.VENDER,
                800000.0,
                10, 110.0, true, "Apartamento de frente para o mar",
                true, 3, 2, 1, 2, 2, 1200.0,
                LocalDate.of(2024, 6, 1), LocalDate.of(2025, 6, 1),
                imobi
        );

        Casa casa3 = new Casa(
                LocalDate.of(2008, 4, 22),
                new Endereco("Pinheiros", "Rua Harmonia", "77"),
                List.of(prop3),
                TipoDisponibilidade.LOCACAO,
                3500.0,
                150.0, false, "Casa com piscina e área gourmet",
                3, 2, 1, 1, 2,
                LocalDate.of(2024, 7, 1), LocalDate.of(2025, 7, 1),
                imobi
        );

        Terreno terreno3 = new Terreno(
                LocalDate.of(1998, 3, 14),
                new Endereco("Zona Norte", "Rua das Pedras", "40"),
                90000.0,
                List.of(prop3),
                TipoDisponibilidade.VENDER,
                LocalDate.of(2024, 8, 1), LocalDate.of(2025, 8, 1),
                imobi,
                false, 300.0, 15.0, false, 20.0
        );

        prop3.getImoveis().add(apto3);
        prop3.getImoveis().add(casa3);
        prop3.getImoveis().add(terreno3);

// ==================== IMÓVEIS DO PROPRIETÁRIO 4 ====================
        Endereco endCliente4 = new Endereco("Moema", "Rua Honduras", "400");

        ClienteProprietario prop4 = new ClienteProprietario(
                "444.444.444-44", "Fernanda Lima",
                endCliente4,
                List.of("(11) 94444-4444"),
                "fernanda@email.com", "Arquiteta",
                Sexo.FEMININO, EstadoCivil.CASADO,
                new ArrayList<>()
        );

        Casa casa4 = new Casa(
                LocalDate.of(2003, 2, 18),
                new Endereco("Moema", "Rua Itapeva", "88"),
                List.of(prop4),
                TipoDisponibilidade.VENDER,
                750000.0,
                220.0, true, "Casa moderna com área gourmet e piscina",
                4, 2, 1, 3, 4,
                LocalDate.of(2024, 9, 1), LocalDate.of(2025, 9, 1),
                imobi
        );

        Apartamento apto4 = new Apartamento(
                LocalDate.of(2019, 11, 25),
                true,
                new Endereco("Vila Mariana", "Av. Domingos de Morais", "560"),
                List.of(prop4),
                TipoDisponibilidade.LOCACAO,
                5500.0,
                8, 95.0, true, "Apartamento moderno próximo ao metrô",
                true, 2, 1, 1, 1, 1, 900.0,
                LocalDate.of(2024, 9, 1), LocalDate.of(2025, 9, 1),
                imobi
        );

        Terreno terreno4 = new Terreno(
                LocalDate.of(2001, 6, 12),
                new Endereco("Alphaville", "Rua das Amendoeiras", "15"),
                320000.0,
                List.of(prop4),
                TipoDisponibilidade.VENDER,
                LocalDate.of(2024, 9, 1), LocalDate.of(2025, 9, 1),
                imobi,
                false, 800.0, 40.0, false, 20.0
        );

        prop4.getImoveis().add(casa4);
        prop4.getImoveis().add(apto4);
        prop4.getImoveis().add(terreno4);

// ==================== IMÓVEIS DO PROPRIETÁRIO 5 ====================
        Endereco endCliente5 = new Endereco("Savassi", "Rua Pernambuco", "500");

        ClienteProprietario prop5 = new ClienteProprietario(
                "555.555.555-55", "Roberto Mendes",
                endCliente5,
                List.of("(31) 95555-5555"),
                "roberto@email.com", "Engenheiro",
                Sexo.MASCULINO, EstadoCivil.CASADO,
                new ArrayList<>()
        );

        SalaComercial sala5 = new SalaComercial(
                LocalDate.of(2016, 4, 10),
                true,
                new Endereco("Savassi", "Av. do Contorno", "1200"),
                List.of(prop5),
                TipoDisponibilidade.LOCACAO,
                6000.0,
                150.0, 4, 10,
                LocalDate.of(2024, 10, 1), LocalDate.of(2025, 10, 1),
                imobi
        );

        Apartamento apto5 = new Apartamento(
                LocalDate.of(2021, 3, 8),
                true,
                new Endereco("Lourdes", "Rua Maranhão", "340"),
                List.of(prop5),
                TipoDisponibilidade.VENDER,
                920000.0,
                15, 130.0, true, "Cobertura com terraço e vista panorâmica",
                true, 4, 2, 1, 3, 2, 1500.0,
                LocalDate.of(2024, 10, 1), LocalDate.of(2025, 10, 1),
                imobi
        );

        Terreno terreno5 = new Terreno(
                LocalDate.of(1995, 9, 20),
                new Endereco("Caiçara", "Rua Padre Eustáquio", "22"),
                110000.0,
                List.of(prop5),
                TipoDisponibilidade.VENDER,
                LocalDate.of(2024, 10, 1), LocalDate.of(2025, 10, 1),
                imobi,
                true, 450.0, 30.0, false, 15.0
        );

        prop5.getImoveis().add(sala5);
        prop5.getImoveis().add(apto5);
        prop5.getImoveis().add(terreno5);

// ==================== IMÓVEIS DO PROPRIETÁRIO 6 ====================
        Endereco endCliente6 = new Endereco("Meireles", "Av. Beira Mar", "600");

        ClienteProprietario prop6 = new ClienteProprietario(
                "666.666.666-66", "Patrícia Alves",
                endCliente6,
                List.of("(85) 96666-6666"),
                "patricia@email.com", "Professora",
                Sexo.FEMININO, EstadoCivil.VIUVO,
                new ArrayList<>()
        );

        Casa casa6 = new Casa(
                LocalDate.of(2011, 7, 30),
                new Endereco("Aldeota", "Rua Silva Jatahy", "190"),
                List.of(prop6),
                TipoDisponibilidade.VENDER,
                480000.0,
                180.0, false, "Casa ampla com jardim e varanda",
                3, 1, 1, 1, 2,
                LocalDate.of(2024, 11, 1), LocalDate.of(2025, 11, 1),
                imobi
        );

        SalaComercial sala6 = new SalaComercial(
                LocalDate.of(2014, 5, 17),
                true,
                new Endereco("Centro", "Av. Monsenhor Tabosa", "800"),
                List.of(prop6),
                TipoDisponibilidade.LOCACAO,
                3800.0,
                100.0, 2, 6,
                LocalDate.of(2024, 11, 1), LocalDate.of(2025, 11, 1),
                imobi
        );

        Apartamento apto6 = new Apartamento(
                LocalDate.of(2022, 1, 14),
                true,
                new Endereco("Meireles", "Av. Beira Mar", "1000"),
                List.of(prop6),
                TipoDisponibilidade.VENDER,
                700000.0,
                12, 105.0, true, "Apartamento com varanda e vista para o mar",
                true, 3, 1, 1, 2, 1, 1100.0,
                LocalDate.of(2024, 11, 1), LocalDate.of(2025, 11, 1),
                imobi
        );

        prop6.getImoveis().add(casa6);
        prop6.getImoveis().add(sala6);
        prop6.getImoveis().add(apto6);

// ==================== CLIENTES ====================
        Endereco endCli1 = new Endereco("Consolação", "Rua Augusta", "750");
        Endereco endCli2 = new Endereco("Copacabana", "Av. Nossa Senhora de Copacabana", "320");

        Cliente cli1 = new Cliente(
                "777.777.777-77", "Lucas",
                endCli1,
                "lucas@email.com", "Analista de Sistemas",
                Sexo.MASCULINO, EstadoCivil.SOLTEIRO
        );

        Cliente cli2 = new Cliente(
                "888.888.888-88", "Juliana",
                endCli2,
                "juliana@email.com", "Designer",
                Sexo.FEMININO, EstadoCivil.CASADO
        );

        Endereco endereco1 = new Endereco("Jardim Primavera", "Rua das Flores", "123");
        Endereco endereco2 = new Endereco("Centro", "Av. Brasil", "456");
        Endereco endereco3 = new Endereco("Bela Vista", "Rua Sete de Setembro", "789");

        Funcionario func1 = new Funcionario("123.456.789-00", "Ana Souza", endereco1, "GERENTE", 5000.0, "ana.souza", "senha123");
        Funcionario func2 = new Funcionario("987.654.321-00", "Carlos Lima", endereco2, "VENDEDOR", 2500.0, "carlos.lima", "senha456");
        Funcionario func3 = new Funcionario("456.789.123-00", "Mariana Costa", endereco3, "ANALISTA", 3800.0, "mariana.costa", "senha789");


        imobi.adicionarFuncionario(func1);
        imobi.adicionarFuncionario(func2);
        imobi.adicionarFuncionario(func3);

            imobi.getClientes().add(cli1);
            imobi.getClientes().add(cli2);
            imobi.getClientes().add(prop1);
            imobi.getClientes().add(prop2);

            imobi.getImoveisDisponiveisSimples().add(terreno1);
            imobi.getImoveisDisponiveisSimples().add(terreno2);
            imobi.getImoveisDisponiveisSimples().add(terreno3);
            imobi.getImoveisDisponiveisSimples().add(terreno4);
            imobi.getImoveisDisponiveisSimples().add(terreno5);

            imobi.getImoveisDisponiveisSimples().add(casa2);
        imobi.getImoveisDisponiveisSimples().add(casa3);
            imobi.getImoveisDisponiveisSimples().add(sala1);
        imobi.getImoveisDisponiveisSimples().add(sala2);
            imobi.getImoveisDisponiveisSimples().add(apto1);
        imobi.getImoveisDisponiveisSimples().add(apto3);


            menu(imobi);
        }

    public static void menu(Imobiliaria imobi){
        Scanner leitor = new Scanner(System.in);

        IO.println("olá, bem vindo a imobilíaria");
        System.out.println("Digite o numero de acordo com a opção que deseja realizar");
        System.out.println("1_Cadastrar funcionario");
        System.out.println("2_Cadastrar cliente");
        System.out.println("3_Cadastrar imóvel");
        System.out.println("4_Comprar ou Alugar imóvel");
        System.out.println("5_Sair");
        int num = leitor.nextInt();

        if (num == 1){
            imobi.cadastrarFuncionario();
        }
        else if (num == 2){
            Boolean ehProprietario = imobi.ehProprietario();
            imobi.cadastrarCliente(ehProprietario);
        }
        else if (num == 3){
            // imobi.cadastarImovel(clienteProprietario); colocar um objeto já pronto
        }
        else if (num == 4) {
            IO.println("Nosso vendedor vai o ajudar...");
            for(Funcionario fu : imobi.funcionarios){
                if (fu.getCargo().equals("VENDEDOR")){
                    System.out.println("Vendedor digite usuario e senha para entrar no sistema!");
                            // Usando
                            Integer escolha = 0;

                            Cliente cliUsu = null;
                            Imovel imoEscolhido = null;

                            while(escolha != 1 && escolha != 2) {
                                System.out.println("(1) Criar novo usuário\n(2) Procurar na Lista de Usuários\n");
                                escolha = leitor.nextInt();
                            }
                            if(escolha == 2) {
                                System.out.println("LISTA USUÁRIOS:");
                                for(Cliente cli: imobi.clientes) {
                                    if(!(cli instanceof ClienteProprietario)) {
                                        IO.println(cli.getNome());
                                    }
                                }
                                System.out.println("Digite o nome do cliente interessado (usuário):");
                                String nomeBusca = leitor.next();
                                cliUsu = imobi.buscarUsuario(nomeBusca);
                            } else {
                                cliUsu = imobi.cadastrarCliente(false);
                            }

                            if(cliUsu == null) {
                                System.out.println("\n!! Usuário não existe !!\n");
                                menu(imobi);
                                break;
                            }

                            int tipoOption = 0;
                            while(tipoOption != 1 && tipoOption != 2) {
                                System.out.println("\nTipo: [1]ALUGUEL ou [2]VENDA...\n");
                                tipoOption = leitor.nextInt();
                            }
                            TipoDisponibilidade tipo = (tipoOption == 1) ?
                                                        TipoDisponibilidade.LOCACAO :
                                                        TipoDisponibilidade.VENDER;

                            System.out.println("\nBUSCANDO IMÓVEIS DISPONÍVEIS...\n");
                            escolha = 0;

                            for(Imovel imovel: imobi.getImoveisDisponiveisTipo(tipo)) {
                                System.out.println(imovel.toString());
                                System.out.println("(1) Escolher este imóvel\n(2) Próximo\n");
                                escolha = leitor.nextInt();

                                if(escolha == 1) {
                                    imoEscolhido = imovel;
                                    break;
                                }
                            }

                            if(cliUsu == null) {
                                System.out.println("\n!! Usuário não existe !!\n");
                                menu(imobi);
                                break;
                            }
                            if(imoEscolhido == null) {
                                System.out.println("\n!! Nenhum imóvel escolhido !!\n");
                                menu(imobi);
                                break;
                            }

                            imobi.realizarTransacao(cliUsu, fu, imoEscolhido);

                            menu(imobi);
                            break;
                }
            }
        }
        else if (num == 5){
            System.exit(0);
        }
        menu(imobi);
    }
}





/*

            for(Funcionario fu : imobi.funcionarios){
                if (fu.getCargo().equals("VENDEDOR")){
                    System.out.println("Vendedor digite usuario e senha para entrar no sistema!");
                    try{
                        if (fu.login(fu.getUsuario(), fu.getSenha())) {
                            // Usando
                            Cliente cliUsu = imobi.getClientes().get(0);
                            Imovel imovelTransacionado = imobi.getImoveisDisponiveis().get(0);

                            imobi.realizarTransacao(cliUsu, fu, imovelTransacionado);
                            menu(imobi);
                            break;
                        } else {
                            throw new LoginErrado();
                        }
                    } catch (LoginErrado e){
                        System.out.println(e);
                        menu(imobi);
                    }
                }
            }


 */