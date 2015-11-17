package br.com.clubeBeerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import PessoaFisica.PessoaFisica;

public class PessoaFisicaDAO {
	
	static Connection con;
	
	public PessoaFisicaDAO() {
		
		this.con = ConnectionFactory.getConnection();
	}
	public static void Adicionar(PessoaFisica pessoaFisica){
		
		String sql = "insert into pessoafisica(nome,cpf,identidade,telefone1,telefone2,cep,endereco,numero,complemento,bairro,cidade,uf,email,sexo)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1,pessoaFisica.getNome());
			statement.setString(2,pessoaFisica.getCpf());
			statement.setString(3,pessoaFisica.getIdentidade());
			statement.setString(4,pessoaFisica.getTelefone1());
			statement.setString(5,pessoaFisica.getTelefone2());
			statement.setString(6,pessoaFisica.getCep());
			statement.setString(7,pessoaFisica.getEndereco());
			statement.setString(8,pessoaFisica.getNumero());
			statement.setString(9,pessoaFisica.getComplemento());
			statement.setString(10,pessoaFisica.getBairro());
			statement.setString(11,pessoaFisica.getCidade());
			statement.setString(12,(String) pessoaFisica.getUf());
			statement.setString(13,pessoaFisica.getEmail());
			statement.setString(14,pessoaFisica.getSexo());
			
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public List<PessoaFisica> Listar(){
		List<PessoaFisica>contatos = new ArrayList<PessoaFisica>();
		try{
			
			String sql = "select * from pessoafisica";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				PessoaFisica contato = new PessoaFisica();
				contato.setId(rs.getInt("idpessoaFisica"));
				contato.setNome(rs.getString("nome"));
				contato.setCpf(rs.getString("cpf"));
				contato.setIdentidade(rs.getString("identidade"));
				contato.setTelefone1(rs.getString("telefone1"));
				contato.setTelefone2(rs.getString("telefone2"));
				contato.setCep(rs.getString("cep"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setNumero(rs.getString("numero"));
				contato.setComplemento(rs.getString("complemento"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setUf(rs.getString("uf"));
				contato.setEmail(rs.getString("email"));
				contato.setSexo(rs.getString("sexo"));
				contatos.add(contato);
				
				
			}
			
			return contatos;
         }catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		
		
	}
    public static void Excliur(String nome){
    	try{
    		String sql = "delete from pessoafisica where nome = ? ";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, nome);
    		stmt.executeUpdate();
    		stmt.close();
    	 }catch (SQLException e){
			throw new RuntimeException(e);
		}
    }
    public static void Alterar(PessoaFisica pessoaFisica){
    	try {
    		String sql = "update pessoafisica set nome=?,cpf=?,identidade=?,telefone1=?,telefone2=?,cep=?,endereco=?,"
    				+ "numero=?,complemento=?,bairro=?,cidade=?,uf=?,email=?,sexo=? where idpessoaFisica=?";
    		PreparedStatement statement = con.prepareStatement(sql);
    		statement.setString(1,pessoaFisica.getNome());
			statement.setString(2,pessoaFisica.getCpf());
			statement.setString(3,pessoaFisica.getIdentidade());
			statement.setString(4,pessoaFisica.getTelefone1());
			statement.setString(5,pessoaFisica.getTelefone2());
			statement.setString(6,pessoaFisica.getCep());
			statement.setString(7,pessoaFisica.getEndereco());
			statement.setString(8,pessoaFisica.getNumero());
			statement.setString(9,pessoaFisica.getComplemento());
			statement.setString(10,pessoaFisica.getBairro());
			statement.setString(11,pessoaFisica.getCidade());
			statement.setString(12,(String) pessoaFisica.getUf());
			statement.setString(13,pessoaFisica.getEmail());
			statement.setString(14,pessoaFisica.getSexo());
			statement.setInt(15,pessoaFisica.getId());
			
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
