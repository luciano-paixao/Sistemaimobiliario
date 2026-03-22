package main.java.imobiliaria.model.exceptions;

public class ConflitoDisponibilidade extends RuntimeException {
    @Override
    public String toString() {
        return "Este imóvel não está disponível para transação";
    }
}
