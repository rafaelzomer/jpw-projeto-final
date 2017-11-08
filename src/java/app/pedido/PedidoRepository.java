package app.pedido;

import app.db.JPA;
import java.util.List;
import javax.persistence.*;

public class PedidoRepository {
    
    public static void salvar(Pedido pedido) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(pedido);
        t.commit();
    }

    public static void excluir(Pedido pedido) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Pedido.class, pedido.getCodigo()));
        t.commit();
    }

    public static Pedido getPedido(Integer codigo) {
        EntityManager em = JPA.getEM();
        return em.find(Pedido.class, codigo);
    }
    
    public static List<Pedido> getPedidos() {
        EntityManager em = JPA.getEM();
        return em.createQuery("select p from pedidos p", Pedido.class).getResultList();
    }
}
