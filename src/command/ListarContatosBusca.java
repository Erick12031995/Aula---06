package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agenda;
import service.ContatosService;

public class ListarContatosBusca implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		
		ContatosService contato = new ContatosService();
		ArrayList<Agenda> lista = null;
		HttpSession session = request.getSession();
		
		RequestDispatcher view = null;
		
		// Busca o contato ou todos os contatos
		if (chave != null && chave.length() > 0) {
			lista = contato.listarContato(chave);
		} else {
			lista = contato.listarContatos();
		}
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarContatos.jsp");
		
		view.forward(request, response);
		
	}

}
