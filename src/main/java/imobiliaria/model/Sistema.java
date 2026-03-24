package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Imobiliaria imobiliaria = new Imobiliaria();

        menu(imobiliaria);
    }

    public static void menu(Imobiliaria imobi) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Olá! bem vindo a imobilíaria");
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
            System.out.println("Nosso vendedor vai o ajudar...");
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
