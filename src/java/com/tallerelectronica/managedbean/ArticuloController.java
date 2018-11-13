package com.tallerelectronica.managedbean;

import com.tallerelectronica.entidades.Articulo;
import com.tallerelectronica.entidades.Cliente;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.CargarVistaController;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.ArticuloFacade;

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
    private com.tallerelectronica.sessionbean.ArticuloFacade ejbFacadeArticulo;
    private List<Articulo> items = null;
    private List<Articulo> articulos_cliente = null;
    private Articulo articulo;
    private Cliente cliente;
    
    private Date currentDate = new Date();    
    
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

    private ArticuloFacade getFacadeArticulo() {
        return ejbFacadeArticulo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
    //limpia el articulo-cliente para que no queden datos basura
    public void limpiarArticuloCliente() {
        System.out.println("En limpiarArticuloCliente()");
        articulo = null;
        //cliente = null;
    }
    
    public String articuloCargarLista(){
        return "/admin/articulo/List";
    }
    
    public String prepareVerArticuloCliente(Articulo a){
        System.out.println("En prepareVerArticuloCliente(Articulo a)");
        articulo = a;
        return "/admin/articulo/ViewArticuloCliente";
    } 
    //prepara la lista de articulos asociados a un cliente, el cliente llega desde ClienteController
    public String prepareGestionArticulosCliente(Cliente cli){   
        System.out.println("En prepareGestionArticulosCliente(Cliente cli)");
        cliente = cli;
        return "/admin/articulo/ListArticulosCliente";
    }  
    
    public Articulo prepareCreate() {
        articulo = new Articulo();
        initializeEmbeddableKey();
        return articulo;
    }
    // prepara lo necesario para crear un articulo asociado a un cliente
    public String prepareCreateArticuloCliente() {
        System.out.println("En prepareCreateArticuloCliente()");
        articulo = new Articulo();
        //initializeEmbeddableKey();
        return "/admin/articulo/CreateArticuloCliente";
    }      
    // pendiente de si se usa o no
    public String cancelCrearArticuloCliente() {
        System.out.println("En cancelCrearArticuloCliente()");
        addMessage("Crear Artículo Cliente", "Cancelado Correctamente");
        return "/admin/articulo/ListArticulosCliente";
    } 
    
    public String create() {
        System.out.println("En create()");
        articulo.setArtFechaingreso(currentDate);//se fija la fecha de ingreso del articulo sacada de el sistema
        articulo.setCliId(cliente);//se fija el cliente asociado a el articulo
        //System.out.println("Fecha = "+currentDate.toString());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        limpiarArticuloCliente();
        return "/admin/articulo/ListArticulosCliente";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloUpdated"));
    }

    public String destroy(Articulo a) {
        System.out.println("En destroy(Articulo a)");
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            ejbFacadeArticulo.remove(a);
            articulo = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            addMessage("Eliminar Artículo", "Artículo Eliminado Correctamente");
        }
        return "/admin/articulo/ListArticulosCliente";
    }

    public List<Articulo> getItems() {
        if (items == null) {
            items = getFacadeArticulo().findAll();
        }
        return items;
    }
    //internamente se ejecuta consulta para sacar los Articulos asociados a un Cliente mediante el id 
    public List<Articulo> getArticulos_cliente() {
        articulos_cliente=getFacadeArticulo().listarArticulosCliente(cliente.getCliId());
        return articulos_cliente;
    }
    // para sacar la fecha del sistema
    public Date getCurrentDate() {
        return currentDate;
    }
    
    public String getCurrentDate2() {
        String fecha = currentDate.toString();
        String[] fechaAux = fecha.split(" ");
        fecha = fechaAux[2]+" "+fechaAux[1]+" "+fechaAux[5];
        System.out.println(fecha);
        return fecha;
    }    
    public void setArticulos_cliente(List<Articulo> articulos_cliente) {
        this.articulos_cliente = articulos_cliente;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (articulo != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacadeArticulo().edit(articulo);
                } else {
                    getFacadeArticulo().remove(articulo);
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleGeneral").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleGeneral").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Articulo getArticulo(java.lang.Integer id) {
        return getFacadeArticulo().find(id);
    }

    public List<Articulo> getItemsAvailableSelectMany() {
        return getFacadeArticulo().findAll();
    }

    public List<Articulo> getItemsAvailableSelectOne() {
        return getFacadeArticulo().findAll();
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
                return getStringKey(o.getArtIdNumorden());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Articulo.class.getName()});
                return null;
            }
        }

    }

}
