package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Producto;

public class AccionBorrar extends Accion{

	public AccionBorrar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteName = (String) request.getParameter("DELETENAME");
		
		Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		if(productos.containsKey(deleteName)) {
			productos.remove(deleteName);
			request.getSession().setAttribute("MSG", "Producto eliminado");
		}
		else {
			request.getSession().setAttribute("MSG", "Producto NO eliminado");
		}
		
		return "crudProductos.jsp";
	}

}
