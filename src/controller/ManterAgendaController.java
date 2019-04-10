package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import service.AgendaService;

@WebServlet("/CadastroAgenda.do")
public class ManterAgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
//instanciar o javabean
		
		Agenda agenda = new Agenda();
		agenda.setNome(pNome);
		agenda.setTelefone(pFone);
		agenda.setEndereco(pEndereco);
		agenda.setEmail(pEmail);
//instanciar o service
		
		AgendaService agendaS = new AgendaService();
		agendaS.inserir(agenda);
		agenda = agendaS.pesquisar(agenda.getId());
		
		request.setAttribute("agenda.jsp", agenda);
		
		RequestDispatcher view = request.getRequestDispatcher("Agenda.jsp");
		view.forward(request, response);
	}
}