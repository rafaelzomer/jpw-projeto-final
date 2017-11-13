package app.prato;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Prato.class)
public class PratoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("feoso1 = " +string);
        try {
            return PratoRepository.getPrato(Long.valueOf(string));
        } catch(Exception e) {
            System.out.println("feoso = " + e.getMessage()+"/"+string);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Prato)) {
            System.out.println("p = " + ((Prato)o).getCodigo());
            return String.valueOf(((Prato) o).getCodigo());
        }
        return null;
    }

}