package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.CuentasDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")

public class AdminServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CuentasDaos cuentasDaos = new CuentasDaos();
        String action = request.getParameter("a") == null ? "ReservarComprados" : request.getParameter("a");

        switch (action){

            case "ReservarComprados":
                request.setAttribute("lista",cuentasDaos.compradosAndReservados());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/reservasYcomprados.jsp");
                requestDispatcher.forward(request,response);
                break;

            case "verPerfil":
                request.getRequestDispatcher("admin/perfilUsuarios.jsp").forward(request, response);

                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }



}
