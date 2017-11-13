package app.gerenciar;

import app.mesa.MesaRepository;
import app.mesa.Mesa;
import app.pedido.PedidoRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class GerenciarController implements Serializable {
     
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

    
}
