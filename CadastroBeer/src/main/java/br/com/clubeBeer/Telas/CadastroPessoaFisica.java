package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.clubeBeerDAO.PessoaFisicaDAO;
import PessoaFisica.PessoaFisica;



public class CadastroPessoaFisica extends JFrame implements ActionListener{
	Container fixo;
    String [] sexo            = {"","Masculino","Feminino","não informado"};//Array para colocar no combo box para escolha do sexo;
    JComboBox escolhaSexo         = new JComboBox (sexo);
    String [] ufEscolha = {"","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    JComboBox uf         = new JComboBox (ufEscolha);		
    JTextArea observacao = new JTextArea("Observação");
    
    JButton salva             = new JButton("SALVAR");//Bot�o para salvar
    // Criando os JTextField
	JTextField dataCadastro   = new JTextField();
	JTextField nome           = new JTextField();	   
	JTextField telefone1      = new JTextField();  
	JTextField telefone2      = new JTextField();  
	JTextField cep            = new JTextField();       
	JTextField endereco       = new JTextField();   
	JTextField numero         = new JTextField();     
	JTextField complemento    = new JTextField();
	JTextField bairro         = new JTextField();     
	JTextField cidade         = new JTextField();           
	JTextField email          = new JTextField();      
	JTextField rg             = new JTextField();
	JTextField cpf            = new JTextField();
	//Criando psJLabel
	JLabel escolhaSexojl           = new JLabel("SEXO :");
	JLabel nomeJl             = new JLabel("NOME :");
	JLabel telefone1jl        = new JLabel("TELEFONE :");
	JLabel telefone2jl        = new JLabel("CELULAR :");
	JLabel cepjl              = new JLabel("CEP :");
	JLabel enderecojl         = new JLabel("ENDERE�O :");
	JLabel numerojl           = new JLabel("Nº :");
	JLabel complementojl      = new JLabel("COMPLEMENTO :");
	JLabel bairrojl           = new JLabel("BAIRRO :");
	JLabel cidadejl           = new JLabel("CIDADE :");
	JLabel ufjl               = new JLabel("UF :");
	JLabel emailjl            = new JLabel("EMAIL :");
	JLabel rgjl               = new JLabel("IDENTIDADE :");
	JLabel cpfjl              = new JLabel("CPF :");
	
	 public CadastroPessoaFisica(){
    	 super("Cadastro - Os Cervejeiros");
    	 setLayout(null);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setVisible(true);
    	 setLocation(0, 0);
    	 fixo = getContentPane();
    	 fixo.setBackground(Color.white);
    	  
    	 nomeJl.setBounds(5,10,50,20);
    	 nome.setBounds(60,10,520,20);
    	 
     	/**/
    	 cpfjl.setBounds(600,10,50,20);
    	 cpf.setBounds(650,10,200,20);

         /**/
    	 rgjl.setBounds(880,10,100,20);
    	 rg.setBounds(980,10,200,20);

    	 /**/  
    	 telefone1jl.setBounds(5,40,80,20);
    	 telefone1.setBounds(85,40,200,20);

   	 /**/
    	 
    	 telefone2jl.setBounds(310,40,80,20);
    	 telefone2.setBounds(380,40,200,20);
 
    	 /**/    
    	 cepjl.setBounds(600,40,50,20);
    	 cep.setBounds(650,40,200,20);

    	 /**/
    	 numerojl.setBounds(935,40,50,20);
    	 numero.setBounds(980,40,100,20);
    	 
    	 /**/ 
    	 enderecojl.setBounds(5,70,80,20);
    	 endereco.setBounds(85,70,495,20);
    	 

   	 /**/
    	 complementojl.setBounds(600,70,100,20);
    	 complemento.setBounds(710,70,200,20);
  	 /**/
    	 bairrojl.setBounds(5,100,100,20);
    	 bairro.setBounds(85,100,200,20);
    	 
    	 /**/
    	 cidadejl.setBounds(300,100,100,20);
    	 cidade.setBounds(370,100,210,20);
    	
    	 
    	 /**/
    	 ufjl.setBounds(600,100,100,20);
    	 uf.setBounds(710,100,200,20);

    	/**/
    	 emailjl.setBounds(5,130,100,20);
    	 email.setBounds(85,130,495,20);
    	
    	/**/
    	escolhaSexojl.setBounds(930,100,100,20);
    	escolhaSexo.setBounds(980,100,200,20);

    	/**/
        salva.setBounds(1000,160,200,40);
    	salva.addActionListener(this);
    
		/**/

		 fixo.add(observacao);
		 fixo.add(escolhaSexojl);
		 fixo.add(escolhaSexo);
    	 fixo.add(nome);
    	 fixo.add(nomeJl);
    	 fixo.add(telefone1jl);
    	 fixo.add(telefone1);
    	 fixo.add(telefone2jl);
    	 fixo.add(telefone2);
    	 fixo.add(cepjl);
    	 fixo.add(cep);
    	 fixo.add(complementojl);
    	 fixo.add(complemento);
    	 fixo.add(numerojl);
    	 fixo.add(numero);
    	 fixo.add(enderecojl);
    	 fixo.add(endereco);
    	 fixo.add(bairrojl);
    	 fixo.add(bairro);
    	 fixo.add(cidadejl);
    	 fixo.add(cidade);
    	 fixo.add(ufjl);
    	 fixo.add(uf);
    	 fixo.add(emailjl);
    	 fixo.add(email);
    	 fixo.add(salva);
    	 fixo.add(cpfjl);
	     fixo.add(cpf);
		 fixo.add(rgjl);
		 fixo.add(rg);
		 
		 setSize(1250,250);
	
	 }
//	public static void main(String[] args) {
//		
//		new CadastroPessoaFisica();
//	}
	public void actionPerformed(ActionEvent eventoBotao) {
		
		
		JOptionPane.showConfirmDialog(null, "Deseja salvar o cadastro ? " );
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setNome(nome.getText());
		pessoaFisica.setCpf(cpf.getText());
		pessoaFisica.setIdentidade(rg.getText());
		pessoaFisica.setTelefone1(telefone1.getText());
		pessoaFisica.setTelefone2(telefone2.getText());
		pessoaFisica.setCep(cep.getText());
		pessoaFisica.setEndereco(endereco.getText());
		pessoaFisica.setComplemento(complemento.getText());
		pessoaFisica.setNumero(numero.getText());
		pessoaFisica.setBairro(bairro.getText());
		pessoaFisica.setCidade(cidade.getText());
		pessoaFisica.setEmail(email.getText());
		pessoaFisica.setUf(ufEscolha[uf.getSelectedIndex()]);
		pessoaFisica.setSexo(sexo[escolhaSexo.getSelectedIndex()]);
		
		
		PessoaFisicaDAO add = new PessoaFisicaDAO();
		add.Adicionar(pessoaFisica);
		br.com.clubeBeer.Telas.Menu.main(null);
		
//		
//		try {
//			PessoaFisicaDAO DAO = FactoryDAO.createPessoaFisicaDAO();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
	
		
		setVisible(false);
		
		
	
	}

}
