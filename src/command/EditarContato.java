package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import service.AgendaService;

public class EditarContato implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		
		Agenda agenda = new Agenda();
		agenda.setId(Integer.parseInt(pId));
		
		//instanciar o service
		AgendaService agendaS = new AgendaService();
		RequestDispatcher view = null;
		
		// Busca contato para para edicao
		agenda = agendaS.pesquisar(agenda.getId());
		request.setAttribute("contato", agenda);
		view = request.getRequestDispatcher("AlterarContato.jsp");
		
		view.forward(request, response);
	}

}
