package app.pedido;

import app.db.JPA;
import java.math.BigDecimal;
import javax.persistence.*;

public class ItemPedidoRepository {
    
    public static Long getProximoId() {
        EntityManager em = JPA.getEM();
        BigDecimal proximoId = em.createQuery("select coalesce(max(p.codigo), 0)+1 from items_pedido p", BigDecimal.class).getSingleResult();
        return proximoId.longValueExact();
    }
}
