package sys.dao;

import org.hibernate.Session;
import sys.model.Detallefactura;



public interface detalleFacturaDao {
 
    //Metodo para guardar el registro en la tabla DetalleFactura de la BD
    public boolean guardarVentaDetalleFactura(Session session, Detallefactura detallefactura) throws Exception;
    
    
    
}
