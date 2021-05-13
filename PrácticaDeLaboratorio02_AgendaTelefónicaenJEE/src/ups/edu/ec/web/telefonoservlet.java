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
import ups.edu.ec.modelo.Telefono;

@WebServlet("/")
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
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTelefono(request, response);
                    break;
                case "/delete":
                    deleteTelefono(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTelefono(request, response);
                    break;
                default:
                    listTelelfono(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTelelfono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Telefono > listTelefono = telefonoDao.getAllTelefono();
        request.setAttribute("listTelelfono", listTelefono);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listartelefono.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("listartelefono.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Telefono existingTelefono = telefonoDao.getTelefono(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevotelefono.jsp");
        request.setAttribute("tel", existingTelefono);
        dispatcher.forward(request, response);

    }

    private void insertTelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String cedula = request.getParameter("cedula");
    	String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String aoperadora = request.getParameter("aoperadora");
        Telefono newTelefono = new Telefono(cedula, numero, tipo, aoperadora);
        telefonoDao.saveTelefono(newTelefono);
        response.sendRedirect("list");
    }

    private void updateTelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cedula = request.getParameter("cedula");
    	String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String aoperadora = request.getParameter("aoperadora");

        Telefono tel = new Telefono(id, cedula, numero, tipo, aoperadora);
        telefonoDao.updateTelefono(tel);
        response.sendRedirect("list");
    }

    private void deleteTelefono(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        telefonoDao.deleteTelefono(id);
        response.sendRedirect("list");
    }
}