/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author paulr
 */
@FacesValidator("VTexto50")
public class ValidarTexto50 implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      
     String TextoTamano50=value.toString().trim();
        
        if (TextoTamano50.length()==0) {
            throw new ValidatorException(new FacesMessage("El campo es obligatorio"));
        }
         if (TextoTamano50.length()>50) {
            throw new ValidatorException(new FacesMessage("No ingreses mas de 50 caractes N caracteres:"+ TextoTamano50.length()));
     
        }
    
    
    }
    
}
