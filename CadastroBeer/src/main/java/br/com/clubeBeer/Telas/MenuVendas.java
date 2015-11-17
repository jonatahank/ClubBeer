package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.clubeBeerDAO.CadastroProdutoDAO;
import Funcionario.Funcionario;
import PessoaFisica.PessoaFisica;
import PessoaJuritica.PessoaJuridica;
import Venda.PDF;
import Venda.Produto;

/**
 * Tela responsavel por gerar pedidos e cadastrar novos produtos ao banco
 * 
 * @author Andriotti
 *
 */

@SuppressWarnings("serial")
public class MenuVendas extends JFrame implements ActionListener, KeyListener {
	int i =0;
	int ChamaFisico;
	int valor = 0;
	JLabel background;
	Icon image = new ImageIcon(
			"C:\\Users\\Andriotti\\Desktop\\Algoritmo\\venda.jpg");
	Icon imageMais = new ImageIcon(
			"C:\\Users\\Andriotti\\Desktop\\Algoritmo\\soma.jpg");
	Icon imageMenu = new ImageIcon(
			"C:\\Users\\Andriotti\\Desktop\\Algoritmo\\menu.png");

	String[] tipoProduto = { " ", "Cervejas", "Destinados", "Regriferantes",
			"Vinhos", "Champanhes" };
	String[] tipoVenda = { " ", "290 ml", "350 ml", "600 ml", "1000 ml" };

	Object[][] tabelaProdutos = new Object[15][2];
	String[] tabelaNomes = { "Produtos", "valor" };

	JTable tabela = new JTable(tabelaProdutos, tabelaNomes);
	JCheckBox[] check = new JCheckBox[3];
	JPanel[] parede = new JPanel[3];
	JButton[] botoes = new JButton[6];
	JTextField[] text = new JTextField[5];
	JLabel[] label = new JLabel[5];
	JComboBox[] combo = new JComboBox[6];
	
	CadastroProdutoDAO dao = new CadastroProdutoDAO();

	public MenuVendas() {
		super("Loja - Clube dos Cervejeiros");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		background = new JLabel(image);
		background.setBounds(320, 10, 615, 300);
		/**
		 * Array de botoes tela 1
		 */

		botoes[0] = new JButton("Adicionar novo Produto");
		botoes[0].setBounds(400, 320, 200, 30);
		botoes[0].addActionListener(this);

		botoes[1] = new JButton("Nova venda");
		botoes[1].setBounds(660, 320, 200, 30);
		botoes[1].addActionListener(this);

		botoes[2] = new JButton(" Adicionar");
		botoes[2].setBounds(735, 660, 200, 30);
		botoes[2].setVisible(false);
		botoes[2].addActionListener(this);

		botoes[3] = new JButton(" Gerar");
		botoes[3].setBounds(735, 660, 200, 30);
		botoes[3].setVisible(false);
		botoes[3].addActionListener(this);

		botoes[4] = new JButton(imageMenu);
		botoes[4].setBackground(Color.black);
		botoes[4].setToolTipText(" Home");
		botoes[4].setBounds(0, 0, 80, 80);
		botoes[4].addActionListener(this);

		botoes[5] = new JButton(imageMais);
		botoes[5].setBackground(Color.black);
		botoes[5].setToolTipText(" Adicionar");
		botoes[5].setBounds(400, 70, 20, 20);
		botoes[5].addActionListener(this);

		
		
		/**
		 * Jtable
		 */
		
		tabela.setBounds(15, 100, 400, 100);
		/**
		 * Array de Label tela 1
		 */

		label[0] = new JLabel("Tipo :");
		label[0].setBounds(10, 10, 100, 20);

		label[1] = new JLabel("Nome Produto :");
		label[1].setBounds(10, 50, 100, 20);

		label[2] = new JLabel("Valor:");
		label[2].setBounds(10, 90, 100, 20);

		label[3] = new JLabel("Descrisão :");
		label[3].setBounds(10, 140, 100, 20);
		
		
		
		
		
	
		
		/**
		 * Array de TextFiel tela 1
		 */

		text[0] = new JTextField();
		text[0].setBounds(10, 110, 100, 20);

		text[1] = new JTextField();
		text[1].setBounds(10, 70, 150, 20);

		text[2] = new JTextField();
		text[2].setBounds(10, 170, 320, 30);

		/**
		 * TexFiel tela 2 venda
		 */

		text[3] = new JTextField();
		text[3].setToolTipText("Codigo Produto");
		text[3].setBounds(10, 70, 50, 20);
		text[3].addKeyListener(this);

		text[4] = new JTextField();
		text[4].setToolTipText("Produto");
		text[4].setBounds(80, 70, 300, 20);
		text[4].addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					Toolkit.getDefaultToolkit().beep();
					ListaProduto pro = new ListaProduto();
					pro.montaTela();
					//setVisible(false);
				}
				
			}
		});

		/**
		 * Array de ComboBox tela 1
		 */
		combo[0] = new JComboBox(tipoProduto);
		combo[0].setToolTipText(" Tipo do Produto ");
		combo[0].setBounds(10, 30, 150, 20);

		combo[1] = new JComboBox(tipoVenda);
		combo[1].setToolTipText(" ML");
		combo[1].setBounds(120, 110, 80, 20);
		/**
		 * ComboBox tela 2
		 */
		
		//lotarComboFisico();
		combo[3] = new JComboBox<PessoaFisica>();
		combo[3].setToolTipText("Cliente");
		combo[3].setBounds(10, 30, 250, 20);

		combo[4] = new JComboBox <Funcionario>();
		combo[4].setToolTipText("Vendedor");
		combo[4].setBounds(350, 30, 250, 20);
		lotarComboVendedor();
		
		
		
		/**
		 * check box para tela 2
		 */

		check[0] = new JCheckBox(" Fisica");
		check[0].setBounds(0, 0, 100, 30);
		check[0].addActionListener(this);

		check[1] = new JCheckBox(" Juritica");
		check[1].setBounds(100, 0, 100, 30);
		check[1].addActionListener(this);
		
		/**
		 * Instanciando a parede.
		 */

		parede[2] = new JPanel();
		parede[2].setLayout(null);
		parede[2].setBounds(320, 400, 615, 250);
		parede[2].setVisible(false);

		parede[1] = new JPanel();
		parede[1].setLayout(null);
		parede[1].setBounds(320, 400, 615, 250);
		parede[1].setVisible(false);

		parede[0] = new JPanel();
		parede[0].setBackground(Color.BLACK);
		parede[0].setLayout(null);

		/**
		 * Colando elemento ao array de painel
		 * 
		 */
		parede[2].add(text[3]);
		parede[2].add(text[4]);

		parede[2].add(combo[3]);
		parede[2].add(combo[4]);

		parede[2].add(botoes[5]);

		parede[2].add(check[0]);
		parede[2].add(check[1]);
		
		parede[2].add(tabela);
		
		

		parede[1].add(label[0]);
		parede[1].add(label[1]);
		parede[1].add(label[2]);
		parede[1].add(label[3]);

		parede[1].add(text[0]);
		parede[1].add(text[1]);
		parede[1].add(text[2]);

		parede[1].add(combo[0]);
		parede[1].add(combo[1]);

		parede[0].add(background);
		parede[0].add(botoes[0]);
		parede[0].add(botoes[1]);
		parede[0].add(botoes[2]);
		parede[0].add(botoes[3]);
		parede[0].add(botoes[4]);

		parede[0].add(parede[1]);
		parede[0].add(parede[2]);

		parede[0].setBounds(0, 0, 1250, 750);

		add(parede[0]);

		setBounds(0, 0, 1250, 750);
	}
	public void lotarComboVendedor(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		lista = dao.listarVendedor();
		
		combo[4].removeAllItems();
		combo[4].addItem(null);
		
		for (Funcionario funcionario : lista) {
			combo[4].addItem(funcionario);
		}
		
	}
	
	public void lotarComboFisico(){
		List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
		
		lista = dao.listarFisico();
		
		combo[3].removeAllItems();
		combo[3].addItem(null);
		
		for (PessoaFisica pessoa : lista) {
			combo[3].addItem(pessoa);
		}
		
	}
	public void lotarCombojuridico(){
		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
		
		lista = dao.listarJuridico();
		
		combo[3].removeAllItems();
		combo[3].addItem(null);
		
		for (PessoaJuridica pessoa : lista) {
			combo[3].addItem(pessoa);
		}
		
	}
	public static void main(String[] args) {
		new MenuVendas();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(botoes[0])) {
			parede[1].setVisible(true);
			botoes[2].setVisible(true);

		} else if (evento.getSource().equals(botoes[1])) {
			parede[2].setVisible(true);
			botoes[3].setVisible(true);

		} else if (evento.getSource().equals(botoes[2])) {
			JOptionPane.showConfirmDialog(null, "Deseja salvar o produto  "
					+ text[1].getText());

			Produto produto = new Produto();

			produto.setTipo(tipoProduto[combo[0].getSelectedIndex()]);
			produto.setNome(text[1].getText());
			produto.setValor(text[0].getText());
			produto.setForma(tipoVenda[combo[1].getSelectedIndex()]);
			produto.setDescrisao(text[2].getText());

			CadastroProdutoDAO add = new CadastroProdutoDAO();
			add.Adicionar(produto);

			JOptionPane.showMessageDialog(null, text[1].getText()
					+ " Salvo com sucesso");

			parede[1].setVisible(false);
			botoes[2].setVisible(false);

		} else if (evento.getSource().equals(botoes[3])) {
			String nome =JOptionPane.showInputDialog("Nome do Arquivo");
		
			 if(ChamaFisico == 1){
				 PessoaFisica pessoa = new PessoaFisica();
					pessoa = (PessoaFisica) combo[3].getSelectedItem();
					String cliente = pessoa.toString();
					
					Funcionario funcionario = new Funcionario();
					funcionario = (Funcionario) combo[4].getSelectedItem();
					String pdfFuncionario = funcionario.toString();
					
					PDF pdf = new PDF(cliente, pdfFuncionario,tabelaProdutos,nome,valor);
					
					Menu menu = new Menu();
					setVisible(false);
					menu.Montar();
					
					
					
			 }else{
					PessoaJuridica Juridica = new PessoaJuridica();
					Juridica = (PessoaJuridica) combo[3].getSelectedItem();
					String clienteJuridico = Juridica.toString(); 
					
					Funcionario funcionario = new Funcionario();
					funcionario = (Funcionario) combo[4].getSelectedItem();
					String pdfFuncionario = funcionario.toString();
					
					PDF pdf = new PDF(clienteJuridico, pdfFuncionario,tabelaProdutos,nome,valor);
					
					Menu menu = new Menu();
					setVisible(false);
					menu.Montar();
			 }
			
			
			
		    
			parede[2].setVisible(false);
			botoes[3].setVisible(false);

		} else if (evento.getSource().equals(botoes[4])) {
			Menu menu = new Menu();
			setVisible(false);
			menu.Montar();
			
		}else if (evento.getSource().equals(botoes[5])){
			CadastroProdutoDAO add = new CadastroProdutoDAO();
		
			tabelaProdutos[i][0] = text[4].getText();
			tabelaProdutos[i][1] = add.valor;
			tabela.repaint();
			i+=1;
			
			valor+=add.valor;

			
		//System.out.println(valor);
	
		}else if (evento.getSource().equals(check[0])){
			ChamaFisico =1;
			lotarComboFisico();
			
		}else if (evento.getSource().equals(check[1])){
			lotarCombojuridico();
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			Toolkit.getDefaultToolkit().beep();
			CadastroProdutoDAO dao = new CadastroProdutoDAO();
			dao.listarProduto(Integer.parseInt(text[3].getText()));
			text[4].setText(dao.retornoId);
		
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			Toolkit.getDefaultToolkit().beep();
			CadastroProdutoDAO dao = new CadastroProdutoDAO();
			dao.listarProduto(Integer.parseInt(text[3].getText()));
			text[4].setText(dao.retornoId);

	}
}
}