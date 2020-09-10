package estagio.totem.endereco.controller.dto;


import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

public class ClienteDTO {
    private Long idCliente;
    @NotNull
    private String nomeClinete;
    @NotNull
    private String cpfClinete;
    @NotNull
    private Date dataNascimento;
    @NotNull
    private Set<CasaDTO> casa;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeClinete() {
        return nomeClinete;
    }

    public void setNomeClinete(String nomeClinete) {
        this.nomeClinete = nomeClinete;
    }

    public String getCpfClinete() {
        return cpfClinete;
    }

    public void setCpfClinete(String cpfClinete) {
        this.cpfClinete = cpfClinete;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<CasaDTO> getCasa() {
        return casa;
    }

    public void setCasa(Set<CasaDTO> casa) {
        this.casa = casa;
    }
}
