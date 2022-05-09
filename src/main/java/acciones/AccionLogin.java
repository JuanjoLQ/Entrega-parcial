package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Usuario;

public class AccionLogin extends Accion{

	public AccionLogin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String user = (String) request.getParameter("USERNAME");
		String contrasena = (String) request.getParameter("PASS");
		
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		if(usuarios.containsKey(user)) {
			
			Usuario usuario = usuarios.get(user);
			
			if(usuario.getPass().equals(contrasena)){
				request.getSession().setAttribute("USUARIO", new Usuario(user, contrasena));
				return "crud.jsp";
				
			}
			else {
				return "login.jsp";
			}
			
		}
		else {
			return "login.jsp";
		}
	
	}

}
