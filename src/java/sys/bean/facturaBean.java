package sys.bean;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import sys.clasesAuxiliares.reporteFactura;

import sys.dao.clienteDao;
import sys.dao.detalleFacturaDao;
import sys.dao.facturaDao;
import sys.dao.productoDao;
import sys.imp.clienteDaoImp;
import sys.imp.detalleFacturaDaoImp;
import sys.imp.facturaDaoImp;
import sys.imp.productoDaoImp;
import sys.model.Cliente;
import sys.model.Detallefactura;
import sys.model.Factura;
import sys.model.Producto;
import sys.model.Vendedor;
import sys.util.HibernateUtil;


@Named(value = "facturaBean")
@ManagedBean
@ViewScoped
public class facturaBean {

    Session session = null;
    Transaction transaction = null;
    @ManagedProperty("#{loginBean}")
    private loginBean lBean;

    private Cliente cliente;
    private Integer codigoCliente;

    private Producto producto;
    private String codigoBarra;

    private List<Detallefactura> listaDetalleFactura;

    private String cantidadProducto;
    private String productoSeleccionado;
    private Factura factura;

    private String cantidadProducto2;

    private Long numeroFactura;

    private BigDecimal totalVentaFactura;

    private Vendedor vendedor;

    public facturaBean() {
        this.factura = new Factura();
        this.listaDetalleFactura = new ArrayList<>();
        this.vendedor = new Vendedor();
        this.cliente = new Cliente();
    }

    public loginBean getlBean() {
        return lBean;
    }

    public void setlBean(loginBean lBean) {
        this.lBean = lBean;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public List<Detallefactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<Detallefactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(String cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public BigDecimal getTotalVentaFactura() {
        return totalVentaFactura;
    }

    public void setTotalVentaFactura(BigDecimal totalVentaFactura) {
        this.totalVentaFactura = totalVentaFactura;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    //metodo para agregar los datos de los clientes por medio de
    //dialogClientes
    public void agregarDatosCliente(Integer codCliente) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            clienteDao cDao = new clienteDaoImp();
            this.transaction = this.session.beginTransaction();

            //obtener los datos del cliente en la variable objeto cliente
            //segun el codigo del cliente
            this.cliente = cDao.obtenerClientePorCodigo(this.session, codCliente);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregados"));

        } catch (Exception e) {

            if (this.transaction != null) {

                System.out.println(e.getMessage());
                transaction.rollback();
            }

        } finally {
            if (this.session != null) {

                this.session.close();
            }

        }
    }

    //metodo para agregar los datos de los clientes buscado por codCliente
    public void agregarDatosCliente2() {
        this.session = null;
        this.transaction = null;

        try {
            if (this.codigoCliente == null) {
                return;
            }

            this.session = HibernateUtil.getSessionFactory().openSession();
            clienteDao cDao = new clienteDaoImp();
            this.transaction = this.session.beginTransaction();

            //obtener los datos del cliente en la variable objeto cliente
            //segun el codigo del cliente
            this.cliente = cDao.obtenerClientePorCodigo(this.session, this.codigoCliente);
            if (this.cliente != null) {

                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregados"));

            } else {
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cliente no encontrado"));

            }

            this.transaction.commit();

        } catch (Exception e) {

            if (this.transaction != null) {

                System.out.println(e.getMessage());
                transaction.rollback();
            }

        } finally {
            if (this.session != null) {

                this.session.close();
            }

        }
    }

    //metodo para solicitar la cantidad de producto a vender
    public void pedirCantidadProducto(String codBarra) {
        this.productoSeleccionado = codBarra;
    }

    //metodo para agregar los datos del producto por medio de
    //dialogProducto
    public void agregarDatosProducto() {
        this.session = null;
        this.transaction = null;

        try {

            if (!(this.cantidadProducto.matches("[0-9]*")) || this.cantidadProducto.equals("0") || this.cantidadProducto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad es incorrecta"));
                this.cantidadProducto = "";

            } else {

                this.session = HibernateUtil.getSessionFactory().openSession();
                productoDao pDao = new productoDaoImp();

                this.transaction = this.session.beginTransaction();

                //obtener los datos del producto en la variable objeto producto
                //segun el codBarra
                this.producto = pDao.obtenerProductoPorCodBarra(this.session, this.productoSeleccionado);

                this.listaDetalleFactura.add(new Detallefactura(null, null, this.producto.getCodBarra(),
                        this.producto.getNombreProducto(), Integer.parseInt(this.cantidadProducto), BigDecimal.valueOf(this.producto.getPrecioVenta()),
                        BigDecimal.valueOf((Integer.parseInt(this.cantidadProducto) * this.producto.getPrecioVenta()))));

                this.transaction.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado al detalle"));
                //lamada al metodo calcular totalFacturaVenta
                this.calcularTotalFactura();

                this.cantidadProducto = "";
            }

        } catch (Exception e) {

            if (this.transaction != null) {

                System.out.println(e.getMessage());
                transaction.rollback();
            }

        } finally {
            if (this.session != null) {

                this.session.close();
            }

        }
    }

    //Metodo para mostrar el dialogCantidadProducto2
    public void mostrarCantidadProducto2() {

        this.session = null;
        this.transaction = null;

        try {
            if (this.codigoBarra.equals("")) {
                return;
            }

            this.session = HibernateUtil.getSessionFactory().openSession();
            productoDao pDao = new productoDaoImp();

            this.transaction = this.session.beginTransaction();

            //obtener los datos del producto en la variable objeto producto
            //segun el codigo de barra
            this.producto = pDao.obtenerProductoPorCodBarra(this.session, this.codigoBarra);

            if (this.producto != null) {

                //Solicitar mostrar el dialog cantidadProducto2
                PrimeFaces.current().executeScript("PF('dialogCantidadProducto2').show();");
                this.codigoBarra = null;

            } else {
                this.codigoBarra = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Producto no encontrado"));

            }

            this.transaction.commit();

        } catch (Exception e) {

            if (this.transaction != null) {

                System.out.println(e.getMessage());
                transaction.rollback();
            }

        } finally {
            if (this.session != null) {

                this.session.close();
            }

        }

    }

    //metodo para agregar los datos del producto buscado por codbarra
    public void agregarDatosProducto2() {

        if (!(this.cantidadProducto2.matches("[0-9]*")) || this.cantidadProducto2.equals("0") || this.cantidadProducto2.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad es incorrecta"));
            this.cantidadProducto2 = "";

        } else {

            this.listaDetalleFactura.add(new Detallefactura(null, null, this.producto.getCodBarra(),
                    this.producto.getNombreProducto(), Integer.parseInt(this.cantidadProducto2), BigDecimal.valueOf(this.producto.getPrecioVenta()),
                    BigDecimal.valueOf((Integer.parseInt(this.cantidadProducto2) * this.producto.getPrecioVenta()))));

            this.cantidadProducto2 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado al detalle"));

            //llamada al metodo calcular totalFacturaVenta()
            this.calcularTotalFactura();
        }
    }

    public void calcularTotalFactura() {
        this.totalVentaFactura = new BigDecimal("0");
        try {
            for (Detallefactura item : listaDetalleFactura) {
                BigDecimal totalVentaPorProducto = item.getPrecioVenta().multiply(new BigDecimal(item.getCantidad()));
                item.setTotal(totalVentaPorProducto);
                totalVentaFactura = totalVentaFactura.add(totalVentaPorProducto);
            }

            this.factura.setTotalVenta(totalVentaFactura);
            System.out.println("Total a vender: " + this.factura.getTotalVenta());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));

        }
    }

    public void quitarProductoDetalleFactura(String codBarra, Integer filaSeleccionada) {
        try {
            int i = 0;
            for (Detallefactura item : this.listaDetalleFactura) {
                if (item.getCodBarra().equals(codBarra) && filaSeleccionada.equals(i)) {
                    this.listaDetalleFactura.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "Se retiro el producto de la factura"));
            //invocamos al metodo totalFacturaVenta para actualizar el total a vender
            this.calcularTotalFactura();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));

        }

    }

    //metodos para editar la cantidad de producto en la tabla productosFactura
    public void onRowEdit(RowEditEvent event) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se modifico la cantidad"));
        //invocar al metodo TotalFacturaVenta
        this.calcularTotalFactura();
    }

    public void onRowCancel(RowEditEvent event) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No se hizo ningun cambio"));

    }

    //metodo para generar el numero de factura
    public void numeracionFactura() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            facturaDao fDao = new facturaDaoImp();
            //verificar si hay registros en la tabla factura de la bd
            this.numeroFactura = fDao.obtenerTotalRegistrosEnFactura(this.session);

            if (this.numeroFactura <= 0 || this.numeroFactura == null) {
                this.numeroFactura = Long.valueOf("1");
            } else {
                //recuperamos el ultimo registro que exista en la tabla factura de la bd
                this.factura = fDao.obtenerUltimoRegistro(this.session);
                this.numeroFactura = Long.valueOf(this.factura.getNumeroFactura() + 1);

                //limpiar la variable totalFactura
                this.totalVentaFactura = new BigDecimal("0");
            }

            this.transaction.commit();

        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();;
            }
            System.out.println(e.getMessage());

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }

    }

    //metodo para limpiar la factura
    public void limpiarFactura() {
        this.cliente = new Cliente();
        this.factura = new Factura();
        this.listaDetalleFactura = new ArrayList<>();
        this.numeroFactura = null;
        this.totalVentaFactura = null;

        //invocar al metodo para desactivar controles en la factura
        this.disableButton();

    }

    //metodo para guardar venta
    public void guardarVenta() {
        this.session = null;
        this.transaction = null;
        this.vendedor.setCodVendedor(lBean.getUsuario().getVendedor().getCodVendedor());

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            productoDao pDao = new productoDaoImp();
            facturaDao fDao = new facturaDaoImp();
            detalleFacturaDao dFDao = new detalleFacturaDaoImp();

            this.transaction = this.session.beginTransaction();
            //datos para guardar en la tabla factura de la BD
            this.factura.setNumeroFactura(this.numeroFactura.intValue());
            this.factura.setCliente(this.cliente);
            this.factura.setVendedor(this.vendedor);

            //hacemos el insert en la tabla factura de la BD
            fDao.guardarVentaFactura(this.session, this.factura);

            //recuperar el ultimo registro de la tabla factura
            this.factura = fDao.obtenerUltimoRegistro(this.session);

            //recorremos el arraylist para guardar cada registro en la bd
            for (Detallefactura item : listaDetalleFactura) {
                this.producto = pDao.obtenerProductoPorCodBarra(this.session, item.getCodBarra());

                item.setFactura(this.factura);
                item.setProducto(this.producto);

                //hacemos el insert en la tabla detalleFactura de la bd
                dFDao.guardarVentaDetalleFactura(this.session, item);
            }
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Venta Registrada"));

            this.limpiarFactura();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {

            if (this.session != null) {
                this.session.close();
            }

        }

    }

    //metodos para activar o desactivar los controles en la factura
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;

    }

    public void enableButton() {

        enabled = true;
    }

    public void disableButton() {

        enabled = false;
    }

    //recuperar fecha del sistema
    private String fechaSistema;

    public String getFechaSistema() {
        Calendar fecha = new GregorianCalendar();

        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        this.fechaSistema = (dia + "/" + (mes + 1) + "/" + anio);
        return fechaSistema;
    }

    //metodo para invocar el reporte y enviarle los parametros
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        this.vendedor.setCodVendedor(lBean.getUsuario().getVendedor().getCodVendedor());
        int cc = this.cliente.getCodCliente();
        int cv = this.vendedor.getCodVendedor();
        int cf = this.factura.getCodFactura() + 1;

        //invocamos al metodo guardVenta, para almacenar la venta en las tablas correspondientes
        this.guardarVenta();
        reporteFactura rFactura = new reporteFactura();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/factura.jasper");

        System.out.println("Cliente: " + cc);
        System.out.println("Vendedor: " + cv);
        System.out.println("Factura: " + cf);

        rFactura.getReporte(ruta, cc, cv, cf);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
