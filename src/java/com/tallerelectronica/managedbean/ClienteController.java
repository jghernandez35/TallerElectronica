package com.tallerelectronica.managedbean;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import com.tallerelectronica.entidades.Cliente;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.ClienteFacade;

import java.io.Serializable;
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

@Named("clienteController")
@SessionScoped
public class ClienteController implements Serializable {

    @EJB
    private com.tallerelectronica.sessionbean.ClienteFacade ejbFacadeCliente;
    private List<Cliente> items = null;
    private Cliente cliente;

    public ClienteController() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ClienteFacade getFacadeCliente() {
        return ejbFacadeCliente;
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    //carga la lista de los clientes del sistema
    public String clienteCargarLista(){
        //cliente = new Cliente();
        System.out.println("En clienteCargarLista()");
        return "/admin/cliente/ListClientes";
    }
    //limpia el cliente para que no queden datos basura
    public void limpiarCliente() {
        System.out.println("En limpiarCliente()");
        cliente = null;
    }
    // prepara lo necesario para crear un cliente
    public String prepareCreate() {
        System.out.println("En prepareCreate()");
        cliente = new Cliente();
        //initializeEmbeddableKey();
        return "/admin/cliente/CreateCliente";
    }  
    
    // prepara lo necesario para editar un cliente
    public String prepareEditarCliente(Cliente c) {
        System.out.println("En prepareEditarCliente(Cliente c)");
        cliente = c;
        initializeEmbeddableKey();
        return "/admin/cliente/EditCliente";
    }    
    
    public String create() {
        System.out.println("En create()");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("ClienteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            //return "/admin/cliente/ListClientes";
        }
        limpiarCliente();
        return "/admin/cliente/ListClientes";
    }
    
    public String cancelCrearCliente() {
        System.out.println("En cancelCrearCliente()");
        limpiarCliente();
        //clienteCargarLista();
        addMessage("Crear Cliente", "Cancelado Correctamente");
        return "/admin/cliente/ListClientes";
    }    
    
    //actualiza el cliente seleccionado
    public String update() {
        System.out.println("En update()");
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("ClienteUpdated"));
        return "/admin/cliente/ListClientes";
    }
    
    public String cancelUpdateCliente() {
        System.out.println("En cancelUpdateCliente()");
        limpiarCliente();
        addMessage("Actualizar Cliente", "Cancelado Correctamente");
        return "/admin/cliente/ListClientes";
    }          

    public String destroy(Cliente c) {
        System.out.println("En destroy(Cliente c)");
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("ClienteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            ejbFacadeCliente.remove(c);
            cliente = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            addMessage("Eliminar Cliente", "Cliente Eliminado Correctamente");
        }
        return "/admin/cliente/ListClientes";
    }

    public List<Cliente> getItems() {
        if (items == null) {
            items = getFacadeCliente().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (cliente != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacadeCliente().edit(cliente);
                } else {
                    getFacadeCliente().remove(cliente);
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

    public Cliente getCliente(java.lang.Integer id) {
        return getFacadeCliente().find(id);
    }

    public List<Cliente> getItemsAvailableSelectMany() {
        return getFacadeCliente().findAll();
    }

    public List<Cliente> getItemsAvailableSelectOne() {
        return getFacadeCliente().findAll();
    }

    @FacesConverter(forClass = Cliente.class)
    public static class ClienteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClienteController controller = (ClienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clienteController");
            return controller.getCliente(getKey(value));
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
            if (object instanceof Cliente) {
                Cliente o = (Cliente) object;
                return getStringKey(o.getCliId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cliente.class.getName()});
                return null;
            }
        }

    }

}
