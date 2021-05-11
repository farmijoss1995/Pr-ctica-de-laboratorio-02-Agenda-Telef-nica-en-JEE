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
    private static final long serialVersionUID = 1 ;
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
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        usuario user = new usuario();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCorreo(correo);
        user.setPassword(password);

        usuarioDao.guardarUsuario(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
        dispatcher.forward(request, response);
    }
}