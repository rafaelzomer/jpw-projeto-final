package app.pedido;

import app.db.JPA;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

public class PedidoRepository {
    
    public static void salvar(Pedido pedido) {
        System.out.println("pedido = " + pedido);
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

    public static Pedido getPedido(String codigo) {
        return getPedido(Long.valueOf(codigo));
    }
    
    public static Pedido getPedido(Long codigo) {
        EntityManager em = JPA.getEM();
        return em.find(Pedido.class, codigo);
    }
    
    public static Long getProximoId() {
        EntityManager em = JPA.getEM();
        BigDecimal proximoId = em.createQuery("select coalesce(max(p.codigo), 0)+1 from pedidos p", BigDecimal.class).getSingleResult();
        return proximoId.longValueExact();
    }
    
    public static List<Pedido> getPedidos() {
        EntityManager em = JPA.getEM();
        return em.createQuery("select p from pedidos p", Pedido.class).getResultList();
    }
}
