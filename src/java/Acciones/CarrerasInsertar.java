/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Models.Group;
import java.io.IOException;
//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
public class CarrerasInsertar {
    public void insertarCarrera(String Nombre) throws SQLException{
    Group group = new Group();
	if ((group.numCarrera() + 1) != 0) {
         //   reques
		group.methods.execute("INSERT INTO \"carrera\" (idcarrera, carrera) VALUES (" + (group.numCarrera() + 1) + ", '" + Nombre + "')");
		//response.sendRedirect("../carreras.jsp");
	}
        
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("../carreras.xhtml");
            // group=new Group();
        } catch (IOException ex) {
            Logger.getLogger(CarrerasInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
