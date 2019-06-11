
package com.zeus.tallerelectronica.validadores;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="ValidarCampoSoloLetrasNumerosGuionBajoGuionPuntosEspacioParentesisAlmohadillaSlash")
public class ValidarCampoSoloLetrasNumerosGuionBajoGuionPuntosEspacioParentesisAlmohadillaSlash implements Validator 
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
        Pattern patron = Pattern.compile("[^A-Za-z_. ñÑáéíóú0-9()#-/]");
        Matcher encaja = patron.matcher(texto);
        
        if(encaja.find())
        {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Solo se permiten caracteres alfanúmericos, guiones bajos, guion, numeros, puntos, espacios, paréntesis, almohadilla, slash.","Solo se permiten caracteres alfanúmericos, guiones bajos, guion, numeros, puntos, espacios, paréntesis, almohadilla, slash.");
            throw new ValidatorException(msg);
        }
    }
    
}