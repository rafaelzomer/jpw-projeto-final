package app.receita;

import app.db.JPA;
import java.util.List;
import javax.persistence.*;

public class ReceitaRepositorio {
    
    public static void salvar(Receita receita) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(receita);
        t.commit();
    }

    public static void excluir(Receita receita) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Receita.class, receita.getCodigo()));
        t.commit();
    }

    public static Receita getReceita(Integer codigo) {
        EntityManager em = JPA.getEM();
        return em.find(Receita.class, codigo);
    }
    
    public static List<Receita> getReceitas() {
        EntityManager em = JPA.getEM();
        return em.createQuery("select p from receitas p", Receita.class).getResultList();
    }
    
    public static List<Receita> getReceitas(String nome) {
        EntityManager em = JPA.getEM();
        TypedQuery<Receita> query = em.createQuery(
                "select p from receitas p where p.nome "
                        + "like :nome", Receita.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}
