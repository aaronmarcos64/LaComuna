
package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Comida  extends Model
{
    public String nombre;
    public Double precio;

    public Comida(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Comida() {}

    @OneToMany(mappedBy = "comida")
    public List<LineaPedido> lineaspedido;
    @OneToMany(mappedBy = "comida")
    public List<LineaComida> lineascomida;
}