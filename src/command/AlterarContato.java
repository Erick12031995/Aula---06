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

public class AlterarContato implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
		
		// Instancias e alimentar Javabean
		Agenda agenda = new Agenda();
		agenda.setId(Integer.parseInt(pId));
		agenda.setNome(pNome);
		agenda.setTelefone(pFone);
		agenda.setEndereco(pEndereco);
		agenda.setEmail(pEmail);
		
		//instanciar o service
		AgendaService agendaS = new AgendaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		// Atualizar contato e re-alimentar a sessao
		agendaS.atualizar(agenda);
		@SuppressWarnings("unchecked")
		ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("lista");
		int pos = busca(agenda, lista);
		lista.remove(pos);
		lista.add(pos, agenda);
		session.setAttribute("lista", lista);
		request.setAttribute("contato", agenda);
		view = request.getRequestDispatcher("VisualizarContato.jsp");
		
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