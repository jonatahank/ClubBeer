package br.com.clubeBeerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import Funcionario.Funcionario;
import PessoaFisica.PessoaFisica;

public class FuncionarioDAO {
static Connection con;
	
	public FuncionarioDAO() {
		
		this.con = ConnectionFactory.getConnection();
	}
	public static void Adicionar(Funcionario pessoa){
		
		String sql = "insert into funcionario(nome,telefone1,telefone2,email,endereco,numero,complemento,bairro,cidade,uf,funcao,estadoCivil,salario,sexo,cpf,rg,cep)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1,pessoa.getNome());
			statement.setString(2,pessoa.getTelefone1());
			statement.setString(3,pessoa.getTelefone2());
			statement.setString(4,pessoa.getEmail());
			statement.setString(5,pessoa.getEndereco());
			statement.setString(6,pessoa.getNumero());
			statement.setString(7,pessoa.getComplemento());
			statement.setString(8,pessoa.getBairro());
			statement.setString(9,pessoa.getCidade());
			statement.setString(10,(String) pessoa.getUf());
			statement.setString(11,(String)pessoa.getFuncao());
			statement.setString(12,(String)pessoa.getEstadoCivil());
			statement.setString(13,pessoa.getSalario());
			statement.setString(14,pessoa.getSexo());
			statement.setString(15,pessoa.getCpf());
			statement.setString(16,pessoa.getIdentidade());
			statement.setString(17,pessoa.getCep());
			
			
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public List<Funcionario> Listar(){
		List<Funcionario>contatos = new ArrayList<Funcionario>();
		try{
			
			String sql = "select * from funcionario";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Funcionario contato = new Funcionario();
				contato.setId(rs.getInt("idfuncionario"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone1(rs.getString("telefone1"));
				contato.setTelefone2(rs.getString("telefone2"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setNumero(rs.getString("numero"));
				contato.setComplemento(rs.getString("complemento"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setUf(rs.getString("uf"));
				contato.setFuncao(rs.getString("funcao"));
				contato.setEstadoCivil(rs.getString("estadoCivil"));
				contato.setSalario(rs.getString("salario"));
				contato.setSexo(rs.getString("sexo"));
				contato.setCpf(rs.getString("cpf"));
				contato.setIdentidade(rs.getString("rg"));
				contato.setCep(rs.getString("cep"));
				
				
			
				contatos.add(contato);
				
				
			}
			
			return contatos;
         }catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		
		
	}
    public static void Excliur(String nome){
    	try{
    		String sql = "delete from funcionario where nome = ? ";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, nome);
    		stmt.executeUpdate();
    		stmt.close();
    	 }catch (SQLException e){
			throw new RuntimeException(e);
		}
    }
    public static void Alterar(Funcionario funcionario){
    	try {
    		String sql = "update funcionario set nome=?,telefone1=?,telefone2=?,email=?,endereco=?,numero=?,complemento=?,"
    				+ "bairro=?,cidade=?,uf=?,funcao=?,estadoCivil=?,salario=?,sexo=?,cpf=?,rg=?,cep=? where idfuncionario=?";
    		PreparedStatement statement = con.prepareStatement(sql);
    		statement.setString(1,funcionario.getNome());
    		statement.setString(2,funcionario.getTelefone1());
			statement.setString(3,funcionario.getTelefone2());
			statement.setString(4,funcionario.getEmail());
			statement.setString(5,funcionario.getEndereco());
			statement.setString(6,funcionario.getNumero());
			statement.setString(7,funcionario.getComplemento());
			statement.setString(8,funcionario.getBairro());
			statement.setString(9,funcionario.getCidade());
			statement.setString(10,(String) funcionario.getUf());
			statement.setString(11,(String) funcionario.getFuncao());
			statement.setString(12,(String) funcionario.getEstadoCivil());
			statement.setString(13,funcionario.getSalario());
			statement.setString(14,funcionario.getSexo());
			statement.setString(15,funcionario.getCpf());
			statement.setString(16,funcionario.getIdentidade());
			statement.setString(17,funcionario.getCep());
			statement.setInt(18,funcionario.getId());
			
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
