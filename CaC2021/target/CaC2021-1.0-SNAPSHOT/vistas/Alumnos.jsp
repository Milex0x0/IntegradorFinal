<%-- 
    Document   : alumnos
    Created on : 13 dic. 2021, 14:57:13
    Author     : Ursula
--%>

<%@page import="modelo.alumnosDAO"%>
<%@page import="modelo.alumnos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlumnosCaC</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
            <div class="container">
                <div class="row">
                    <a class="btn btn-primary col-4 m4" href="AlumnosController?accion=nuevo">Agregar Alumno </a>
                    <table class="table table-primary">
                        <thead>
                                <tr>
                                <th>Id</th>
                                <th>Nombre</th> 
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Modificar</th>
                                <th>Eliminar</th>
                            </tr>                                
                        </thead>
                        <tbody>
                            <%
                            List <alumnos> resultado=null;
                            alumnosDAO alumno = new alumnosDAO();
                            resultado = alumno.listarAlumnos();
                            
                            for (int i=0; i < resultado.size(); i++) {
                                String ruta ="AlumnosController?accion=modificar&id" + resultado.get(i).getId();
                                String rutaE ="AlumnosController?accion=eliminar&id" + resultado.get(i).getId();
                            
                                 
                            %>
                            <tr>
                                <td><%= resultado.get(i).getId()%></td>
                                <td><%= resultado.get(i).getNombre()%></td>
                                <td><%= resultado.get(i).getApellido()%></td>
                                <td><%= resultado.get(i).getEmail()%></td>
                                <td><a class="text-success" href=<%ruta%>>X</a></td>
                                <td><a class="text-danger" href=<%rutaE%>>X</a></td>
                            </tr>
                                <%;
                                     }
                                %>
                        </tbody>
                    </table>
                </div>
            </div>
    </body>
</html>
