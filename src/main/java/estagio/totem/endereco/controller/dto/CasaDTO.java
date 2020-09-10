package estagio.totem.endereco.controller.dto;

import estagio.totem.endereco.entity.Cliente;

import javax.validation.constraints.NotNull;

public class CasaDTO {
    private Long idCasa;
    @NotNull
    private String nomeRuaCasa;
    @NotNull
    private int numCasa;
    @NotNull
    private BairroDTO bairro;
    private ComplementoDTO complemento;

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

    public BairroDTO getBairro() {
        return bairro;
    }

    public void setBairro(BairroDTO bairro) {
        this.bairro = bairro;
    }

    public ComplementoDTO getComplemento() {
        return complemento;
    }

    public void setComplemento(ComplementoDTO complemento) {
        this.complemento = complemento;
    }
}
