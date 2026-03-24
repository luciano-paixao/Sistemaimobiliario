package main.java.imobiliaria.model.filtros;

import main.java.imobiliaria.model.*;
import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.util.function.Predicate;

public class ImovelFiltro {

    public static Predicate<Imovel> porBairro(String bairro) {
        return i -> i.getEndereco().getBairro().equalsIgnoreCase(bairro);
    }

    public static Predicate<Imovel> disponiveis() {
        return Imovel::getDisponibilidade;
    }

    public static Predicate<Imovel> indisponiveis() {
        return i -> !i.getDisponibilidade();
    }

    public static Predicate<Imovel> porPrecoMin(double valor) {
        return i -> i.getValorSugerido() >= valor;
    }

    public static Predicate<Imovel> porPrecoMax(double valor) {
        return i -> i.getValorSugerido() <= valor;
    }

    public static Predicate<Imovel> porFaixaPreco(double min, double max) {
        return i -> i.getValorSugerido() >= min && i.getValorSugerido() <= max;
    }

    public static Predicate<Imovel> porTipoDisponibilidade(TipoDisponibilidade tipo) {
        return i -> i.getTipoDisponibilidade() == tipo;
    }

    public static Predicate<Imovel> casas() {
        return i -> i instanceof Casa;
    }

    public static Predicate<Imovel> apartamentos() {
        return i -> i instanceof Apartamento;
    }

    public static Predicate<Imovel> terrenos() {
        return i -> i instanceof Terreno;
    }

    public static Predicate<Imovel> salasComerciais() {
        return i -> i instanceof SalaComercial;
    }
}
