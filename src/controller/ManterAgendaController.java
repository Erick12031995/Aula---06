package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agenda;
import service.AgendaService;

@WebServlet("/CadastroAgenda.do")
public class ManterAgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
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
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		//agendaS.inserir(agenda);
		//agenda = agendaS.pesquisar(agenda.getId());
		//ArrayList<Agenda> lista = agendaS.findAll();
		//request.setAttribute("lista", lista);
		//request.setAttribute("agenda", agenda);
		//RequestDispatcher view = request.getRequestDispatcher("Agenda.jsp");
		//view.forward(request, response);
		
		if (pAcao.equals("Criar")) {
			agendaS.inserir(agenda);
			ArrayList<Agenda> lista = new ArrayList<>();
			lista.add(agenda);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarContatos.jsp");
		} else if (pAcao.equals("Excluir")) {
			agenda.setId(Integer.parseInt(pId));
			agendaS.excluir(agenda.getId());
			ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("lista");
			lista.remove(busca(agenda, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarContatos.jsp");			
		} else if (pAcao.equals("Alterar")) {
			agenda.setId(Integer.parseInt(pId));
			agendaS.atualizar(agenda);
			ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("lista");
			int pos = busca(agenda, lista);
			lista.remove(pos);
			lista.add(pos, agenda);
			session.setAttribute("lista", lista);
			request.setAttribute("contato", agenda);
			view = request.getRequestDispatcher("VisualizarContato.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			agenda.setId(Integer.parseInt(pId));
			agenda = agendaS.pesquisar(agenda.getId());
			request.setAttribute("contato", agenda);
			view = request.getRequestDispatcher("VisualizarContato.jsp");		
		} else if (pAcao.equals("Editar")) {
			agenda.setId(Integer.parseInt(pId));
			agenda = agendaS.pesquisar(agenda.getId());
			request.setAttribute("contato", agenda);
			view = request.getRequestDispatcher("AlterarContato.jsp");		
		}
		
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