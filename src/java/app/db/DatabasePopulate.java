package app.db;

import app.mesa.Mesa;
import app.mesa.MesaRepository;
import app.pedido.ItemPedido;
import app.pedido.Pedido;
import app.pedido.PedidoRepository;
import app.prato.Prato;
import app.prato.PratoRepository;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulate {
   
    public static void main(String[] args) {
        List<Prato> pratos = new ArrayList<>();
        pratos.add(new Prato(1l, "Frango grelhado"));
        pratos.add(new Prato(2l, "Bife a milanesa"));
        pratos.add(new Prato(3l, "Salada"));
        pratos.add(new Prato(4l, "Peixe frito"));
        pratos.add(new Prato(5l, "Salmão"));
        PratoRepository.salvar(pratos);
        
        long itemPedidoId = 1;
        Pedido pedido1 = new Pedido();
        pedido1.setCodigo(1l);
        List<ItemPedido> itens1 = new ArrayList<>();
        itens1.add(new ItemPedido(itemPedidoId++, 1, pratos.get(0)));
        itens1.add(new ItemPedido(itemPedidoId++, 2, pratos.get(1)));
        pedido1.setItens(itens1);
        
        List<Mesa> mesas = new ArrayList<>();
        Mesa mesa1 = new Mesa(1l, "Mesa perto da janela");
        mesa1.setPedido(pedido1);
        mesas.add(mesa1);
        
        mesas.add(new Mesa(2l, "Mesa atrás do balcão"));
        mesas.add(new Mesa(3l, "Mesa verde na rua / lado direito"));
        mesas.add(new Mesa(4l, "Mesa verde na rua / lado esquerdo"));
        mesas.add(new Mesa(5l, "Mesa da porta"));
        MesaRepository.salvar(mesas);
        

    }
}
