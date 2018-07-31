package com.tallerelectronica.validadores;


import com.tallerelectronica.sessionbean.ClienteFacade;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="ValidarCampoNumeroIdentificacionCliente")
public class ValidarCampoNumeroIdentificacionCliente implements Validator,Serializable
{
    @EJB
    private ClienteFacade clienteEJB;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
    
      
        
        if(clienteEJB.buscarPorNumeroIdentificacion(texto))
        {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Numero de identificacion ya esta registrado");
            throw new ValidatorException(msg); 
        }else{
                
        }
        
    }
}