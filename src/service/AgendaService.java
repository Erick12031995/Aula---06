package service;


import dao.AgendaDAO;
import model.Agenda;

public class AgendaService {
	
	AgendaDAO dao;
	
	public AgendaService() {
		dao = new AgendaDAO();	
	}
	public void inserir(Agenda agenda) {
		dao.inserir(agenda);
	}
	public void excluir(int id) {
		dao.excluir(id);
	}
	public void atualizar(Agenda agenda) {
		dao.atualizar(agenda);
	}
	public Agenda pesquisar(int id) {
		return dao.pesquisar(id);
	}
	//public ArrayList<Agenda> findAll() {
		//return dao.findAll();
	//}
}
