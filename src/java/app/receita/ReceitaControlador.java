package app.receita;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ReceitaControlador {

    private Receita receita;
    private List<Receita> receitas;
    
    public ReceitaControlador() {
        novo();
        atualizarLista();
        
//        receita = new Receita();
        receita.setCodigo(1);
        receita.setNome("Bolo de banaca");
        receita.setModoPreparo("preparar");
        receita.setObservacao("obs");
        receita.setTipo(TipoReceita.DOCE);;
    }
    
    public void atualizarLista() {
        receitas = ReceitaRepositorio.getReceitas();
    }
    
    public void novo() {
        receita = new Receita();
    }

    public String salvar() {
        ReceitaRepositorio.salvar(receita);
        atualizarLista();
        return "receitas";
    }
    
    public void excluir() {
        excluir(this.receita);
    }
    
    public void excluir(Receita produto) {
        ReceitaRepositorio.excluir(produto);
        atualizarLista();
        novo();
    }
    
    public List<String> completaTipos() {
        List<String> results = new ArrayList<String>();
//        for(int i = 0; i < 10; i++) {
//            results.add(query + i);
//        }
//        String[] results = TipoReceita.values();
        for(TipoReceita tip : TipoReceita.values()) {
            results.add(tip.toString());
        }
        return results;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
    
    
    
    
}
