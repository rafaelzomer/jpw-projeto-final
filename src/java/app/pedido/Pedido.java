package app.pedido;

import app.receita.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "pedidos")
public class Pedido implements Serializable {
    
    @Id
    private Integer codigo;
    
    @OneToMany(fetch = FetchType.LAZY, 
            mappedBy = "pedido", 
            orphanRemoval = true, 
            cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    

    
}
