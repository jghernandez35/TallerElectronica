package com.zeus.tallerelectronica.managedbean;

import com.zeus.tallerelectronica.entidades.Tiporepuesto;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.zeus.tallerelectronica.sessionbean.TiporepuestoFacade;

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

@Named("tiporepuestoController")
@SessionScoped
public class TiporepuestoController implements Serializable {

    @EJB
    private com.zeus.tallerelectronica.sessionbean.TiporepuestoFacade ejbFacade;
    private List<Tiporepuesto> items = null;
    private Tiporepuesto selected;

    public TiporepuestoController() {
    }

    public Tiporepuesto getSelected() {
        return selected;
    }

    public void setSelected(Tiporepuesto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TiporepuestoFacade getFacade() {
        return ejbFacade;
    }

    public Tiporepuesto prepareCreate() {
        selected = new Tiporepuesto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleadmin").getString("TiporepuestoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundleadmin").getString("TiporepuestoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundleadmin").getString("TiporepuestoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tiporepuesto> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleadmin").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleadmin").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Tiporepuesto getTiporepuesto(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tiporepuesto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tiporepuesto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tiporepuesto.class)
    public static class TiporepuestoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TiporepuestoController controller = (TiporepuestoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tiporepuestoController");
            return controller.getTiporepuesto(getKey(value));
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
            if (object instanceof Tiporepuesto) {
                Tiporepuesto o = (Tiporepuesto) object;
                return getStringKey(o.getTiporepuId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tiporepuesto.class.getName()});
                return null;
            }
        }

    }

}
