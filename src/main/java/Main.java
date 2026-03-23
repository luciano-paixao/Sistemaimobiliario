package main.java;

import main.java.imobiliaria.model.Cliente;
import main.java.imobiliaria.model.Funcionario;
import main.java.imobiliaria.model.Imobiliaria;
import main.java.imobiliaria.model.Sistema;

public class Main {
    public static void main(String[] args) {
        Sistema.main(new String[]{});

        // VOSSA VERSÃO
//    public static void main(String[] args) {
//        Imobiliaria i = new Imobiliaria();
//
//        for (int j = 0; j < 2; j++) {
//            i.cadastarCliente();
//        }
//
//        for (Cliente c : i.getClientes()) {
//            System.out.println(c);
//        }
//
//        for (Funcionario f : i.getFuncionarios()) {
//            System.out.println(f);
//        }
//    }
    }
}
