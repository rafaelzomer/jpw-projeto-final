package app.receita;

public enum TipoReceita {
    SALGADO("S", "Salgado"),
    DOCE("D", "Doce");

    private String db;
    private String descricao;
    
    private TipoReceita(String db, String descricao) {
        this.db = db;
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
}
