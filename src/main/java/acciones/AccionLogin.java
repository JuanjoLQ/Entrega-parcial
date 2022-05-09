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
		String pass = (String) request.getParameter("PASS");
		
		if(user == null){
			return "login.jsp";
		}
		
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		if(usuarios.containsKey(user)) {
			
			Usuario usuario = usuarios.get(user);
			
			if(usuario.getPass().equals(pass)){
				request.getSession().setAttribute("USUARIO", new Usuario(user, pass));
				request.getSession().setAttribute("ISADMIN", usuario.getAdmin());
				return "crudProductos.jsp";
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
