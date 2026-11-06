
package controllers;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    //Service para inicializar la bd
    public static void initbd() {

        //Vaciamos la bd
        LineaPedido.deleteAll();
        LineaComida.deleteAll();
        Pedido.deleteAll();
        Comida.deleteAll();
        Ingrediente.deleteAll();
        User.deleteAll();

        //Creamos los usuarios
        User u1 = new User(1, "Aaron", "1234", "aaron@mail.com");
        u1.save();
        User u2 = new User(1, "Yerald", "1234", "yerald@mail.com");
        u2.save();

        //Creamos ingredientes
        Ingrediente i1 = new Ingrediente(10,"hamburguesa ternera");
        i1.save();
        Ingrediente i2 = new Ingrediente(10,"pan briox");
        i2.save();

        //Creamos comidas
        Comida c1 = new Comida("Hamburguesa clásica", 6.5);
        c1.save();
        Comida c2 = new Comida("Hamburguesa doble", 8.5);
        c2.save();

        //Creamos las relaciones entre comida e ingredientes
        //Hamburguesa clásica
        LineaComida lc1 = new LineaComida(1, c1, i1);
        lc1.save();
        LineaComida lc2 = new LineaComida(1, c1, i2);
        lc2.save();

        //Hamburguesa doble
        LineaComida lc3 = new LineaComida(2, c2, i1);
        lc3.save();
        LineaComida lc4 = new LineaComida(1, c2, i2);
        lc4.save();

        //Creamos los pedidos
        //Pedido Aaron
        Pedido p1 = new Pedido(8.5, new Date(), 1, u1);
        p1.save();
            //Relación Pedido-LineaPedido
        LineaPedido lp1 = new LineaPedido(8.5, 1, p1, c2);
        lp1.save();
        //Pedido Yerald
        Pedido p2 = new Pedido(6.5*2, new Date(), 1, u2);
        p2.save();
            //Relación Pedido-LineaPedido
        LineaPedido lp2 = new LineaPedido(6.5*2, 2, p2, c1);
        lp2.save();
    }
    //Service para borrar el último pedido
    public static void deleteUltimoPedido() {
        Pedido p = Pedido.find("order by id desc").first();
        if (p != null) {
            LineaPedido.delete("pedido.id = ?1", p.id);
            p.delete();
        }
    }
    //Service inicio de sesión


}