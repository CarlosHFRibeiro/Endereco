package estagio.totem.endereco.controller.dto;

import estagio.totem.endereco.entity.Complemento;

import javax.validation.constraints.NotNull;

public class CasaFormDTO {
    private Long idCasa;
    @NotNull
    private String nomeRuaCasa;
    @NotNull
    private int numCasa;
    @NotNull
    private Long idBairro;
    private Complemento complemento;

    public Long getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Long idCasa) {
        this.idCasa = idCasa;
    }

    public String getNomeRuaCasa() {
        return nomeRuaCasa;
    }

    public void setNomeRuaCasa(String nomeRuaCasa) {
        this.nomeRuaCasa = nomeRuaCasa;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }
}
