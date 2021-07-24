package sys.model;

public class Usuario  implements java.io.Serializable {


     private Integer codUsuario;
     private Vendedor vendedor;
     private String nombreUsuario;
     private String password;

    public Usuario() {
    }

    public Usuario(Vendedor vendedor, String nombreUsuario, String password) {
       this.vendedor = vendedor;
       this.nombreUsuario = nombreUsuario;
       this.password = password;
    }
   
    public Integer getCodUsuario() {
        return this.codUsuario;
    }
    
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


