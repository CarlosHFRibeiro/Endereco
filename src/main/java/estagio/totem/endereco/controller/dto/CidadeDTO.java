package estagio.totem.endereco.controller.dto;

public class CidadeDTO {
    private Long idCidade;
    private String nomeCiadade;
    private EstadoDTO estado;

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCiadade() {
        return nomeCiadade;
    }

    public void setNomeCiadade(String nomeCiadade) {
        this.nomeCiadade = nomeCiadade;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }
}
