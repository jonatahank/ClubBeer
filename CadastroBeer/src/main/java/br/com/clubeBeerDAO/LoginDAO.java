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
	public  static void Listar(Login login){
		List<Login>contatos = new ArrayList<Login>();
		try{
			
			String sql = "select user,senha from login";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Login cadastro = new Login();
				
				cadastro.setUsuario(rs.getString("user"));
				cadastro.setSenha(rs.getString("senha"));
				contatos.add(cadastro);
				//rs.first();// não sei que faz não em 
				if(login.getUsuario().equals(cadastro.getUsuario()) && login.getSenha().equals(cadastro.getSenha())){
					Menu.Montar();
				}else if(login.getUsuario()!= cadastro.getUsuario() && login.getSenha().equals(cadastro.getSenha())) {
					JOptionPane.showMessageDialog(null, "Usuario Incorreto " );
				}else if(login.getUsuario().equals(cadastro.getUsuario()) && login.getSenha()!= cadastro.getSenha()) {
					JOptionPane.showMessageDialog(null, "Senha Incorreto " );
				}else if(login.getUsuario()!= cadastro.getUsuario() && login.getSenha()!= cadastro.getSenha()) {
					JOptionPane.showMessageDialog(null, "Usuario e Senha Incorreto " );
				}

				
				
			
			}
			System.out.println(contatos.toString());
			
         }catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
