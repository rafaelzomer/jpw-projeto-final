package app.pedido;

import app.mesa.MesaRepository;
import app.mesa.Mesa;
import app.prato.Prato;
import app.prato.PratoRepository;
import app.utils.DefaultController;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class NovoPedidoController extends DefaultController {
     
    private Prato prato = new Prato();
    private Integer quantidade = 1;
    private String id;    
    private Mesa mesa;
       
    public void onLoad() {
        this.mesa = MesaRepository.getMesa(id);
        if (mesa.getPedido() == null) {
            mesa.setPedido(new Pedido());
        }
    }
    
    public String salvar() {
                      
        if (mesa.getPedido().getCodigo() == null) {
            mesa.getPedido().setCodigo(PedidoRepository.getProximoId());
        }
        Long proximoIdItemPedido = ItemPedidoRepository.getProximoId();
        for(ItemPedido item  : mesa.getPedido().getItens()) {
            item.setCodigo(proximoIdItemPedido++);
        }
        MesaRepository.salvar(mesa);
        
        return "index";
    }
    
    public void adicionarItem() {
        if (prato == null) {
            setMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um prato para continuar");
            return;
        }
        if (quantidade == null || quantidade < 1) {
            setMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione uma quantidade para continuar");
            return;
        }
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrato(this.prato);
        itemPedido.setQuantidade(this.quantidade);
        prato = new Prato();
        this.mesa.getPedido().getItens().add(itemPedido);
    }
    
    public void excluirItem(ItemPedido item) {
        List<ItemPedido> itens = mesa.getPedido().getItens();
        itens.remove(item);
        mesa.getPedido().setItens(itens);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public void editarItem(ItemPedido item) {
        this.prato = item.getPrato();
        this.quantidade = item.getQuantidade();
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    
}
