package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import service.AgendaService;

public class VisualizarContato implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		
		// Instanciar Javaben
		Agenda agenda = new Agenda();
		agenda.setId(Integer.parseInt(pId));
		
		//Instanciar o Service
		AgendaService agendaS = new AgendaService();
		
		RequestDispatcher view = null;
		
		// busca o contato para ser exibido
		
		agenda = agendaS.pesquisar(agenda.getId());
		request.setAttribute("contato", agenda);
		view = request.getRequestDispatcher("VisualizarContato.jsp");
		
		view.forward(request, response);
		
	}

}
