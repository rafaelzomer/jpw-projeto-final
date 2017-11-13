package app.pedido;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PedidoController implements Serializable {
     
    private List<Pedido> pedidos;
     
    @PostConstruct
    public void init() {
        this.pedidos = PedidoRepository.getPedidos();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
