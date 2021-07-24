package sys.bean;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import sys.dao.productoDao;
import sys.imp.productoDaoImp;
import sys.model.Producto;


@Named(value = "productoBean")
@ManagedBean
@ViewScoped
public class productoBean implements Serializable {

    private List<Producto> listaProductos;
    private Producto producto;
    public productoBean() {
    }

   

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
     public List<Producto> getListaProductos() {
         productoDao pDao = new productoDaoImp();
         listaProductos = pDao.listarProductos();
         return listaProductos;
    }
     
    public void prepararNuevoProducto(){
        producto = new Producto();
    }
    
    public void nuevoProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.newProducto(producto);
    }
    
    public void modificarProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.updateProducto(producto);
        producto = new Producto();
        
    }
    
    public void eliminarProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.deleteProducto(producto);
        producto = new Producto();
                
    }
    
     
}
