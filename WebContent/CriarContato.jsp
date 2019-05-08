<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro de Agenda</title>
    <link href="Resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="Resources/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Contato</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="CadastroAgenda.do" method="get">
        
            <!-- area de campos do form -->
             <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome completo">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Celular</label>
                    <input type="tel" class="form-control" name="fone" id="fone" maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="Obrigatorio; (99) 99999-9999">
                </div>
				<div class="form-group col-md-6">
                    <label for="endereco">Endereço</label>
                    <input class="form-control" name="endereco" id="enderco" required maxlength="60" placeholder="Endereço">
                </div>
                <div class="form-group col-md-6">
                    <label for="email">E-Mail</label>
                    <input type="email" class="form-control" name="email" id="email" required maxlength="60" placeholder="Email obrigatório">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
                    <a href="ListarContatos.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
     <script src="Resources/js/jquery.min.js"></script>
     <script src="Resources/js/bootstrap.min.js"></script>
</body>

</html>