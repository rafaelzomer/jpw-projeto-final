package app.pedido;

import app.prato.Prato;
import app.prato.PratoRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NovoPedidoController {
     
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
    
    public void adicionarItem() throws Exception {
        if (prato == null) {
            throw new Exception("Selecione um prato");
        }
        Long proximoIdItemPedido = ItemPedidoRepository.getProximoId();
        ItemPedido itemPedido = new ItemPedido(proximoIdItemPedido);
        itemPedido.setPrato(this.prato);
        itemPedido.setQuantidade(this.quantidade);
        System.out.println("item = " + itemPedido+ '/'+prato);
        this.pedido.getItens().add(itemPedido);
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
