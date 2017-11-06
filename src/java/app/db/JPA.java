package app.db;

import javax.persistence.*;

public class JPA {
    
    public static EntityManagerFactory emf;
    
    public static EntityManager getEM() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("receitas");
        }
        
        try {
            return emf.createEntityManager();
        } finally {
//            emf.close();;
        }
    }    
}
