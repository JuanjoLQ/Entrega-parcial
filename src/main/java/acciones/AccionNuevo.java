package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Producto;

public class AccionNuevo extends Accion{

	public AccionNuevo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newId = (String) request.getParameter("NEWID");
		String newNombre = (String) request.getParameter("NEWNAME");
		Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		if(newId != null && newNombre != null) {
			
			if(productos.containsKey(newId)) {
				request.getSession().setAttribute("MSG", "ID ya existente.");
				
			}
			else {

				productos.put(newId, new Producto(newId, newNombre));
				request.getSession().setAttribute("MSG", "Producto Creado");
				
			}
			
		}
		else {
			request.getSession().setAttribute("MSG", "Producto NO Creado");
			
		}
		return "crudProductos.jsp";
		
	}
		
}
