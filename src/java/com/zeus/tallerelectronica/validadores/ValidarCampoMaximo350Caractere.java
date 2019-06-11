/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author David
 */
@FacesValidator(value="ValidarCampoMaximo350Caracteres")
public class ValidarCampoMaximo350Caractere implements Validator
{
     @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String texto = String.valueOf(value);
        
        if(texto.length()>350)
        {
             FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"","No se permite mas de 350 caracteres.");
             throw new ValidatorException(msg);  
        }           
        
    }
}
