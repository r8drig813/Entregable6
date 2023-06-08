package com.example.proyecto_iweb.models.daos;

import com.example.proyecto_iweb.models.beans.ComprasVentas;
import com.example.proyecto_iweb.models.beans.Estados;
import com.example.proyecto_iweb.models.beans.Juegos;
import com.example.proyecto_iweb.models.beans.JuegosVendidosNuevos;

import java.sql.*;
import java.util.ArrayList;

public class JuegosDaos {
    /*-------------------USUARIOS----------------------------*/

    public ArrayList<Juegos> listarJuegos(){
        ArrayList<Juegos> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from juegos ";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Juegos juegos = new Juegos();
                juegos.setIdJuegos(resultSet.getInt(1));
                juegos.setNombre(resultSet.getString(2));
                juegos.setDescripcion(resultSet.getString(3));
                juegos.setPrecio(resultSet.getDouble(4));
                juegos.setDescuento(resultSet.getDouble(5));
                juegos.setStock(resultSet.getInt(6));
                juegos.setFoto(resultSet.getString(7));
                juegos.setRetirar_juego(resultSet.getBoolean(8));
                juegos.setJuego_sugerido(resultSet.getBoolean(9));
                lista.add(juegos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Juegos listar(int juegoId) {
        Juegos juegos = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from juegos where idJuegos = ?";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, juegoId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    juegos = new Juegos();
                    juegos.setIdJuegos(rs.getInt(1));
                    juegos.setNombre(rs.getString(2));
                    juegos.setDescripcion(rs.getString(3));
                    juegos.setPrecio(rs.getDouble(4));
                    juegos.setDescuento(rs.getDouble(5));
                    juegos.setStock(rs.getInt(6));
                    juegos.setFoto(rs.getString(7));
                    juegos.setRetirar_juego(rs.getBoolean(8));
                    juegos.setJuego_sugerido(rs.getBoolean(9));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return juegos;
    }

    public ArrayList<Juegos> buscarPorTitle(String title) {
        ArrayList<Juegos> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from juegos where nombre like ?";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + title + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Juegos juegos = new Juegos();
                    juegos.setIdJuegos(resultSet.getInt(1));
                    juegos.setNombre(resultSet.getString(2));
                    juegos.setDescripcion(resultSet.getString(3));
                    juegos.setPrecio(resultSet.getDouble(4));
                    juegos.setDescuento(resultSet.getDouble(5));
                    juegos.setStock(resultSet.getInt(6));
                    juegos.setFoto(resultSet.getString(7));
                    juegos.setRetirar_juego(resultSet.getBoolean(8));
                    juegos.setJuego_sugerido(resultSet.getBoolean(9));
                    lista.add(juegos);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Juegos> listarCola(){
        ArrayList<Juegos> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql =    "SELECT juegos.*\n" +
                        "FROM juegos\n" +
                        "JOIN compras_ventas ON juegos.idJuegos = compras_ventas.Juegos_idJuegos\n" +
                        "WHERE compras_ventas.Estados_idEstados = 1;";

        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Juegos juegos = new Juegos();
                juegos.setIdJuegos(resultSet.getInt(1));
                juegos.setNombre(resultSet.getString(2));
                juegos.setDescripcion(resultSet.getString(3));
                juegos.setPrecio(resultSet.getDouble(4));
                juegos.setDescuento(resultSet.getDouble(5));
                juegos.setStock(resultSet.getInt(6));
                juegos.setFoto(resultSet.getString(7));
                juegos.setRetirar_juego(resultSet.getBoolean(8));
                juegos.setJuego_sugerido(resultSet.getBoolean(9));
                lista.add(juegos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Juegos> listarexistentes(){

        ArrayList<Juegos> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql =   "select * from juegos where Existentes=1";

        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Juegos juegos = new Juegos();
                juegos.setIdJuegos(resultSet.getInt(1));
                juegos.setNombre(resultSet.getString(2));
                juegos.setDescripcion(resultSet.getString(3));
                juegos.setPrecio(resultSet.getDouble(4));
                juegos.setDescuento(resultSet.getDouble(5));
                juegos.setStock(resultSet.getInt(6));
                juegos.setFoto(resultSet.getString(7));
                juegos.setRetirar_juego(resultSet.getBoolean(8));
                juegos.setJuego_sugerido(resultSet.getBoolean(9));
                juegos.setExistentes(resultSet.getBoolean(10));
                lista.add(juegos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Juegos> listarnuevos(){

        ArrayList<Juegos> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql =   "select * from juegos where Existentes=0";

        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Juegos juegos = new Juegos();
                juegos.setIdJuegos(resultSet.getInt(1));
                juegos.setNombre(resultSet.getString(2));
                juegos.setDescripcion(resultSet.getString(3));
                juegos.setPrecio(resultSet.getDouble(4));
                juegos.setDescuento(resultSet.getDouble(5));
                juegos.setStock(resultSet.getInt(6));
                juegos.setFoto(resultSet.getString(7));
                juegos.setRetirar_juego(resultSet.getBoolean(8));
                juegos.setJuego_sugerido(resultSet.getBoolean(9));
                juegos.setExistentes(resultSet.getBoolean(10));
                lista.add(juegos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


    public ArrayList<ComprasVentas> listarVendidos() {
        ArrayList<Juegos> lista = new ArrayList<>();
        ArrayList<ComprasVentas> lista2 = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from compras_ventas cv\n" +
                "inner join juegos j on cv.Juegos_idJuegos = j.idJuegos\n" +
                "inner join estados e on cv.Estados_idEstados = e.idEstados\n" +
                "inner join compras_ventas_has_cuentas cvc on cvc.Compras_ventas_idCompras_ventas = cv.idCompras_ventas\n" +
                "where cv.compra_o_venta = 1 and cvc.Cuentas_idCuentas = 100";

        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                ComprasVentas comprasVentas = new ComprasVentas();

                comprasVentas.setIdComprasVentas(resultSet.getInt(1));
                comprasVentas.setPrecioTotal(resultSet.getInt(2));
                comprasVentas.setDescripcionEstado(resultSet.getString(4));
                comprasVentas.setCantidad(resultSet.getInt(5));
                comprasVentas.setCompraVenta(resultSet.getInt(8));
                Juegos juegos = new Juegos();

                juegos.setIdJuegos(resultSet.getInt("j.idJuegos"));
                juegos.setNombre(resultSet.getString("nombre"));
                comprasVentas.setJuegos(juegos);

                Estados estados = new Estados();
                estados.setIdEstados(resultSet.getInt("e.idEstados"));
                estados.setNombreEstado(resultSet.getString("nombre_estado"));
                comprasVentas.setEstados(estados);

                lista2.add(comprasVentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista2;
    }

    public ArrayList<ComprasVentas> listarComprados() {
        ArrayList<Juegos> lista = new ArrayList<>();
        ArrayList<ComprasVentas> lista2 = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from compras_ventas cv\n" +
                "inner join juegos j on cv.Juegos_idJuegos = j.idJuegos\n" +
                "inner join estados e on cv.Estados_idEstados = e.idEstados\n" +
                "inner join compras_ventas_has_cuentas cvc on cvc.Compras_ventas_idCompras_ventas = cv.idCompras_ventas\n" +
                "where cv.compra_o_venta = 0 and cvc.Cuentas_idCuentas = 100";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                ComprasVentas comprasVentas = new ComprasVentas();

                comprasVentas.setIdComprasVentas(resultSet.getInt(1));
                comprasVentas.setPrecioTotal(resultSet.getInt(2));
                comprasVentas.setDescripcionEstado(resultSet.getString(4));
                comprasVentas.setCantidad(resultSet.getInt(5));
                comprasVentas.setCompraVenta(resultSet.getInt(8));
                comprasVentas.setDescripcionJuego(resultSet.getString(9));

                Juegos juegos = new Juegos();

                juegos.setIdJuegos(resultSet.getInt("j.idJuegos"));
                juegos.setNombre(resultSet.getString("nombre"));
                juegos.setFoto(resultSet.getString("foto"));
                comprasVentas.setJuegos(juegos);

                Estados estados = new Estados();
                estados.setIdEstados(resultSet.getInt("e.idEstados"));
                estados.setNombreEstado(resultSet.getString("nombre_estado"));
                comprasVentas.setEstados(estados);

                lista2.add(comprasVentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista2;
    }

    public void borrar(String id)  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "DELETE FROM compras_ventas WHERE idCompras_ventas = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ComprasVentas> listarNotificaciones(){
        ArrayList<ComprasVentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from compras_ventas cv\n" +
                "inner join compras_ventas_has_cuentas cvc on cvc.Compras_ventas_idCompras_ventas = cv.idCompras_ventas\n" +
                "inner join cuentas c on c.idCuentas = cvc.Cuentas_idCuentas\n" +
                "inner join juegos j on cv.Juegos_idJuegos = j.idJuegos\n" +
                "where cv.compra_o_venta = 1 and c.idCuentas = 100 and descripcionJuego is not null;\n";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                ComprasVentas comprasVentas = new ComprasVentas();

                comprasVentas.setIdComprasVentas(resultSet.getInt(1));
                comprasVentas.setPrecioTotal(resultSet.getInt(2));
                comprasVentas.setDescripcionEstado(resultSet.getString(4));
                comprasVentas.setCantidad(resultSet.getInt(5));
                comprasVentas.setIdEstados(resultSet.getInt(6));
                comprasVentas.setCompraVenta(resultSet.getInt(8));
                comprasVentas.setDescripcionJuego(resultSet.getString(9));
                Juegos juegos = new Juegos();

                juegos.setIdJuegos(resultSet.getInt("j.idJuegos"));
                juegos.setNombre(resultSet.getString(24));
                comprasVentas.setJuegos(juegos);
                lista.add(comprasVentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // Agregar Juegos Para vender

    public void guardar(JuegosVendidosNuevos juegosVendidosNuevos) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "INSERT INTO compras_ventas (precio_total,fecha_cv,descripcionEstado,cantidad,Estados_idEstados,Juegos_idJuegos,compra_o_venta,descripcionJuego) VALUES (?,?,?,?,1,106,1,null)";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, juegosVendidosNuevos.getPrecio());
            pstmt.setString(2, juegosVendidosNuevos.getFecha_sudida());
            pstmt.setString(3, juegosVendidosNuevos.getDescripcion());
            pstmt.setInt(4, juegosVendidosNuevos.getCantidad());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Lista de Ofertas

    /*-------------------ADMIN----------------------------*/

    /*ROMMEL*/
    // Listar todos los juegos disponibles del catalogo (Retorna una lista de Juegos)
    public ArrayList<Juegos> listarJuegosDisponibles() {
        ArrayList<Juegos> lista = new ArrayList<>();

        // Definimos el Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from juegos";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Juegos juegoDisponible = new Juegos();

                // Obtenemos los valores
                juegoDisponible.setIdJuegos(resultSet.getInt(1));
                juegoDisponible.setNombre(resultSet.getString(2));
                juegoDisponible.setDescripcion(resultSet.getString(3));
                juegoDisponible.setPrecio(resultSet.getFloat(4));
                juegoDisponible.setDescuento(resultSet.getInt(5));
                juegoDisponible.setStock(resultSet.getInt(6));
                juegoDisponible.setFoto(resultSet.getString(7));
                juegoDisponible.setRetirar_juego(resultSet.getBoolean(8));
                juegoDisponible.setJuego_sugerido(resultSet.getBoolean(9));
                lista.add(juegoDisponible);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // Listar las ofertas (Retorna una lista de Juegos Ofertados)
    public ArrayList<Juegos> listarOfertas() {
        ArrayList<Juegos> ofertas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql1 = "select * from juegos where descuento != 0";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql1)) {

            while (resultSet.next()) {
                Juegos juegoOferta = new Juegos();

                // Obtenemos los valores
                juegoOferta.setIdJuegos(resultSet.getInt(1));
                juegoOferta.setNombre(resultSet.getString(2));
                juegoOferta.setPrecio(resultSet.getInt(4));
                juegoOferta.setDescuento(resultSet.getInt(5));
                juegoOferta.setStock(resultSet.getInt(6));
                juegoOferta.setFoto(resultSet.getString(7));
                ofertas.add(juegoOferta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ofertas;
    }


    // Crear y guardar juego
    public void guardar(Juegos juegos) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "INSERT INTO juegos (idJuegos,nombre,descripcion,precio,descuento,stock,foto) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, juegos.getIdJuegos());
            pstmt.setString(2, juegos.getNombre());
            pstmt.setString(3, juegos.getDescripcion());
            pstmt.setDouble(4, juegos.getPrecio());
            pstmt.setDouble(5, juegos.getDescuento());
            pstmt.setInt(6, juegos.getStock());
            pstmt.setString(7, juegos.getFoto());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Buscar el juego por el ID y obtener sus parametros
    public Juegos listarJuegoAdmin(String id) {
        Juegos juego = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from juegos where idJuegos = ?";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    juego = new Juegos();
                    juego.setIdJuegos(rs.getInt(1));
                    juego.setNombre(rs.getString(2));
                    juego.setDescripcion(rs.getString(3));
                    juego.setPrecio(rs.getDouble(4));
                    juego.setFoto(rs.getString(7));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return juego;
    }


    // Editamos la información del juego (EDITAR-ACTUALIZAR)
    public void editarJuego(Juegos juegos){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE juegos SET nombre = ?,descripcion = ?,precio = ? WHERE idJuegos = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, juegos.getNombre());
            pstmt.setString(2, juegos.getDescripcion());
            pstmt.setDouble(3, juegos.getPrecio());
            pstmt.setInt(4, juegos.getIdJuegos());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Eliminar/Borrar de la lista de juegos disponibles
    public void eliminarJuego(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "DELETE FROM juegos WHERE idJuegos = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Eliminar oferta (Actulizamos el valor de descuento=0)
    public void eliminarOferta(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE juegos SET descuento = 0 WHERE idJuegos = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    /*-------------------MANAGER----------------------------*/

}
