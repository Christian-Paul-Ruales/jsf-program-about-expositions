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
@FacesValidator("VImagen")
public class ValidarImagen implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String NombreImagen=value.toString().trim();
      //  String []cad=NombreImagen.split(".");
        Group g=new Group();
        
        
        String []cad=NombreImagen.split(",");
   // public char charAt(int index)
   
    NombreImagen=cad[0];
 
    String cad2[]=NombreImagen.split("=");
    NombreImagen=cad2[1];
    
    String cad3[]=NombreImagen.split("[.]");
    
    NombreImagen=cad3[1];
        
      //  String []cad2=cad[1].split(",");
     // String aux="";
       
        if (NombreImagen.length()==0) {
            throw new ValidatorException(new FacesMessage("No se ha seleccionado imagen"));
        }
        if(g.isImage(NombreImagen)==false){
        throw new ValidatorException(new FacesMessage("Archivo No permitido Solo JPG PNG o GIF:" +NombreImagen));
        }
        
    }
    
}
