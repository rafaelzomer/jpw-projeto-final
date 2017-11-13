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
    private Prato prato = new Prato();
    private Integer quantidade = 1;
    
    public String salvar() {
        System.out.println("pedido = " + pedido);
        if (pedido.getCodigo() == null) {
            pedido.setCodigo(PedidoRepository.getProximoId());
        }
        PedidoRepository.salvar(pedido);
        return "pedidos";
    }
    
    public void adicionarItem() {
        ItemPedido itemPedido = new ItemPedido(this.codigoItem++);
        itemPedido.setPrato(this.prato);
        itemPedido.setQuantidade(this.quantidade);
        System.out.println("item = " + itemPedido+ '/'+prato);
        this.pedido.getItens().add(itemPedido);
//        this.prato = null;
//        this.quantidade = 1;
    }
    
    public void excluirItem(ItemPedido item) {
        List<ItemPedido> itens = pedido.getItens();
        itens.remove(item);
        pedido.setItens(itens);
    }
    
    public void editarItem(ItemPedido item) {
        this.prato = item.getPrato();
        this.quantidade = item.getQuantidade();
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }
    
    
}
