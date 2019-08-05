package Models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class nivel {

	private int id_nivel;
	private String nombre_nivel;
	
	public nivel(int id_nivel, String nombre_nivel) {
		this.id_nivel = id_nivel;
		this.nombre_nivel = nombre_nivel;
	}
	
	public int getId() {
		return this.id_nivel;
	}
	
	public String getNombre() {
		return this.nombre_nivel;
	}
	
	public void setNombre(String nombre_nivel) {
		this.nombre_nivel = nombre_nivel;
	}

    public nivel() {
    }
	
        
	
}
