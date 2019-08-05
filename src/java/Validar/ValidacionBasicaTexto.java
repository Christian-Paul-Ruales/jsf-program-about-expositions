/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import Models.Group;
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
@FacesValidator("VBasica")

public class ValidacionBasicaTexto implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       String Texto=value.toString().trim();
        
        if (Texto.length()==0) {
            throw new ValidatorException(new FacesMessage("El campo es obligatorio"));
        }
        //0 a 30
         if (Texto.length()>30) {
            throw new ValidatorException(new FacesMessage("No ingreses mas de 30 caractes N caracteres:"+ Texto.length()));
     
        }
         Group g=  new Group();
        if (g.isNumeric(Texto)==true) {
                        throw new ValidatorException(new FacesMessage("No se aceptan numeros"));

        }
    
    
    }
    
}
