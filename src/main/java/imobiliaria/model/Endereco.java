package main.java.imobiliaria.model;

public class Endereco {

    String bairro;

    String rua;

    String numero;

    public Endereco(String bairro, String rua, String numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
