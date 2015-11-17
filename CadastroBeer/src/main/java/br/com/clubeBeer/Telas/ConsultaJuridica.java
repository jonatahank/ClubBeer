package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import PessoaFisica.PessoaFisica;
import PessoaFisica.TabelaModelo;
import PessoaJuritica.PessoaJuridica;
import PessoaJuritica.TabelaModeloJ;
import br.com.clubeBeerDAO.PessoaFisicaDAO;
import br.com.clubeBeerDAO.PessoaJuridicaDAO;

public class ConsultaJuridica {
	private static JFrame janela;
	private static JPanel painelPrincipal;
	private static JTable tabela;

//	public static void main(String[] args) {
//		Locale.setDefault(new Locale("pt", "BR"));
//
//		new ConsultaJuridica().montaTela();
//
//	}

	public static void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		// preparaTitulo();
		preparaTabela();
		preparaBotaoCarregar();
		// preparaBotaoSair();
		mostraJanela();
	}

	private static void preparaTabela() {
		tabela = new JTable();
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);
		tabela.addMouseListener(new MouseAdapter() {  
	            public void mouseClicked(MouseEvent e) {  
	                if(e.getClickCount() == 2) {  
	                    int row = tabela.getSelectedRow();  
	                    PessoaJuridica pessoa = new PessoaJuridica();
	                    AlterarRegistroJuridico teste = new AlterarRegistroJuridico();
	                    
	                    teste.nome.setText(tabela.getValueAt(row, 0).toString());
	                    teste.cnpj.setText(tabela.getValueAt (row, 1).toString());
	                    teste.fantasia.setText(tabela.getValueAt(row, 2).toString());
	                    teste.telefone1.setText(tabela.getValueAt (row, 3).toString());
	                    teste.telefone2.setText(tabela.getValueAt(row, 4).toString());
	                    teste.cep.setText(tabela.getValueAt (row, 5).toString());
	                    teste.numero.setText(tabela.getValueAt(row, 6).toString());
	                    teste.endereco.setText(tabela.getValueAt (row, 7).toString());
	                    teste.complemento.setText(tabela.getValueAt(row, 8).toString());
	                    teste.bairro.setText(tabela.getValueAt (row, 9).toString());
	                    teste.cidade.setText(tabela.getValueAt(row, 10).toString());
	                    teste.uf.setSelectedItem(tabela.getValueAt (row, 11).toString());
	                    teste.email.setText(tabela.getValueAt (row, 12).toString());
	                    teste.id.setText(tabela.getValueAt(row, 13).toString());
	            
	                     
	                }  
	            }  
	        });  
	     

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.setPreferredSize(new Dimension(1200,500));
		scroll.getViewport().add(tabela);
		painelPrincipal.add(scroll);
	}

	private static void preparaJanela() {
		janela = new JFrame("Consulta");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private static void mostraJanela() {
		janela.pack();
		janela.setSize(1250, 750);

		janela.setVisible(true);

	}

	private static void preparaBotaoCarregar() {
		JButton botaoCarregar = new JButton("Consultar");
		botaoCarregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
				List<PessoaJuridica> pessoas = dao.Listar();
				TabelaModeloJ ntm = new TabelaModeloJ(pessoas);
				tabela.setModel(ntm);
				tabela.setPreferredScrollableViewportSize(new Dimension(785,
						220));
				tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(108);
//				tabela.getColumnModel().getColumn(3).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(4).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(5).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(6).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(7).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(8).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(9).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(10).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(11).setPreferredWidth(18);
//				tabela.getColumnModel().getColumn(12).setPreferredWidth(18);
				
			

			};
		});
		painelPrincipal.add(botaoCarregar);
		
	}
}
