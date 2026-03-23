package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Sistema {


    public static void main(String[] args) {

        Imobiliaria imobi = new Imobiliaria();

        // Lista de proprietários (exemplo simples)
        List<ClienteProprietario> proprietarios1 = new ArrayList<>();
        List<ClienteProprietario> proprietarios2 = new ArrayList<>();

        // Objetos auxiliares (supondo construtores básicos)
        Endereco endereco1 = new Endereco("Rua A", "123", "Centro");
        Endereco endereco2 = new Endereco("Rua B", "456", "Bairro X");

        // USUÁRIO

        Cliente cli1 = new Cliente("12312312345", "Semfim", endereco1, "teste@hotmail.com", "Qualqueruma", Sexo.FEMININO, EstadoCivil.DIVORCIADO);
        imobi.adicionarCliente(cli1);

        List<String> telefonesFu1 = new ArrayList<>();
        telefonesFu1.add("(91) 98888-7777");


        // PROPRIETÁRIO

        Endereco enderecoProp = new Endereco("Avenida Nazaré", "1000", "Centro");

        ClienteProprietario novoProprietario = new ClienteProprietario(
                "98765432100",
                "Maria Oliveira",
                enderecoProp,
                "maria.oliveira@email.com",
                "Engenheira",
                Sexo.FEMININO,
                EstadoCivil.CASADO
        );
        proprietarios1.add(novoProprietario);
        imobi.adicionarCliente(novoProprietario);

        Funcionario fu1 = new Funcionario(
                "12345678900",
                "José Roberto",
                endereco2,
                telefonesFu1,
                "VENDEDOR",
                2500.0,
                "jose.vendedor",
                "senha123"
        );

        imobi.adicionarFuncionario(fu1);

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
            //Boolean ehProprietario = imobi.ehProprietario();
            imobi.cadastrarCliente(imobi.ehProprietario());
        } else if (num == 3) {
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
