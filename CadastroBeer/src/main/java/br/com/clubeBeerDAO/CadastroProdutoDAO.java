package br.com.clubeBeerDAO;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PessoaFisica.PessoaFisica;
import PessoaJuritica.PessoaJuridica;
import Venda.Produto;
import Conexao.ConnectionFactory;
import Funcionario.Funcionario;

public class CadastroProdutoDAO {
	static Connection con;
	public static String[] vendedor = new String[15];
	public static String retornoId;
	public static Integer valor;

	public CadastroProdutoDAO() {
		this.con = ConnectionFactory.getConnection();
	}

	public static void Adicionar(Produto produto) {
		String sql = "insert into produto (tipo,nome,valor,formaVenda,descrisao)"
				+ "values(?,?,?,?,?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, (String) produto.getTipo());
			stm.setString(2, produto.getNome());
			stm.setString(3, produto.getValor());
			stm.setString(4, (String) produto.getForma());
			stm.setString(5, produto.getDescrisao());

			stm.execute();
			stm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> listarVendedor() {
  
		try {
			 List<Funcionario> lista = new ArrayList<Funcionario>();
			String sql = "select * from funcionario where funcao = 'vendedor'";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		   
			while (rs.next()) {
				Funcionario fun = new Funcionario();
				fun.setNome(rs.getString("nome"));
				lista.add(fun);
				//System.out.println(lista);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public List<PessoaFisica> listarFisico() {
		  
		try {
			 List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
			String sql = "select * from pessoafisica";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		   
			while (rs.next()) {
				PessoaFisica pessoa = new PessoaFisica();
				pessoa.setNome(rs.getString("nome"));
				lista.add(pessoa);
				//System.out.println(lista);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public List<PessoaJuridica> listarJuridico() {
		  
		try {
			 List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
			String sql = "select * from pessoajuridica";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		   
			while (rs.next()) {
				PessoaJuridica pessoa = new PessoaJuridica();
				pessoa.setNome(rs.getString("nome"));
				lista.add(pessoa);
				//System.out.println(lista);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public static void listarProduto(int id) {
		String sql = "select * from produto where idproduto = ?";
		try {
		
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
			 retornoId = rs.getString("nome");
			 valor = Integer.valueOf(rs.getString("valor"));
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Produto> Listar(){
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			
			String sql = "select * from produto";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Produto produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getString("valor"));
			    produto.setId(rs.getInt("idproduto"));
				 produtos.add(produto);
				
				
			}
			
			return  produtos;
         }catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		
		
	}
}
