package com.zeus.tallerelectronica.managedbean;

import com.zeus.tallerelectronica.entidades.Articulo;
import com.zeus.tallerelectronica.entidades.Cliente;
import com.zeus.tallerelectronica.entidades.Garantia;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.zeus.tallerelectronica.sessionbean.ArticuloFacade;
import com.zeus.tallerelectronica.sessionbean.GarantiaFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("articuloController")
@SessionScoped
public class ArticuloController implements Serializable {

    @EJB
    private com.zeus.tallerelectronica.sessionbean.ArticuloFacade ejbFacadeArticulo;
    @EJB
    private com.zeus.tallerelectronica.sessionbean.GarantiaFacade ejbFacadeGarantia;    
    private List<Articulo> items = null;
    private List<Articulo> articulos_cliente = null;
    private Articulo articulo;
    private Cliente cliente;
    private Garantia garantia;
    private Date currentDate = new Date(); //creo que no es necesaria aqui sino en rearaciones asi como el import de DEATE
    
    public ArticuloController() {
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ArticuloFacade getFacade() {
        return ejbFacadeArticulo;
    }

    public ArticuloFacade getEjbFacadeArticulo() {
        return ejbFacadeArticulo;
    }

    public void setEjbFacadeArticulo(ArticuloFacade ejbFacadeArticulo) {
        this.ejbFacadeArticulo = ejbFacadeArticulo;
    }

    public GarantiaFacade getEjbFacadeGarantia() {
        return ejbFacadeGarantia;
    }

    public void setEjbFacadeGarantia(GarantiaFacade ejbFacadeGarantia) {
        this.ejbFacadeGarantia = ejbFacadeGarantia;
    }

    public List<Articulo> getArticulos_cliente() {
        return articulos_cliente;
    }

    public void setArticulos_cliente(List<Articulo> articulos_cliente) {
        this.articulos_cliente = articulos_cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
    
    //limpia el articulo-cliente para que no queden datos basura
    public void limpiarArticuloCliente() {
        System.out.println("En limpiarArticuloCliente()");
        articulo = null;
        //garantia = null;
        //cliente = null;
    }
    //carga la lista de articulos
    public String articuloCargarLista(){
        return "/admin/articulo/ListArticulos";
    }
    
    public String prepareVerArticuloCliente_(Articulo a){
        System.out.println("En prepareVerArticuloCliente(Articulo a)");
        articulo = a;
        return "/admin/articulo/ViewArticuloCliente";
    } 
    
    //prepara la lista de articulos asociados a un cliente, el cliente llega desde ClienteController
    public String prepareGestionArticulosCliente_(Cliente cli){   
        System.out.println("En prepareGestionArticulosCliente(Cliente cli)");
        cliente = cli;
        return "/admin/articulo/ListArticulosCliente";
    }  
    
    // prepara lo necesario para crear un articulo asociado a un cliente
    public String prepareCreateArticuloCliente_() {
        System.out.println("En prepareCreateArticuloCliente()");
        articulo = new Articulo();
        //initializeEmbeddableKey();
        return "/admin/articulo/CreateArticuloCliente";
    }    
    
    // pendiente de si se usa o no
    public String cancelCrearArticuloCliente_() {
        System.out.println("En cancelCrearArticuloCliente()");
        addMessage("Crear Artículo Cliente", "Cancelado Correctamente");
        limpiarArticuloCliente();
        return "/admin/articulo/ListArticulosCliente";
    } 
    
    public Articulo prepareCreate() {
        articulo = new Articulo();
        initializeEmbeddableKey();
        return articulo;
    }

    public String create_() {
        System.out.println("En create()");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleadmin").getString("ArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "/admin/articulo/ListArticulosCliente";// seredirecciona
    }
    
    public void create() {
        System.out.println("En create()");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleadmin").getString("ArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundleadmin").getString("ArticuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundleadmin").getString("ArticuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            articulo = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Articulo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    //internamente se ejecuta consulta para sacar los Articulos asociados a un Cliente mediante el id 
    public List<Articulo> getArticulos_cliente2() {
        //articulos_cliente=getFacadeArticulo().listarArticulosCliente(cliente.getCliId());
        return articulos_cliente;
    }
    // para sacar la fecha del sistema
    public Date getCurrentDate2() {
        return currentDate;
    }
    // se saca la fecha del sistema y se hace un split por espacio para sacarla mas adecuadamente
    // fecha del sistema = Wed Nov 14 08:15:22 COT 2018
    // fecha despues del split = 14 Nov 2018 solo se sava dia mes y año
    public String getCurrentDate3() {
        String fecha = currentDate.toString();
        //System.out.println(fecha);// Wed Nov 14 08:15:22 COT 2018
        String[] fechaAux = fecha.split(" ");
        fecha = fechaAux[2]+" "+fechaAux[1]+" "+fechaAux[5];
        //System.out.println(fecha);// 14 Nov 2018
        return fecha;
    }    
    public void setArticulos_cliente2(List<Articulo> articulos_cliente) {
        this.articulos_cliente = articulos_cliente;
    }    
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (articulo != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(articulo);
                } else {
                    getFacade().remove(articulo);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleadmin").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleadmin").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Articulo getArticulo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Articulo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Articulo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Articulo.class)
    public static class ArticuloControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ArticuloController controller = (ArticuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "articuloController");
            return controller.getArticulo(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Articulo) {
                Articulo o = (Articulo) object;
                return getStringKey(o.getArtId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Articulo.class.getName()});
                return null;
            }
        }

    }

}
