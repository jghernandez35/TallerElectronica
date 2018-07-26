package com.tallerelectronica.managedbean;

import com.tallerelectronica.entidades.Reparacion;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.ReparacionFacade;

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

@Named("reparacionController")
@SessionScoped
public class ReparacionController implements Serializable {

    @EJB
    private com.tallerelectronica.sessionbean.ReparacionFacade ejbFacade;
    private List<Reparacion> items = null;
    private Reparacion selected;

    public ReparacionController() {
    }

    public Reparacion getSelected() {
        return selected;
    }

    public void setSelected(Reparacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReparacionFacade getFacade() {
        return ejbFacade;
    }

    public Reparacion prepareCreate() {
        selected = new Reparacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("ReparacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("ReparacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("ReparacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Reparacion> getItems() {
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

    public Reparacion getReparacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Reparacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Reparacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Reparacion.class)
    public static class ReparacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReparacionController controller = (ReparacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reparacionController");
            return controller.getReparacion(getKey(value));
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
            if (object instanceof Reparacion) {
                Reparacion o = (Reparacion) object;
                return getStringKey(o.getRepId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reparacion.class.getName()});
                return null;
            }
        }

    }

}
