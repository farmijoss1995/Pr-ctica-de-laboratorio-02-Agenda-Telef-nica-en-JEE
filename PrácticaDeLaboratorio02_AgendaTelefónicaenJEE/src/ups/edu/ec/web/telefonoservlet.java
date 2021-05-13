package ups.edu.ec.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.telefonodao;
import ups.edu.ec.modelo.telefono;
@WebServlet("/telefono")
public class telefonoservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private telefonodao telefonoDao;

    public void init() {
        telefonoDao = new telefonodao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/nuevo":
                    nuevotelefono(request, response);
                    break;
                case "/insertar":
                    insertartelefono(request, response);
                    break;
                case "/eliminar":
                    eliminartelefono(request, response);
                    break;
                case "/editar":
                    editartelefono(request, response);
                    break;
                case "/actualizar":
                    actualizartelefono(request, response);
                    break;
                default:
                    listartelefono(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listartelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < telefono > listartelefono = telefonoDao.getAlltelefono();
        request.setAttribute("listartelefono", listartelefono);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listartelefono.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevotelefono(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editartelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        telefono existingUser = telefonoDao.gettelefono(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("telefono", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertartelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String cedula = request.getParameter("cedula");
    	String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String aoperadora= request.getParameter("operadora");
        telefono nuevotelefono = new telefono(cedula, numero, tipo, aoperadora);
        telefonoDao.guardartelefono(nuevotelefono);
        response.sendRedirect("listar");
    }

    private void actualizartelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cedula = request.getParameter("cedula");
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String aoperadora = request.getParameter("aoperadora");
        telefono user = new telefono(id, cedula, numero, tipo, aoperadora);
        telefonoDao.actualizartelefono(user);
        response.sendRedirect("listar");
    }

    private void eliminartelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        telefonoDao.eliminartelefono(id);
        response.sendRedirect("listar");
    }
}