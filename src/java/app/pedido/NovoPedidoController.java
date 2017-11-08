package app.pedido;

import app.prato.Prato;
import app.prato.PratoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NovoPedidoController {
     
    private Long codigoItem = 1l;
    private Pedido pedido = new Pedido();
    
    public String salvar() {
        System.out.println("pedido = " + pedido);
        PedidoRepository.salvar(pedido);
        return "pedidos";
    }
    
    public void novoItem() {
//        List<ItemPedido> itens = pedido.getItens();
        pedido.getItens().add(new ItemPedido(codigoItem++,pedido));
//        pedido.setItens(itens);
        System.out.println("pedido.get = " + pedido.getItens());
    }
    
    public void excluirItem(ItemPedido item) {
        List<ItemPedido> itens = pedido.getItens();
        itens.remove(item);
        pedido.setItens(itens);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Prato> getPratos() {
        return PratoRepository.getPratos();
    }
    
}
