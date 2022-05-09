package servlets;


import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.AccionBorrar;
import acciones.AccionLogin;
import acciones.AccionNuevo;
import acciones.AccionUpdate;
import pojos.Producto;
import pojos.Usuario;

/**
 * Servlet implementation class Control
 */
@WebServlet({"/Control", "/control"})
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable<String, Accion> acciones = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	this.acciones = (Hashtable<String, Accion>) this.getServletContext().getAttribute("ACCIONES");
    	
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "WEB-INF/jsp/";
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
		
		String parameterAccion = (String) request.getParameter("IDACCION");
		
		if(usuario != null) {
			
			Accion accion = this.acciones.get(parameterAccion);
			if(accion != null) {
				jsp += accion.ejecutar(request, response);
				
			}
			
		}
		else {
			if("LOGIN".equals(parameterAccion)) {
				Accion accion = new AccionLogin();
				jsp += accion.ejecutar(request, response);
				
			}
			else {

				jsp += "login.jsp";
			}
			
			
		}
		System.out.println(jsp);
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
