package app.db;

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
    }
}
