
package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

import java.util.List;

@Entity
public class Pedido extends Model {
    public Date fecha;
    public int estado;
    public Double precio_total;
    @ManyToOne
    public User usuario;
    @OneToMany(mappedBy = "pedido")
    public List<LineaPedido> lineaspedido;

    public Pedido(Double precio_total, Date fecha, int estado, User usuario) {
        this.precio_total = precio_total;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Pedido() {}

}
