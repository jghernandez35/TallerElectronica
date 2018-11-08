
package com.tallerelectronica.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "ValidarCampoMinimo8Numeros")
public class ValidarCampoMinimo8Numeros implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
        
        if(texto.length()<8)
        {
             FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se permite menos de 8 dígitos.","No se permite menos de 8 dígitos.");
             throw new ValidatorException(msg);  
        } 
    }
    
}
