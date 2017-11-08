package app.prato;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pratos")
public class Prato implements Serializable {

    public Prato() {
    }

    public Prato(Long codigo) {
        this.codigo = codigo;
    }

    
    
    public Prato(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    @Id
    private Long codigo;
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
