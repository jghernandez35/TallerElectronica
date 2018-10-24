package com.tallerelectronica.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="ValidarCampoMaximo10Caracteres")
public class ValidarCampoMaximo10Caracteres implements Validator
{
   

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
        
        if(texto.length()>20)
        {
             FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"","No se permite mas de 10 caracteres.");
             throw new ValidatorException(msg);  
        }           
        
    }
}