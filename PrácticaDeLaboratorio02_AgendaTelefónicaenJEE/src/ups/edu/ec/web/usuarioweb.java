package ups.edu.ec.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.usuariodao;
import ups.edu.ec.modelo.usuario;

@WebServlet("/registro")
public class usuarioweb extends HttpServlet {
    private static final long serialVersionUID = 1L ;
    private usuariodao usuarioDao;

    public void init() {
        usuarioDao = new usuariodao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("accesoaceptado.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String cedula = request.getParameter("cedula");
    	String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        usuario user = new usuario();
        user.setCedula(cedula);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCorreo(correo);
        user.setPassword(password);

        usuarioDao.guardarUsuario(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}