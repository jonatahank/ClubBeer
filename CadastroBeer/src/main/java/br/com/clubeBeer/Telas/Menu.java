package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu{
	private static JFrame jframe;
	private static JPanel painelPrincipal;
	private static JMenuBar menuBar;
	
	private static JMenuItem sair;
	
	private static JMenu menuCadastro;
	private static JMenu menuProdutos;
	private static JMenu menuSair;
	private static JMenu tipoCliente;
	
	private static JMenuItem club;
	
	/* Menu para pessoas fisicas*/
	private static JMenu fisico;
	private static JMenuItem fisicoItem;
	private static JMenuItem fisicoConsulta;
	
	/* Menu  para pessoas juridica*/
	private static JMenu juridico;
	private static JMenuItem juridicoItem;
	private static JMenuItem juridicoConsulta;
	
	/* menu funcionario*/
	private static JMenu menuFuncionario;
	private static JMenuItem funcionarioCadastrar;
	private static JMenuItem funcionarioConsultar;

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		Montar();
	}

	public static void CreateFrame() {
		jframe = new JFrame("Menu");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);

	}

	public static void Painel() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.black);
		jframe.add(painelPrincipal);
	}

	public static void MenuBar() {
		menuBar = new JMenuBar();
		jframe.setJMenuBar(menuBar);// PAREDE DO MENU BAR

	}

	public static void MenuItem() {
		menuCadastro = new JMenu("Cadastrar");// menu de cadastro de pessoas
		menuProdutos = new JMenu("Loja");// menu de cadastro de vendas e produtos
		menuSair = new JMenu("Sair");// menu sair 
		tipoCliente = new JMenu("Clientes");// sub menu do menu cadastro para tipos de pessoas ( fisica/juridica)
		/* menus de tipos de pessoas*/
		fisico = new JMenu("Pessoa Fisica");
		juridico = new JMenu("Pessoa Juridico");
		menuFuncionario = new JMenu("Funcionarios");
	
		// COLANDO NA PAREDE
		menuBar.add(menuCadastro);
		menuBar.add(menuProdutos);
		menuBar.add(menuSair);
		
		menuCadastro.add(tipoCliente);
		menuCadastro.add(menuFuncionario);
		tipoCliente.add(fisico);
		tipoCliente.add(juridico);
	

	}

	public static void MenuSubItem() {
		club = new JMenuItem("Clube Beer - Vendas");
		/*  sub item do menu pessoa fisica para cadastrar e consultar*/
		fisicoItem = new JMenuItem("Salva cliente fisico");
		fisicoConsulta = new JMenuItem("Consulta pessoa fisico");
		/*  sub item do menu pessoa juridica para cadastrar e consultar*/
		juridicoItem = new JMenuItem("Salva cliente juridico");
		juridicoConsulta = new JMenuItem("Consulta pessoa juridico");
		sair = new JMenuItem("Sair da aplicação");
		
		
		funcionarioCadastrar = new JMenuItem("Cadastro de Funcionarios");
		funcionarioConsultar = new JMenuItem("Consultar Funcionarios");
		
		/*colando na parede*/
		fisico.add(fisicoItem);
		fisico.add(fisicoConsulta);
		
		juridico.add(juridicoItem);
		juridico.add(juridicoConsulta);
		
		menuFuncionario.add(funcionarioCadastrar);
		menuFuncionario.add(funcionarioConsultar);
		menuSair.add(sair);
		menuProdutos.add(club);

	}

	private static void preparaBotaoCarregar()  {
		/* Bot�es para tela pessoa fisica*/

		fisicoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == fisicoItem){
				   CadastroPessoaFisica chamaCadastro = new CadastroPessoaFisica();
				   jframe.setVisible(false);
			}}
		});
		
		fisicoConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == fisicoConsulta){
				   ConsultaFisica chamaCadastro = new ConsultaFisica();
				   chamaCadastro.montaTela();
				   jframe.setVisible(false);
			}}
		});
		
	}
	private static void preparaBotaoCarregarJ()  {
		/* Bot�es para tela pessoa juridica*/

		juridicoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == juridicoItem){
				   CadastroPessoaJuridica chamaCadastro = new CadastroPessoaJuridica();
				   jframe.setVisible(false);
			}}
		});
		
		juridicoConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == juridicoConsulta){
				   ConsultaJuridica chamaCadastro = new ConsultaJuridica();
				   chamaCadastro.montaTela();
				   jframe.setVisible(false);
			}}
		});

	}
	private static void preparaBotaoCarregarF()  {
		/* Bot�es para tela pessoa juridica*/

		funcionarioCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == funcionarioCadastrar){
				   CadastroFuncionario chamaCadastro = new CadastroFuncionario();
				   jframe.setVisible(false);
			}}
		});
		
		funcionarioConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == funcionarioConsultar){
				   ConsultaFuncionario chamaConsulta = new ConsultaFuncionario();
				   chamaConsulta.montaTela();
				   jframe.setVisible(false);
			}}
		});
		


	}
	
	private static void preparaBotaoCarregarCompras()  {
		/* Bot�es para tela pessoa juridica*/

		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == sair){
					JOptionPane.showMessageDialog(null, "Deseja sair da aplicação");
				 System.exit(0);
			}}
		});

		
		club.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == club){
				   MenuVendas vendas = new MenuVendas();
				   
				   jframe.setVisible(false);
			}}
		});
	}
	public static void Label(){
		Icon cerveja = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\logo_serv.png");
		JLabel logo = new JLabel(cerveja);	
		painelPrincipal.add(logo);
		
	}

	public static void IniciarFrame() {
		jframe.setSize(1250, 750);
		jframe.setVisible(true);
	}

	public static void Montar() {
		CreateFrame();
		Painel();
		MenuBar();
		MenuItem();
		MenuSubItem();
		preparaBotaoCarregar();
		preparaBotaoCarregarJ();
		preparaBotaoCarregarF();
		preparaBotaoCarregarCompras();
		Label();
		IniciarFrame();
	}

	

}
