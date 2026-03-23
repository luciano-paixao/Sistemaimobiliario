package main.java;

import main.java.imobiliaria.model.*;
import main.java.imobiliaria.model.enums.EstadoCivil;
import main.java.imobiliaria.model.enums.Sexo;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Imobiliaria imobiliaria = new Imobiliaria();

        List<ClienteProprietario> p = new ArrayList<>();

        Funcionario funcionario = imobiliaria.cadastrarFuncionario();
        System.out.println(funcionario);

        Cliente usuario = imobiliaria.cadastrarCliente(true);
        System.out.println(usuario);

        Imovel imovel1 = imobiliaria.cadastrarImovel(p);
        System.out.println(imovel1);

        System.out.println(funcionario.getComissoes());
        System.out.println(imobiliaria.getImoveisDisponiveis(imobiliaria.getImoveis()));


// ==================== UTILS ====================
        Endereco endCliente1 = new Endereco("Centro", "Rua das Palmeiras", "100");
        Endereco endCliente2 = new Endereco("Jardim América", "Av. Paulista", "200");
        Endereco endCliente3 = new Endereco("Boa Viagem", "Rua do Mar", "300");

        List<String> telefones1 = new ArrayList<>();
        String telefone1 = "(00)00000-0000";
        telefones1.add(telefone1);

        List<String> telefones2 = new ArrayList<>();
        String telefone2 = "(00)00000-0000";
        telefones2.add(telefone2);

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
                imobiliaria,
                250000.0,
                20.0,
                30.0,
                false,
                false
        );

        SalaComercial sala1 = new SalaComercial(
                LocalDate.of(2015, 3, 20),
                new Endereco("Centro", "Av. Comercial", "55"),
                proprietarios1,
                TipoDisponibilidade.LOCACAO,
                imobiliaria,
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
                imobiliaria,
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
                imobiliaria,
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
                imobiliaria,
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
                imobiliaria,
                150000.0,
                20.0,
                10.0,
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
                "777.777.777-77",
                "Lucas Ferreira",
                endCli1,
                telefones1,
                "lucas@email.com",
                "Analista de Sistemas",
                Sexo.MASCULINO,
                EstadoCivil.SOLTEIRO
        );

        Cliente cli2 = new Cliente(
                "888.888.888-88", "Juliana Castro",
                endCli2,
                telefones2,
                "juliana@email.com",
                "Designer",
                Sexo.FEMININO,
                EstadoCivil.CASADO
        );

        System.out.println(funcionario.getComissoes());
        System.out.println(imobiliaria.getTotalcomissoes());

        imobiliaria.realizarTransacao(cli1, funcionario, casa2);

        System.out.println(funcionario.getComissoes());
        System.out.println(imobiliaria.getTotalcomissoes());
    }
}