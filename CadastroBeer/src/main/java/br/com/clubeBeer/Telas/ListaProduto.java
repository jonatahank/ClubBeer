package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import br.com.clubeBeerDAO.CadastroProdutoDAO;
import PessoaFisica.PessoaFisica;

	import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

	import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableModel;

import br.com.clubeBeerDAO.FuncionarioDAO;
import br.com.clubeBeerDAO.PessoaFisicaDAO;
import Funcionario.Funcionario;
import Funcionario.TabelaModeloFuncionario;
import PessoaFisica.PessoaFisica;
import PessoaFisica.TabelaModelo;
import Venda.Produto;
import Venda.TabelaModeloProduto;

	public class ListaProduto  {

		public static JFrame janela;
		private static JPanel painelPrincipal;
		private static JTable tabela;

//		public static void main(String[] args) {
//			Locale.setDefault(new Locale("pt", "BR"));
//
//			new ListaProduto().montaTela();
//
//		}

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
		                    Produto pessoa = new Produto();
		                    janela.setVisible(false);
//		                    MenuVendas listar = new  MenuVendas();
//		                    listar.setVisible(true);
//		                    listar.text[4].setText(tabela.getValueAt(row, 0).toString());
//		                    listar.text[3].setText(tabela.getValueAt(row, 2).toString());
  
		                }  
		            }  
		        });  
		     

			JScrollPane scroll = new JScrollPane();
			scroll.getViewport().setBorder(null);
			scroll.setPreferredSize(new Dimension(300,500));
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
			janela.setBounds(1020, 0, 350, 750);

			janela.setVisible(true);

		}

		private static void preparaBotaoCarregar() {
			JButton botaoCarregar = new JButton("Consultar");
			botaoCarregar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CadastroProdutoDAO dao = new CadastroProdutoDAO();
					List<Produto> pessoas = dao.Listar();
					TabelaModeloProduto ntm = new TabelaModeloProduto(pessoas);
					tabela.setModel(ntm);
					tabela.setPreferredScrollableViewportSize(new Dimension(785,
							220));
					tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
					tabela.getColumnModel().getColumn(1).setPreferredWidth(108);

//					
				

				};
			});
			painelPrincipal.add(botaoCarregar);
			
		}

}


