package com.zeus.tallerelectronica.managedbean;

import com.zeus.tallerelectronica.entidades.Imagen;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil;
import com.zeus.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.zeus.tallerelectronica.sessionbean.ImagenFacade;

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

@Named("imagenController")
@SessionScoped
public class ImagenController implements Serializable {

    @EJB
    private com.zeus.tallerelectronica.sessionbean.ImagenFacade ejbFacade;
    private List<Imagen> items = null;
    private Imagen selected;

    public ImagenController() {
    }

    public Imagen getSelected() {
        return selected;
    }

    public void setSelected(Imagen selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ImagenFacade getFacade() {
        return ejbFacade;
    }

    public Imagen prepareCreate() {
        selected = new Imagen();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleadmin").getString("ImagenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundleadmin").getString("ImagenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundleadmin").getString("ImagenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Imagen> getItems() {
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

    public Imagen getImagen(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Imagen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Imagen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Imagen.class)
    public static class ImagenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImagenController controller = (ImagenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imagenController");
            return controller.getImagen(getKey(value));
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
            if (object instanceof Imagen) {
                Imagen o = (Imagen) object;
                return getStringKey(o.getImgId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Imagen.class.getName()});
                return null;
            }
        }

    }

}
