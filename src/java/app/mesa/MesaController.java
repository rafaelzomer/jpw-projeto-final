package app.mesa;

import app.pedido.*;
import app.prato.Prato;
import app.prato.PratoRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MesaController {
     
    private Mesa mesa = new Mesa();
    private List<Mesa> mesas;
    
    @PostConstruct
    public void init() {
        buscar();
    }
    
    private void buscar() {
        this.mesas = MesaRepository.getMesas();
    }
    
    public void salvar() {
        if (mesa.getCodigo() == null) {
            mesa.setCodigo(MesaRepository.getProximoId());
        }
        MesaRepository.salvar(mesa);
        buscar();
    }
    
    public void excluir(Mesa mesa) {
        MesaRepository.excluir(mesa);
        buscar();
    }
    
    public boolean isValido() {
        if (mesa.getDescricao() == null) {
            return false;
        }
        if (mesa.getCodigo() == null) {
            return false;
        }
        return true;
    }
    
    public void editar(Mesa mesa) {
        System.out.println("mesa = " + mesa);
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    
    
}
