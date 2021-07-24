package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import sys.model.Usuario;
import org.primefaces.context.PrimeRequestContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.dao.usuarioDao;
import sys.imp.usuarioDaoImp;



@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Usuario usuario;
    private String nombreUsuario;
    private String password;

    public loginBean() {
        
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public void login() {
        
        PrimeRequestContext context= PrimeRequestContext.getCurrentInstance(); 
        FacesMessage message = null; 
        
        boolean loggedIn = false;
        String ruta="";
        
        usuarioDao uDao = new usuarioDaoImp();
        this.usuario = uDao.login(this.usuario);
        
        if (this.usuario != null ) {
            
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenida@", this.usuario.getNombreUsuario());
            ruta="/FINAL_DW_FACTURACION/faces/views/bienvenido.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Acceso", "Usuario o Password es incorrecto");
            this.usuario = new Usuario();
            
            
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
   
    }
    
    //metodo para cerrar la session
    public String cerrarSession(){
        this.nombreUsuario=null;
        this.password = null;
        
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();//para borrar la session
        return "/login";
    }
    
    public void cambiarIdioma(ValueChangeEvent e){
        FacesContext fc=FacesContext.getCurrentInstance();
        UIViewRoot ui=fc.getViewRoot();
        ui.setLocale(new Locale(e.getNewValue().toString()));
        
    }

}
