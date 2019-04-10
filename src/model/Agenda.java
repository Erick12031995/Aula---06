package model;
import java.io.Serializable;

public class Agenda implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	   private String endereco;
	   private String email;
	   private String telefone;
	   private int id;
	   
	   	public Agenda() {
	   		
	   	}
		public Agenda(int id) {
			this.setId(id);
		}
	   public Agenda(String nome, String telefone, String endereco, String email){
		      this.setNome(nome);
		      this.setEndereco(endereco);
		      this.setEmail(email);
		      this.setTelefone(telefone);
		   }
	   public Agenda(int id, String nome, String telefone, String endereco, String email) {
		   this.setId(id);
		   this.setNome(nome);
		   this.setEndereco(endereco);
		   this.setEmail(email);
		   this.setTelefone(telefone);
	   }
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}