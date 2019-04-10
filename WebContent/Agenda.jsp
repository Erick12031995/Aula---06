<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import ="model.Agenda" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
		<title>Agenda</title>
		<link href="Resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="Resources/css/style.css" rel="stylesheet">
	</head>
	<body>
		    <%Agenda agenda = (Agenda)request.getAttribute("agenda.jsp"); %>

        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Agenda #<%=agenda.getId() %></h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        <%=agenda.getNome() %>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Celular</strong>
                    </p>
                    <p>
                        <%=agenda.getTelefone() %>
                    </p>
                </div>
				<div class="col-md-6">
                    <p><strong>Endereço</strong>
                    </p>
                    <p>
                        <%=agenda.getEndereco() %>
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>E-Mail</strong>
                    </p>
                    <p>
                        <%=agenda.getEmail() %>
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.html" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	</body>
</html>