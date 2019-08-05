package Models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Carrera {

	private int id_carrera;
	private String nombre_carrera;
	
	public Carrera(int id_carrera, String nombre_carrera) {
		this.id_carrera = id_carrera;
		this.nombre_carrera = nombre_carrera;
	}
	
	public int getId() {
		return this.id_carrera;
	}
	
	public String getNombre() {
		return this.nombre_carrera;
	}
	
	public void setNombre(String nombre_carrera) {
		this.nombre_carrera = nombre_carrera;
	}

    public Carrera() {
    }

        
        
        
}
