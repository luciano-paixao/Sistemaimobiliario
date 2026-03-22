package main.java.imobiliaria.model;

public class LoginErrado extends Exception {

    @Override
    public String toString() {
        return "senha ou usuario incorreto";
    }
}
