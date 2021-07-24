package sys.dao;

import org.hibernate.Session;
import sys.model.Factura;


public interface facturaDao {

    //obtener el ultimo registro en la tabla factura de la BD
    public Factura obtenerUltimoRegistro(Session session)throws Exception;
    //averiguar si la tabla factura posee registros
    public Long obtenerTotalRegistrosEnFactura(Session session);
    
    
    //Metodo para guardar el registro en la tabla factura de la BD
    public boolean guardarVentaFactura(Session session, Factura factura) throws Exception;
    
}
