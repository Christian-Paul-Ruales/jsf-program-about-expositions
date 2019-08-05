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
@FacesValidator("VCedula")
public class ValidacionCedula implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
   
       String Cedula=value.toString().trim();
        
    
         Group g=  new Group();
        if (g.validadorDeCedula(Cedula)==false) {
                        throw new ValidatorException(new FacesMessage("Error: Cedula No admitida: "+Cedula));

        }
    
    
    }
    
    
    
    
}
