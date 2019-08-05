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
@FacesValidator("VCarrera")

public class ValidarCarrera implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    
        String Carrera=value.toString().trim();
        
        if (Carrera.length()==0) {
            throw new ValidatorException(new FacesMessage("El Nombre de la carrera es obligatorio"));
        }
        else if (Carrera.length()>60) {
            throw new ValidatorException(new FacesMessage("No ingreses mas de 60 caractes N caracteres:"+ Carrera.length()));
     
        }
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
