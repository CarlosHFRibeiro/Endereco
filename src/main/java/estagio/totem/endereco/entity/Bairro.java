package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_bairro")
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBairro;

    @Column
    private String nomeBairro;

    @ManyToOne
    @JoinColumn(name = "fkCidadeBairro")
    private Cidade cidade;

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
