package br.com.clubeBeer.Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Login.Login;
import PessoaFisica.PessoaFisica;
import br.com.clubeBeerDAO.LoginDAO;
import br.com.clubeBeerDAO.PessoaFisicaDAO;
// setEnaled desabilida sem desaparecer
public class TelaLogin extends JFrame implements ActionListener, MouseListener{
     String a;
	
     JPanel painel;
     JPanel painelLogin;
     
     JTextField user;
     JTextField userC;
     JTextField senhaC;
     
     JPasswordField senha;
     
     JButton entra;
     JButton cadastra;
     JButton salva;
     static JButton login;
     
     Icon rotulo = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\Fundo2.png");
     Icon barril = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\barril.png");
     Icon text = new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\text.png");
     
     JLabel fundo;
     JLabel cadastro;
     
     public TelaLogin(){
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    	setContentPane(new JLabel(new ImageIcon("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\Fundo.png")));
    	
    	fundo = new JLabel(rotulo);
    	fundo.setSize(300,200);
    	
        painel = new JPanel(); 
        painel.setLayout(null);
        painel.setVisible(false);
	  	
		userC = new JTextField();
	  	userC.setBounds(30, 30, 250, 30);
	  	userC.setToolTipText("USUARIO");
	  	
	  	senhaC = new JTextField();
	  	senhaC.setBounds(30, 80, 250, 30);
	  	senhaC.setToolTipText("SENHA");
	  	
	  	salva = new JButton("Salvar");
	  	salva.setBounds(175, 150, 100, 20);
	  	salva.addActionListener(this);
	  	
	  	painel.add(salva);
	  	painel.add(userC);
	  	painel.add(senhaC);
	 // 	painel.add(user);
	  	painel.add(fundo);
	  	
	  	add(painel);
	  	
	  	painel.setBounds(350, 160, 300, 200);
    	
    	painelLogin = new JPanel();
    	painelLogin.setLayout(null);
    	painelLogin.setBackground(Color.black);
    	painelLogin.setVisible(true);
    	painelLogin.setBounds(0, 0, 1000, 50);
		
		cadastro = new JLabel("   Cadastre aqui .");
		cadastro.setForeground(Color.white);
		cadastro.setBounds(540, 35, 250, 15);
		cadastro.addMouseListener(this);
	
		user = new JTextField();
	  	user.setBounds(540, 10, 150, 20);
	  	user.requestFocus();
	  	user.setToolTipText("USUARIO");
	  	
	  	senha = new JPasswordField();
	  	senha.setBounds(700, 10, 150, 20);
	  	senha.setToolTipText("SENHA");
	  	
	  	login = new JButton("Login");
	  	login.setBounds(880, 10, 100, 20);
	  	login.addActionListener(this);
	  	
	  	
	  	painelLogin.add(cadastro);
	  	painelLogin.add(login);
	  	painelLogin.add(senha);
	  	painelLogin.add(user);

    	JLabel bar = new JLabel(barril);
    	bar.setBounds(710, 315, 400, 400);
    	
    	add(bar);
    	add(painelLogin);
    	
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

		if (evento.getSource() == login){
			Login consulta = new Login();
			consulta.setUsuario(user.getText());
			consulta.setSenha(senha.getText());
			LoginDAO add = new LoginDAO ();
			add.Listar(consulta);
			setVisible(false);
		
			
			
		}else if (evento.getSource() == salva){
			JOptionPane.showConfirmDialog(null, "Deseja salvar o cadastro ? " );
			
			Login login = new Login();
			
			login.setUsuario(userC.getText());
			login.setSenha(senhaC.getText());
			

			
			LoginDAO add = new LoginDAO ();
			add.Adicionar(login);
			
//			userC.setText("");
//			senhaC.setText("");
			painel.setVisible(false);
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		painel.setVisible(true);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
