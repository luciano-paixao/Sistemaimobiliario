package main.java.imobiliaria.model;

import main.java.imobiliaria.model.enums.TipoDisponibilidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Imovel {

    private LocalDate dataConstrucao;

    private Boolean disponibilidade;

    private Endereco endereco;

    private List<ClienteProprietario> proprietarios = new ArrayList<>();

    private TipoDisponibilidade tipoDisponibilidade;

    private LocalDate incioOferta;

    private LocalDate fimOferta;

    private Imobiliaria imobiliaria;

    public Imovel(LocalDate dataConstrucao, Endereco endereco, TipoDisponibilidade tipoDisponibilidade, Imobiliaria imobiliaria) {
        this.dataConstrucao = dataConstrucao;
        this.disponibilidade = true;
        this.endereco = endereco;
        this.tipoDisponibilidade = tipoDisponibilidade;
        this.incioOferta = LocalDate.now();
        this.imobiliaria = imobiliaria;
    }

    public void adicionarProprietario(ClienteProprietario proprietario){
        this.proprietarios.add(proprietario);
    }

    public void removerProprietario(ClienteProprietario proprietario){
        this.proprietarios.remove(proprietario);
    }

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ClienteProprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<ClienteProprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public TipoDisponibilidade getTipoDisponibilidade() {
        return tipoDisponibilidade;
    }

    public void setTipoDisponibilidade(TipoDisponibilidade tipoDisponibilidade) {
        this.tipoDisponibilidade = tipoDisponibilidade;
    }

    public LocalDate getIncioOferta() {
        return incioOferta;
    }

    public void setIncioOferta(LocalDate incioOferta) {
        this.incioOferta = incioOferta;
    }

    public LocalDate getFimOferta() {
        return fimOferta;
    }

    public void setFimOferta(LocalDate fimOferta) {
        this.fimOferta = fimOferta;
    }

    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public String mostarProprietarios(){
        String nomesProprietarios = "";
        for (ClienteProprietario Proprietarios : this.proprietarios){
            nomesProprietarios += Proprietarios.getNome() + ",";
        }
        return nomesProprietarios;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "dataConstrucao=" + dataConstrucao +
                ", disponibilidade=" + disponibilidade +
                ", endereco=" + endereco +
                ", proprietarios=" + mostarProprietarios() +
                ", tipoDisponibilidade=" + tipoDisponibilidade +
                ", incioOferta=" + incioOferta +
                ", fimOferta=" + fimOferta +
                ", imobiliaria=" + imobiliaria +
                '}';
    }
}
