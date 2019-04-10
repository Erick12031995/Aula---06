package teste;

import java.sql.Connection;
import java.sql.SQLException;

import ConnectionFactory.ConexaoBDAgenda;
import jframe.AgendaJF;

public class TesteAgenda{
   public static void main(String[] args){
      try{
          Connection conn = ConexaoBDAgenda.obtemConexao();       
          new AgendaJF(conn);
      }catch(SQLException e){
          e.printStackTrace();
       }
   }
}

	