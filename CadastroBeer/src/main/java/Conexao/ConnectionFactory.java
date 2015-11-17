package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public static Connection getConnection(){
		try{
		String url = "jdbc:mysql://localhost:3306/cadastrobeer";
	
		return DriverManager.getConnection(url,"root","45774217"); 
		}catch(SQLException e){
			
			throw new RuntimeException(e);
		}
		
	}

}
