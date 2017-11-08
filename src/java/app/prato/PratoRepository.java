package app.prato;

import app.db.JPA;
import java.util.List;
import javax.persistence.*;

public class PratoRepository {
    
    public static void salvar(List<Prato> pratos) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        for(Prato prato : pratos) {
            em.merge(prato);
        }
        t.commit();
    }
    
    public static void salvar(Prato prato) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(prato);
        t.commit();
    }
    
    public static Prato getPrato(Long codigo) {
        EntityManager em = JPA.getEM();
        return em.find(Prato.class, codigo);
    }
    
    public static List<Prato> getPratos() {
        EntityManager em = JPA.getEM();
        return em.createQuery("select p from pratos p", Prato.class).getResultList();
    }
}
