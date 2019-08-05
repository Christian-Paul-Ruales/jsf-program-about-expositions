package Models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class lider {
	
	private int id_lider;
	private String nombre_lider;
        private String cedula;
        private String email;
        
	
	public lider(int id_lider, String nombre_lider, String ced,String correo) {
		this.id_lider = id_lider;
		this.nombre_lider = nombre_lider;
                this.cedula=ced;
                this.email=correo;
	}

    public lider() {
    }
	
        
        
	public int getId() {
		return this.id_lider;
	}
	
	public String getNombre() {
		return this.nombre_lider;
	}
	
	public void setNombre(String nombre_lider) {
		this.nombre_lider = nombre_lider;
	}

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
        
    
	
}
