package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;
import main.java.imobiliaria.model.exceptions.LoginErrado;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
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

            Funcionario fu1 = new Funcionario(
                    "12345678900",
                    "João Silva",
                    endereco2,
                    telefonesFu1,
                    "VENDEDOR",
                    2500.0,
                    "joao.vendedor",
                    "senha123"
            );

            imobi.adicionarFuncionario(fu1);

            // Criando dois apartamentos
            Apartamento ap1 = new Apartamento(
                    LocalDate.of(2015, 5, 10),
                    true,
                    endereco1,
                    proprietarios1,
                    TipoDisponibilidade.VENDER,
                    3,
                    80.0,
                    true,
                    "Apartamento bem localizado",
                    true,
                    2,
                    1,
                    1,
                    1,
                    1,
                    350.0,
                    LocalDate.now(),
                    LocalDate.now().plusMonths(24),
                    imobi,
                    24000.00
            );

            Apartamento ap2 = new Apartamento(
                    LocalDate.of(2020, 8, 20),
                    false,
                    endereco2,
                    proprietarios2,
                    TipoDisponibilidade.LOCACAO,
                    10,
                    120.0,
                    false,
                    "Apartamento amplo com vista",
                    true,
                    3,
                    2,
                    1,
                    2,
                    2,
                    500.0,
                    LocalDate.now(),
                    LocalDate.now().plusMonths(24),
                    imobi,
                    24000.00
            );

        Apartamento ap3 = new Apartamento(
                LocalDate.of(2021, 8, 20),
                false,
                endereco2,
                proprietarios2,
                TipoDisponibilidade.LOCACAO,
                10,
                120.0,
                false,
                "Apartamento amplo com vista",
                true,
                3,
                2,
                1,
                2,
                2,
                500.0,
                LocalDate.now(),
                LocalDate.now().plusMonths(24),
                imobi,
                24000.00
        );

            imobi.getImoveisDisponiveisSimples().add(ap2);
            imobi.getImoveisDisponiveisSimples().add(ap1);
            imobi.getImoveisDisponiveisSimples().add(ap3);
            menu(imobi);
        }

    public static void menu(Imobiliaria imobi){
        Scanner leitor = new Scanner(System.in);

        IO.println("olá, bem vindo a imobilíaria");
        System.out.println("Digite o numero de acordo com a opção que deseja realizar");
        System.out.println("1_Cadastrar funcionario");
        System.out.println("2_Cadastrar cliente");
        System.out.println("3_Cadastrar imovel");
        System.out.println("4_Comprar imovel");
        System.out.println("5_Alugar imovel");
        System.out.println("6_Sair");
        int num = leitor.nextInt();

        if (num == 1){
            imobi.cadastrarFuncionario();
            menu(imobi);
        }
        else if (num == 2){
            // vai chamar o método chamar cadastrar cliente na class imobiliaria (mas clinte Proprietario ou usuario?
            //  sei lá, resolvam aí KKKKKKKKKKKKKKK)
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
                            Cliente cliUsu = imobi.getClientes().get(0);
                            Imovel imovelTransacionado = imobi.getImoveisDisponiveis().get(1);

                            imobi.realizarTransacao(cliUsu, fu, imovelTransacionado);

                            menu(imobi);
                            break;
                }
            }
            menu(imobi);
        }
        else if (num == 5){
            // mesma coisa do if anterior só que para aluguel
        }
        else if (num == 6){
            System.exit(0);
        }
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