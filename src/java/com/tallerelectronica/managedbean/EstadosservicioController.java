package com.tallerelectronica.managedbean;

import com.tallerelectronica.entidades.Estadosservicio;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.EstadosservicioFacade;

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

@Named("estadosservicioController")
@SessionScoped
public class EstadosservicioController implements Serializable {

    @EJB
    private com.tallerelectronica.sessionbean.EstadosservicioFacade ejbFacade;
    private List<Estadosservicio> items = null;
    private Estadosservicio selected;

    public EstadosservicioController() {
    }

    public Estadosservicio getSelected() {
        return selected;
    }

    public void setSelected(Estadosservicio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstadosservicioFacade getFacade() {
        return ejbFacade;
    }

    public Estadosservicio prepareCreate() {
        selected = new Estadosservicio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("EstadosservicioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("EstadosservicioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("EstadosservicioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Estadosservicio> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
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

    public Estadosservicio getEstadosservicio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Estadosservicio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Estadosservicio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Estadosservicio.class)
    public static class EstadosservicioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadosservicioController controller = (EstadosservicioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadosservicioController");
            return controller.getEstadosservicio(getKey(value));
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
            if (object instanceof Estadosservicio) {
                Estadosservicio o = (Estadosservicio) object;
                return getStringKey(o.getEstId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Estadosservicio.class.getName()});
                return null;
            }
        }

    }

}
