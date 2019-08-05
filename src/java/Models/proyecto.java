package Models;

import java.awt.Image;
//;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@ManagedBean
@SessionScoped
@Entity
@NamedQueries({
	@NamedQuery(name="proyecto.obtenerTodas", query="SELECT p FROM proyecto p")
})
public class proyecto implements Serializable{
	/// private static final long serialVersionUDI= 1L;
    
      private static final long serialVersionUID = 1249502063762562932L;

	@Id
        
        
	private int id_proyecto;
	private String id_nivel;
	private String id_lider;
	private String id_carrera;
	private String titulo_proyecto;
	private String descripcion_proyecto;
	//private Image imagen;
	private String Imagen;
	@OneToMany(mappedBy="proyecto")
	private List<comentario> comentarios;
	   // byte[] data = Files.readAllBytes(request.getParameter("nombreProyecto"));
	   //  @OneToMany(mappedBy = "proyecto")

     //   private List<comentario> Comentarios;
	   
	    
	public proyecto(int id_proyecto, String id_nivel, String id_carrera,String id_lider,  String titulo_proyecto, String descripcion_proyecto,String img) {
		this.id_proyecto = id_proyecto;
		this.id_nivel = id_nivel;
		this.id_lider = id_lider;
		this.id_carrera = id_carrera;
		this.titulo_proyecto = titulo_proyecto;
		this.descripcion_proyecto = descripcion_proyecto;
		this.Imagen=img;
		//this.archivoimg2=img;
		
	}

    public proyecto() {
    }
        
        
	
	public String getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(String id_nivel) {
		this.id_nivel = id_nivel;
	}

	public String getId_lider() {
		return id_lider;
	}

	public void setId_lider(String id_lider) {
		this.id_lider = id_lider;
	}

	public String getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getTitulo_proyecto() {
		return titulo_proyecto;
	}

	public void setTitulo_proyecto(String titulo_proyecto) {
		this.titulo_proyecto = titulo_proyecto;
	}

	public String getDescripcion_proyecto() {
		return descripcion_proyecto;
	}

	public void setDescripcion_proyecto(String descripcion_proyecto) {
		this.descripcion_proyecto = descripcion_proyecto;
	}

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
 
        

	public int getId_proyecto() {
		return id_proyecto;
	}
	
	
	
	public String getImagen() {
		return Imagen;
	}
	
	public void setImagen(String imagen) {
		Imagen = imagen;
	}

    public List<comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<comentario> comentarios) {
        this.comentarios = comentarios;
    }

   public String miparametro(){
             FacesContext facesContext = FacesContext.getCurrentInstance();
                Map params = facesContext.getExternalContext().getRequestParameterMap();
            Integer parametroObtenido= new Integer((String) params.get("PrmidProyectos"));
           
            this.id_proyecto=parametroObtenido;
// return parametroObtenido;

            return "verProyectos";
             }
	
        
	
}
