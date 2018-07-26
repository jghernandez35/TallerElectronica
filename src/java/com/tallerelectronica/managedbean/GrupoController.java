package com.tallerelectronica.managedbean;

import com.tallerelectronica.entidades.Grupo;
import com.tallerelectronica.managedbean.util.JsfUtil;
import com.tallerelectronica.managedbean.util.JsfUtil.PersistAction;
import com.tallerelectronica.sessionbean.GrupoFacade;

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

@Named("grupoController")
@SessionScoped
public class GrupoController implements Serializable {

    @EJB
    private com.tallerelectronica.sessionbean.GrupoFacade ejbFacade;
    private List<Grupo> items = null;
    private Grupo selected;

    public GrupoController() {
    }

    public Grupo getSelected() {
        return selected;
    }

    public void setSelected(Grupo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getGrupoPK().setRolId(selected.getRol().getRolId());
        selected.getGrupoPK().setTecId(selected.getTecnico().getTecId());
    }

    protected void initializeEmbeddableKey() {
        selected.setGrupoPK(new com.tallerelectronica.entidades.GrupoPK());
    }

    private GrupoFacade getFacade() {
        return ejbFacade;
    }

    public Grupo prepareCreate() {
        selected = new Grupo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleGeneral").getString("GrupoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleGeneral").getString("GrupoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleGeneral").getString("GrupoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Grupo> getItems() {
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

    public Grupo getGrupo(com.tallerelectronica.entidades.GrupoPK id) {
        return getFacade().find(id);
    }

    public List<Grupo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Grupo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Grupo.class)
    public static class GrupoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GrupoController controller = (GrupoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "grupoController");
            return controller.getGrupo(getKey(value));
        }

        com.tallerelectronica.entidades.GrupoPK getKey(String value) {
            com.tallerelectronica.entidades.GrupoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.tallerelectronica.entidades.GrupoPK();
            key.setTecId(Integer.parseInt(values[0]));
            key.setRolId(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.tallerelectronica.entidades.GrupoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTecId());
            sb.append(SEPARATOR);
            sb.append(value.getRolId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Grupo) {
                Grupo o = (Grupo) object;
                return getStringKey(o.getGrupoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Grupo.class.getName()});
                return null;
            }
        }

    }

}
