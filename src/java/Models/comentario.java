package Models;

//import Entidades.Proyecto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@ManagedBean
@Entity
@NamedQuery(name="comentario.ComentarioPorProyecto", query="SELECT c FROM comentario c WHERE c.proyecto.id_proyecto=:id_proyecto")

public class comentario implements Serializable {
 
    private static final long serialVersionUID = 12L;
	@Id
	private int id_comentario;
	private String id_proyecto;
	private String nota_comentario;
	private String estudiante_comentario;
	private String calificacion;
	private String correo_estudiante;
        
         @ManyToOne()
    
    
    @JoinColumn(name = "id_proyecto")
        private proyecto proyecto;
	
	public comentario(int id_comentario, String id_proyecto, String nota_comentario,String Correo_est,String estudiante_comentario,String calificacionm) {
		this.id_comentario = id_comentario;
		this.id_proyecto = id_proyecto;
		this.nota_comentario = nota_comentario;
		this.estudiante_comentario = estudiante_comentario;
		this.calificacion=calificacionm;
		this.correo_estudiante=Correo_est;
	}
	
	public String getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(String id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getNota_comentario() {
		return nota_comentario;
	}

	public void setNota_comentario(String nota_comentario) {
		this.nota_comentario = nota_comentario;
	}

	public String getEstudiante_comentario() {
		return estudiante_comentario;
	}

	public void setEstudiante_comentario(String estudiante_comentario) {
		this.estudiante_comentario = estudiante_comentario;
	}

	public int getId_comentario() {
		return id_comentario;
	}

	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getCorreo_estudiante() {
		return correo_estudiante;
	}
	
	public void setCorreo_estudiante(String correo_estudiante) {
		this.correo_estudiante = correo_estudiante;
	}

    public proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public comentario() {
    }
	
    
	
	
}
