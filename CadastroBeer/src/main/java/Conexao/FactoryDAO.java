package Conexao;

import java.sql.SQLException;

import br.com.clubeBeerDAO.PessoaFisicaDAO;

public class FactoryDAO {
   public static  PessoaFisicaDAO createPessoaFisicaDAO() throws SQLException{
	   return new PessoaFisicaDAO();
   }
}
