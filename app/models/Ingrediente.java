
package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Ingrediente extends Model {
    public String nombre;
    public int stock;

    public Ingrediente(int stock, String nombre) {
        this.stock = stock;
        this.nombre = nombre;
    }

    public Ingrediente() {}

    @OneToMany(mappedBy = "ingrediente")
    public List<LineaComida> lineascomida;
}
