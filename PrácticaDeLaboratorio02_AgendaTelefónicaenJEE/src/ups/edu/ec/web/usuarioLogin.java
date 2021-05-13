package ups.edu.ec.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.usuariodao;



@WebServlet("/login")
public class usuarioLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private usuariodao loginDao;

    public void init() {
        loginDao = new usuariodao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("listartelefono.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        if (loginDao.validarUsuario(correo, contrasena)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("listartelefono.jsp");
            dispatcher.forward(request, response);
        } else {
        	request.getRequestDispatcher("errorlogeo.jsp").forward(request, response);
            
       
		}
	}
}
