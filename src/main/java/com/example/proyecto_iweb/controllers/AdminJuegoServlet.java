package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.beans.Juegos;
import com.example.proyecto_iweb.models.daos.CuentasDaos;
import com.example.proyecto_iweb.models.daos.JuegosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminJuegoServlet", value = "/AdminJuegoServlet")

public class AdminJuegoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        JuegosDaos juegosDaos = new JuegosDaos();
        CuentasDaos cuentasDaos = new CuentasDaos();

        String action = request.getParameter("a") == null ? "JuegosDisponibles" : request.getParameter("a");

        switch (action){

            case "JuegosDisponibles":
                request.setAttribute("lista",juegosDaos.listarJuegosDisponibles());
                request.getRequestDispatcher("admin/indexAdmin.jsp").forward(request,response);
                break;

            case "crear":
                request.getRequestDispatcher("admin/crearJuego.jsp").forward(request, response);
                break;

            // Editar juego
            case "Editar":

                String id = request.getParameter("id");         // Obtengo el parametro "id"
                request.setAttribute("juego", juegosDaos.listarJuegoAdmin(id));

                request.getRequestDispatcher("admin/editarJuego.jsp").forward(request, response);
                break;

            case "Ofertas":
                request.setAttribute("ofertas",juegosDaos.listarOfertas());
                request.getRequestDispatcher("admin/ofertasJuegos.jsp").forward(request,response);
                break;

            case "juego":   // Se observa cada juego en especifico
                String id1 = request.getParameter("id");         // Obtengo el parametro "id"
                request.setAttribute("juego", juegosDaos.listarJuegoAdmin(id1));
                request.getRequestDispatcher("admin/verJuego.jsp").forward(request, response);
                break;

            case "eliminar":            // Eliminamos un juego de la base de datos
                String id2 = request.getParameter("id");

                juegosDaos.eliminarJuego(id2);
                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet");
                break;

                //Juegos Vendidos
            case "eliminarOferta":
                String id3 = request.getParameter("id");
                juegosDaos.eliminarOferta(id3);
                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet?a=Ofertas");
                break;

            case "listarcola":
                request.setAttribute("lista", juegosDaos.listarCola());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("admin/juegosColaAdminOficial.jsp");
                requestDispatcher2.forward(request, response);
                break;

            case "nuevos":
                request.setAttribute("nuevos", juegosDaos.listarnuevos());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("admin/juegosNuevosAdminOficial.jsp").forward(request, response);
                break;
            case "existentes":
                request.setAttribute("existentes", juegosDaos.listarexistentes());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("admin/juegosExistentesAdminOficial.jsp").forward(request, response);
                break;

            case "cambiarestadoaceptar":
                String id4 = request.getParameter("id");
                juegosDaos.cambiarestadoaceptar(id4);
                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet?a=listarcola");
                break;

            case "cambiarestadonoaceptar":
                String id5 = request.getParameter("id");
                juegosDaos.cambiarestadoaceptar(id5);
                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet?a=listarcola");
                break;

            case "cambiarestadorechazar":
                String id6 = request.getParameter("id");
                juegosDaos.cambiarestadoaceptar(id6);
                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet?a=listarcola");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        JuegosDaos juegoDao = new JuegosDaos();

        switch (action) {
            case "crear":
                Juegos juegos = parseJuegos(request);
                juegoDao.guardar(juegos);

                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet");
                break;
            case "a":
                Juegos juegos2 = parseJuegos(request);
                juegoDao.editarJuego(juegos2);

                response.sendRedirect(request.getContextPath() + "/AdminJuegoServlet");
                break;

        }

    }

    // Creación del parseJuegos
    public Juegos parseJuegos(HttpServletRequest request) {

        Juegos juegos = new Juegos();
        String juegoId = request.getParameter("idJuegos") != null ? request.getParameter("idJuegos") : "";
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precioStr = request.getParameter("precio");
        String foto = request.getParameter("imagen");
        String retirarJuegoStr = request.getParameter("retirar_juego");
        String juegoSugeridoStr = request.getParameter("juego_sugerido");

        try {
            int id = Integer.parseInt(juegoId);
            double precio = Double.parseDouble(precioStr);
            Boolean retirarJuego = Boolean.parseBoolean(retirarJuegoStr);
            Boolean juegoSugerido = Boolean.parseBoolean(juegoSugeridoStr);

            juegos.setIdJuegos(id);
            juegos.setNombre(nombre);
            juegos.setDescripcion(descripcion);
            juegos.setPrecio(precio);
            juegos.setFoto(foto);
            juegos.setRetirar_juego(retirarJuego);
            juegos.setJuego_sugerido(juegoSugerido);

            return juegos;

        } catch (NumberFormatException e) {

        }
        return juegos;
    }

}
