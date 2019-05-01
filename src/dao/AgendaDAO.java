package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Agenda;

public class AgendaDAO{

   public void inserir(Agenda to){
      String sqlInsert = "INSERT INTO tb_agenda(nome, telefone, endereco, email) VALUES (?, ?, ?, ?)";
      try(Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
    		  PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setString(1, to.getNome());
         stm.setString(2, to.getTelefone());
         stm.setString(3, to.getEndereco());
         stm.setString(4, to.getEmail());
         stm.execute();
         String sqlQuery = "SELECT LAST_INSERT_ID()";
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();){
        	 if(rs.next()) {
        		 to.setId(rs.getInt(1));
        	 }
         }catch (Exception e) {
        	 e.printStackTrace();
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   
    public Agenda pesquisar(int id) {
    	Agenda agenda = new Agenda();
    	String sqlInsert = 
         "SELECT * FROM tb_agenda WHERE id = ?";
      try (Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
    		  PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, id);
         stm.execute();
         try (ResultSet rs = stm.executeQuery();) {
				/*
				 * este outro try e' necessario pois nao da' para abrir o
				 * resultsetno anterior uma vez que antes era preciso configurar
				 * o parametrovia setInt; se nao fosse, poderia se fazer tudo no
				 * mesmo try
				 */
				while (rs.next()) {
					agenda.setId(rs.getInt("id"));
					agenda.setNome(rs.getString("nome"));
					agenda.setTelefone(rs.getString("telefone"));
					agenda.setEndereco(rs.getString("endereco"));
					agenda.setEmail(rs.getString("email"));}
			} catch (Exception e) {
				e.printStackTrace();
			}
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
	return agenda;
	
   }
    
    public ArrayList<Agenda> listarContatos() {
    	ArrayList<Agenda> listAgenda = new ArrayList<Agenda>();
    	String sql = "SELECT * FROM tb_agenda" ;
      try (Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
    		  PreparedStatement stm = conn.prepareStatement(sql);) {
         stm.execute();
         try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Agenda agenda = new Agenda();
					
					agenda.setId(rs.getInt("id"));
					agenda.setNome(rs.getString("nome"));
					agenda.setTelefone(rs.getString("telefone"));
					agenda.setEndereco(rs.getString("endereco"));
					agenda.setEmail(rs.getString("email"));
					
					listAgenda.add(agenda);
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
	return listAgenda;
	
   }
    
    public ArrayList<Agenda> listarContato(String chave) {
    	ArrayList<Agenda> listAgenda = new ArrayList<Agenda>();
    	String sql = "SELECT * FROM tb_agenda where upper(nome) like ?" ;
      try (Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
    		  PreparedStatement stm = conn.prepareStatement(sql);) {
    	 stm.setString(1, "%" + chave.toUpperCase() + "%");
         stm.execute();
         try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Agenda agenda = new Agenda();
					
					agenda.setId(rs.getInt("id"));
					agenda.setNome(rs.getString("nome"));
					agenda.setTelefone(rs.getString("telefone"));
					agenda.setEndereco(rs.getString("endereco"));
					agenda.setEmail(rs.getString("email"));
					
					listAgenda.add(agenda);
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
	return listAgenda;
	
   }
    
   public void excluir(Agenda agenda){
      String sqlDelete = "DELETE FROM tb_agenda WHERE id = ?";
      try(Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
    		  PreparedStatement stm = conn.prepareStatement(sqlDelete);){
         stm.setInt(1, agenda.getId());
         stm.execute();
         //Null atributos
         agenda.setId(-1);
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   	public void atualizar(Agenda agenda) {
		String sqlUpdate = "UPDATE tb_agenda SET nome = ?, telefone = ?, endereco = ? WHERE email = ?";

		try (Connection conn = ConnectionFactory.obtemConexaoDBAgenda();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
         stm.setString(1, agenda.getNome());
         stm.setString(2, agenda.getTelefone());
         stm.setString(3, agenda.getEndereco());
         stm.setString(4, agenda.getEmail());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}