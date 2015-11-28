package br.com.clubeBeerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.clubeBeer.Telas.Menu;
import br.com.clubeBeer.Telas.TelaLogin;
import Conexao.ConnectionFactory;
import Login.Login;
import PessoaFisica.PessoaFisica;

public class LoginDAO {
static Connection con;
public String user;
public String senha;
	
	public LoginDAO() {
		
		this.con = ConnectionFactory.getConnection();
	}
	public static void Adicionar(Login login){
		
		String sql = "insert into login(user,senha)"
				+ " values(?,?)";
		
		try {
			
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1,login.getUsuario());
			statement.setString(2,login.getSenha());
		
			
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void Listar(Login login){  
		
		boolean usuario = false;
		boolean senhaU = false;
		
	    try {
	    	
	    	String sql = "select user,senha from login ";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String user = rs.getString("user");
				String senha = rs.getString("senha");

					if(user.equals(login.getUsuario()) && senha.equals(login.getSenha())){
						usuario = true;
						senhaU  = true;
					}
					
				}
				if(usuario == true && senhaU == true){
					Menu.Montar();
				}else{
					TelaLogin inicio = new TelaLogin();
					inicio.setVisible(true);
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
				}
					
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
//	public  static void Listar(Login login){
//		List<Login>contatos = new ArrayList<Login>();
//		try{
//			
//			String sql = "select user,senha from login where user = ? and senha = ?";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			
//			
//			Login cadastro = new Login();
//			stmt.setString(1,cadastro.getUsuario());
//			stmt.setString(2,cadastro.getSenha());
//			
//			ResultSet rs = stmt.executeQuery();
//		
//				
//				String a = (rs.getString("user"));
//				String b = (rs.getString("senha"));
//				contatos.add(cadastro);
//				System.out.println(a + b);
//			
//			
//			
//         }catch (SQLException e){
//			throw new RuntimeException(e);
//		}
//		
//	}
}
