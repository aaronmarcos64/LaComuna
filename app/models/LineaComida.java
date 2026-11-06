
package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LineaComida extends Model {
    public int cantidad;
    @ManyToOne
    public Comida comida;
    @ManyToOne
    public Ingrediente ingrediente;

    public LineaComida(int cantidad) {
        this.cantidad = cantidad;
    }

    public LineaComida(int cantidad, Comida comida, Ingrediente ingrediente) {
        this.cantidad = cantidad;
        this.comida = comida;
        this.ingrediente = ingrediente;
    }

    public LineaComida() {}
}
