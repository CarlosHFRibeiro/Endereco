package estagio.totem.endereco.entity;

import javax.persistence.*;

@Entity@Table(name = "tbl_casa_cliente")
public class CasaCliente {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCC;

    @ManyToOne@JoinColumn(name = "fkCasa")
    private Casa casa;

    @ManyToOne@JoinColumn(name = "fkCliente")
    private Cliente cliente;

    public Long getIdCC() {
        return idCC;
    }

    public void setIdCC(Long idCC) {
        this.idCC = idCC;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
