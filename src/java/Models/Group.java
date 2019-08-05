package Models;

import Connection.Metodos;

//import static Models.proyecto_.comentarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

//import Dao.exceptions.RollbackFailureException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.registry.LifeCycleManager;


@ManagedBean
public class Group {

	public Metodos methods;
	HashMap<Integer, Carrera> carreras = new HashMap<>();
	HashMap<Integer, lider> lideres = new HashMap<>();
	HashMap<Integer, nivel> niveles = new HashMap<>();
	HashMap<Integer, proyecto> proyectos = new HashMap<>();
	HashMap<Integer, comentario> comentarios = new HashMap<>();
        HashMap<Integer, Reporte> reportes = new HashMap<>();
        

    public HashMap<Integer, Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(HashMap<Integer, Carrera> carreras) {
        this.carreras = carreras;
    }

    public HashMap<Integer, nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(HashMap<Integer, nivel> niveles) {
        this.niveles = niveles;
    }

    public HashMap<Integer, lider> getLideres() {
        return lideres;
    }

    public void setLideres(HashMap<Integer, lider> lideres) {
        this.lideres = lideres;
    }

    public HashMap<Integer, proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(HashMap<Integer, proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public HashMap<Integer, comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(HashMap<Integer, comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public HashMap<Integer, Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(HashMap<Integer, Reporte> reportes) {
        this.reportes = reportes;
    }
    
    
    
        
        
        
	
	public Group() {
		try {
		
                    methods = new Metodos();
			llenarMapaCarreras();
			llenarMapaNiveles();
                        llenarMapaLideres();
                        llenarMapaProyectos();
                        llenarMapaComentarios();
                    try {
                        llenarMapaReportes();
                    } catch (SQLException ex) {
                        Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (ClassNotFoundException e) {
			System.out.println("------------ ERROR EN EL CONSTRUCTOR GROUP: " + e);
			e.printStackTrace();
		}
		
	}
	
	private void llenarMapaCarreras() {
		ResultSet result = this.methods.read("SELECT * FROM  \"carrera\"");
		try {
			while (result.next()) {
				this.carreras.put(result.getInt(1), new Carrera(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("------------ ERROR EN EL METODO LLENAR CARRERAS GROUPP: " + e);
			e.printStackTrace();
		}
	}
	
	
        private void llenarMapaNiveles() {
		ResultSet result = this.methods.read("SELECT * FROM  \"nivel\"");
		try {
			while (result.next()) {
				this.niveles.put(result.getInt(1), new nivel(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("------------ ERROR EN EL METODO LLENAR NIVELES GROUPP: " + e);
			e.printStackTrace();
		}
	}
	
        
        private void llenarMapaLideres() {
		ResultSet result = this.methods.read("SELECT * FROM  \"alumno\"");
		try {
			while (result.next()) {
				this.lideres.put(result.getInt(1), new lider(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
			}
		} catch (SQLException e) {
			System.out.println("------------ ERROR EN EL METODO LLENAR LIDERES GROUPP: " + e);
			e.printStackTrace();
		}
	}

	
        private void llenarMapaProyectos() {
		ResultSet result = this.methods.read("select idproyecto, nivel,"
				+ " carrera, nombre, tema, descripcion, imagen"
				+ " from proyecto, nivel, carrera, alumno where nivel.idnivel=proyecto.idnivel"
				+ " and carrera.idcarrera=proyecto.idcarrera and "
				+ "proyecto.idalumno=alumno.idalumno order by carrera.carrera");
		try {
			while (result.next()) {
				String det=result.getInt(1)+"-"+ result.getString(2)+"-"+ result.getString(3)+"-"+ result.getString(4)+"-"+result.getString(5)+"-"+result.getString(6)+"-"+result.getString(7);
				System.out.println(det);

				this.proyectos.put(result.getInt(1), new proyecto(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),result.getString(7)));
			
			
			}
		} catch (SQLException e) {
			System.out.println("------------ ERROR EN EL METODO LLENAR PROYECTOS GROUPP: " + e);
			e.printStackTrace();
		}
	}
        
        
        private void llenarMapaComentarios() {
		ResultSet result = this.methods.read("select idcomentario, comentario, tema, valor, estudiante_comentario, email from comentario, calificacion, proyecto " +
"where comentario.idcalificacion=calificacion.idcalificacion and comentario.idproyecto=proyecto.idproyecto");
		try {
			while (result.next()) {
				this.comentarios.put(result.getInt(1), new comentario(result.getInt(1), result.getString(3), result.getString(2), result.getString(6), result.getString(5), result.getString(4)));
			}
		} catch (SQLException e) {
			System.out.println("------------ ERROR EN EL METODO LLENAR NIVELES GROUPP: " + e);
			e.printStackTrace();
		}
	}
	
        
        public void llenarMapaReportes() throws SQLException{
            
            ArrayList<Integer> proyectos = new ArrayList<>();
            int A=0,B=0,C=0;
            String codCarreras="Select * from proyecto";
            ResultSet resultCarreras=this.methods.read(codCarreras);
            
            while (resultCarreras.next()) {
                try {
                    proyectos.add(resultCarreras.getInt(1));
                } catch (SQLException ex) {
                    
                    Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        for(int r=0; r<proyectos.size();r++){
             
            try {
                 String codAs="Select idproyecto, count(idcalificacion) from comentario "
                    + "where idcalificacion=1 and idproyecto="+proyectos.get(r)+" group by idproyecto  order by idproyecto";
        
            ResultSet rA = this.methods.read(codAs);
            rA.next();
			
            A=rA.getInt(2);
            rA.close();
                
                
            } catch (Exception e) {
                A=0;
            }
           
            
            try {
                 String codBs="Select idproyecto, count(idcalificacion) from comentario "
                    + "where idcalificacion=2 and idproyecto="+proyectos.get(r)+" group by idproyecto  order by idproyecto";
        
            ResultSet rB = this.methods.read(codBs);
            rB.next();
			
            B=rB.getInt(2);
            rB.close();
            } catch (Exception e) {
                B=0;
            }
            
            
            
            try {
                 String codCs="Select idproyecto, count(idcalificacion) from comentario "
                    + "where idcalificacion=3 and idproyecto="+proyectos.get(r)+" group by idproyecto  order by idproyecto";
        
            ResultSet rC = this.methods.read(codCs);
            rC.next();
			
             C=rC.getInt(2);
            rC.close();
            } catch (Exception e) {
                C=0;
            }
            
           
            //Reporte reportAux=n
             Reporte reporteAux=new Reporte(proyectos.get(r)+"",A,B,C);
           // reportes.add(reporteAux);
            reportes.put(proyectos.get(r), reporteAux);
            //reportes.p
            
        }    
        
            
        
       
        
        
        }
        
        public String buscarcarrera(int codigo){
            String Busqueda="";
            ResultSet result = this.methods.read("select * from carrera where idcarrera="+codigo);
            
            try {
                result.next();
               Busqueda=result.getString(2);
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }
        
    
        public int []buscarReporte(int clave){
            int []Reporte=new int[4];
                   
            for (Map.Entry<Integer, Reporte> entry : reportes.entrySet()) {
                int key = entry.getKey();
                if(key==clave){
                     Reporte value = entry.getValue();
                     int id= Integer.parseInt(value.getNombre_Carrera());
                     int numA=value.getCantidad_As();
                     int numB=value.getCantidad_Bs();
                     int numC=value.getCantidad_Cs();
                     
                     Reporte[0]=id;
                     Reporte[1]=numA;
                     Reporte[2]=numB;
                     Reporte[3]=numC;
                     
                
                }
               
               
               // repo
            }
        
         return Reporte;
        
        }
        
          public String buscarNivel(int codigo){
            String Busqueda="";
            ResultSet result = this.methods.read("select * from nivel where idnivel="+codigo);
            
            try {
                result.next();
               Busqueda=result.getString(2);
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }

          
          public String []buscarLider(int codigo){
            String []Busqueda = new String[3];
            ResultSet result = this.methods.read("select * from alumno where idalumno="+codigo);
            
            try {
                result.next();
                
               Busqueda[0]=result.getString(2);
               Busqueda[1]=result.getString(3);
               Busqueda[2]=result.getString(4);
             //  Busqueda[3]=result.getString(5);

             
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }
          
          
	
	
	
	
	
          public String []buscarProyecto(int codigo){
            String []Busqueda = new String[6];
            ResultSet result = this.methods.read("select nivel,"
				+ " carrera, nombre, tema, descripcion, imagen"
				+ " from proyecto, nivel, carrera, alumno where nivel.idnivel=proyecto.idnivel"
				+ " and carrera.idcarrera=proyecto.idcarrera and "
				+ "proyecto.idalumno=alumno.idalumno and idproyecto="+codigo);
            
            try {
                result.next();
                
               Busqueda[0]=result.getString(1).toString();
               Busqueda[1]=result.getString(2);
               Busqueda[2]=result.getString(3);
                Busqueda[3]=result.getString(4).toString();
               Busqueda[4]=result.getString(5);
               Busqueda[5]=result.getString(6);
             //  Busqueda[3]=result.getString(5);

             
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }
          
          public String []buscarComentario(int codigo){
            String []Busqueda = new String[6];
            ResultSet result = this.methods.read("select idcomentario, comentario, tema, valor, estudiante_comentario, email from comentario, calificacion, proyecto " +
"where comentario.idcalificacion=calificacion.idcalificacion and comentario.idproyecto=proyecto.idproyecto and idcomentario="
                    +codigo);
            try {
                result.next();
                
               Busqueda[0]=result.getString(1).toString();
               Busqueda[1]=result.getString(2);
               Busqueda[2]=result.getString(3);
                Busqueda[3]=result.getString(4).toString();
               Busqueda[4]=result.getString(5);
               Busqueda[5]=result.getString(6);
             //  Busqueda[3]=result.getString(5);

             
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }
          
          
          
	
           public String []MostrarProyecto(int codigo){
            String []Busqueda = new String[6];
            ResultSet result = this.methods.read("select tema, imagen, proyecto.descripcion, carrera, nombre, nivel " +
                                                "from alumno, carrera, nivel, proyecto " +
                                                 "where alumno.idalumno=proyecto.idalumno and carrera.idcarrera=proyecto.idcarrera and nivel.idnivel=proyecto.idnivel"
                                                    + " and idproyecto="+codigo);
            
             ResultSet resultc = this.methods.read("sselect email, estudiante_comentario, comentario, descripcion,"
                     + " valor from comentario, calificacion " +
                "where calificacion.idcalificacion=comentario.idcalificacion and idproyecto="+codigo);
            
            try {
                result.next();
                
               Busqueda[0]=result.getString(1).toString();
               Busqueda[1]=result.getString(2);
               Busqueda[2]=result.getString(3);
                Busqueda[3]=result.getString(4).toString();
               Busqueda[4]=result.getString(5);
               Busqueda[5]=result.getString(6);
             //  Busqueda[3]=result.getString(5);

             
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return Busqueda;
        }
          
          
	
	
	public int numCarrera() throws SQLException {
		int numero = -1;
		ResultSet result = this.methods.read("SELECT MAX(idcarrera) FROM \"carrera\"");
		while (result.next()) {
			numero = result.getInt(1);
		}
		return numero;
	}
	
	public int numNivel() throws SQLException {
		int numero = -1;
		
		ResultSet result = this.methods.read("SELECT MAX(idnivel) FROM \"nivel\"");
		while (result.next()) {
			numero = result.getInt(1);
		}
		return numero;
	}
        
        
        public int numLider() throws SQLException {
		int numero = -1;
		ResultSet result = this.methods.read("SELECT MAX(idalumno) FROM \"alumno\"");
		while (result.next()) {
			numero = result.getInt(1);
		}
		return numero;
	}
        
        
        	public int numProyecto() throws SQLException {
		int numero = -1;
		ResultSet result = this.methods.read("SELECT MAX(idproyecto) FROM \"proyecto\"");
		while (result.next()) {
			numero = result.getInt(1);
		}
		return numero;
	}
	
                public int numComentario() throws SQLException {
		int numero = -1;
		ResultSet result = this.methods.read("SELECT MAX(idcomentario) FROM \"comentario\"");
		while (result.next()) {
			numero = result.getInt(1);
		}
		return numero;
	}
                

                
                
           
             
                
                public List<SelectItem> hselectalumno(){

                 List<SelectItem> items = new ArrayList<SelectItem>();

                  for (Map.Entry<Integer, lider> entry : lideres.entrySet()) {
                                int key1 = entry.getKey();
                                //Carrera value = entry.getValue();
                                items.add(new SelectItem(key1, buscarLider(key1)[0]));

                            }
                  
                    //List<lider> categoryList = dao.getAllCategory();
                   // ResultSet result = this.methods.read("SELECT MAX(idproyecto) FROM \"proyecto\"");
                       
                        
                    return items;
                 }
                
                
                public List<SelectItem> hselectnivel(){

                 List<SelectItem> items = new ArrayList<SelectItem>();

                  for (Map.Entry<Integer, nivel> entry : niveles.entrySet()) {
                                int key1 = entry.getKey();
                                //Carrera value = entry.getValue();
                                items.add(new SelectItem(key1, buscarNivel(key1)));

                            }
                  
                    //List<lider> categoryList = dao.getAllCategory();
                   // ResultSet result = this.methods.read("SELECT MAX(idproyecto) FROM \"proyecto\"");
                       
                        
                    return items;
                 }
                
                
                  public List<SelectItem> hseleccarrera(){

                 List<SelectItem> items = new ArrayList<SelectItem>();

                  for (Map.Entry<Integer, Carrera> entry : carreras.entrySet()) {
                                int key1 = entry.getKey();
                                //Carrera value = entry.getValue();
                                items.add(new SelectItem(key1, buscarcarrera(key1)));

                            }
                  
                    //List<lider> categoryList = dao.getAllCategory();
                   // ResultSet result = this.methods.read("SELECT MAX(idproyecto) FROM \"proyecto\"");
                       
                        
                    return items;
                 }
                  
                  
                  public List<SelectItem> hselectProyectos(){

                 List<SelectItem> items = new ArrayList<SelectItem>();

                  for (Map.Entry<Integer, proyecto> entry : proyectos.entrySet()) {
                                int key1 = entry.getKey();
                                //Carrera value = entry.getValue();
                                items.add(new SelectItem(key1, buscarProyecto(key1)[3]));

                            }
                  
                     
                        
                    return items;
                 }
                  
                  
               
             public void miparametro(){
             FacesContext facesContext = FacesContext.getCurrentInstance();
                Map params = facesContext.getExternalContext().getRequestParameterMap();
            Integer parametroObtenido= new Integer((String) params.get("PrmidProyectos"));
           
// return parametroObtenido;
             }
             
             	
             public List<comentario> comentariosPorProyecto(int IdProyecto){
                List<comentario> ListcomentAux = new ArrayList<>();
            
             String codComentarios="select idcomentario, comentario, idproyecto, calificacion.descripcion, estudiante_comentario, email from comentario, calificacion " +
"where comentario.idcalificacion=calificacion.idcalificacion and idproyecto="+IdProyecto;
                             ResultSet resultcomentarios = this.methods.read(codComentarios);
                             
            try {
               
                while (resultcomentarios.next()) {
                    comentario auxComent=new comentario(resultcomentarios.getInt(1), IdProyecto+"", resultcomentarios.getString(2), resultcomentarios.getString(6), resultcomentarios.getString(5), resultcomentarios.getString(4));
                    //Object nextElement = en.nextElement();
                    ListcomentAux.add(auxComent);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            
            
                return ListcomentAux;
             }
             
             public int[] IDscomentariosPorProyecto(int id_proyecto) throws SQLException{
              String cantComentarios="select count(*) from comentario where id_proyecto="+id_proyecto;
               ResultSet ResultcantComentarios = this.methods.read(cantComentarios);
               ResultcantComentarios.next();
               int cant=ResultcantComentarios.getInt(1);
               int []cadIDs=new int[cant];
               
               
                String codComentarios="select * from comentario where id_proyecto="+id_proyecto;
		    ResultSet resultcomentarios = this.methods.read(codComentarios);
               for(int i=0;i<cadIDs.length;i++){
                  // resultcomentarios
                  resultcomentarios.next();
                   cadIDs[i]=resultcomentarios.getInt(1);
               }
               
             
		  //;
               return cadIDs;  
             }
             
             
             public static boolean isNumeric(String cadena) {

                    boolean resultado;

                    try {
                        Integer.parseInt(cadena);
                        resultado = true;
                    } catch (NumberFormatException excepcion) {
                        resultado = false;
                    }

                    return resultado;
                }
        
             
                                public boolean validadorDeCedula(String cedula) {
                                boolean cedulaCorrecta = false;

                                try {

                                if (cedula.length() == 10) // ConstantesApp.LongitudCedula
                                {
                                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                                if (tercerDigito < 6) {
                                // Coeficientes de validación cédula
                                // El decimo digito se lo considera dígito verificador
                                 int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                                 int verificador = Integer.parseInt(cedula.substring(9,10));
                                 int suma = 0;
                                 int digito = 0;
                                for (int i = 0; i < (cedula.length() - 1); i++) {
                                 digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                                 suma += ((digito % 10) + (digito / 10));
                                }

                                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                                 cedulaCorrecta = true;
                                }
                                else if ((10 - (suma % 10)) == verificador) {
                                 cedulaCorrecta = true;
                                } else {
                                 cedulaCorrecta = false;
                                }
                                } else {
                                cedulaCorrecta = false;
                                }
                                } else {
                                cedulaCorrecta = false;
                                }
                                } catch (NumberFormatException nfe) {
                                cedulaCorrecta = false;
                                } catch (Exception err) {
                                System.out.println("Una excepcion ocurrio en el proceso de validadcion");
                                cedulaCorrecta = false;
                                }

                                if (!cedulaCorrecta) {
                                System.out.println("La Cédula ingresada es Incorrecta");
                                }
                                return cedulaCorrecta;
                                }

             
                                public boolean isImage(String Extencion){
                                
                                    boolean verificador;
                                    if (Extencion.equalsIgnoreCase("png")) {
                                        verificador=true;
                                    }
                                    
                                    else if (Extencion.equalsIgnoreCase("jpg")) {
                                        verificador=true;
                                    }
                                    else if (Extencion.equalsIgnoreCase("gif")) {
                                        verificador=true;
                                    }else{
                                    verificador=false;
                                    }
                                
                                    return verificador;
                                }

    private Reporte Reporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
             
            
             
             
             
                
}
