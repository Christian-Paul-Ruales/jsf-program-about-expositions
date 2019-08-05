/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author paulr
 */
@ManagedBean
public class Reporte {
    
    String Nombre_Carrera;
    int Cantidad_As;
    int Cantidad_Bs;
    int Cantidad_Cs;

    public String getNombre_Carrera() {
        return Nombre_Carrera;
    }

    public void setNombre_Carrera(String Nombre_Carrera) {
        this.Nombre_Carrera = Nombre_Carrera;
    }

    public int getCantidad_As() {
        return Cantidad_As;
    }

    public void setCantidad_As(int Cantidad_As) {
        this.Cantidad_As = Cantidad_As;
    }

    public int getCantidad_Bs() {
        return Cantidad_Bs;
    }

    public void setCantidad_Bs(int Cantidad_Bs) {
        this.Cantidad_Bs = Cantidad_Bs;
    }

    public int getCantidad_Cs() {
        return Cantidad_Cs;
    }

    public void setCantidad_Cs(int Cantidad_Cs) {
        this.Cantidad_Cs = Cantidad_Cs;
    }

    public Reporte() {
    }//vacio

    public Reporte(String Nombre_Carrera, int Cantidad_As, int Cantidad_Bs, int Cantidad_Cs) {
        this.Nombre_Carrera = Nombre_Carrera;
        this.Cantidad_As = Cantidad_As;
        this.Cantidad_Bs = Cantidad_Bs;
        this.Cantidad_Cs = Cantidad_Cs;
    }
    
    
    
    
    
    
}
