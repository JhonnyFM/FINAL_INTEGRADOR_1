package sys.bean;

import java.util.Locale;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


public class idiomaBean {
    
    public void cambiarIdioma(ValueChangeEvent e){
        FacesContext fc=FacesContext.getCurrentInstance();
        UIViewRoot ui=fc.getViewRoot();
        ui.setLocale(new Locale(e.getNewValue().toString()));
        
    }
}
