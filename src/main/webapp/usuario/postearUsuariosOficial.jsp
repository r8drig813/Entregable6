<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.proyecto_iweb.models.beans.Juegos" %>
<%@ page import="com.example.proyecto_iweb.models.beans.Cuentas" %>
<%@ page import="com.example.proyecto_iweb.models.beans.ComprasVentas" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Juegos> lista = (ArrayList<Juegos>) request.getAttribute("lista");
  ArrayList<ComprasVentas> listaNotificaciones = (ArrayList<ComprasVentas>) request.getAttribute("lista4");
%>


<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>JA-VAGOS</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link rel="icon" href="pestania.png">

  <!-- Estilos CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <!--Importando estilos CSS-->
  <link rel="stylesheet" href="estilos/usuario/filtros.css">
  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

</head>
<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center bg-primary">

    <div class="d-flex align-items-center justify-content-between">
      <a href="<%=request.getContextPath()%>/JuegosServlet?a=listar" class="logo d-flex align-items-center">
        <img src="/logoUsuario.png" alt="">
        <span class="d-none d-lg-block text-light">JA-VAGOS</span>
      </a>
    </div>

  <nav class="header-nav ms-auto">
    <ul class="d-flex align-items-center">
      <!--BUSCADOR -->
      <li class="nav-item d-block d-lg-none">
        <a class="nav-link nav-icon search-bar-toggle " href="#">
          <i class="bi bi-search"></i>
        </a>
      </li>

      <!-- ICONO DE TIENDA Y NOTIFICACIÓN-->
      <li class="nav-item">
        <a class="nav-link nav-icon" href="usuario/carrito.jsp">
          <i class="bi bi-cart text-light"></i>
          <span class="badge bg-success badge-number"></span>
        </a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-chat-left-text text-light"></i>
          <span class="badge bg-danger badge-number">2</span>
        </a><!-- End Messages Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
          <li class="dropdown-header">
            Tienes 2 mensajes nuevos ! ! !
            <!--
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">Ver todo</span></a>
            -->
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="dropdown-footer">
            <a  href="<%=request.getContextPath()%>/JuegosServlet?a=listarNotificaciones">Ver todo los mensajes</a>
          </li>

        </ul>

      </li>


      <li class="nav-item dropdown pe-3">

        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
          <img src="img/usuario/usuario1.webp" alt="Profile" class="rounded-circle">
          <span class="d-none d-md-block dropdown-toggle ps-2 text-light">dylan</span>
        </a><!-- End Profile Iamge Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
          <li class="dropdown-header">
            <h6>dylan</h6>
            <span>Usuario</span>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="<%=request.getContextPath()%>/JuegosServlet?a=perfil">
              <i class="bi bi-person"></i>
              <span>Mi Perfil</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="#profile-edit">
              <i class="bi bi-gear"></i>
              <span>Configuración</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="cerrarLoguinOficial.html">
              <i class="bi bi-box-arrow-right"></i>
              <span>Sign Out</span>
            </a>
          </li>

        </ul><!-- End Profile Dropdown Items -->
      </li><!-- End Profile Nav -->

    </ul>
  </nav><!-- End Icons Navigation -->

</header>




<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

  <ul class="sidebar-nav" id="sidebar-nav">

    <li class="nav-item">
      <a class="nav-link collapsed" href="<%=request.getContextPath()%>/JuegosServlet?a=listar">
        <i class="bi bi-grid"></i>
        <span>Disponibles</span>
      </a>
    </li><!-- End Dashboard Nav -->

    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/JuegosServlet?a=listar1">
        <i class="bi bi-arrow-up-square"></i>
        <span>Postear</span>
      </a>
    </li><!-- End Profile Page Nav -->


    <li class="nav-item">
      <a class="nav-link collapsed" href="<%=request.getContextPath()%>/JuegosServlet?a=vendidos">
        <i class="bi bi-bag"></i>
        <span>Vendidos</span>
      </a>
    </li><!-- End F.A.Q Page Nav -->

    <li class="nav-item">
      <a class="nav-link collapsed" href="<%=request.getContextPath()%>/JuegosServlet?a=vendidos">
        <i class="bi bi-shop"></i>
        <span>Comprados</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="<%=request.getContextPath()%>/JuegosServlet?a=ofertas">
        <i class="bi bi-shop"></i>
        <span>Ofertas</span>
      </a>
    </li>
    <!-- End Contact Page Nav -->

  </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

  <div class="pagetitle">
    <h1>¿Que videojuego desea postear?</h1>
  </div><!-- End Page Title -->
  <div class="row">
    <div class="col-9">
      <div class="form-floating">
        <form method="post" action="<%=request.getContextPath()%>/JuegosServlet?p=b">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" placeholder="Buscador" name="textoBuscar">
            <label>Buscar juego existente a subir</label>
          </div>
        </form>
      </div>
    </div>
    <div class="col-3">
      <a class="btn btn-success" href="<%=request.getContextPath()%>/JuegosServlet?a=agregar">Agregar Juego Nuevo</a>
    </div>
  </div>

  <table class="table table-stripped">
    <thead>
    <tr>
      <th>Nombre del juego</th>
      <th>Descripcion</th>
      <th>Precio</th>
      <th>Stock</th>
    </tr>
    </thead>
    <tbody>
    <% for (Juegos j : lista) { %>
    <tr>
      <td><%=j.getNombre()%>
      </td>
      <td><%=j.getDescripcion() %>
      </td>
      <td><%=j.getPrecio()%>
      </td>
      <td><%=j.getStock()%>
      </td>
      <td><a href="<%=request.getContextPath()%>/JuegosServlet?a=agregarjuego&id=<%=j.getIdJuegos()%>">Subir este juego</a>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>



</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">

  <!-- Section: Social media -->
  <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
    <!-- Left -->
    <div class="me-5 d-none d-lg-block">
      <span>Conéctate con nosotras en las redes sociales:</span>
    </div>
    <!-- Left -->

    <!-- Right -->
    <div>
      <a href="" class="me-4 link-secondary">
        <i class="bi bi-facebook"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="bi bi-twitter"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="bi bi-instagram"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="bi bi-linkedin"></i>
      </a>

    </div>
    <!-- Right -->
  </section>
  <!-- Section: Social media -->


  <!-- Section: Links  -->
  <section class="">
    <div class="container text-center text-md-start mt-5">
      <!-- Grid row -->
      <div class="row mt-3">
        <!-- Grid column -->
        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
          <!-- Content -->
          <h6 class="text-uppercase fw-bold mb-4">
            <i class="fas fa-gem me-3 text-secondary"></i>Nombre de la compañia
          </h6>
          <p>
            Ja-Vagos, somos un grupo de estudiantes que quiere aprobar el curso de Ing. Web para Telecomunicaciones...
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Productos
          </h6>
          <p>
            <a href="#!" class="text-reset">Angular</a>
          </p>
          <p>
            <a href="#!" class="text-reset">React</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Vue</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Laravel</a>
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Links
          </h6>
          <p>
            <a href="#!" class="text-reset">Pricing</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Settings</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Orders</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Help</a>
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">Contacto</h6>
          <p><i class="bi bi-geo-alt me-3 text-secondary"></i>Av. Universitaria 1801, San Miguel</p>
          <p>
            <i class="bi bi-envelope me-3 text-secondary"></i>
            javagos@pucp.edu.pe
          </p>
          <p><i class="bi bi-phone me-3 text-secondary"></i> + 51 987 654 321</p>
          <p><i class="bi bi-telephone me-3 text-secondary"></i> + 01 765 567 21</p>
        </div>
        <!-- Grid column -->
      </div>
      <!-- Grid row -->
    </div>
  </section>
  <!-- Section: Links  -->



  <div class="copyright">
    &copy; Copyright <strong><span>NiceAdmin</span></strong>. Todos los derechos reservados
  </div>
  <div class="credits">
    Designed by <a href="#">Ja-Vagos</a>
  </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>


<!-- Vendor JS Files -->
<script src="/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/assets/vendor/chart.js/chart.umd.js"></script>
<script src="/assets/vendor/echarts/echarts.min.js"></script>
<script src="/assets/vendor/quill/quill.min.js"></script>
<script src="/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="/assets/vendor/php-email-form/validate.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<!-- Template Main JS File -->
<script src="/assets/js/main.js"></script>
</body>

</html>