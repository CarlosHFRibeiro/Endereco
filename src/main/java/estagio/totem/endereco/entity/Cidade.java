package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;

    @Column
    private String nomeCiadade;

    @ManyToOne
    @JoinColumn(name = "fkEstadoCidade")
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
