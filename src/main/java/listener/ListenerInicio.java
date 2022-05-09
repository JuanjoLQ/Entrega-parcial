package listener;

import java.util.Hashtable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import acciones.Accion;
import acciones.AccionBorrar;
import acciones.AccionLogin;
import acciones.AccionNuevo;
import acciones.AccionUpdate;
import pojos.Producto;
import pojos.Usuario;

/**
 * Application Lifecycle Listener implementation class ListenerInicio
 *
 */
@WebListener
public class ListenerInicio implements ServletContextListener {
	
	private Hashtable<String, Usuario> usuarios = null;
	private Hashtable<String, Producto> productos = null;
	private Hashtable<String, Accion> acciones = null;
    /**
     * Default constructor. 
     */
    public ListenerInicio() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	this.usuarios = new Hashtable<String, Usuario>();
    	this.acciones = new Hashtable<String, Accion>();
    	this.productos = new Hashtable<String, Producto>();
    	
    	
    	
    	this.usuarios.put("admin", new Usuario("admin", "admin", true));
    	this.usuarios.put("Juanjo", new Usuario("Juanjo", "1234"));
    	
    	/*
    	Usuario usuario = this.usuarios.get("Juanjo");
    	usuario.setAdmin(true);
    	this.usuarios.replace(usuario.getUsername(), usuario);
    	*/
    	
    	this.acciones.put("LOGIN", new AccionLogin());
    	this.acciones.put("NEW", new AccionNuevo());
    	this.acciones.put("ELIMINAR", new AccionBorrar());
    	this.acciones.put("UPDATE", new AccionUpdate());
    	
    	this.productos.put("1", new Producto("1", "manzana"));
    	this.productos.put("2", new Producto("2", "mandarina"));
    	
    	
    	sce.getServletContext().setAttribute("PRODUCTOS", this.productos);
    	sce.getServletContext().setAttribute("USUARIOS", this.usuarios);
    	sce.getServletContext().setAttribute("ACCIONES", this.acciones);
    	
    	
         System.out.println("Estas en el listener");
    }
	
}
