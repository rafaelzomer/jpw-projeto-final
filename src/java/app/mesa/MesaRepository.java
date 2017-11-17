package app.mesa;

import app.pedido.*;
import app.db.JPA;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

public class MesaRepository {
    
    public static void salvar(List<Mesa> mesas) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        for(Mesa mesa : mesas) {
            em.merge(mesa);
        }
        t.commit();
    }
    
    public static void salvar(Mesa mesa) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(mesa);
        t.commit();
    }

    public static void excluir(Mesa mesa) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        System.out.println("Remover = " + mesa.getCodigo());
        em.remove(em.find(Mesa.class, mesa.getCodigo()));
        t.commit();
    }

    public static Mesa getMesa(String codigo) {
        return getMesa(Long.valueOf(codigo));
    }
    
    public static Mesa getMesa(Long codigo) {
        EntityManager em = JPA.getEM();
        return em.find(Mesa.class, codigo);
    }
    
    public static Long getProximoId() {
        EntityManager em = JPA.getEM();
        BigDecimal proximoId = em.createQuery("select coalesce(max(p.codigo), 0)+1 from mesas p", BigDecimal.class).getSingleResult();
        return proximoId.longValueExact();
    }
    
    public static List<Mesa> getMesas() {
        EntityManager em = JPA.getEM();
        return em.createQuery("select p from mesas p", Mesa.class).getResultList();
    }
}
