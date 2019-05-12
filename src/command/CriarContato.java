package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agenda;
import service.AgendaService;

public class CriarContato implements Command  {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
		
		// Instancias e alimentar Javabean
		Agenda agenda = new Agenda();
		agenda.setNome(pNome);
		agenda.setTelefone(pFone);
		agenda.setEndereco(pEndereco);
		agenda.setEmail(pEmail);
		
		//instanciar o service
		AgendaService agendaS = new AgendaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		// Criar contato e alimentar a sessao
		agendaS.inserir(agenda);
		ArrayList<Agenda> lista = new ArrayList<>();
		lista.add(agenda);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarContatos.jsp");
		
		view.forward(request, response);
	}

}
