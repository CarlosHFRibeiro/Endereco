package estagio.totem.endereco.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nomeClinete;

    @Column
    private String cpfClinete;

    @Column
    private Date dataNascimento;

    @ManyToMany
    @JoinTable(name = "tbl_casa_cliente",
            joinColumns = @JoinColumn(name = "fkCliente"),
            inverseJoinColumns = @JoinColumn(name = "fkCasa"))
    private Set<Casa> casa;

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

    public Set<Casa> getCasa() {
        if (casa == null) {
            Collections.emptySet();
        }
        return casa;
    }

    public void addCasa(Casa casa) {
        if (this.casa == null) {
            this.casa = new HashSet<>();
        }
        this.casa.add(casa);
    }
}
