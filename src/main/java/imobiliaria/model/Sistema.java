package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Sistema {


    public static void main(String[] args) {

        Imobiliaria i = new Imobiliaria();

        List<ClienteProprietario> p = new ArrayList<>();

        Cliente usuario = i.cadastrarCliente(true);
        System.out.println(usuario);

        Imovel imovel1 = i.cadastrarImovel(p);
        System.out.println(imovel1);

        System.out.println(i.getImoveisDisponiveis(i.getImoveis()));


// ==================== ENDEREÇOS ====================
        Endereco endCliente1 = new Endereco("Centro", "Rua das Palmeiras", "100");
        Endereco endCliente2 = new Endereco("Jardim América", "Av. Paulista", "200");
        Endereco endCliente3 = new Endereco("Boa Viagem", "Rua do Mar", "300");

// ==================== CLIENTES PROPRIETÁRIOS (lista de imóveis vazia por enquanto) ====================

        List<ClienteProprietario> proprietarios1 = new ArrayList<>();
        List<ClienteProprietario> proprietarios2 = new ArrayList<>();
        List<ClienteProprietario> proprietarios3 = new ArrayList<>();

        ClienteProprietario prop1 = new ClienteProprietario(
                "111.111.111-11", "João Silva",
                endCliente1,
                List.of("(11) 91111-1111"),
                "joao@email.com", "Empresário",
                Sexo.MASCULINO, EstadoCivil.CASADO,
                new ArrayList<>()
        );

        proprietarios1.add(prop1);

        ClienteProprietario prop2 = new ClienteProprietario(
                "222.222.222-22", "Maria Oliveira",
                endCliente2,
                List.of("(21) 92222-2222"),
                "maria@email.com", "Médica",
                Sexo.FEMININO, EstadoCivil.SOLTEIRO,
                new ArrayList<>()
        );

        proprietarios2.add(prop2);

// ==================== IMÓVEIS DO PROPRIETÁRIO 1 ====================
        Terreno terreno1 = new Terreno(
                LocalDate.of(2010, 5, 10),
                new Endereco("Centro", "Rua das Acácias", "10"),
                proprietarios1,
                TipoDisponibilidade.VENDER,
                i,
                250000.0,
                20.0,
                30.0,
                600.0,
                false,
                false
        );

        SalaComercial sala1 = new SalaComercial(
                LocalDate.of(2015, 3, 20),
                new Endereco("Centro", "Av. Comercial", "55"),
                proprietarios1,
                TipoDisponibilidade.LOCACAO,
                i,
                1700.0,
                200.0,
                1,
                1
        );

        Apartamento apto1 = new Apartamento(
                LocalDate.of(2018, 7, 15),
                new Endereco("Jardim Primavera", "Rua das Flores", "200"),
                proprietarios1,
                TipoDisponibilidade.VENDER,
                i,
                3600.0,
                5,
                3,
                4,
                3,
                3,
                1500.0,
                false,
                2,
                3500.0,
                true
        );

        prop1.getImoveis().add(terreno1);
        prop1.getImoveis().add(sala1);
        prop1.getImoveis().add(apto1);

        // ==================== IMÓVEIS DO PROPRIETÁRIO 2 ====================

        Casa casa2 = new Casa(
                LocalDate.of(2005, 8, 10),
                new Endereco("Jardim América", "Rua dos Ipês", "321"),
                proprietarios2,
                TipoDisponibilidade.VENDER,
                i,
                6000.0,
                2,
                3,
                4,
                4,
                1,
                900.0,
                true
        );

        SalaComercial sala2 = new SalaComercial(
                LocalDate.of(2012, 11, 5),
                new Endereco("Centro", "Av. Principal", "900"),
                proprietarios2,
                TipoDisponibilidade.LOCACAO,
                i,
                4500.0,
                600.0,
                3,
                2
        );

        Terreno terreno2 = new Terreno(
                LocalDate.of(2000, 1, 1),
                new Endereco("Bairro Novo", "Estrada Rural", "Km 3"),
                proprietarios2,
                TipoDisponibilidade.VENDER,
                i,
                150000.0,
                20.0,
                10.0,
                200.0,
                true,
                false
        );

        prop2.getImoveis().add(casa2);
        prop2.getImoveis().add(sala2);
        prop2.getImoveis().add(terreno2);

// ==================== CLIENTES ====================
        Endereco endCli1 = new Endereco("Consolação", "Rua Augusta", "750");
        Endereco endCli2 = new Endereco("Copacabana", "Av. Nossa Senhora de Copacabana", "320");

        Cliente cli1 = new Cliente(
                "777.777.777-77", "Lucas Ferreira",
                endCli1,
                "lucas@email.com", "Analista de Sistemas",
                Sexo.MASCULINO, EstadoCivil.SOLTEIRO
        );

        Cliente cli2 = new Cliente(
                "888.888.888-88", "Juliana Castro",
                endCli2,
                "juliana@email.com", "Designer",
                Sexo.FEMININO, EstadoCivil.CASADO
        );
        menu(i);

    }

    public static void menu(Imobiliaria imobi) {
        Scanner leitor = new Scanner(System.in);

        IO.println("olá, bem vindo a imobilíaria");
        System.out.println("Digite o numero de acordo com a opção que deseja realizar");
        System.out.println("1_Cadastrar funcionario");
        System.out.println("2_Cadastrar cliente");
        System.out.println("3_Cadastrar imóvel");
        System.out.println("4_Comprar ou Alugar imóvel");
        System.out.println("5_Sair");
        int num = leitor.nextInt();

        if (num == 1) {
            imobi.cadastrarFuncionario();
        } else if (num == 2) {
            imobi.cadastrarCliente(imobi.ehProprietario());
            menu(imobi);
        } else if (num == 3) {
            menu(imobi);
            //imobi.cadastrarImovel()
            // imobi.cadastarImovel(clienteProprietario); colocar um objeto já pronto
        } else if (num == 4) {
            IO.println("Nosso vendedor vai o ajudar...");
            for (Funcionario fu : imobi.funcionarios) {
                if (fu.getCargo().equals("VENDEDOR")) {
                    System.out.println("Vendedor digite usuario e senha para entrar no sistema!");
                    // Usando
                    Integer escolha = 0;

                    Cliente cliUsu = null;
                    Imovel imoEscolhido = null;

                    while (escolha != 1 && escolha != 2) {
                        System.out.println("(1) Criar novo usuário\n(2) Procurar na Lista de Usuários\n");
                        escolha = leitor.nextInt();
                    }
                    if (escolha == 2) {
                        System.out.println("Digite o nome do cliente interessado (usuário):");
                        String nomeBusca = leitor.next();
                        cliUsu = imobi.buscarUsuario(nomeBusca);
                    } else {
                        cliUsu = imobi.cadastrarCliente(false);
                    }

                    if (cliUsu == null) {
                        System.out.println("\n!! Usuário não existe !!\n");
                        menu(imobi);
                        break;
                    }

                    int tipoOption = 0;
                    while (tipoOption != 1 && tipoOption != 2) {
                        System.out.println("\nTipo: [1]ALUGUEL ou [2]VENDA...\n");
                        tipoOption = leitor.nextInt();
                    }
                    TipoDisponibilidade tipo = (tipoOption == 1) ?
                            TipoDisponibilidade.LOCACAO :
                            TipoDisponibilidade.VENDER;

                    System.out.println("\nBUSCANDO IMÓVEIS DISPONÍVEIS...\n");
                    escolha = 0;

                    for (Imovel imovel : imobi.getImoveisDisponiveisTipo(tipo)) {
                        System.out.println(imovel.toString());
                        System.out.println("(1) Escolher este imóvel\n(2) Próximo\n");
                        escolha = leitor.nextInt();


                        if (escolha == 1) {
                            imoEscolhido = imovel;
                            break;
                        }
                    }

                    if (cliUsu == null) {
                        System.out.println("\n!! Usuário não existe !!\n");
                        menu(imobi);
                        break;
                    }
                    if (imoEscolhido == null) {
                        System.out.println("\n!! Nenhum imóvel escolhido !!\n");
                        menu(imobi);
                        break;
                    }

                    imobi.realizarTransacao(cliUsu, fu, imoEscolhido);

                    menu(imobi);
                    break;
                }
            }
        } else if (num == 5) {
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
