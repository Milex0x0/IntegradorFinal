/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.alumnos;
import modelo.alumnosDAO;

/**
 *
 * @author Ursula
 */
@WebServlet(name = "AlumnosController", urlPatterns = {"/AlumnosController"})
public class AlumnosController extends HttpServlet 
{
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        alumnosDAO alumnosDao = new alumnosDAO();
        String accion;
        RequestDispatcher dispactcher = null;
        accion = request.getParameter("accion");
        if(accion == null || accion.isEmpty())
        {
            dispactcher = request.getRequestDispatcher("vistas/Alumnos.jsp");
        }
        else if(accion.equals("modificar"))
        {
            dispactcher = request.getRequestDispatcher("vistas/modificar.jsp");
        }
        else if(accion.equals("actualizar"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            
            alumnos alumno = new alumnos(id,nombre,apellido,email);
            alumnosDao.actualizarAlumno(alumno);
            
            dispactcher = request.getRequestDispatcher("vistas/Alumnos.jsp");
        }
        else if(accion.equals("eliminar"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            alumnosDao.eliminarAlumno(id);
            
            dispactcher = request.getRequestDispatcher("vistas/Alumnos.jsp");
        }
        else if(accion.equals("nuevo"))
        {
            dispactcher = request.getRequestDispatcher("vistas/nuevo.jsp");
        }
        else if(accion.equals("insert"))
        {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            
            alumnos alumno = new alumnos(0,nombre,apellido,email);
            alumnosDao.insertarAlumnos(alumno);
            
            dispactcher = request.getRequestDispatcher("vistas/Alumnos.jsp");
        }
        else
        {
            dispactcher = request.getRequestDispatcher("vistas/Alumnos.jsp");
        }
        dispactcher.forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }}