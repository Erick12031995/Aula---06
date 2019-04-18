<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
		<title>Agenda</title>
		<link href="Resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="Resources/css/style.css" rel="stylesheet">
	</head>
	<body>
	     <!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Agenda #${agenda.id}</h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        ${agenda.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Celular</strong>
                    </p>
                    <p>
                        ${agenda.telefone}
                    </p>
                </div>
				<div class="col-md-6">
                    <p><strong>Endereço</strong>
                    </p>
                    <p>
                        ${agenda.endereco}
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>E-Mail</strong>
                    </p>
                    <p>
                        ${agenda.email}
                    </p>
                </div>
            </div>
            <hr />
            
            <c:forEach var="list" items="${lista}">
				${list.id}
				${list.nome}
				${list.telefone}
				${list.endereco}
				${list.email}
			</c:forEach>
			
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="Resources/js/jquery.min.js"></script>
        <script src="Resources/js/bootstrap.min.js"></script>
	</body>
</html>