package acciones;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {

	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
