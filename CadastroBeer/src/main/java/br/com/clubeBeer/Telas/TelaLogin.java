package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Login.Login;
import PessoaFisica.PessoaFisica;
import br.com.clubeBeerDAO.LoginDAO;
import br.com.clubeBeerDAO.PessoaFisicaDAO;

public class TelaLogin extends JFrame implements ActionListener{
     String a;
	
     JPanel painel;
     
     JTextField user;
     JTextField senhaC;
     
     JPasswordField senha;
     
     JButton entra;
     JButton cadastra;
     JButton salva;
     static JButton login;
     
     Icon BSalva = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\salvar.png");
     Icon Bcadastro = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\cadas.png");
     Icon barril = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\barril.png");
     Icon text = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\text.png");
     
     JLabel fundo;
     
     public TelaLogin(){
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    	setContentPane(new JLabel(new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\Fundo.png")));
    	
    	
		
    	
    	fundo = new JLabel(text);
    	fundo.setSize(300,200);
    	
    	
    	
    	entra = new JButton(BSalva);
    	entra.setBounds(400, 110, 203, 100);
    	entra.addActionListener(this);
    	
    	cadastra = new JButton(Bcadastro);
    	cadastra.setBounds(400, 230, 203, 100);
    	cadastra.addActionListener(this);
    	
    	JLabel bar = new JLabel(barril);
    	bar.setBounds(710, 315, 400, 400);
    	
    	add(bar);
    	add(cadastra);
    	add(entra);
    	
    	setSize(1000, 700);
    	
     }
     
     public static void main(String[] args) {
    	 try {
 			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
 			} catch (Exception ex) {
 			ex.printStackTrace();
 			}
		new TelaLogin();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()== entra){
		painel = new JPanel();	
		user = new JTextField();
	  	user.setBounds(30, 30, 250, 30);
	  	user.setToolTipText("USUARIO");
	  	
	  	senha = new JPasswordField();
	  	senha.setBounds(30, 80, 250, 30);
	  	senha.setToolTipText("SENHA");
	  	
	  	login = new JButton("Login");
	  	login.setBounds(175, 150, 100, 20);
	  	login.addActionListener(this);
	  	
	  	
	  	
	  	painel.add(login);
	  	painel.add(senha);
	  	painel.add(user);
	  	painel.add(fundo);
	  	
	  	add(painel);
	  	painel.setBounds(680, 10, 300, 200);
	  	
			
		}else if(evento.getSource() == cadastra){
			
			painel = new JPanel();  	
		  	
			user = new JTextField();
		  	user.setBounds(30, 30, 250, 30);
		  	user.setToolTipText("USUARIO");
		  	
		  	senhaC = new JTextField();
		  	senhaC.setBounds(30, 80, 250, 30);
		  	senhaC.setToolTipText("SENHA");
		  	
		  	salva = new JButton("Salvar");
		  	salva.setBounds(175, 150, 100, 20);
		  	salva.addActionListener(this);
		  	
		  	painel.add(salva);
		  	painel.add(senhaC);
		  	painel.add(user);
		  	painel.add(fundo);
		  	add(painel);
		  	painel.setBounds(10, 10, 300, 200);
		  	
		}else if (evento.getSource() == login){
			Login consulta = new Login();
			consulta.setUsuario(user.getText());
			consulta.setSenha(senha.getText());
			LoginDAO add = new LoginDAO ();
			add.Listar(consulta);
			
		
			
			
		}else if (evento.getSource() == salva){
			JOptionPane.showConfirmDialog(null, "Deseja salvar o cadastro ? " );
			
			Login login = new Login();
			
			login.setUsuario(user.getText());
			login.setSenha(senhaC.getText());
			
			
			LoginDAO add = new LoginDAO ();
			add.Adicionar(login);
			
		}
		
	}
}
