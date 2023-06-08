package com.example.proyecto_iweb.controllers;

import java.io.*;

import com.example.proyecto_iweb.models.beans.JuegosVendidosNuevos;
import com.example.proyecto_iweb.models.daos.CuentasDaos;
import com.example.proyecto_iweb.models.daos.JuegosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "JuegosServlet", value = "/JuegosServlet")
public class JuegosServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        JuegosDaos juegosDaos = new JuegosDaos();
        CuentasDaos cuentasDaos = new CuentasDaos();


        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        switch (action) {
            case "listar":
                request.setAttribute("lista", juegosDaos.listarJuegos());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("usuario/indexUsuarioOficial.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "listar1":
                request.setAttribute("lista", juegosDaos.listarJuegos());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("usuario/postearUsuariosOficial.jsp");
                requestDispatcher1.forward(request, response);
                break;
            case "verjuego":
                int juegoId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("juegos", juegosDaos.listar(juegoId));
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("usuario/verJuego.jsp").forward(request, response);
                break;

            case "carrito":
                int juegoId1 = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("juegos", juegosDaos.listar(juegoId1));
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("usuario/carrito.jsp").forward(request, response);
                break;

            case "vendidos":
                request.setAttribute("lista2", juegosDaos.listarVendidos());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("usuario/vendidosUsuariosOficial.jsp").forward(request, response);
                break;
            case "comprados":
                request.setAttribute("lista3", juegosDaos.listarComprados());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("usuario/compradosUsuariosOficial.jsp").forward(request, response);
                break;
            case  "perfil" :
                String id = request.getParameter("id");
                request.setAttribute("cuentas",cuentasDaos.listar(id));
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("usuario/miPerfilOficial.jsp").forward(request, response);
                break;

            case "listarJuegos":
                request.setAttribute("lista",juegosDaos.listarJuegosDisponibles());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("admin/indexAdmin.jsp").forward(request,response);
                break;
            case "listarofertas":
                request.setAttribute("ofertas",juegosDaos.listarOfertas());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.getRequestDispatcher("admin/ofertasJuegos.jsp").forward(request,response);
                break;
            case "borrar":
                String id2 = request.getParameter("id");
                juegosDaos.borrar(id2);
                response.sendRedirect(request.getContextPath() + "/JuegosServlet");
                break;
            case "listarNotificaciones":
                request.setAttribute("lista2", juegosDaos.listarVendidos());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.getRequestDispatcher("usuario/notificacionesUsuarioOficial.jsp").forward(request,response);
                break;
            case "agregar":
                request.getRequestDispatcher("usuario/agregarjuegonuevo.jsp").forward(request, response);
                break;
            case "ofertas":
                request.setAttribute("lista2", juegosDaos.listarVendidos());
                request.setAttribute("lista4",juegosDaos.listarNotificaciones());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.setAttribute("listar",juegosDaos.listarOfertas());
                request.getRequestDispatcher("usuario/ofertasUsuarioOficial.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        JuegosDaos juegosDaos = new JuegosDaos();

        switch (action) {
            case "b":
                String textoBuscar = request.getParameter("textoBuscar");
                request.setAttribute("lista", juegosDaos.buscarPorTitle(textoBuscar));
                request.getRequestDispatcher("usuario/postearUsuariosOficial.jsp").forward(request, response);
                break;
            case "b1":
                String textoBuscar1 = request.getParameter("buscador");
                request.setAttribute("lista", juegosDaos.buscarPorTitle(textoBuscar1));
                request.getRequestDispatcher("usuario/indexUsuarioOficial.jsp").forward(request, response);
                break;
            case "c":
                JuegosVendidosNuevos juegosVendidosNuevos = parseJuegosVendidosNuevos(request);
                juegosDaos.guardar(juegosVendidosNuevos);

                response.sendRedirect(request.getContextPath() + "/JuegosServlet?a=listar1");
                break;

        }

    }

    public JuegosVendidosNuevos parseJuegosVendidosNuevos(HttpServletRequest request) {

        JuegosVendidosNuevos juegosVendidosNuevos = new JuegosVendidosNuevos();
        //String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");


        try {

            //juegosVendidosNuevos.setPrecio(Integer.parseInt(precio));
            juegosVendidosNuevos.setPrecio(Integer.parseInt(precio));
            juegosVendidosNuevos.setDescripcion(descripcion);
            juegosVendidosNuevos.setCantidad(Integer.parseInt(cantidad));
            juegosVendidosNuevos.setFecha_sudida(fecha);

            return juegosVendidosNuevos;

        } catch (NumberFormatException e) {

        }
        return juegosVendidosNuevos;
    }
}
