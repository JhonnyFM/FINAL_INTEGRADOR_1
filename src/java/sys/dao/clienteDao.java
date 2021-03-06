
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Cliente;


public interface clienteDao {
    
    public List<Cliente> listarClientes();
    public void newCliente(Cliente cliente);
    public void updateCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente);
    
    //este metodo se utilizara en la factura. facturaBean
    public Cliente obtenerClientePorCodigo(Session session, Integer codCliente)throws Exception;
}
