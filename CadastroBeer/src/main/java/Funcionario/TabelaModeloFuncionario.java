package Funcionario;

	

	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;
	import java.util.List;

	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.border.LineBorder;
	import javax.swing.table.AbstractTableModel;

	import javax.swing.table.AbstractTableModel;

	@SuppressWarnings("serial")
	public class TabelaModeloFuncionario extends AbstractTableModel {

	    private final List<Funcionario> lista;

	    // ctrl + 3 constructor
	    public TabelaModeloFuncionario(List<Funcionario> lista) {
	        super();
	        this.lista = lista;
	    }

	    @Override
	    public int getRowCount() {
	        return lista.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return 18;
	    }

	    @Override
	    public Object getValueAt(int linha, int coluna) {
	        Funcionario pessoa = lista.get(linha);
	        switch (coluna) {
	        
	        case 0:
	        	return pessoa.getNome();
	        case 1:
	        	return pessoa.getTelefone1();
	        case 2:
	        	return pessoa.getTelefone2();
	        case 3:
	            return pessoa.getEmail();
	        case 4:
	            return pessoa.getEndereco();
	        case 5 : 
	        	return pessoa.getNumero();
	        case 6 : 
	        	return pessoa.getComplemento();	
	        case 7:
	            return pessoa.getBairro();
	        case 8: 
	        	return pessoa.getCidade();
	        case 9:
	        	return pessoa.getUf();
	        case 10:
	            return pessoa.getFuncao();
	        case 11:
	            return pessoa.getEstadoCivil();
	        case 12:
	            return pessoa.getSalario();
	        case 13:
	        	return pessoa.getSexo();
	        case 14:
	        	return pessoa.getCpf();
	        case 15:
	        	return pessoa.getIdentidade();
	        case 16:
	        	return pessoa.getCep();
	        case 17:
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
	            return "Telefone";
	        case 2:
	            return "Cel";
	        case 3:
	            return "Email:";
	        case 4:
	            return "End:";
	        case 5:
	            return "Nº";
	        case 6:
	            return "Complemento";
	        case 7:
	            return "Bairro";
	        case 8:
	            return "Cidade";
	        case 9:
	            return "UF";
	        case 10:
	            return "Funcao";
	        case 11:
	            return "Estado.C";
	        case 12:
	            return "Salário";
	        case 13:
	            return "Sexo";
	        case 14:
	        	return "CPF";
	        case 15:
	        	return "RG";
	        case 16:
	        	return "CEP";
	        }
	        return "";
	    }
	}

