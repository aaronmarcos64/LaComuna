
package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends Model {
    public int tipo;
    public String nombre;
    public String password;
    public String mail;
    @OneToMany(mappedBy = "usuario")
    public List<Pedido> pedidos;

    public User(int tipo, String nombre, String password, String mail) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.password = password;
        this.mail = mail;
    }
    public User(){}
}
