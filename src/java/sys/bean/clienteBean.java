package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.model.Cliente;
import javax.faces.bean.ManagedBean;
import sys.dao.clienteDao;
import sys.imp.clienteDaoImp;
import java.io.Serializable;


@Named(value = "clienteBean")
@ManagedBean
@ViewScoped


public class clienteBean implements Serializable{

    private List<Cliente> listaClientes;
    private Cliente cliente;
    
    
    public clienteBean() {
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> getListaClientes() {
        clienteDao cDao = new clienteDaoImp();
        listaClientes=cDao.listarClientes();
        return listaClientes;
    }
     
    public void prepararNuevoCliente(){
        cliente = new Cliente();
    }
    
    public void nuevoCliente(){
        clienteDao cDao = new clienteDaoImp();
        cDao.newCliente(cliente);
    }
    
    public void modificarCliente(){
        clienteDao cDao = new clienteDaoImp();
        cDao.updateCliente(cliente);
        cliente = new Cliente();
        
    }
    
    public void eliminarCliente(){
        clienteDao cDao = new clienteDaoImp();
        cDao.deleteCliente(cliente);
        cliente = new Cliente();
        
        
    }
}
