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
public class ComentariosInsertar {
     public void insertarComentario(String Comentario,String idProyecto,String Calificacion,String Estudiante, String Correo) throws SQLException{
    Group group = new Group();
	if ((group.numComentario() + 1) != 0) {
         //   reques
		group.methods.execute("INSERT INTO public.comentario(idcomentario, comentario, idproyecto, "
                        + "idcalificacion, estudiante_comentario, email)VALUES (" + (group.numComentario() + 1) + ",'" 
                        + Comentario +"','"+idProyecto+"','"+Calificacion+"','"+Estudiante+"','"+Correo+"')");
		//response.sendRedirect("../carreras.jsp");
	}
        
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("../comentarios.xhtml");
            // group=new Group();
        } catch (IOException ex) {
            Logger.getLogger(CarrerasInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
