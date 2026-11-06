
package models;
import groovyjarjarpicocli.CommandLine;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LineaPedido extends Model {
    public int cantidad;
    public double precio_unitario;
    @ManyToOne
    public Pedido pedido;
    @ManyToOne
    public Comida comida;

    public LineaPedido(double precio_unitario, int cantidad,  Pedido pedido, Comida comida) {
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.comida = comida;
    }

    public LineaPedido() {}
}
