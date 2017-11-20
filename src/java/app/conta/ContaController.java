package app.conta;

import app.pedido.*;
import app.mesa.MesaRepository;
import app.mesa.Mesa;
import app.prato.Prato;
import app.prato.PratoRepository;
import app.utils.DefaultController;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ContaController extends DefaultController {
     
    private String id;    
    private Mesa mesa;
       
    public void onLoad() {
        this.mesa = MesaRepository.getMesa(id);
        if (mesa.getPedido() == null) {
            mesa.setPedido(new Pedido());
        }
    }
    
    public String fecharConta() {
        mesa.setPedido(null);
        MesaRepository.salvar(mesa);
        return "index.xhtml";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    
    
    
    
}
