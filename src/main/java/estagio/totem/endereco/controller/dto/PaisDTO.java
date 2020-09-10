package estagio.totem.endereco.controller.dto;

import javax.persistence.Column;

public class PaisDTO {
    private Long idPais;
    private String nomePais;

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
