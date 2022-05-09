package acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccionUsuarios extends Accion{

	public AccionUsuarios(){
		
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("MSG", null);
		return "crudUsuarios.jsp";
	}

}
