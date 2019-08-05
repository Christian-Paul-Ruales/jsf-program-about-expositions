/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Models.Group;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author paulr
 */
@ManagedBean
public class ProyectoInsertar {
    
   
     public void add(String tema, String descripcion, String idalumno, String idnivel, String idcarrera,String imagen) throws SQLException{
    Group group = new Group();
    String []cad=imagen.split(",");
   // public char charAt(int index)
   
    imagen=cad[0];
 
    String cad2[]=imagen.split("=");
    imagen=cad2[1];
    
	if ((group.numProyecto()+ 1) != 0) {
         //   reques
           System.out.println("----------------------------- err"+tema+" "+descripcion+" - "+idalumno+" - "+idnivel+"  -"+idcarrera+" = " +imagen );
		group.methods.execute("INSERT INTO public.proyecto(idproyecto, tema, "
                        + "descripcion, idalumno, idnivel, idcarrera, imagen)VALUES (" 
                        + (group.numProyecto()+ 1) + ",'" + tema + "','"+descripcion+"','"+idalumno+"','"+idnivel+"','"+idcarrera+"','"+imagen+"')");
		//response.sendRedirect("../carreras.jsp");
	}
        
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("../proyectos.xhtml");
            // group=new Group();
        } catch (IOException ex) {
            Logger.getLogger(CarrerasInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    

    
}
