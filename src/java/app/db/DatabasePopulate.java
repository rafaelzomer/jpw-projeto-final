package app.db;

import app.mesa.Mesa;
import app.mesa.MesaRepository;
import app.prato.Prato;
import app.prato.PratoRepository;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulate {
   
    public static void main(String[] args) {
        Prato prato = PratoRepository.getPrato(1l);
        if (prato == null)
        {
            List<Prato> pratos = new ArrayList<>();
            pratos.add(new Prato(1l, "Frango grelhado"));
            pratos.add(new Prato(2l, "Bife a milanesa"));
            pratos.add(new Prato(3l, "Salada"));
            pratos.add(new Prato(4l, "Peixe frito"));
            pratos.add(new Prato(5l, "Salmão"));
            PratoRepository.salvar(pratos);
        }
        
        Mesa mesa = MesaRepository.getMesa(1l);
        if (mesa == null)
        {
            List<Mesa> mesas = new ArrayList<>();
            mesas.add(new Mesa(1l, "Mesa perto da janela"));
            mesas.add(new Mesa(2l, "Mesa atrás do balcão"));
            mesas.add(new Mesa(3l, "Mesa verde na rua / lado direito"));
            mesas.add(new Mesa(4l, "Mesa verde na rua / lado esquerdo"));
            mesas.add(new Mesa(5l, "Mesa da porta"));
            MesaRepository.salvar(mesas);
        }
    }
}
