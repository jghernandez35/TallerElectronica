package com.tallerelectronica.managedbean;

import com.tallerelectronica.entidades.Articulo;
import com.tallerelectronica.entidades.Cliente;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.CargarVistaController;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.ArticuloFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("articuloController")
@SessionScoped
public class ArticuloController implements Serializable {

    @EJB
    private com.tallerelectronica.sessionbean.ArticuloFacade ejbFacade;
    private List<Articulo> items = null;
    private List<Articulo> items_cliente = null;
    private Articulo articulo;
    private Cliente cliente;
    
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
        return ejbFacade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String articuloCargarLista(){
        return "/admin/articulo/List";
    }
    // no funciona, asi lo manejaba en proyectos anteriores, pero no funciona en este.
    public void articuloCargarLista2(CargarVistaController cvc){
        System.out.println("En Controlador ArticuloController Metodo articuloCargarLista()");
        //CargarVistaController cvc = new CargarVistaController();
        //System.out.println("Se Creo el objeto CargarVistaController NOOO /articulo/List");
        System.out.println("return /admin/articulo/List");
        cvc.CargarListaArticulos2();  
    }
    
    public String prepareGestionArticulosCliente(Cliente cli){
        cliente = cli;
        return "/admin/cliente/ListArticulosCliente";
    }  
    
    public Articulo prepareCreate() {
        articulo = new Articulo();
        initializeEmbeddableKey();
        return articulo;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("ArticuloDeleted"));
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
    public List<Articulo> getItems_cliente() {
        items_cliente=getFacade().listarArticulosCliente(cliente.getCliId());
        return items_cliente;
    }

    public void setItems_cliente(List<Articulo> items_cliente) {
        this.items_cliente = items_cliente;
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleGeneral").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleGeneral").getString("PersistenceErrorOccured"));
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
                return getStringKey(o.getArtIdNumorden());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Articulo.class.getName()});
                return null;
            }
        }

    }

}
