<%@page import="java.util.Hashtable"%>
<%@page import="pojos.Producto"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
    
Estas en el CRUD de productos.

<br><form action="Control" method="post">

	<input type = "hidden" name="IDACCION" value="NEW">
	Id del producto: <input type="text" name="NEWID">
	Nombre del producto: <input type="text" name="NEWNAME">
	<input type ="submit" value ="Crear">
</form><br><br>

<%

Boolean isAdmin = (Boolean) request.getSession().getAttribute("ISADMIN");
String botonUsuarios;
if(isAdmin){
	botonUsuarios = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"USUARIOS\">" +
			"<input type = \"submit\" value = \"Ir a Usuarios\">" +
			"</form>";
	out.println(botonUsuarios + "<br>");
}

String msg = (String) request.getSession().getAttribute("MSG");

if((msg != null)){
	out.println(msg + "<br><br>");
}

//Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
String mod = "";
String del = "";
Hashtable <String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
Enumeration productoEnumeration = productos.elements();


while(productoEnumeration.hasMoreElements()){
    Producto producto = (Producto) productoEnumeration.nextElement();
    
    del = " [<a href = \"Control?IDACCION=ELIMINAR&DELETENAME=" + producto.getId() +"\">Borrar</a>]";
    mod = "<form action = \"Control\" method = \"post\">" + 
        		"<input type = \"hidden\" name=\"IDACCION\" value=\"UPDATE\">" +
    			"<input type = \"hidden\" name = \"UPDATEID\" value = " + producto.getId() + ">" +
    			"Nombre: " + "<input type = \"text\" name = \"UPDATENAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>";
    out.println(producto.getId() + " " + producto.getNombre() + del + mod + "<br>"); 
    
}


/*
for(Producto producto : productoEnumeration.nextElement()){
	
	out.println(producto.getId() + " " + producto.getNombre());  
	
}

out.println("<form method = \"GET\" action = \"HTMLBank\">" + 
    			"<input type = \"text\" name = \"NEWNAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>");
*/

%>




</body>
</html>