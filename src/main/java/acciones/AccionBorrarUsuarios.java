package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Producto;
import pojos.Usuario;

public class AccionBorrarUsuarios extends Accion{

	public AccionBorrarUsuarios() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deleteUser = (String) request.getParameter("DELETEUSER");
		
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		if(usuarios.containsKey(deleteUser)) {
			usuarios.remove(deleteUser);
			request.getSession().setAttribute("MSG", "Usuario eliminado");
		}
		else {
			request.getSession().setAttribute("MSG", "Usuario NO eliminado");
		}
		
		return "crudUsuarios.jsp";
		
		
	}

}
