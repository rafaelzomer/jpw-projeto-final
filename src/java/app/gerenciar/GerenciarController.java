package app.gerenciar;

import app.mesa.MesaRepository;
import app.mesa.Mesa;
import app.pedido.PedidoRepository;
import app.pedido.Pedido;
import app.utils.DefaultController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GerenciarController extends DefaultController implements Serializable {
     
    private List<Mesa> mesas;
     
    @PostConstruct
    public void init() {
        this.mesas = MesaRepository.getMesas();
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
    
    public String iniciarMesa(Mesa mesa) {
        return "pedido.xhtml?faces-redirect=true&id=" + mesa.getCodigo();
    }
    
    public String editar(Mesa mesa) {
        return "pedido.xhtml?faces-redirect=true&id=" + mesa.getCodigo();
    }
    
    public void cancelarConta(Mesa mesa) {
        System.out.println("cancelarConta = " + mesa);
        setMessage(FacesMessage.SEVERITY_WARN, "Cancelada!", "Conta cancelada");
        mesa.setPedido(null);
        MesaRepository.salvar(mesa);
    }
    
    public String fecharConta(Mesa mesa) {
        return "fechar_conta.xhtml?faces-redirect=true&id=" + mesa.getCodigo();
    }
    
}
