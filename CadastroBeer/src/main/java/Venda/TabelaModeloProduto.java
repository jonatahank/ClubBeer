package Venda;


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
	public class TabelaModeloProduto  extends AbstractTableModel {

	    private final List<Produto> lista;

	    // ctrl + 3 constructor
	    public TabelaModeloProduto(List<Produto> lista) {
	        super();
	        this.lista = lista;
	    }

	    @Override
	    public int getRowCount() {
	        return lista.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return 3;
	    }

	    @Override
	    public Object getValueAt(int linha, int coluna) {
	        Produto pessoa = lista.get(linha);
	        switch (coluna) {
	        
	        case 0:
	        	return pessoa.getNome();
	        case 1:
	        	return pessoa.getValor();
	        case 2:
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
	            return "Valor";
	        case 2:
	        	return "ID";
	       
	        }
	        return "";
	    }
}
