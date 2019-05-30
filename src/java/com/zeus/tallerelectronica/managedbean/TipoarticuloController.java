package com.zeus.tallerelectronica.managedbean;

import com.zeus.tallerelectronica.entidades.Tipoarticulo;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.zeus.tallerelectronica.sessionbean.TipoarticuloFacade;

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

@Named("tipoarticuloController")
@SessionScoped
public class TipoarticuloController implements Serializable {

    @EJB
    private com.zeus.tallerelectronica.sessionbean.TipoarticuloFacade ejbFacade;
    private List<Tipoarticulo> items = null;
    private Tipoarticulo selected;

    public TipoarticuloController() {
    }

    public Tipoarticulo getSelected() {
        return selected;
    }

    public void setSelected(Tipoarticulo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoarticuloFacade getFacade() {
        return ejbFacade;
    }

    public Tipoarticulo prepareCreate() {
        selected = new Tipoarticulo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleadmin").getString("TipoarticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundleadmin").getString("TipoarticuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundleadmin").getString("TipoarticuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tipoarticulo> getItems() {
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

    public Tipoarticulo getTipoarticulo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tipoarticulo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tipoarticulo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tipoarticulo.class)
    public static class TipoarticuloControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoarticuloController controller = (TipoarticuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoarticuloController");
            return controller.getTipoarticulo(getKey(value));
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
            if (object instanceof Tipoarticulo) {
                Tipoarticulo o = (Tipoarticulo) object;
                return getStringKey(o.getTipartId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tipoarticulo.class.getName()});
                return null;
            }
        }

    }

}
