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

public class ExcluirContato implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		
		// Instanciar Javabean
		Agenda agenda = new Agenda();
		agenda.setId(Integer.parseInt(pId));
		
		//Instanciar Service
		AgendaService agendaS = new AgendaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		// Excluir contato e remover da lista da sessao
		agendaS.excluir(agenda.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("lista");
		lista.remove(busca(agenda, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarContatos.jsp");		
		
		view.forward(request, response);
	}
	
	public int busca(Agenda contato, ArrayList<Agenda> lista) {
		Agenda to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == contato.getId()){
				return i;
			}
		}
		return -1;
	}

}
