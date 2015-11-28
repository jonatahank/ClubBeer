package br.com.clubeBeer.Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import PessoaFisica.PessoaFisica;
import PessoaJuritica.PessoaJuridica;
import br.com.clubeBeerDAO.PessoaFisicaDAO;
import br.com.clubeBeerDAO.PessoaJuridicaDAO;

public class AlterarRegistroJuridico extends JFrame implements ActionListener {
	
	
	Container fixo;
  
    String [] ufEscolha = {"","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    JComboBox uf         = new JComboBox (ufEscolha);		
    JTextArea observacao = new JTextArea("Observaçao");
    
    JButton atualiza             = new JButton("Atualizar");
    JButton excluir             = new JButton("Excluir");//Bot�o para salvar
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
	JTextField fantasia             = new JTextField();
	JTextField cnpj            = new JTextField();
	JTextField id             = new JTextField();
	//Criando psJLabel
	JLabel nomeJl             = new JLabel("NOME :");
	JLabel telefone1jl        = new JLabel("TELEFONE :");
	JLabel telefone2jl        = new JLabel("CELULAR :");
	JLabel cepjl              = new JLabel("CEP :");
	JLabel enderecojl         = new JLabel("ENDEREÇO :");
	JLabel numerojl           = new JLabel("Nº :");
	JLabel complementojl      = new JLabel("COMPLEMENTO :");
	JLabel bairrojl           = new JLabel("BAIRRO :");
	JLabel cidadejl           = new JLabel("CIDADE :");
	JLabel ufjl               = new JLabel("UF :");
	JLabel emailjl            = new JLabel("EMAIL :");
	JLabel fantasiajl               = new JLabel("FANTASIA :");
	JLabel cnpjjl              = new JLabel("CNPJ :");
	JLabel idjl              = new JLabel("ID :");
	
	 public AlterarRegistroJuridico(){
    	 super("Atualizar Registros - Os Cervejeiros");
    	 setLayout(null);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setVisible(true);
    	 setLocation(0, 0);
    	 fixo = getContentPane();
    	 fixo.setBackground(Color.white);
    	  
    	 nomeJl.setBounds(5,10,50,20);
    	 nome.setBounds(60,10,520,20);
    	 
     	/**/
    	 cnpjjl.setBounds(600,10,50,20);
    	 cnpj.setBounds(650,10,200,20);

         /**/
    	 fantasiajl.setBounds(880,10,100,20);
    	 fantasia.setBounds(980,10,200,20);

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


    	/**/
    	idjl.setBounds(600,160, 50, 50);
    	id.setBounds(650,160, 50, 50);
    	
        atualiza.setBounds(1000,160,200,40);
    	atualiza.addActionListener(this);
    	excluir.setBounds(750,160,200,40);
    	excluir.addActionListener(this);
    
		/**/

		 fixo.add(observacao);
	
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
    	 fixo.add(cnpjjl);
	     fixo.add(cnpj);
		 fixo.add(fantasiajl);
		 fixo.add(fantasia);
		 fixo.add(idjl);
		 fixo.add(id);
		 fixo.add(atualiza);
		 fixo.add(excluir);
		 
		 setSize(1250,250);
	
	 }
//	public static void main(String[] args) {
//		
//		new AlteraRegistroFisico();
//	}
	public void actionPerformed(ActionEvent eventoBotao) {
		
		if(eventoBotao.getSource() == atualiza){
		JOptionPane.showConfirmDialog(null, "Deseja Atualizar cadastro ? " );
		
		PessoaJuridica pessoa = new PessoaJuridica();

		PessoaJuridicaDAO add = new PessoaJuridicaDAO();
		
		
		pessoa.setNome(nome.getText());
		pessoa.setCnpj(cnpj.getText());
		pessoa.setNomeFantasia(fantasia.getText());
		pessoa.setTelefone1(telefone1.getText());
		pessoa.setTelefone2(telefone2.getText());
		pessoa.setCep(cep.getText());
		pessoa.setEndereco(endereco.getText());
		pessoa.setComplemento(complemento.getText());
		pessoa.setNumero(numero.getText());
		pessoa.setBairro(bairro.getText());
		pessoa.setCidade(cidade.getText());
		pessoa.setEmail(email.getText());
		pessoa.setUf(ufEscolha[uf.getSelectedIndex()]);
		pessoa.setId((Integer.parseInt(id.getText())));
		
		add.Alterar(pessoa);
		
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso " );
		
		Menu.Montar();

		
		setVisible(false);
		
		}else if ( eventoBotao.getSource() == excluir){
			JOptionPane.showConfirmDialog(null, "Deseja realmente exluir  cadastro ? "+ nome.getText() );
			PessoaJuridicaDAO excluir = new PessoaJuridicaDAO();
			excluir.Excliur(nome.getText());
			JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso " );
			setVisible(false);
			Menu.Montar();
		}
		
	}

}
