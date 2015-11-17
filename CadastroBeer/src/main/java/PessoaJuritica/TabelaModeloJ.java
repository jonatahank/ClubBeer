package PessoaJuritica;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import PessoaFisica.PessoaFisica;

@SuppressWarnings("serial")
public class TabelaModeloJ extends AbstractTableModel {

    private final List<PessoaJuridica> lista;

    // ctrl + 3 constructor
    public TabelaModeloJ(List<PessoaJuridica> lista) {
        super();
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 14;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PessoaJuridica pessoa = lista.get(linha);
        switch (coluna) {
        
        case 0:
        	return pessoa.getNome();
        case 1:
        	return pessoa.getCnpj();
        case 2:
        	return pessoa.getNomeFantasia();
        case 3:
            return pessoa.getTelefone1();
        case 4:
            return pessoa.getTelefone2();
        case 5 : 
        	return pessoa.getCep();
        case 6 : 
        	return pessoa.getNumero(); 	
        case 7:
            return pessoa.getEndereco();
        case 8: 
        	return pessoa.getComplemento();
        case 9:
        	return pessoa.getBairro();
        case 10:
            return pessoa.getCidade();
        case 11:
            return pessoa.getUf();
        case 12:
            return pessoa.getEmail();
        case 13:
        	return pessoa.getId();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
        case 0:
            return "Nome";
        case 1:
            return "Cnpj";
        case 2:
            return "Fantasia";
        case 3:
            return "Tel:";
        case 4:
            return "Cel:";
        case 5:
            return "Cep";
        case 6:
            return "N�";
        case 7:
            return "End";
        case 8:
            return "Complemento";
        case 9:
            return "Bairro";
        case 10:
            return "Cidade";
        case 11:
            return "UF";
        case 12:
            return "Email";
        }
        return "";
    }
}
 
//	String url = "jdbc:mysql://localhost:3306/cadastrobeer";
//
//	Connection con = DriverManager.getConnection(url,"root","45774217");
//
//	String sql = "select idpessoafisica,nome,email from pessoafisica";
//	 
//	PreparedStatement	statement = con.prepareStatement(sql);
//
//
//	ResultSet rs = statement.executeQuery();
//
//
//		while (rs.next()) {
//			  String id = rs.getString("idpessoafisica");
//			  String nome = rs.getString("nome");
//			  String email = rs.getString("email");
//			  
//		
//			 araay = new ArrayList<String>();
//             araay.add(id);
//             araay.add(nome);
//             araay.add(email);
//			  //System.out.println(id + " :: "+ nome + " :: "+email);
//             
//             System.out.println(araay);
//			}
//
//	statement.close();
//	con.close(); 
	
 


