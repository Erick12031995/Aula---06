package teste;

import java.sql.Connection;
import java.sql.SQLException;
import dao.ConnectionFactory;
import jframe.AgendaJF;

public class TesteAgenda{
   public static void main(String[] args){
      try{
          Connection conn = ConnectionFactory.obtemConexaoDBAgenda();       
          new AgendaJF(conn);
      }catch(SQLException e){
          e.printStackTrace();
       }
   }
}

	