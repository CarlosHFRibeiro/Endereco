package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity@Table(name = "tbl_estado")
public class Estado {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column private String nomeEstado;

    @ManyToOne
    @JoinColumn(name = "fkPaisEstado")
    private Pais pais;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
