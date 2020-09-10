package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCasa;

    @Column
    private String nomeRuaCasa;

    @Column
    private int numCasa;

    @ManyToOne
    @JoinColumn(name = "fkCasaBairro")
    private Bairro bairro;

    @OneToOne(mappedBy = "casa")
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }
}