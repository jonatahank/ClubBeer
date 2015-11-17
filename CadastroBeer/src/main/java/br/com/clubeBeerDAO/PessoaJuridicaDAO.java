package br.com.clubeBeerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import PessoaFisica.PessoaFisica;
import PessoaJuritica.PessoaJuridica;

public class PessoaJuridicaDAO {
	static Connection con;

	public PessoaJuridicaDAO() {

		this.con = ConnectionFactory.getConnection();
	}

	public static void Adicionar(PessoaJuridica pessoaF) {

		String sql = "insert into pessoajuridica(nome,cnpj,nomeFantasia,telefone1,telefone2,cep,endereco,numero,complemento,bairro,cidade,uf,email)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, pessoaF.getNome());
			statement.setString(2, pessoaF.getCnpj());
			statement.setString(3, pessoaF.getNomeFantasia());
			statement.setString(4, pessoaF.getTelefone1());
			statement.setString(5, pessoaF.getTelefone2());
			statement.setString(6, pessoaF.getCep());
			statement.setString(7, pessoaF.getEndereco());
			statement.setString(8, pessoaF.getNumero());
			statement.setString(9, pessoaF.getComplemento());
			statement.setString(10, pessoaF.getBairro());
			statement.setString(11, pessoaF.getCidade());
			statement.setString(12, (String) pessoaF.getUf());
			statement.setString(13, pessoaF.getEmail());
		

			statement.execute();
			statement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<PessoaJuridica> Listar() {
		List<PessoaJuridica> contatos = new ArrayList<PessoaJuridica>();
		try {

			String sql = "select * from pessoaJuridica";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				PessoaJuridica contato = new PessoaJuridica();
				contato.setId(rs.getInt("idpessoaJuridica"));
				contato.setNome(rs.getString("nome"));
				contato.setCnpj(rs.getString("cnpj"));
				contato.setNomeFantasia(rs.getString("nomeFantasia"));
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
				contatos.add(contato);

			}

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public static void Excliur(String nome) {
		try {
			String sql = "delete from pessoajuridica where nome = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void Alterar(PessoaJuridica pessoa) {
		try {
			String sql = "update pessoaJuridica set nome=?,cnpj=?,nomeFantasia=?,telefone1=?,telefone2=?,cep=?,endereco=?,"
					+ "numero=?,complemento=?,bairro=?,cidade=?,uf=?,email=? where idpessoaJuridica=?";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getCnpj());
			statement.setString(3, pessoa.getNomeFantasia());
			statement.setString(4, pessoa.getTelefone1());
			statement.setString(5, pessoa.getTelefone2());
			statement.setString(6, pessoa.getCep());
			statement.setString(7, pessoa.getEndereco());
			statement.setString(8, pessoa.getNumero());
			statement.setString(9, pessoa.getComplemento());
			statement.setString(10, pessoa.getBairro());
			statement.setString(11, pessoa.getCidade());
			statement.setString(12, (String) pessoa.getUf());
			statement.setString(13, pessoa.getEmail());
			statement.setInt(14, pessoa.getId());

			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
