package main.java.imobiliaria.model.exceptions;

public class LoginErrado extends Exception {

    @Override
    public String toString() {
        return "Senha ou usuario incorreto";
    }
}
