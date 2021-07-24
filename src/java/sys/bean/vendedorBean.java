package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.vendedorDao;
import sys.imp.vendedorDaoImp;
import sys.model.Vendedor;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@Named(value = "vendedorBean")
@ManagedBean
@ViewScoped
public class vendedorBean implements Serializable{

    private List<Vendedor> listaVendedores;
    private Vendedor vendedor; 
    
    public vendedorBean() {
    
    
    }

    
    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public List<Vendedor> getListaVendedores() {
        vendedorDao vDao = new vendedorDaoImp();
        listaVendedores = vDao.listarVendedor();
               
        return listaVendedores;
    }
    
    public void prepararNuevoVendedor(){
        vendedor = new Vendedor();
    }
    
    public void nuevoVendedor(){
        vendedorDao vDao = new vendedorDaoImp();
        vDao.newVendedor(vendedor);
    }
    
    public void modificarVendedor(){
        vendedorDao vDao = new vendedorDaoImp();
        vDao.updateVendedor(vendedor);
        vendedor = new Vendedor();
        
    }
    
    public void eliminarVendedor(){
        vendedorDao vDao = new vendedorDaoImp();
        vDao.deleteVendedor(vendedor);
        vendedor = new Vendedor();
        
        
    }
}
