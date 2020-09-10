package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_complemento")
public class Complemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComplemento;

    @Column
    private String nomeComplemento;

    @OneToOne
    @JoinColumn(name = "fkCasaComplemnto",referencedColumnName = "idCasa")
    private Casa casa;

    public Long getIdComplemento() {
        return idComplemento;
    }

    public void setIdComplemento(Long idComplemento) {
        this.idComplemento = idComplemento;
    }

    public String getNomeComplemento() {
        return nomeComplemento;
    }

    public void setNomeComplemento(String nomeComplemento) {
        this.nomeComplemento = nomeComplemento;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
}
