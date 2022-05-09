package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Usuario;

public class AccionUpdateUsuarios extends Accion{

	public AccionUpdateUsuarios() {
		
		
		
		
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String updateUser = (String) request.getParameter("UPDATEUSERNAME");
		String updatePass = (String) request.getParameter("UPDATEPASS");
		
		System.out.println("class update usuarios");
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		if(usuarios.containsKey(updateUser)) {
			usuarios.replace(updateUser, new Usuario(updateUser, updatePass));
			request.getSession().setAttribute("MSG", "Usuario modificado");
		}
		else {
			request.getSession().setAttribute("MSG", "Usuario NO modificado");
		}
		
		return "crudUsuarios.jsp";
	}

}
