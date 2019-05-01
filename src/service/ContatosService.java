package service;

import java.util.ArrayList;

import dao.AgendaDAO;
import model.Agenda;


public class ContatosService {
	AgendaDAO dao;
	
	public ContatosService(){
		dao = new AgendaDAO();
	}
	public ArrayList<Agenda> listarContatos(){
		return dao.listarContatos();
	}
	public ArrayList<Agenda> listarContato(String chave){
		return dao.listarContato(chave);
	}

}
